package com.yl.myproject.json;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

//@JSONType(orders={"name","sex","age"})
public class User {
	@JSONField(ordinal = 2)
	private String name;
	@JSONField(ordinal = 3)
	private String sex;
	@JSONField(ordinal = 1)
	private String age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public static void main(String[] args) {
		User user = new User();
		user.setAge("sss");
		// user.setSex("y");
		user.setName("dddd");
		Object json = JSONObject.toJSONString(user, SerializerFeature.SortField);
		System.out.println(JSONObject.toJSONString(user));
		System.out.println(json.toString());

	}

}
