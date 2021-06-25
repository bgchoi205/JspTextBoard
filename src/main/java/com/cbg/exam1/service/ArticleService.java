package com.cbg.exam1.service;

import java.util.List;

import com.cbg.exam1.container.Container;
import com.cbg.exam1.dto.Article;
import com.cbg.exam1.dto.ResultData;
import com.cbg.exam1.repository.ArticleRepository;
import com.cbg.exam1.util.Ut;

public class ArticleService {
	private ArticleRepository articleRepository = Container.articleRepository;
	
	
	public ResultData write(String title, String body) {
		int id = articleRepository.write(title, body);
		
		return ResultData.from("S-1", Ut.f("%d번 게시물 생성 완료", id),"id", id);
	}

	public List<Article> getForPrintArticles() {
		
		return articleRepository.getForPrintArticles();
	}

	public Article getForPrintArticleById(int id) {
		return articleRepository.getForPrintArticleById(id);
	}

}
