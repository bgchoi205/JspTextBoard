package com.cbg.exam1.http.controller;

import com.cbg.exam1.http.Rq;
import com.cbg.exam1.http.service.ArticleService;

public class UsrArticleController extends Controller {
	private ArticleService articleService;
	
	public UsrArticleController() {
		articleService = new ArticleService();
	}

	@Override
	public void performAction(Rq rq) {
		
		switch(rq.getActionMethodName()) {
		case "write" :
			actionShowWrite(rq);
			break;
			
		case "doWrite" :
			actionDoWrite(rq);
			break;
		}
		
	}

	private void actionDoWrite(Rq rq) {
		String title = rq.getParam("title", "");
		String body = rq.getParam("body", "");
		
		rq.printf("title : %s<br>", title);
		rq.printf("body : %s<br>", body);
		
	}

	private void actionShowWrite(Rq rq) {
		rq.jsp("usr/article/write");
		
	}

	
}
