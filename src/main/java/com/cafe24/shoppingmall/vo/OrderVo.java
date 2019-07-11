package com.cafe24.shoppingmall.vo;

public class OrderVo {

	private Long no;
	private String name;
	private String password;
	private String phone;
	private String email;
	private String address;
	private String regDate;
	private String shippingMessage;
	private Long shippingFee;
	private Long totalPrice;
	private Long memberNo;
	
	public OrderVo() {
		// TODO Auto-generated constructor stub
	}

	public OrderVo(Long no, String name, String password, String phone, String email, String address, String regDate,
			String shippingMessage, Long shippingFee, Long totalPrice, Long memberNo) {
		super();
		this.no = no;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.regDate = regDate;
		this.shippingMessage = shippingMessage;
		this.shippingFee = shippingFee;
		this.totalPrice = totalPrice;
		this.memberNo = memberNo;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getShippingMessage() {
		return shippingMessage;
	}

	public void setShippingMessage(String shippingMessage) {
		this.shippingMessage = shippingMessage;
	}

	public Long getShippingFee() {
		return shippingFee;
	}

	public void setShippingFee(Long shippingFee) {
		this.shippingFee = shippingFee;
	}

	public Long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Long getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}

	@Override
	public String toString() {
		return "OrderVo [no=" + no + ", name=" + name + ", password=" + password + ", phone=" + phone + ", email="
				+ email + ", address=" + address + ", regDate=" + regDate + ", shippingMessage=" + shippingMessage
				+ ", shippingFee=" + shippingFee + ", totalPrice=" + totalPrice + ", memberNo=" + memberNo + "]";
	}
	
}
