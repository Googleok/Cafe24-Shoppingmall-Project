package com.cafe24.shoppingmall.controller.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
	private UserService userService;
	
	
	// 회원가입
	@PostMapping("/join")
	public ResponseEntity<JSONResult> join(@RequestBody @Valid UserVo vo,
									BindingResult result) {
		
		// @valid 유효성 검증
		if(result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error : errors) {
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
	@RequestMapping(value="/checkemail", method=RequestMethod.GET)
	public ResponseEntity<JSONResult> checkEmail(
			@RequestParam(value="email", required=true, defaultValue="") String email){
		Boolean exist = userService.existEmail(email);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(exist));
	}
	
	// 로그인
	
	// 회원정보 수정 
	
	// 로그아웃
	
	// 장바구니 리스트 요청
	
	// 장바구니 담기 - ajax
	
	// 장바구니 삭제 - ajax
	
	
	
	
	
	
	
	
	
	
	
}
