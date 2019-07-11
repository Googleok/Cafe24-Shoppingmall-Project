package com.cafe24.shoppingmall.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public JSONResult addProduct(){
		List<ProductVo> list = adminService.getProductList();
		return JSONResult.success(list);
	}
	
	// 상품수정
	@PutMapping("/product")
	public JSONResult modifyProduct(){
		List<ProductVo> list = adminService.getProductList();
		return JSONResult.success(list);
	}
	
	// 상품삭제
	@DeleteMapping("/product")
	public JSONResult deleteProduct(){
		List<ProductVo> list = adminService.getProductList();
		return JSONResult.success(list);
	}
	
	
	
}
