package com.cbg.exam1.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/HomeMainServlet")
public class UsrHomeMainServlet extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		//들어오는 파라미터를 UTF-8로 해석.
		request.setCharacterEncoding("UTF-8");
		
		// 서블릿이 HTML 파일을 만들 때 UTF-8로 쓰기.
		response.setCharacterEncoding("UTF-8");
		
		// HTML이 UTF-8 형식이라는 것을 브라우저에 알림.
		response.setContentType("text/html; charset=UTF-8");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}