package com.cbg.exam1.dto;

import java.util.Map;

import com.cbg.exam1.util.Ut;

public class ResultData {
	
	private String msg;
	private String resultCode;
	private Map<String, Object> body;
	
	private ResultData() {
		
	}


	public String getMsg() {
		return msg;
	}


	public String getResultCode() {
		return resultCode;
	}


	public Map<String, Object> getBody() {
		return body;
	}
	
	public boolean isSuccess() {
		return resultCode.startsWith("S-1");
	}
	
	public boolean isFail() {
		return !isSuccess();
	}


	public static ResultData from(String resultCode, String msg, Object...bodyArgs) {
		ResultData rd = new ResultData();
		
		rd.resultCode = resultCode;
		rd.msg = msg;
		rd.body = Ut.mapOf(bodyArgs);
		
		return rd;
	}

}
