package com.cafe24.shoppingmall.controller.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.service.UserService;
import com.cafe24.shoppingmall.vo.UserVo;

@RestController("userAPIController")
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private UserService userService;

	// 회원가입
	@PostMapping("/join")
	public ResponseEntity<JSONResult> join(@RequestBody @Valid UserVo vo, BindingResult result) {

		// @valid 유효성 검증
		if (result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError error : errors) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(error.getDefaultMessage()));
			}
		}

		UserVo newVo = userService.join(vo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(newVo));
	}

//	@ApiOperation(value="이메일 존재 여부")
//	@ApiImplicitParams({
//		@ApiImplicitParam(name="email", value="이메일 주소", required = true) 
//	})
	@RequestMapping(value = "/checkemail", method = RequestMethod.GET)
	public ResponseEntity<JSONResult> checkEmail(
			@RequestParam(value = "email", required = true, defaultValue = "") String email) {
		Boolean exist = userService.existEmail(email);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(exist));
	}

	// 로그인
	@PostMapping(value = "/login")
	public ResponseEntity<JSONResult> login(@RequestBody UserVo userVo) {

		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		/*
		 * 이게 왜 Set이냐 validator가 두개 달린 필드도 존재하기 때문에 순서없이 담는다.
		 */
		Set<ConstraintViolation<UserVo>> validatorResults = validator.validateProperty(userVo, "email");
		if(validatorResults.isEmpty() == false) {
			for(ConstraintViolation<UserVo> validatorResult : validatorResults) {
				
				 String message = messageSource.getMessage("Email.userVo.email", null, LocaleContextHolder.getLocale());
				
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(validatorResult.getMessage()));
			}
		}

		validatorResults = validator.validateProperty(userVo, "password");
		if(validatorResults.isEmpty() == false) {
			for(ConstraintViolation<UserVo> validatorResult : validatorResults) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(validatorResult.getMessage()));
			}
		}

//		List<String> checkFields = new ArrayList<String>();
//		checkFields.add("email");
//		checkFields.add("password");
//		ResponseEntity<JSONResult> result = nonValid(validator, userVo, checkFields, messageSource);
//		return result == null ? ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(userVo)) : result;

		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(userVo));
	}

	public static ResponseEntity<JSONResult> nonValid(Validator validator, UserVo userVo, List<String> checkFields,
			MessageSource messageSource) {
		for (String checkField : checkFields) {
			Set<ConstraintViolation<UserVo>> validatorResults = validator.validateProperty(userVo, checkField);

			if (validatorResults.isEmpty() == false) {
				for (ConstraintViolation<UserVo> validatorResult : validatorResults) {
					// String message = messageSource.getMessage("Email.userVo.email", null,
					// LocaleContextHolder.getLocale());

					return ResponseEntity.status(HttpStatus.BAD_REQUEST)
							.body(JSONResult.fail(validatorResult.getMessage()));
				}
			}

		}
		return null;
	}
	// 회원정보 수정

	// 로그아웃

	// 장바구니 리스트 요청

	// 장바구니 담기 - ajax

	// 장바구니 삭제 - ajax

}
