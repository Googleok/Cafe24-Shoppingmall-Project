package com.cafe24.shoppingmall.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shoppingmall.repository.OrderDao;
import com.cafe24.shoppingmall.vo.OrderDetailVo;
import com.cafe24.shoppingmall.vo.OrderVo;
import com.cafe24.shoppingmall.vo.PaymentVo;

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

	public OrderVo orderProduct(OrderVo vo) {
		// 주문 저장 되고, 결제도 결제대기상태로 저장됨
		return vo;
	}

	public PaymentVo payOrder(Long no) {
		PaymentVo newVo = null;
		List<PaymentVo> list = new ArrayList<PaymentVo>();
		list.add(new PaymentVo(1L, "결제대기", "카카오페이", 1L));
		list.add(new PaymentVo(2L, "결제대기", "무통장입금", 2L));
		list.add(new PaymentVo(3L, "결제대기", "신용카드", 3L));
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getNo() == no) {
				list.get(i).setPaymentStatus("결제완료");
				// 결제완료 상태로 변경하면 이젠 배송상태도 변경시킨다.
				newVo = list.get(i);
			}
		}
		return newVo;
	}
	
	
}
