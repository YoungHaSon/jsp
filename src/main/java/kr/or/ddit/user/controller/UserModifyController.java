package kr.or.ddit.user.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.util.PartUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@WebServlet("/UserModifyController")
@MultipartConfig(maxFileSize = 1024 * 1024 * 3, maxRequestSize = 1024 * 1024 * 15)
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
		
		
//		request.setCharacterEncoding("UTF-8"); --> 필터로!ㄱㄱ
		
		String userId = request.getParameter("userId");
		String name = request.getParameter("name");
		String alias = request.getParameter("alias");
		String birth = request.getParameter("birth"); // Date타입으로 바꿔줘야한다
		String zipcd = request.getParameter("zipcd");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");

		//사용자가 보낸 평문 비밀번호 데이터 --> 암화화!
		String pass = request.getParameter("pass");
		pass = KISA_SHA256.encrypt(pass);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		//이 친구가 하는 역할은 뭘까? 
		UserVo userVo = null;
		try {
			userVo = new UserVo(userId, name, alias, pass, addr1, addr2, zipcd, sdf.parse(birth),"","");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//userModify.jsp 에서 profile이라는 name속성값을 받아옴! 
		Part profile = request.getPart("profile");
		
		//파일에 정보? 가있으면?! userVo에 담는다!
		if(profile.getSize() != 0){
			//
			String contentDisposition = profile.getHeader("content-disposition");
			//파일명 반환 받아온다!
			String fileName = PartUtil.getFileName(contentDisposition);
			
			String ext = PartUtil.getExt(fileName);
			 
			String uploadPath = PartUtil.getUploadPath();
			File uploadFolder = new File(uploadPath);
			
			//폴더가 존재할경우 
			if(uploadFolder.exists()){
				String filePath = uploadPath + File.separator + UUID.randomUUID().toString() + ext;
				
				//사진의 위치
				userVo.setPath(filePath);
				//사진 이름
				userVo.setFilename(fileName);
				
				//파일 복사!
				profile.write(filePath);
				//임시 공간 제거
				profile.delete();
			}
			
			//없으면 기존의 데이터를 가져와서 다시 그대로 띄운다
		} else{
			userVo.setPath(userService.getUser(userId).getPath());
			userVo.setFilename(userService.getUser(userId).getFilename());
		}
			
		//	userService 객체를 통해 insertUser(userVo);
		int updateCnt = userService.updateUser(userVo);
		
		//정상등록! --->사용자 페이징 리스트로 이동!
		if(updateCnt == 1){
			request.setAttribute("userVo", userVo);
			request.getRequestDispatcher("/user/user.jsp").forward(request, response);

		}
	
	}

}
