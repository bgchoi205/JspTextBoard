package com.cbg.exam1.service;

import com.cbg.exam1.container.Container;
import com.cbg.exam1.dto.Member;
import com.cbg.exam1.dto.ResultData;
import com.cbg.exam1.repository.MemberRepository;

public class MemberService {
	private MemberRepository memberRepository = Container.memberRepository;

	public ResultData login(String loginId, String loginPw) {
		Member member = memberRepository.getMemberByLoginId(loginId);
		
		if(member == null) {
			return ResultData.from("F-1", "존재하지 않는 아이디입니다.");
		}
		
		if(member.getLoginPw().equals(loginPw) == false) {
			return ResultData.from("F-2", "비밀번호가 틀립니다.");
		}
		
		return ResultData.from("S-1", "환영합니다.", "member", member);
	}

}
