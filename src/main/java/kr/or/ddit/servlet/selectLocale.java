package kr.or.ddit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class selectLocale
 */
@WebServlet("/selectLocale")
public class selectLocale extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger logger = LoggerFactory
			.getLogger(selectLocale.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String locale = request.getParameter("locale");
		logger.debug("locale : {}", locale);
		
		if(locale == null){
			request.setAttribute("locale", "ko");
		}else{
			request.setAttribute("locale", locale);
		}
		request.getRequestDispatcher("/jstl/selectLocale.jsp").forward(request, response);
		
		
	}

}
