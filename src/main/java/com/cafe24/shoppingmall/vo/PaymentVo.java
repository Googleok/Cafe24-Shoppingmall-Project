package com.cafe24.shoppingmall.vo;

public class PaymentVo {

	private Long no;
	private String paymentStatus;
	private String paymentSystem;
	private Long orderNo;
	
	public PaymentVo() {
		// TODO Auto-generated constructor stub
	}
	
	public PaymentVo(Long no, String paymentStatus, String paymentSystem, Long orderNo) {
		this.no = no;
		this.paymentStatus = paymentStatus;
		this.paymentSystem = paymentSystem;
		this.orderNo = orderNo;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getPaymentSystem() {
		return paymentSystem;
	}

	public void setPaymentSystem(String paymentSystem) {
		this.paymentSystem = paymentSystem;
	}

	public Long getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}

	@Override
	public String toString() {
		return "PaymentVo [no=" + no + ", paymentStatus=" + paymentStatus + ", paymentSystem=" + paymentSystem
				+ ", orderNo=" + orderNo + "]";
	}
	
	
}
