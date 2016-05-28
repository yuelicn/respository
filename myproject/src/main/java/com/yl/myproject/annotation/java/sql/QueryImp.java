package com.yl.myproject.annotation.java.sql;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.hamcrest.core.IsInstanceOf;


@SuppressWarnings("unused")
public class QueryImp implements Query {

	@Override
	public int query(User f) {
		// TODO Auto-generated method stub
		getSql(f);
		return 0;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static String getSql(Object f){
		
		// 1.加载class
				Class c = f.getClass();
				// 2判断是不是使用了Table注解
				boolean isTable = c.isAnnotationPresent(Table.class);
				
				if (!isTable) {
					return "error";

				}
				
				Table table = (Table)c.getAnnotation(Table.class);
				//3 获取表名
				String tableName = table.value();
				
				StringBuilder sb = new StringBuilder();
				sb.append("select * from ").append(tableName).append(" where 1=1");
				
		        Field[] fields = c.getDeclaredFields();
		        
		        for (Field field : fields) {
		        	
		        	//4获取字段名
		        	
		        	Column column = (Column)field.getAnnotation(Column.class);
		        	
		        	String fieldName = column.value();
		        	
		        	//5 获取字段值
		        	String methodName = "get"+field.getName().substring(0, 1).toUpperCase();
		        	
		        	methodName = methodName + field.getName().substring(1);
		        	Object fieldVaule;
		        	try {
						Method method = c.getMethod(methodName);
						
						 fieldVaule =method.invoke(f);
						
						 if(fieldVaule == null || (fieldVaule instanceof Integer && (Integer)fieldVaule == 0 )){
							 
							 continue;
						 }
						 
						 if(fieldVaule instanceof String){
							 sb.append(" and ").append(fieldName).append(" = ").append("'").append(fieldVaule).append("'");
							 
						 }else{
						 
						sb.append(" and ").append(fieldName).append(" = ").append(fieldVaule);}
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				}

		        System.out.println(sb);
				return sb.toString();
		
		
		
	}
	
	
	
	
}
