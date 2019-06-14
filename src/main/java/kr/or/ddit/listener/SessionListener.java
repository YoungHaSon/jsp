package kr.or.ddit.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SessionListener implements HttpSessionListener {

	private static final Logger logger = LoggerFactory
			.getLogger(SessionListener.class);
	
	private Map<String, HttpSession> sessionMap = new HashMap<String, HttpSession>();  
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		se.getSession().getServletContext().setAttribute("sessionMap", sessionMap);
		logger.debug("Session Created : {}", se.getSession().getId());
		sessionMap.put(se.getSession().getId(), se.getSession());
		
//		getSession() ?
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		logger.debug("Session Destroyed : {}", se.getSession().getId());
		sessionMap.remove(se.getSession().getId());
		
	}
}
