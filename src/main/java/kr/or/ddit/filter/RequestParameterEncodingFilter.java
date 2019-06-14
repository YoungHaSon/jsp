package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet Filter implementation class RequestParamenterEncodingFilter
 */
//@WebFilter("/*") 
//모든 servlet을 호출할시 이 Filter를 거쳐서 감!
//@WebFilter(urlPatterns={"/uerForm", "/userModify"} 요렇게 복수도 가능!
public class RequestParameterEncodingFilter implements Filter {

	private static final Logger logger = LoggerFactory
			.getLogger(RequestParameterEncodingFilter.class);
   
    public RequestParameterEncodingFilter() {
        // TODO Auto-generated constructor stub
    }
	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		logger.debug("여기는 UTF-8로 인코딩 하는 곳입니다.");
		
		request.setCharacterEncoding("UTF-8");
		
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
