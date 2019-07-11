package com.cafe24.shoppingmall.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	// 상품리스트
	@GetMapping({"/product", "/product/list"})
	public JSONResult getProductList(){
		List<ProductVo> list = adminService.getProductList();
		return JSONResult.success(list);
	}
	
	// 상품 하나만
	@GetMapping("/product/{no}")
	public JSONResult getProductOne(@PathVariable("no") Long no){
		ProductVo vo = adminService.getProductOne(no);
		return JSONResult.success(vo);
	}
	
	
	// 상품등록
	@PostMapping("/product")
	public JSONResult addProduct(@RequestBody ProductVo vo){
		Boolean result = adminService.addProduct(vo);
		return JSONResult.success(result);
	}
	
	// 상품수정
	@PutMapping("/product/{no}")
	public JSONResult modifyProduct(@PathVariable("no") Long no, @RequestBody ProductVo vo){
		ProductVo newVo = adminService.modifyProduct(no, vo);
		return JSONResult.success(newVo);
	}
	
	// 상품삭제
	@DeleteMapping("/product/{no}")
	public JSONResult deleteProduct(@PathVariable("no") Long no){
		boolean result = adminService.deleteProduct(no);
		return JSONResult.success(result);
	}
	
	// 상품검색
	@GetMapping("/product/search")
	public JSONResult getProductSearchList(@RequestParam(value = "keyword") String keyword){
		List<ProductVo> list = adminService.getProductSearchList(keyword);
		return JSONResult.success(list);
	}
	
	// 주문관리
	// order
	
	// 전체주문리스트 요청
	@GetMapping({"/order", "/order/list"})
	public JSONResult getOrderList(){
		List<OrderVo> list = adminService.getOrderList();
		return JSONResult.success(list);
	}
	
	// 주문한개 요청
	@GetMapping("/order/{no}")
	public JSONResult getOrderOne(@PathVariable("no") Long no){
		OrderVo vo = adminService.getOrderOne(no);
		return JSONResult.success(vo);
	}
	
	// 상세주문 요청
	@GetMapping("/order/detail/{no}")
	public JSONResult getOrderDetail(@PathVariable("no") Long no){
		OrderDetailVo vo = adminService.getOrderDetail(no);
		return JSONResult.success(vo);
	}
	

	// 입금확인체크
	@PutMapping("/order/depositcheck/{no}")
	public JSONResult orderDepositCheck(@PathVariable("no") Long no){
		OrderDetailVo newVo = adminService.orderDepositCheck(no);
		return JSONResult.success(newVo);
	}
	
	// 배송출발체크
	@PutMapping("/order/deliverycheck/{no}")
	public JSONResult orderDeliveryCheck(@PathVariable("no") Long no){
		OrderDetailVo newVo = adminService.orderDeliveryCheck(no);
		return JSONResult.success(newVo);
	}
	
	// 주문검색 --> 너무많은데 일단 phone 번호로 체크
	@GetMapping("/order/search")
	public JSONResult getOrderSearchList(@RequestParam(value = "keyword") String keyword){
		List<OrderVo> list = adminService.getOrderSearchList(keyword);
		return JSONResult.success(list);
	}

	// 회원관리
	// user
	
	// 회원리스트 요청
	@GetMapping({"/user", "/user/list"})
	public JSONResult getUserList(){
		List<UserVo> list = adminService.getUserList();
		return JSONResult.success(list);
	}
	// 회원 삭제
	// 회원 상태 수정
	// 회원검색
	
	
	
	
	
	
	
	
	
	
	
}

