package cn.dinner.util;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import cn.dinner.action.UsersAction;

public class SessionCounter implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		String sessionId=se.getSession().getId(); 
		UsersAction.user_session.remove(UsersAction.sessionId_user.get(sessionId));
		UsersAction.sessionId_user.remove(sessionId);
	}

}
