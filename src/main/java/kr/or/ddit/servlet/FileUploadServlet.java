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
@MultipartConfig(maxFileSize = 1024 * 1024 * 3, maxRequestSize = 1024 * 1024)
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
			logger.debug("part.getContentType()" + part.getContentType());
			logger.debug("part.getName()" + part.getName());

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

			Date dt = new Date();
			SimpleDateFormat yyyymmSdf = new SimpleDateFormat("yyyyMM");

			String yyyymm = yyyymmSdf.format(dt);
			String yyyy = yyyymm.substring(0,4);
			//substring(4); 4만써줘도 4번째 index에서 끝까지를 가져옴
			String mm = yyyymm.substring(4,6);

			// 년도에 해당하는 폴더가 있는지, 년도안에 월에 해당하는 폴더가 있는지 검색필요
			File YFolder = new File("d:\\upload\\" + yyyy);
			// 신규년도로 넘어갔을때 해당 년도의 폴더를 생성한다.
			if (!YFolder.exists()) {
				// 디렉토리 생성?
				YFolder.mkdir();
			}

			// 월에 해당하는 폴더가 있는지 확인
			File MFolder = new File("d:\\upload\\2019\\" + mm);
			if (!MFolder.exists()) {
				// 디렉토리 생성?
				MFolder.mkdir();
			}

//			File.separator --> "\\"
			String uploadPath = "d:\\upload\\" + yyyy + File.separator + mm;
			File uploadFolder = new File(uploadPath);
			if (uploadFolder.exists()) {
				part.write(uploadPath + File.separator + UUID.randomUUID().toString() + ext);
				// 임시적으로 생긴 파일의 공간을 지우는
				part.delete();
			}
			
		}
	}
}
