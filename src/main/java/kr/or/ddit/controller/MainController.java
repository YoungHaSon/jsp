package kr.or.ddit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "/main.jsp"; 
		
//		return "redirect:/main.jsp"; 
		
		// 기본값 --> forward
		// redirect :/main.jsp --> redirect
//		request.getRequestDispatcher("/main.jsp").forward(request, response);
		
	}

}