package com.yl.myproject.annotation.blank;

public class User1 {
	@RequiredFieldValidator(required=true)
	private String userName1;
	@RequiredFieldValidator(required=true)
	private String pswd1;
	@RequiredFieldValidator(required=true)
	private int age1;
	public String getUserName1() {
		return userName1;
	}
	public void setUserName1(String userName1) {
		this.userName1 = userName1;
	}
	public String getPswd1() {
		return pswd1;
	}
	public void setPswd1(String pswd1) {
		this.pswd1 = pswd1;
	}
	public int getAge1() {
		return age1;
	}
	public void setAge1(int age1) {
		this.age1 = age1;
	}
}
