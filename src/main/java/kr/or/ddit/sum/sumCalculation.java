package kr.or.ddit.sum;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class sumCalculation
 */

@WebServlet("/sumCalculation")
public class sumCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	private static final Logger logger = LoggerFactory
		.getLogger(sumCalculation.class);
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		int sum1 = Integer.parseInt(request.getParameter("sum1"));
		int sum2 = Integer.parseInt(request.getParameter("sum2"));
		
		int sum = 0;
		 
	        for (int i = sum1; i <= sum2; i++) {
	 
	            sum += i;
	        }
	        
		request.getSession().setAttribute("sumResult", sum);
		
		request.getRequestDispatcher("/sum/sumResult.jsp").forward(request, response);
	}

}
