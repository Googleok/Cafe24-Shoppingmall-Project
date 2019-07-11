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
import com.cafe24.shoppingmall.vo.ProductVo;

@RestController("adminAPIController")
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	// 상품관리 
	// product
	
	// 상품리스트
	@GetMapping("/product")
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
	// 상품리스트
	@GetMapping("/product/search")
	public JSONResult getProductSearchList(@RequestParam(value = "keyword") String keyword){
		List<ProductVo> list = adminService.getProductSearchList(keyword);
		return JSONResult.success(list);
	}
	
	// 주문관리
	// order
	
	// 전체주문리스트 요청
	// 입금확인체크
	// 배송출발체크
	// 전체주문중에 주문상세 요청
	// 주문검색
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

