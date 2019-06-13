package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.UserService;

/**
 * Servlet implementation class Pagingnation
 */
@WebServlet("/userPagingList")
public class UserPagination extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 필수입니다 리스트를 받아올라면~!!
	private IuserService userService;

	@Override
	public void init() throws ServletException {
		userService = new UserService();
	}
	//////////////////////////////////////////////

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// left.jsp 부분에서 /userPagingList?page=1&pageSize=10 매개로 page 1 pageSize
		// 10 이 넘어 오니까
		// int형으로 형변환! 매개로 page pageSize를 넘겨준다!
		//파라미터가 없을경우 page = 1, pageSize =10 기본값으로 설정
		String pageString = request.getParameter("page");
		String pageSizeString = request.getParameter("pageSize");
		
		int page = pageString == null ? 1 : Integer.parseInt(pageString);
		int pageSize = pageSizeString == null ? 10 : Integer.parseInt(pageSizeString);
		
		//page, pageSize 파타 미터를 이용하여 PageVo작성
		PageVo pageVo = new PageVo(page, pageSize);
		
		//pageVo를 이용한 사용자 페이징 리스트 조회
		Map<String, Object> resultMap = userService.userPagingList(pageVo);
		
		//요렇게 Map으로 담아주고 jsp에서 따로 뽑아도 된다! 
//		request.setAttribute("resultMap", resultMap);
		
		//아니면 미리 꺼내서 넘겨도 괜춘!
		List<UserVo> userList = (List<UserVo>)resultMap.get("userList");
		int paginationSize = (Integer)resultMap.get("paginationSize");
		
		request.setAttribute("userList", userList);
		request.setAttribute("paginationSize", paginationSize);
		request.setAttribute("pageVo", pageVo);
		
		RequestDispatcher rd = request.getRequestDispatcher("/user/pagination.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
