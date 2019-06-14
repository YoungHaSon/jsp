package kr.or.ddit.user.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.util.PartUtil;

/**
 * Servlet implementation class Join
 */
@WebServlet("/userForm")
@MultipartConfig(maxFileSize = 1024 * 1024 * 3, maxRequestSize = 1024 * 1024 * 15)
public class UserFromController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory
			.getLogger(UserFromController.class);

	private IuserService userService;

	@Override
	public void init() throws ServletException {
		userService = new UserService();
	}

	// 사용자 등록 화면 요청 처리
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 사용자 등록 화면으로 이동
		request.getRequestDispatcher("/user/userForm.jsp").forward(request,
				response);
	}

	// 사용자 등록 요청 처리
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		logger.debug("userForm doPost()");

//		request.setCharacterEncoding("UTF-8"); --> 필터로 옮김!

		// 사용자가 보낸 파라미터를 사용해서 UserVo 인스턴스를 만들어서
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
			userVo = new UserVo(userId, name, alias, pass, addr1, addr2, zipcd,
					sdf.parse(birth),"","");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// 사용자가 입력한 userId가 이미 존재하는 userId인지 체크
		// 존재하지 않을 경우{
		UserVo dbUser = userService.getUser(userId);

		// 등록된 사용자가 아닌경우 --> 정상입력이 가능한 상태
		if (dbUser == null) {
			// profile에 대한 파일 업로드 처리!
			Part profile = request.getPart("profile");

			// 사용자가 파일을 업로드 한 경우
			if (profile.getSize() > 0) {
				// 실제 파일명 사진에 대한 정보를 받아온다.
				String contentDisposition = profile.getHeader("content-disposition");
				//사진명을 받아온다
				String fileName = PartUtil.getFileName(contentDisposition);
				
				String ext = PartUtil.getExt(fileName);
				
				// File.separator --> "\\"
				String uploadPath = PartUtil.getUploadPath();
				File uploadFolder = new File(uploadPath);
				if (uploadFolder.exists()) {
					String filePath = uploadPath + File.separator + UUID.randomUUID().toString() + ext;

					userVo.setPath(filePath);
					userVo.setFilename(fileName);

					profile.write(filePath);
					// 임시적으로 생긴 파일의 공간을 지우는
					profile.delete();
				}
				
				//등록할 떄 사진이 없으면 사진없음 사진이 뜨게끔... d:\\upload\\empty\\sally.png
			} 
			
			//userVo path, fileName ==> null 상태이다
			
			// userService 객체를 통해 insertUser(userVo);
			int insertCnt = userService.insertUser(userVo);

			// 정상등록! --->사용자 페이징 리스트로 이동!
			if (insertCnt == 1) {
				// sendRedirect get으로 요청을 보내는거!
				response.sendRedirect(request.getContextPath() + "/userPagingList");
			}

			// 아이디가 중복된 경우
			// 사용자 등록 페이지로 이동 --> "이미 존재하는 userId입니다." alert나 text로 표시
		} else {
			request.setAttribute("msg", "이미 존재하는 사용자 입니다.");
			doGet(request, response);
		}
		// redirect --> request가 새로 만들어진다 따라서 안에 있는 값 다 날라감! , forward
		// request 재사용 가능
		// request.getRequestDispatcher("/userForm").forward(request,
		// response); 요걸로 하면 다시 post메서드로 오니까 error발생
		// 사용자 등록 페이지로 이동 --> "이미 존재하는 userId입니다." alert나 text로 표시

	}

}
