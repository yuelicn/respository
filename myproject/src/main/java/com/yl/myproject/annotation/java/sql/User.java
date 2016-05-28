package com.yl.myproject.annotation.java.sql;

@Table("user")
public class User {

	@Column("name")
	private String name;
	@Column("email")
	private String email;
	@Column("age")
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
