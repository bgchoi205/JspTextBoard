package com.cbg.exam1.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cbg.exam1.util.Ut;

public class Rq {
	
	private HttpServletRequest req;
	private HttpServletResponse resp;
	private boolean isInvalid = false;
	private String controllerTypeName;
	private String controllerName;
	private String actionMethodName;
	

	public Rq(HttpServletRequest req, HttpServletResponse resp) {
		
		//�뱾�뼱�삤�뒗 �뙆�씪誘명꽣瑜� UTF-8濡� �빐�꽍.
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
				
		// �꽌釉붾┸�씠 HTML �뙆�씪�쓣 留뚮뱾 �븣 UTF-8濡� �벐湲�.
		resp.setCharacterEncoding("UTF-8");
				
		// HTML�씠 UTF-8 �삎�떇�씠�씪�뒗 寃껋쓣 釉뚮씪�슦���뿉 �븣由�.
		resp.setContentType("text/html; charset=UTF-8");
		
		this.req = req;
		this.resp = resp;
		
		String requestUri = req.getRequestURI();
		String[] requestUriBits = requestUri.split("/");

		int minBitsCount = 5;

		if (requestUriBits.length < minBitsCount) {
			isInvalid = true;
			return;
		}
		
		int controllerTypeNameIndex = 2;
		int controllerNameIndex = 3;
		int actionMethodNameIndex = 4;
		
		this.controllerTypeName = requestUriBits[controllerTypeNameIndex];
		this.controllerName = requestUriBits[controllerNameIndex];
		this.actionMethodName = requestUriBits[actionMethodNameIndex];
		
	}


	public HttpServletRequest getReq() {
		return req;
	}


	public boolean isInvalid() {
		return isInvalid;
	}


	public String getControllerTypeName() {
		return controllerTypeName;
	}


	public String getControllerName() {
		return controllerName;
	}


	public String getActionMethodName() {
		return actionMethodName;
	}


	public void print(String str) {
		try {
			resp.getWriter().append(str);
		} catch(IOException e){
			e.printStackTrace();
		}
	}


	public void println(String str) {
		print(str + "\n");
		
	}
	
	public void printf(String format, Object...args) {
		print(Ut.f(format, args));
	}


	public void jsp(String jspPath) {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/" + jspPath + ".jsp");
		try {
			requestDispatcher.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
	}


	public String getParam(String paramName, String defaultValue) {
		String paramValue = req.getParameter(paramName);
		
		if(paramValue == null) {
			return defaultValue;
		}
		
		return paramValue;
	}


	public void historyBack(String msg) {
		println("<script>");
		printf("alert('%s');\n", msg);
		println("history.back();");
		println("</script>");
		
	}


}
