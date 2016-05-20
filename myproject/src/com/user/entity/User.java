package com.user.entity;

import org.apache.commons.lang.StringUtils;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;


   /**
    * user 实体类
    * Thu May 19 18:36:37 CST 2016 封狼居胥

    */ 

public class User extends BaseOutputUtil {


	private static Logger LOGGER = LoggerFactory.getLogger(User.class);

 private ResponseVO resVO;

 public XYHDUtil() {

 resVO = new ResponseVO();
}
@Override
public ResponseVO sendOrder(RequestVO reqVO) {	private String name;
	private String name1;
	public void setName(String name){
	this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setName1(String name1){
	this.name1=name1;
	}
	public String getName1(){
		return name1;
	}
}


