package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NowTimeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8"); //한글을쓰려면 필요
		
		PrintWriter dt = resp.getWriter();
		
		Date today = new Date();
	
		SimpleDateFormat sysdate = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss"); 
		
		dt.write(sysdate.format(today));
		
		dt.close();
	}

	
}
