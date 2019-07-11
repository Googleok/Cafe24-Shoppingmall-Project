package com.cafe24.shoppingmall.vo;

public class ProductVo {
	private Long no;
	private String name;
	private Long price;
	private String regDate;
	private Boolean exhibitionAvailability;
	private Boolean optionAvailability;
	private Boolean sailsStatus;
	private Long exhibitionRank;
	private Long count;
	private String detail;
	private Long shippingFee;
	private Long categoryNo;
	
	public ProductVo() {
		// TODO Auto-generated constructor stub
	}
	
	public ProductVo(Long no, String name, Long price, String regDate, Boolean exhibitionAvailability,
			Boolean optionAvailability, Boolean sailsStatus, Long exhibitionRank, Long count, String detail,
			Long shippingFee, Long categoryNo) {
		this.no = no;
		this.name = name;
		this.price = price;
		this.regDate = regDate;
		this.exhibitionAvailability = exhibitionAvailability;
		this.optionAvailability = optionAvailability;
		this.sailsStatus = sailsStatus;
		this.exhibitionRank = exhibitionRank;
		this.count = count;
		this.detail = detail;
		this.shippingFee = shippingFee;
		this.categoryNo = categoryNo;
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

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public Boolean getExhibitionAvailability() {
		return exhibitionAvailability;
	}

	public void setExhibitionAvailability(Boolean exhibitionAvailability) {
		this.exhibitionAvailability = exhibitionAvailability;
	}

	public Boolean getOptionAvailability() {
		return optionAvailability;
	}

	public void setOptionAvailability(Boolean optionAvailability) {
		this.optionAvailability = optionAvailability;
	}

	public Boolean getSailsStatus() {
		return sailsStatus;
	}

	public void setSailsStatus(Boolean sailsStatus) {
		this.sailsStatus = sailsStatus;
	}

	public Long getExhibitionRank() {
		return exhibitionRank;
	}

	public void setExhibitionRank(Long exhibitionRank) {
		this.exhibitionRank = exhibitionRank;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Long getShippingFee() {
		return shippingFee;
	}

	public void setShippingFee(Long shippingFee) {
		this.shippingFee = shippingFee;
	}

	public Long getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(Long categoryNo) {
		this.categoryNo = categoryNo;
	}

	@Override
	public String toString() {
		return "ProductVo [no=" + no + ", name=" + name + ", price=" + price + ", regDate=" + regDate
				+ ", exhibitionAvailability=" + exhibitionAvailability + ", optionAvailability=" + optionAvailability
				+ ", sailsStatus=" + sailsStatus + ", exhibitionRank=" + exhibitionRank + ", count=" + count
				+ ", detail=" + detail + ", shippingFee=" + shippingFee + ", categoryNo=" + categoryNo + "]";
	}
	
	



}
