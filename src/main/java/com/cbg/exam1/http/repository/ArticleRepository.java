package com.cbg.exam1.http.repository;

import com.cbg.mysqlutil.MysqlUtil;
import com.cbg.mysqlutil.SecSql;

public class ArticleRepository {

	public int write(String title, String body) {
		SecSql sql = new SecSql();
		sql.append("INSERT INTO article");
		sql.append("SET regDate = NOW()");
		sql.append(", updateDate = NOW()");
		sql.append(", title = ?", title);
		sql.append(", `body` = ?", body);
		int id = MysqlUtil.insert(sql);
		
		return id;
	}

}
