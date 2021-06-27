package com.cbg.exam1.http.controller;

import com.cbg.exam1.container.Container;
import com.cbg.exam1.dto.ResultData;
import com.cbg.exam1.http.Rq;
import com.cbg.exam1.service.MemberService;

public class UsrMemberController extends Controller {
	private MemberService memberService = Container.memberService;
	
	@Override
	public void performAction(Rq rq) {
		
		switch(rq.getActionMethodName()) {
		case "login" :
			actionShowLogin(rq);
			break;
		case "doLogin" :
			actionDoLogin(rq);
			break;
		default:
			rq.println("존재하지 않는 페이지입니다.");
			break;
		}
		
	}


	private void actionDoLogin(Rq rq) {
		String loginId = rq.getParam("loginId", "");
		String loginPw = rq.getParam("loginPw", "");
		
		if(loginId.length() == 0) {
			rq.historyBack("loginId를 입력해주세요.");
			return;
		}
		
		if(loginPw.length() == 0) {
			rq.historyBack("loginPw를 입력해주세요.");
			return;
		}
		
		ResultData loginRd = memberService.login(loginId, loginPw);
		
		if(loginRd.isFail()) {
			rq.historyBack(loginRd.getMsg());
		}
		
	}


	private void actionShowLogin(Rq rq) {
		
		rq.jsp("usr/member/login");
	}

	
}
