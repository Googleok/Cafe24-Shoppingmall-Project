package com.cafe24.shoppingmall.vo;

public class OrderDetailVo {
	
	private Long no;
	private String productName;
	private String options;
	private Long productPrice;
	private String shippingStatus;
	private Long count;
	private Long orderNo;
	
	public OrderDetailVo() {
		// TODO Auto-generated constructor stub
	}

	public OrderDetailVo(Long no, String productName, String options, Long productPrice, String shippingStatus,
			Long count, Long orderNo) {
		super();
		this.no = no;
		this.productName = productName;
		this.options = options;
		this.productPrice = productPrice;
		this.shippingStatus = shippingStatus;
		this.count = count;
		this.orderNo = orderNo;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public Long getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Long productPrice) {
		this.productPrice = productPrice;
	}

	public String getShippingStatus() {
		return shippingStatus;
	}

	public void setShippingStatus(String shippingStatus) {
		this.shippingStatus = shippingStatus;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public Long getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}

	@Override
	public String toString() {
		return "OrderDetailVo [no=" + no + ", productName=" + productName + ", options=" + options + ", productPrice="
				+ productPrice + ", shippingStatus=" + shippingStatus + ", count=" + count + ", orderNo=" + orderNo
				+ "]";
	}

	
	
}
