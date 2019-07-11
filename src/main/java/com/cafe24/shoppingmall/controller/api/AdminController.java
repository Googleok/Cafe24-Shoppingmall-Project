package com.cafe24.shoppingmall.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	@RequestMapping(value="/product", method=RequestMethod.GET)
	public JSONResult getProductList(){
		List<ProductVo> list = adminService.getProductList();
		return JSONResult.success(list);
	}
	
	// 상품 하나만
	
	// 상품등록
	
	// 상품수정
	
	// 상품삭제
	
	
	
}
