package com.cbg.exam1.http.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cbg.exam1.container.Container;
import com.cbg.exam1.http.Rq;
import com.cbg.exam1.http.controller.Controller;
import com.cbg.exam1.interceptor.Interceptor;
import com.cbg.mysqlutil.MysqlUtil;

@WebServlet("/usr/*")
public class DispatcherServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		Rq rq = new Rq(req, resp);
		
		if(rq.isInvalid()) {
			rq.print("올바른 요청이 아닙니다.");
			return;
		}
		
		
		Controller controller = null;
		
		if(runInterceptors(rq) == false) {
			return;
		}
		
		switch(rq.getControllerTypeName()) {
		case "usr":
			switch(rq.getControllerName()) {
			case "article":
				controller = Container.usrArticleController;
				break;
			case "member":
				controller = Container.usrMemberController;
				break;
			}
			break;
		}
		
		if(controller != null) {
			
			controller.performAction(rq);
			
			MysqlUtil.closeConnection();
		}else {
			rq.print("올바른 요청이 아닙니다.");
			return;
		}
		
	}

	private boolean runInterceptors(Rq rq) {
		if(Container.beforeActionInterceptor.runBeforeAction(rq) == false) {
			return false;
		}
		
		if(Container.needLoginInterceptor.runBeforeAction(rq) == false) {
			return false;
		}
		
		if(Container.needLogoutInterceptor.runBeforeAction(rq) == false) {
			return false;
		}
		
		return true;
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

		doGet(req, resp);
	}

}