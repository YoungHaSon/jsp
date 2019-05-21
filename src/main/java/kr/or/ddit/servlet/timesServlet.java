package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class timesServlet extends HttpServlet {

	//kr.or.ddit.servlet.timesServlet
	private Logger logger = LoggerFactory.getLogger(timesServlet.class); 
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setContentType("text/html; charset=utf-8");

		PrintWriter pw = resp.getWriter();

		// http://localhost/jsp/time?param=6&param2=4
		//trace, debug, info, warn, error
		
		String param = req.getParameter("i");//param 이름을 내맘대로 줄수있어요!
		logger.debug("param : {}" , param); //--> 요런 방법을 선호한다???
		
		String param2 = req.getParameter("j");//param 이름을 내맘대로 줄수있어요!
		logger.debug("param2 : {}" , param2);
		
		int pass = Integer.parseInt(param); //String 형이기 때문에 int형으로 바꿈
		int pass2 = Integer.parseInt(param2);//String 형이기 때문에 int형으로 바꿈
		
		pw.write("<html>");
		pw.write("	<head>");
		pw.write("		<style>td{border : 1px solid black;}");
		pw.write("		</style>");
		pw.write("	</head>");
		pw.write("	<body>");
		pw.write("		<table>");
		pw.write("<th>구구단.....!</th>");

		for (int i = 0; i <= pass2; i++) {
			pw.write("<tr>");
			for (int j = 2; j <= pass; j++) {
				if (i == 0) {
					pw.write("<th>");
					pw.write(j + "단");
					pw.write("</th>");
				} else if (i != 0) {
					pw.write("<td>");
					pw.write(j + "*" + i + "=" + j * i);
					pw.write("</td>");
				}
			}
			pw.write("</tr>");
		}
		pw.write("		</table>");
		pw.write("	</body>");
		pw.write("</html>");
		pw.close();

	}

}
