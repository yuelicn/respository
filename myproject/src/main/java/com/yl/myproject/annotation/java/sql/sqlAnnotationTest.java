package com.yl.myproject.annotation.java.sql;


import org.junit.Test;

public class sqlAnnotationTest {

	@Test
	public void Testquery() {
		User user = new User();
		
		user.setAge(18);
		
		User user1 = new User();
		
		user1.setName("张三");
		
		
		User user2 = new User();
		
		user2.setEmail("zhang@test.com,li@test.com");
		
		User user3 = new User();
		
		user3.setAge(20);
		
		user3.setEmail("长得帅");
		
		user3.setName("li@test.com");
		
		
		
		QueryImp query = new QueryImp();
		
		query.query(user);
		query.query(user1);
		query.query(user2);
		query.query(user3);
		
	}

}
