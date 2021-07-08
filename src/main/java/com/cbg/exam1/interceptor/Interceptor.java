package com.cbg.exam1.interceptor;

import com.cbg.exam1.http.Rq;

public abstract class Interceptor {
	abstract public boolean runBeforeAction(Rq rq);
}
