package kr.or.ddit.mul;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class mulCalculation
 */

@WebServlet("/mulCalculation")
public class mulCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger logger = LoggerFactory
			.getLogger(mulCalculation.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mul1 = Integer.parseInt(request.getParameter("mul1"));
		int mul2 = Integer.parseInt(request.getParameter("mul2"));
		
		int mul = mul1 * mul2;
		
		request.getSession().setAttribute("mulResult", mul);
		
		request.getRequestDispatcher("/mul/mulResult.jsp").forward(request, response);
		
		
	}

}
