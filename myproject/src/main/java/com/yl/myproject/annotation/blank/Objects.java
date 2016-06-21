package com.yl.myproject.annotation.blank;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Objects {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String fieldValidator(Object o) {

		Class clzz = o.getClass();

		Field[] fields = clzz.getDeclaredFields();
		for (Field field : fields) {
			
			//判断是否加了RequiredFieldValidator 注解
			if (!field.isAnnotationPresent(RequiredFieldValidator.class)) {
				continue;
			}
			//获取注解
			RequiredFieldValidator required = field.getAnnotation(RequiredFieldValidator.class);
			// 非必填项 不处理
			if (!required.required()) {
				continue;
			}
			
			
			
			//获取方法名
			String fieldName = field.getName();
			//拼接get方法名
			String methodName = "get" + initcap(fieldName);
			
			Object fieldVaule = "";
			
			try {

				Method method = clzz.getMethod(methodName);

				fieldVaule = method.invoke(o);
				System.out.println(fieldName);
				System.out.println(fieldVaule instanceof Object );
				
				
				if (fieldVaule == null || "".equals(fieldVaule)) {

					return fieldName + " 为空"; 

				}
				

			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;
	}

	private static String initcap(String str) {

		char[] ch = str.toCharArray();
		if (ch[0] >= 'a' && ch[0] <= 'z') {
			ch[0] = (char) (ch[0] - 32);
		}

		return new String(ch);
	}

	public static void main(String[] args) {

		User u = new User();
		u.setAge(18);
		u.setPswd("123");
		u.setUserName("111");
		User1 u1 = new User1();
		u.setAge(13);
		u.setPswd("222");
		u.setUserName("2223");
		u.setUser1(u1);
		System.out.println(Objects.fieldValidator(u));

	}

}
