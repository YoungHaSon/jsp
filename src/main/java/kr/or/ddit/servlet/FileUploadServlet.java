package kr.or.ddit.servlet;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Collection;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.util.PartUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/fileUpload")
// 3mb
@MultipartConfig(maxFileSize = 1024 * 1024 * 3, maxRequestSize = 1024 * 1024 * 15)
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory
			.getLogger(FileUploadServlet.class);

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	// 파일 업로드 --> Post방식으로만 가능
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// userId, profile 파라미터를 확인
		String userId = request.getParameter("userId");
		String profile = request.getParameter("profile");

		// 파일명이 출력됩니다~
		logger.debug("UserId : {} ", userId);
		logger.debug("profile : {} ", profile);

		// input 타입의 name속성값을 넣어준다
		Part part = request.getPart("profile");
		logger.debug("part.getSize() : {}", part.getSize());

		// 파일이 존재할 떄만 파일을 정해진 위치에 기록한다.
		if (part.getSize() > 0) {

			Collection<String> headerNames = part.getHeaderNames();
			String contentDisposition = part.getHeader("content-disposition");
			String fileName = PartUtil.getFileName(contentDisposition);

			for (String header : headerNames)
				logger.debug("{} : {} ", header, part.getHeader(header));

			// 파일 디스크에 쓰기? jsp에서 입력받은 이미지 파일을 해당 경로에 저장 시키는!
			// 같은 파일명이 있으면 덮어 씌워짐...가짜 이름을 만들어줘야함...

			// 확장자 붙여주기! --> 업로드하는 파일의 확장자를 떼어서 붙이는?..
			// String str = fileName.substring(fileName.lastIndexOf("."));
			String ext = PartUtil.getExt(fileName);

			// File.separator --> "\\"
			String uploadPath = PartUtil.getUploadPath();
			File uploadFolder = new File(uploadPath);
			
			if (uploadFolder.exists()) {
				part.write(uploadPath + File.separator
						+ UUID.randomUUID().toString() + ext);
				// 임시적으로 생긴 파일의 공간을 지우는
				part.delete();
			}

		}
	}
}
