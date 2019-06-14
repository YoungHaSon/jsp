package kr.or.ddit.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// application은 서버가 실행되면 생기는 공간?
// contextPath -> js, css 경로 설정
// ${cp}/js/jquery.js --> 더 간단히 쓰기 위해?
// ${cp}/js/jquery.js
// application cp 속성이 comtextPath 값을 넣어주면 

public class ApplicationListener implements ServletContextListener {

	private static final Logger logger = LoggerFactory
			.getLogger(ApplicationListener.class);
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application = sce.getServletContext();
		sce.getServletContext().setAttribute("cp",application.getContextPath());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
