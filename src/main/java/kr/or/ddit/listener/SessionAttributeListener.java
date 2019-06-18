package kr.or.ddit.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import kr.or.ddit.user.model.UserVo;

public class SessionAttributeListener implements HttpSessionAttributeListener {

	private Map<String, UserVo> sessionUserMap = new HashMap<String, UserVo>();
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		//세션 객체에 속성이 추가되면  웹 컨테이너에 의해 자동으로 실행된다.
		event.getSession().getServletContext().setAttribute("sessionUserMap", sessionUserMap);
	//ServletContext 속성이 추가될때 컨테이너에 의해 자동 실행됨	
		
		//속성명
		if("USER_INFO".equals(event.getName())){
			sessionUserMap.put(event.getSession().getId(), (UserVo)event.getValue());
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		//세션 객체에 속성이 제거되면 기존 웹 컨테이너에 의해 자동으로 실행된다.
		//ServletContext 속성이 삭제(제거)될때 컨테이너에 의해 자동 실행됨
		if("USER_INFO".equals(event.getName())){
			sessionUserMap.remove(event.getSession().getId());
		}
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		//세션 객체에 속성값이 변경되면 웹 컨테이너에 의해 자동으로 실행된다.
		//ServletContext 속성이 수정(변경,교체)될때 컨테이너에 의해 자동 실행됨
	}

}

/*

1. HttpSessionAttributeListener 

HttpSessionAttributeListener는  java.util.EventListener 를 확장한 리스너이며, 
웹 응용 프로그램의 서블릿 세션 속성에 변화가 있을때마다 컨테이너에 의해 호출됩니다.

① public void attributeAdded (HttpSessionBindingEvent e)
세션 객체에 속성이 추가되면  웹 컨테이너에 의해 자동으로 실행된다.

② public void attributeRemoved (HttpSessionBindingEvent e)
세션 객체에 속성이 제거되면 기존 웹 컨테이너에 의해 자동으로 실행된다.

③ public void attributeReplaced (HttpSessionBindingEvent e)
세션 객체에 속성값이 변경되면 웹 컨테이너에 의해 자동으로 실행된다.

*/

