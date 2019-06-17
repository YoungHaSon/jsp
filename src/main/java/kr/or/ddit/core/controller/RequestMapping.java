package kr.or.ddit.core.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.controller.Controller;
import kr.or.ddit.controller.MainController;
import kr.or.ddit.controller.UserListController;
import kr.or.ddit.db.model.UriVo;
import kr.or.ddit.db.service.IuriService;
import kr.or.ddit.db.service.UriService;

//이해 안대!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
public class RequestMapping {

	private static final Logger logger = LoggerFactory
			.getLogger(RequestMapping.class);
	// main.do --> MainController(컨트롤러 인터페이스를 구현한 클래스)
	// userList.do --> UserListController

//	private static Map<String, String> requsetMappingClass;
	private static Map<String, Controller> requsetMapping;
	private static IuriService service = new UriService();
	
	static {
		List<UriVo> uriList = service.uriMapping();
		requsetMapping = new HashMap<String, Controller>();
		
//		requsetMappingClass = new HashMap<String, String>();
//		requsetMappingClass.put("/main.do", "kr.or.ddit.controller.MainController");

		for (UriVo uriVo : uriList ) {
			// classInfo : "kr.or.ddit.controller.MainController"
			String classInfo = uriVo.getClassname();
			try {
				//클래스 생성?
				Class clazz = Class.forName(classInfo);
				//클래스 인스턴스 객체 생성
				Object obj = clazz.newInstance();
				//						     인터페이스 = new 구현체
				// 랑 같은 뜻...Controller controller = new MainController();
				
				// key, value로 담아
				requsetMapping.put(uriVo.getUri(), (Controller) obj);
				
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		Integer i = new Integer(1);

		// requsetMapping.put("/main.do", new MainController());
		// requsetMapping.put("/userList.do", new UserListController());

	}

	public static Controller getController(String uri) {
		logger.debug("getController: {}", uri);
		return requsetMapping.get(uri);
	}

}
