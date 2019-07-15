package com.cafe24.shoppingmall.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.service.AdminService;
import com.cafe24.shoppingmall.vo.OrderDetailVo;
import com.cafe24.shoppingmall.vo.OrderVo;
import com.cafe24.shoppingmall.vo.ProductVo;
import com.cafe24.shoppingmall.vo.UserVo;

@RestController("adminAPIController")
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	// 상품관리 
	// product
	
	/**
	 * 상품리스트
	 * @return
	 */
	@GetMapping({"/product", "/product/list"})
	public ResponseEntity<JSONResult> getProductList(){
		List<ProductVo> list = adminService.getProductList();
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	}
	
	/**
	 * 상품 하나만
	 * @param no
	 * @return
	 */
	@GetMapping("/product/{no}")
	public ResponseEntity<JSONResult> getProductOne(@PathVariable("no") Long no){
		ProductVo vo = adminService.getProductOne(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(vo));
	}
	
	
	/**
	 * 상품등록
	 * @param vo
	 * @return
	 */
	@PostMapping("/product")
	public ResponseEntity<JSONResult> addProduct(@RequestBody ProductVo vo){
		Boolean result = adminService.addProduct(vo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}

	/**
	 * 상품수정
	 * @param no
	 * @param vo
	 * @return
	 */
	@PutMapping("/product/{no}")
	public ResponseEntity<JSONResult> modifyProduct(@PathVariable("no") Long no, @RequestBody ProductVo vo){
		ProductVo newVo = adminService.modifyProduct(no, vo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(newVo));
	}
	
	/**
	 * 상품삭제
	 * @param no
	 * @return
	 */
	@DeleteMapping("/product/{no}")
	public ResponseEntity<JSONResult> deleteProduct(@PathVariable("no") Long no){
		boolean result = adminService.deleteProduct(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
	
	/**
	 * 상품검색
	 * @param keyword
	 * @return
	 */
	@GetMapping("/product/search")
	public ResponseEntity<JSONResult> getProductSearchList(@RequestParam(value = "keyword") String keyword){
		List<ProductVo> list = adminService.getProductSearchList(keyword);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	}
	
	// 주문관리
	// order
	
	/**
	 * 전체주문리스트 요청
	 * @return
	 */
	@GetMapping({"/order", "/order/list"})
	public ResponseEntity<JSONResult> getOrderList(){
		List<OrderVo> list = adminService.getOrderList();
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	}
	
	/**
	 * 주문한개 요청
	 * @param no
	 * @return
	 */
	@GetMapping("/order/{no}")
	public ResponseEntity<JSONResult> getOrderOne(@PathVariable("no") Long no){
		OrderVo vo = adminService.getOrderOne(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(vo));
	}
	
	/**
	 * 상세주문 요청
	 * @param no
	 * @return
	 */
	@GetMapping("/order/detail/{no}")
	public ResponseEntity<JSONResult> getOrderDetail(@PathVariable("no") Long no){
		OrderDetailVo vo = adminService.getOrderDetail(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(vo));
	}

	/**
	 * 입금확인체크
	 * @param no
	 * @return
	 */
	@PutMapping("/order/depositcheck/{no}")
	public ResponseEntity<JSONResult> orderDepositCheck(@PathVariable("no") Long no){
		OrderDetailVo newVo = adminService.orderDepositCheck(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(newVo));
	}
	
	/**
	 * 배송출발체크
	 * @param no
	 * @return
	 */
	@PutMapping("/order/deliverycheck/{no}")
	public ResponseEntity<JSONResult> orderDeliveryCheck(@PathVariable("no") Long no){
		OrderDetailVo newVo = adminService.orderDeliveryCheck(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(newVo));
	}
	
	/**
	 * 주문검색 --> 너무많은데 일단 phone 번호로 체크
	 * @param keyword
	 * @return
	 */
	@GetMapping("/order/search")
	public ResponseEntity<JSONResult> getOrderSearchList(@RequestParam(value = "keyword") String keyword){
		List<OrderVo> list = adminService.getOrderSearchList(keyword);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	}

	// 회원관리
	// user
	 
	/**
	 * 회원리스트 요청
	 * @return
	 */
	@GetMapping({"/user", "/user/list"})
	public ResponseEntity<JSONResult> getUserList(){
		List<UserVo> list = adminService.getUserList();
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	}
	
	/**
	 * 회원 삭제
	 * @param no
	 * @return
	 */
	@DeleteMapping("/user/{no}")
	public ResponseEntity<JSONResult> deleteUser(@PathVariable("no") Long no){
		boolean result = adminService.deleteUser(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
	
	/**
	 * 회원 상태 수정
	 * @param no
	 * @param vo
	 * @return
	 */
	@PutMapping("/user/{no}")
	public ResponseEntity<JSONResult> modifyUser(@PathVariable("no") Long no, @RequestBody UserVo vo){
		UserVo newVo = adminService.modifyUser(no, vo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(newVo));
	}
	
	/**
	 * 회원검색 --> 너무많은데 일단 ID로 체크
	 * @param keyword
	 * @return
	 */
	@GetMapping("/user/search")
	public ResponseEntity<JSONResult> getUserSearchList(@RequestParam(value = "keyword") String keyword){
		List<UserVo> list = adminService.getUserSearchList(keyword);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	}
	
	
	
	
	
	
	
	
	
}

