package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasicServlet extends HttpServlet {


	//요청과 응답과 관련
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw = resp.getWriter();
		pw.write("<html>");
		pw.write("	<head>");
		pw.write("		<title>hello, world!</title>");
		pw.write("		<style>span{border : 3px solid red; font-size : 2em; background : cyan;} </style>");
		pw.write("	</head>");
		pw.write("	<body>");
		pw.write("		<span>hello, world!</span>");
		pw.write("	</body>");
		pw.close();
		
	}
	
	@Override //딱 최초 1번만 호출 
	public void init() throws ServletException {
		System.out.println("BasicServlet init()");
	}
	
}
