package com.cbg.exam1.interceptor;

public class NeedLoginInterceptor extends Interceptor {

	@Override
	boolean runBeforeAction() {
		return true;
	}
	
}