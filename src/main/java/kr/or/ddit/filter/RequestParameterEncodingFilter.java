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
    }
	
	public void destroy() {
		//필터가 웹 콘테이너에서 삭제될 때 호출된다.
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//체인을 따라 다음에 존재하는 필터로 이동한다. 체인의 가장 마지막에는 클라이언트가 요청한 최종 자원이 위치한다.
		logger.debug("여기는 UTF-8로 인코딩 하는 곳입니다.");
		
		request.setCharacterEncoding("UTF-8");
		
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		//필터를 웹 콘테이너내에 생성한 후 초기화할 때 호출한다.
	}

}
