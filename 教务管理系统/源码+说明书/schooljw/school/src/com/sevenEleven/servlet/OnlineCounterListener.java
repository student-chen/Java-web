package com.sevenEleven.servlet;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


import com.sevenEleven.javaBean.Count;

public class OnlineCounterListener implements HttpSessionListener {
	public void sessionCreated(HttpSessionEvent hse) {
		Count.raise();
	}

	public void sessionDestroyed(HttpSessionEvent hse) {
		Count.reduce();
	}
}