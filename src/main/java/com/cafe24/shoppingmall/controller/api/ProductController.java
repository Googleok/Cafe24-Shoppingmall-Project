package com.cafe24.shoppingmall.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.service.ProductService;
import com.cafe24.shoppingmall.vo.ProductVo;

@RestController("productAPIController")
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	/**
	 * 상품검색
	 * @param keyword
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/search")
	public JSONResult getSearchProductList(@RequestParam(value = "keyword") String keyword) throws Exception{
		List<ProductVo> list = productService.getSearchProductList(keyword);
		return JSONResult.success(list);
	}
	
	/**
	 * 상품목록조회
	 * @return
	 */
	@GetMapping({"", "/list"})
	public JSONResult getProductList(){
		List<ProductVo> list = productService.getProductList();
		return JSONResult.success(list);
	}
	
	/**
	 * 상품상세조회
	 * @param no
	 * @return
	 */
	@GetMapping("/{no}")
	public JSONResult getProductOne(@PathVariable("no") Long no){
		ProductVo vo = productService.getProductOne(no);
		return JSONResult.success(vo);
	}
}
