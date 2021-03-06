package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingFilter implements Filter {

	private static final Logger logger = LoggerFactory
			.getLogger(LoggingFilter.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//전처리
//		HttpServletRequest req = (HttpServletRequest)request;
		String uri = ((HttpServletRequest)request).getRequestURI();
		logger.debug("LoggingFilter에서 doFilter 전처리 과정 : {}",uri);
		
		//다음 servlet, jsp 요청
		logger.debug("LoggingFilter에서 doFilter 후처리 과정 입니다.");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		
	}
}
