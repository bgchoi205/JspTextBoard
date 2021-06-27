package com.cbg.exam1.http.controller;

import java.util.List;

import com.cbg.exam1.container.Container;
import com.cbg.exam1.dto.Article;
import com.cbg.exam1.dto.ResultData;
import com.cbg.exam1.http.Rq;
import com.cbg.exam1.service.ArticleService;
import com.cbg.exam1.util.Ut;

public class UsrArticleController extends Controller {
	private ArticleService articleService = Container.articleService;
	
	@Override
	public void performAction(Rq rq) {
		
		switch(rq.getActionMethodName()) {
		case "list" :
			actionShowList(rq);
			break;
		case "detail" :
			actionDetailList(rq);
			break;
		case "write" :
			actionShowWrite(rq);
			break;	
		case "doWrite" :
			actionDoWrite(rq);
			break;
		case "doDelete" :
			actionDoDelete(rq);
			break;
		case "modify" :
			actionShowModify(rq);
			break;	
		case "doModify" :
			actionDoModify(rq);
			break;
		default:
			rq.println("존재하지 않는 페이지입니다.");
			break;
		}
		
	}

	private void actionDoDelete(Rq rq) {
		int id = rq.getIntParam("id", 0);
		if(id == 0) {
			rq.historyBack("id를 입력해주세요");
			return;
		}
		
		Article article = articleService.getForPrintArticleById(id);
		
		if(article == null) {
			rq.historyBack(Ut.f("%d번은 없는 게시물 번호입니다.", id));
			return;
		}
		
		articleService.delete(id);
		
		rq.replace(id + "번 게시물 삭제 완료", "../article/list");
		
	}

	private void actionDetailList(Rq rq) {
		int id = rq.getIntParam("id", 0);
		if(id == 0) {
			rq.historyBack("id를 입력해주세요");
			return;
		}
		
		Article article = articleService.getForPrintArticleById(id);
		
		if(article == null) {
			rq.historyBack(Ut.f("%d번은 없는 게시물 번호입니다.", id));
			return;
		}
		
		rq.setAttr("article", article);
		
		rq.jsp("usr/article/detail");
		
	}

	private void actionShowList(Rq rq) {
		List<Article> articles = articleService.getForPrintArticles();
		
		rq.setAttr("articles", articles);
		
		rq.jsp("usr/article/list");
	}

	private void actionDoWrite(Rq rq) {
		String title = rq.getParam("title", "");
		String body = rq.getParam("body", "");
		String redirectUri = rq.getParam("redirectUri", "../article/list");
		
		if(title.length() == 0) {
			rq.historyBack("title을 입력해주세요.");
			return;
		}
		
		if(body.length() == 0) {
			rq.historyBack("body를 입력해주세요.");
			return;
		}
		
		ResultData writeRd = articleService.write(title, body);
		int id = (int)writeRd.getBody().get("id");
		
		redirectUri = redirectUri.replace("[NEW_ID]", id + "");
		
		rq.replace(writeRd.getMsg(), redirectUri);
		
	}

	private void actionShowWrite(Rq rq) {
		rq.jsp("usr/article/write");
		
	}
	private void actionDoModify(Rq rq) {
		int id = rq.getIntParam("id", 0);
		String title = rq.getParam("title", "");
		String body = rq.getParam("body", "");
		String redirectUri = rq.getParam("redirectUri", Ut.f("../article/detail?id=%d", id));
		
		if(id == 0) {
			rq.historyBack("id를 입력해주세요.");
			return;
		}
		
		if(title.length() == 0) {
			rq.historyBack("title을 입력해주세요.");
			return;
		}
		
		if(body.length() == 0) {
			rq.historyBack("body를 입력해주세요.");
			return;
		}
		
		ResultData modifyRd = articleService.modify(id, title, body);
		
		rq.replace(modifyRd.getMsg(), redirectUri);
		
	}

	private void actionShowModify(Rq rq) {
		int id = rq.getIntParam("id", 0);
		if(id == 0) {
			rq.historyBack("id를 입력해주세요");
			return;
		}
		
		Article article = articleService.getForPrintArticleById(id);
		
		if(article == null) {
			rq.historyBack(Ut.f("%d번은 없는 게시물 번호입니다.", id));
			return;
		}
		
		rq.setAttr("article", article);
		
		rq.jsp("usr/article/modify");
		
	}

	
}
