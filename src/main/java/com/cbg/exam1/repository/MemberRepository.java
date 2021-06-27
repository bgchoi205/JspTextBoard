package com.cbg.exam1.repository;

import com.cbg.exam1.dto.Article;
import com.cbg.exam1.dto.Member;
import com.cbg.mysqlutil.MysqlUtil;
import com.cbg.mysqlutil.SecSql;

public class MemberRepository {

	public Member getMemberByLoginId(String loginId) {
		SecSql sql = new SecSql();
		sql.append("SELECT M.*");
		sql.append("FROM `member` AS M");
		sql.append("WHERE M.loginId = ?", loginId);
		return MysqlUtil.selectRow(sql, Member.class);
	}

}
