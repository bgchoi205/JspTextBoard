package com.cbg.exam1.service;

import java.util.List;

import com.cbg.exam1.container.Container;
import com.cbg.exam1.dto.Article;
import com.cbg.exam1.dto.Member;
import com.cbg.exam1.dto.ResultData;
import com.cbg.exam1.repository.ArticleRepository;
import com.cbg.exam1.util.Ut;

public class ArticleService {
	private ArticleRepository articleRepository = Container.articleRepository;
	
	
	public ResultData write(int boardId, int memberId, String title, String body) {
		int id = articleRepository.write(boardId, memberId, title, body);
		
		return ResultData.from("S-1", Ut.f("%d번 게시물 생성 완료", id),"id", id);
	}

	public List<Article> getForPrintArticles() {
		
		return articleRepository.getForPrintArticles();
	}

	public Article getForPrintArticleById(int id) {
		return articleRepository.getForPrintArticleById(id);
	}

	public ResultData delete(int id) {
		articleRepository.delete(id);
		
		return ResultData.from("S-1", Ut.f("%d번 게시물 삭제 완료", id),"id", id);
	}

	public ResultData modify(int id, String title, String body) {
		articleRepository.modify(id, title, body);
		
		return ResultData.from("S-1", Ut.f("%d번 게시물 수정 완료", id),"id", id);
	}

	public ResultData actorCanModify(Member loginedMember, Article article) {
		int loginedMemberId = loginedMember.getId();
		int memberId = article.getMemberId();
		
		if(loginedMemberId != memberId) {
			return ResultData.from("F-1", Ut.f("권한이 없습니다."));
		}
		
		return ResultData.from("S-1", Ut.f("수정 가능"));
	}

	public ResultData actorCanDelete(Member loginedMember, Article article) {
		int loginedMemberId = loginedMember.getId();
		int memberId = article.getMemberId();
		
		if(loginedMemberId != memberId) {
			return ResultData.from("F-1", Ut.f("권한이 없습니다."));
		}
		
		return ResultData.from("S-1", Ut.f("삭제 가능"));
	}

}
