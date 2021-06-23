package com.cbg.exam1.app;

import com.cbg.exam1.container.Container;
import com.cbg.mysqlutil.MysqlUtil;

public class App {

	public static void init() {
		// DB 세팅
		MysqlUtil.setDBInfo("localhost", "sbsst", "sbs123414", "jsp_board");
		MysqlUtil.setDevMode(true);
		
		Container.init();
	}

}
