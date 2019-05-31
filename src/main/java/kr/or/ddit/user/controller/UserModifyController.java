package kr.or.ddit.user.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.UserService;

/**
 * Servlet implementation class UserModifyController
 */
@WebServlet("/UserModifyController")
public class UserModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger logger = LoggerFactory
			.getLogger(UserModifyController.class);
	
	private IuserService userService;
	
	@Override
	public void init() throws ServletException {
		userService = new UserService();
	}
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("Modify doGet");
		
		//이름 보내준다
		String userId = request.getParameter("userId");
		
		UserVo userVo =  userService.getUser(userId);

		request.setAttribute("userVo", userVo);
		
		RequestDispatcher rd = request.getRequestDispatcher("/user/userModify.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("Modify doPost");
		
		
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String alias = request.getParameter("alias");
		String birth = request.getParameter("birth"); // Date타입으로 바꿔줘야한다
		String zipcd = request.getParameter("zipcd");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		UserVo userVo = null;
		try {
			userVo = new UserVo(userId, name, alias, pass, addr1, addr2, zipcd, sdf.parse(birth));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//	userService 객체를 통해 insertUser(userVo);
		int updateCnt = userService.updateUser(userVo);
		
		//정상등록! --->사용자 페이징 리스트로 이동!
		if(updateCnt == 1){
			//sendRedirect get으로 요청을 보내는거!
			response.sendRedirect(request.getContextPath() + "/userPagingList");
		}
	
		
	}

}
