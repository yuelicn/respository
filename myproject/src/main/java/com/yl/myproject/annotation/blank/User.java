package com.yl.myproject.annotation.blank;

public class User {
	
	@RequiredFieldValidator(required=true)
	private String userName;
	@RequiredFieldValidator(required=true)
	private String pswd;
	private int age;
	@RequiredFieldValidator(required=true)
	private User1 user1;
	

	public User1 getUser1() {
		return user1;
	}

	public void setUser1(User1 user1) {
		this.user1 = user1;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	

}
