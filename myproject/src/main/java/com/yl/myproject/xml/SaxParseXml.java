package com.yl.myproject.xml;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 功能描述:采用sax方式解析XML<br>
 * 
 * @author sxyx2008
 *
 */
public class SaxParseXml extends DefaultHandler {

	// 存放遍历集合
	private List<Object> list;
	// 构建Student对象
	private static Object student;
	// 用来存放每次遍历后的元素名称(节点名称)
	private String tagName;

	private static List<String> field;
	
	private String className;

	@SuppressWarnings("static-access")
	public SaxParseXml(Object student) {
		super();
		this.student = student;
	}

	public List<Object> getList() {
		return list;
	}

	public void setList(List<Object> list) {
		this.list = list;
	}

	public Object getStudent() {
		return student;
	}

	@SuppressWarnings("static-access")
	public void setStudent(Student student) {
		this.student = student;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	// 只调用一次 初始化list集合
	@SuppressWarnings("rawtypes")
	@Override
	public void startDocument() throws SAXException {
		list = new ArrayList<Object>();
		field = new ArrayList<>();
		Class clazz = student.getClass();
		className = clazz.getSimpleName();
		Field[] fields = clazz.getDeclaredFields();

		for (Field f : fields) {
			field.add(f.getName());
		}

	}

	// 调用多次 开始解析
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		this.tagName = qName;
	}

	// 调用多次
	@SuppressWarnings("static-access")
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals(className)) {
			this.list.add(this.student);
		}
		this.tagName = null;
	}

	// 只调用一次
	@Override
	public void endDocument() throws SAXException {
	}

	// 调用多次
	@SuppressWarnings("static-access")
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (this.tagName != null) {
			String date = new String(ch, start, length);
			this.set(this.tagName, date);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void set(String name, String date) {

		if (field.indexOf(name) < 0) {
			return;
		}
		String fieldName = field.get(field.indexOf(name));
		String methodName = "set" + fieldName.substring(0, 1).toUpperCase();
		methodName = methodName + fieldName.substring(1);
		Class clazz = student.getClass();
			Method method;
			try {
				method = clazz.getMethod(methodName, String.class);
				method.setAccessible(true);
				method.invoke(student, date);
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}