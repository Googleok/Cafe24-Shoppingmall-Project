package com.cafe24.shoppingmall.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shoppingmall.repository.OrderDao;
import com.cafe24.shoppingmall.vo.OrderDetailVo;
import com.cafe24.shoppingmall.vo.OrderVo;

@Service
public class OrderService {

	@Autowired
	private OrderDao orderDao;

	public OrderVo getOrderOne(String id) {
		OrderVo vo = new OrderVo(1L, "박종억", "1234", "01040287755", "whddjr2225@naver.com", "서울시 관악구",
				"2019-07-12", "빨리요!", 2500L, 185000L, 1L);
		return vo;
	}

	public OrderDetailVo getOrderDetail(Long no) {
		OrderDetailVo newVo = new OrderDetailVo();
		OrderDetailVo vo1 = new OrderDetailVo(1L, "모자", "빨/L", 20000L, "결제대기", 100L, 3L);
		OrderDetailVo vo2 = new OrderDetailVo(2L, "바지", "빨/L", 20000L, "결제대기", 100L, 3L);
		OrderDetailVo vo3 = new OrderDetailVo(3L, "상의", "빨/L", 20000L, "결제대기", 100L, 3L);
		List<OrderDetailVo> list = new ArrayList<OrderDetailVo>();
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getNo() == no) {
				newVo = list.get(i);
			}
		}
		return newVo;
	}
	
	
}
