package com.yl.myproject.xml;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Test {

	public static void main(String[] args) {
		SAXParser parser = null;
		try {
			/*
			 * String strXML = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
			 * +"<root>" + "<student id=\"1\" group=\"1\">" +
			 * "<name>张三</name>  " + "<sex>男</sex>  " + "<age>18</age>  " +
			 * "<email>zhangsan@163.com</email>  " +
			 * "<birthday>1987-06-08</birthday> " + " <memo>好学生</memo> " +
			 * "</student> " + "<student id=\"2\" group=\"2\">" +
			 * "<name>李四</name>  " + "<sex>女</sex>  " + "<age>18</age>  " +
			 * "<email>lisi@163.com</email>  " +
			 * "<birthday>1987-06-08</birthday>  " + "<memo>好学生</memo>  " +
			 * "</student>" + "</root>";
			 */

			String strXML = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
					+ "<AdvPay><PubInfo><ReturnCode>15</ReturnCode><ReturnMsg>充值号码不能为空</ReturnMsg></PubInfo></AdvPay>";
			StringReader reader = new StringReader(strXML);
			InputSource stream = new InputSource(reader);


			// 构建SAXParser
			parser = SAXParserFactory.newInstance().newSAXParser();
			// 实例化 DefaultHandler对象
			SaxParseXml parseXml = new SaxParseXml(new PubInfo());
			// 加载资源文件 转化为一个输入流
			// InputStream
			// stream=SaxParseXml.class.getClassLoader().getResourceAsStream("student.xml");
			// 调用parse()方法
			parser.parse(stream, parseXml);
			// 遍历结果
			List<Object> list = parseXml.getList();
			for (Object students : list) {
				// Student student= (Student) students;
				// System.out.println("id:"+"\tgroup:"+"\tname:"+student.getName()+"\tsex:"+student.getSex()+"\tage:"+"\temail:"+student.getEmail()+"\tbirthday:"+student.getBirthday()+"\tmemo:"+student.getMemo());
				PubInfo info = (PubInfo) students;

				System.out.println(info.toString());

			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
