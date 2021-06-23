package com.cbg.exam1.repository;

import java.util.List;

import com.cbg.exam1.dto.Article;
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

	public List<Article> getForPrintArticles() {
		SecSql sql = new SecSql();
		sql.append("SELECT A.*");
		sql.append("FROM article AS A");
		sql.append("ORDER BY A.id DESC");
		
		return MysqlUtil.selectRows(sql, Article.class);
		
	}

}
