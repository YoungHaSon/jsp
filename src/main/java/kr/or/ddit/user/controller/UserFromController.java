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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.UserService;

/**
 * Servlet implementation class Join
 */
@WebServlet("/userForm")
public class UserFromController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private static final Logger logger = LoggerFactory
			.getLogger(UserFromController.class);
	
	private IuserService userService;
	
	@Override
	public void init() throws ServletException {
		userService = new UserService();
	}
	
	//사용자 등록 화면 요청 처리 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사용자 등록 화면으로 이동
		request.getRequestDispatcher("/user/userForm.jsp").forward(request, response);
	}
	
	//사용자 등록 요청 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("userForm doPost()");
		
		request.setCharacterEncoding("UTF-8");
		
		//사용자가 보낸 파라미터를 사용해서 UserVo 인스턴스를 만들어서
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
		
		//사용자가 입력한 userId가 이미 존재하는 userId인지 체크
		//존재하지 않을 경우{
		UserVo dbUser = userService.getUser(userId);
		
		//등록된 사용자가 아닌경우 --> 정상입력이 가능한 상태
		if(dbUser == null){
			//	userService 객체를 통해 insertUser(userVo);
			int insertCnt = userService.insertUser(userVo);
			
			//정상등록! --->사용자 페이징 리스트로 이동!
			if(insertCnt ==1){
				//sendRedirect get으로 요청을 보내는거!
				response.sendRedirect(request.getContextPath()+"/userPagingList");
			}
			
		//아이디가 중복된 경우	
		// 사용자 등록 페이지로 이동 --> "이미 존재하는 userId입니다." alert나 text로 표시
		}else{
			//redirect --> request가 새로 만들어진다 따라서 안에 있는 값 다 날라감! , forward request 재사용 가능
//			request.getRequestDispatcher("/userForm").forward(request, response); 요걸로 하면 다시 post메서드로 오니까 error발생
			// 사용자 등록 페이지로 이동 --> "이미 존재하는 userId입니다." alert나 text로 표시
			request.setAttribute("msg", "이미 존재하는 사용자 입니다.");
			doGet(request, response);
		}
		
	
	
	}

}
