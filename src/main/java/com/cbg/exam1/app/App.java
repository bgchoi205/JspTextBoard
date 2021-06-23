package com.cbg.exam1.app;

import com.cbg.exam1.container.Container;
import com.cbg.mysqlutil.MysqlUtil;

public class App {
	public static boolean isDevMode() {
		return true; // false를 리턴하면 productionMode이다.
	}

	public static void init() {
		// DB 세팅
		MysqlUtil.setDBInfo("localhost", "sbsst", "sbs123414", "jsp_board");
		MysqlUtil.setDevMode(isDevMode());
		
		// 공용 객체 세팅
		Container.init();
	}

}
