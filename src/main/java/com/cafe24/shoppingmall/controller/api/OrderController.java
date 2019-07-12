package com.cafe24.shoppingmall.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.service.OrderService;
import com.cafe24.shoppingmall.vo.OrderDetailVo;
import com.cafe24.shoppingmall.vo.OrderVo;
import com.cafe24.shoppingmall.vo.PaymentVo;

@RestController("orderAPIController")
@RequestMapping("/api/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
		
	/**
	 * 상품주문
	 * id 같은경우는 @AuthUser 를 파라미터로 받을거기 때문에
	 * @param orderVo
	 * @return
	 */
	@PostMapping("")
	public JSONResult orderProduct(@RequestBody OrderVo orderVo) {
		OrderVo vo = orderService.orderProduct(orderVo);
		return JSONResult.success(vo);
	}
	
	/**
	 * 주문내역확인
	 * @param no
	 * @return
	 */
	@GetMapping("/{id}")
	public JSONResult getOrderOne(@PathVariable("id") String id){
		OrderVo vo = orderService.getOrderOne(id);
		return JSONResult.success(vo);
	}
	
	/**
	 * 주문상세보기
	 * @param no
	 * @return
	 */
	@GetMapping("/detail/{no}")
	public JSONResult getOrderDetail(@PathVariable("no") Long no){
		OrderDetailVo vo = orderService.getOrderDetail(no);
		return JSONResult.success(vo);
	}
	
	/**
	 * 주문결제
	 * @param no
	 * @return
	 */
	@PutMapping("/payment/{no}")
	public JSONResult payOrder(@PathVariable("no") Long no) {
		 PaymentVo vo = orderService.payOrder(no);
		return JSONResult.success(vo);
	}
	
	
}

