package com.yl.myproject.xml;

public class PubInfo {

	
	private String ReturnCode;
	
	private String ReturnMsg;

	public String getReturnCode() {
		return ReturnCode;
	}

	public void setReturnCode(String returnCode) {
		ReturnCode = returnCode;
	}

	public String getReturnMsg() {
		return ReturnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		ReturnMsg = returnMsg;
	}

	@Override
	public String toString() {
		return "PubInfo [ReturnCode=" + ReturnCode + ", ReturnMsg=" + ReturnMsg + "]";
	}
	
	
	
}
