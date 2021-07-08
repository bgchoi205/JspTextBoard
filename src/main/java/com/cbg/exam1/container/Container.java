package com.cbg.exam1.container;

import com.cbg.exam1.http.controller.UsrArticleController;
import com.cbg.exam1.http.controller.UsrMemberController;
import com.cbg.exam1.interceptor.BeforeActionInterceptor;
import com.cbg.exam1.interceptor.NeedLoginInterceptor;
import com.cbg.exam1.interceptor.NeedLogoutInterceptor;
import com.cbg.exam1.repository.ArticleRepository;
import com.cbg.exam1.repository.MemberRepository;
import com.cbg.exam1.service.ArticleService;
import com.cbg.exam1.service.MemberService;

public class Container {
	public static BeforeActionInterceptor beforeActionInterceptor;
	public static NeedLoginInterceptor needLoginInterceptor;
	public static NeedLogoutInterceptor needLogoutInterceptor;
	
	public static ArticleRepository articleRepository; // 근본적인 것부터 순서대로 만든다.
	public static ArticleService articleService;
	public static UsrArticleController usrArticleController;
	
	public static MemberRepository memberRepository;
	public static MemberService memberService;
	public static UsrMemberController usrMemberController;
	
	public static void init() {
		articleRepository = new ArticleRepository();
		memberRepository = new MemberRepository();
		
		articleService = new ArticleService();
		memberService = new MemberService();
		
		beforeActionInterceptor = new BeforeActionInterceptor();
		needLoginInterceptor = new NeedLoginInterceptor();
		needLogoutInterceptor = new NeedLogoutInterceptor();
		
		usrArticleController = new UsrArticleController();
		usrMemberController = new UsrMemberController();
		
	}
}
