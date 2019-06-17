package kr.or.ddit.core.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.controller.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//불필요한 servlet생성 XX 위해!

//localhost/userList.do --> init --> 
@WebServlet("*.do")
//이 친구가 모든 mapping을 받음!

public class FrontController extends HttpServlet{
	private static final long serialVersionUID = -6634139402055661534L; 
	//mvc 패턴에서 만드는 유일한 servlet?
	
	private static final Logger logger = LoggerFactory
			.getLogger(FrontController.class);

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		logger.debug("service : {}", req.getRequestURI());
		
		//uri를 처리해줄수 있는 controller로? 
		String uri = req.getRequestURI();
		
		Controller controller = RequestMapping.getController(uri);
		String viewName = controller.execute(req,resp);
		
		//받아온 view이름으로 처리
		ViewResolver.viewResolve(viewName, req, resp);
		
	}
}
