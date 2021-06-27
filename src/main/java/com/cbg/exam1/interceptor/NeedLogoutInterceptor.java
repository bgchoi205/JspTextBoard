package com.cbg.exam1.interceptor;

public class NeedLogoutInterceptor extends Interceptor {

	@Override
	boolean runBeforeAction() {
		return true;
	}
	
}