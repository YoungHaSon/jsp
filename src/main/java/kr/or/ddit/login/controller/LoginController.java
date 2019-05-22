package kr.or.ddit.login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
* LoginController.java
* 로그인 처리 컨트롤러
* @author PC13
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정자 수정내용
* ------ ------------------------
* PC13 최초 생성
*
* </pre>
*/

//web.xnl servlet, servlet-mapping --> java annotation
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//개발할 때 쓰이는 아주 중요한것!
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	//사용자 로그인 화면 요청 처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("LoginController doGet()");
		
		
		//login 화면을 처리해줄 누군가?에게 위임 (단순 login화면을 html로 응답을 생성해주는 작업이 필요)
		//  /login/login.jsp 위임하면 댐! --> 서버상에 별도의 상태변경을 가하는 요청이 아니기 때문에 
		//  dispatch 방식으로 위임
		
//		RequestDispatcher rd = request.getRequestDispatcher("/login/login.jsp");
//		rd.forward(request, response);
		
		request.getRequestDispatcher("/login/login.jsp").forward(request, response);
		
		
	}
	
	//로그인 요청을 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//처리를 잘하면 console 창에 찍는다!
		logger.debug("parameter userId {} ", request.getParameter("userId") );
		logger.debug("parameter password {} ", request.getParameter("password") );
	
		//사용자 파라미터 userId, password
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		//일반적으로 DB에서 해당 사용자의 정보조회(service객체, dao객체)
		//해당 사용자 정보를 이용하여 사용자가 보낸 userId, password가 일치하는 지 검사
		// 하지만 우리는 --> userId : brown이고 password : brown1234라는 값일 때 통과, 그 이외값은 불일치
		
		//일치하면 .... 로그인 성공 --> Main화면으로 이동 
		if(userId.equals("brown")&&password.equals("brown1234")){
			RequestDispatcher rd = request.getRequestDispatcher("/main.jsp");
			rd.forward(request, response);
			
		//불일치하면.... Id, Password 잘못 입력 --> 다시 입력하도록 로그인 화면으로 이동!
		}else{
			//로그인 화면으로 이동 : localhost/jsp/login
			//현상환에서 /jsp/login URl로 dispatch 방식으로 위임이 불가!?????
			//request.getMethod(); //Get, Post라는 값을 리턴함.

			response.sendRedirect(request.getContextPath() + "/login");
			
			
		}
		
	
	}

}
