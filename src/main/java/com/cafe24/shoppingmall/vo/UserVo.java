package com.cafe24.shoppingmall.vo;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class UserVo {
	private Long no;
	
	@NotEmpty(message = "아이디를 입력하세요.")
	@Pattern(regexp = "^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$", message = "잘못된 아이디 형식입니다.")
	private String id;

	@Length(min=9, max=15, message="비밀번호 길이는 8~16자 입니다.")
	// 비밀번호 정규식 (최소 8자리에 대문자 1자리 소문자 한자리 숫자 한자리)
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$", message = "잘못된 비밀번호 형식입니다.")
	private String password;
	
	@NotEmpty(message="이름을 입력하세요.")
	// 영문 혹은 한글 이름
	@Pattern(regexp = "^[가-힣]{2,4}|^[a-zA-Z]*$", message = "잘못된 이름 형식입니다.")
	private String name;

	@NotEmpty(message="전화번호를 입력해주세요.") 
	// 전화번호 정규식
	@Pattern(regexp = "^01(?:0|1|[6-9])[.-]?(\\d{3}|\\d{4})[.-]?(\\d{4})$", message = "잘못된 전화번호 형식입니다.")
	private String phone;
	
	@Email(message="잘못된 이메일 형식입니다.")
	@NotEmpty(message="이메일을 입력해주세요.")
	private String email;
	private String birth;
	private String gender;
	
	
	public UserVo() {
	}

	public UserVo(Long no, String id, String password, String name, String phone, String email, String birth,
			String gender) {
		super();
		this.no = no;
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.birth = birth;
		this.gender = gender;
	}

	public UserVo(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "UserVo [no=" + no + ", id=" + id + ", password=" + password + ", name=" + name + ", phone=" + phone
				+ ", email=" + email + ", birth=" + birth + ", gender=" + gender + "]";
	}
	
	
	
}
