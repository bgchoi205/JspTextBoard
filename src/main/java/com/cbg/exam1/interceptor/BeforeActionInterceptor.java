package com.cbg.exam1.interceptor;

import com.cbg.exam1.dto.Member;
import com.cbg.exam1.http.Rq;
import com.cbg.exam1.util.Ut;
import com.fasterxml.jackson.core.type.TypeReference;

public class BeforeActionInterceptor extends Interceptor {

	@Override
	public boolean runBeforeAction(Rq rq) {
		boolean isLogined = false;
		int loginedMemberId = 0;
		Member loginedMember = null;
		
		String loginedMemberJson = rq.getSessionAttr("loginedMemberJson", "");
		
		if (loginedMemberJson.length() > 0) {
			rq.setLogined(true);
			rq.setLoginedMember(Ut.toObjFromJson(loginedMemberJson, Member.class));
			rq.setLoginedMemberId(rq.getLoginedMember().getId());
		}

		rq.setAttr("rq", rq);
		
		return true;
	}
	
}
