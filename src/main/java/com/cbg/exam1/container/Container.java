package com.cbg.exam1.container;

import com.cbg.exam1.http.controller.UsrArticleController;
import com.cbg.exam1.repository.ArticleRepository;
import com.cbg.exam1.service.ArticleService;

public class Container {
	public static ArticleRepository articleRepository; // 근본적인 것부터 순서대로 만든다.
	public static ArticleService articleService;
	public static UsrArticleController usrArticleController;
	
	public static void init() {
		articleRepository = new ArticleRepository();
		articleService = new ArticleService();
		usrArticleController = new UsrArticleController();
		
	}
}
