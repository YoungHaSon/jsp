package kr.or.ddit.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// application은 서버가 실행되면 생기는 공간?
// contextPath -> js, css 경로 설정
// ${cp}/js/jquery.js --> 더 간단히 쓰기 위해?
// ${cp}/js/jquery.js
// application cp 속성이 comtextPath 값을 넣어주면 

public class ApplicationListener implements ServletContextListener {

	private static final Logger logger = LoggerFactory
			.getLogger(ApplicationListener.class);
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application = sce.getServletContext();
		sce.getServletContext().setAttribute("cp",application.getContextPath());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}
}

/*
ServletContextListener

웹 어플리케이션을 실행하는 데 필요한 초기화 작업이나 웹 어플리케이션이 종료된 후 사용된 자원을 반환하는 등의 작업을 수행하는데 사용된다. 
웹 어플리케이션이 시작되고 종료될 때 특정한 기능을 실행하려면 다음과 같은 코드를 작성하면 된다.

① javax.servlet.ServletcontextListener 인터페이스를 구현한 클래스를 작성한다.
② web.xml 파일에 ① 번에서 작성한 클래스를 등록한다.

ServletContextListener 인터페이스는 다음 두 개의 메서드가 정의되어 있다.

- public void contextInitialized(ServletContextEvent sce) : 웹 어플리케이션이 초기활될 때 호출된다.
- public void contextDestroyed(ServletContextEvent sce) : 웹 어플리케이션이 종료될 때 호출된다.

ServletContextListener 인터페이스를 구현한 클래스가 웹 어플리케이션이 시작되거나 종료될 때 실행되도록 하려면 
web.xml 파일에 <listener> 태그와 <listener-class> 태그를 사용해서 완전한 클래스 이름을 명시해 주면 된다.


ex)

<web-app ...>
      <listener>
             <listener-class>kame.jdbc.loader.DBCPInitListener</listener-class>
      </listener>

      <listener>
             <listener-class>kame.chap22.CodeInitListener</listener-class>
      </listener>
       ....
</web-app>
=> 한 개 이상의 <listener> 태그를 등록할 수 있으며, 각 <listener> 태그에는 반드시 한 개의 <listener-class> 태그를 자식 태그로 가져야한다.

ServletContextListener 인터페이스에 정의된 두 메서드는 모두 파라미터로 javax.servlet.ServletContextEvent 타입의 객체를 전달 받는데,
ServletContextEvent 클래스는 시작되거나 종료된 웹 어플리케이션 콘텍스트를 구할 수 있는 getServletContext() 메서드를 제공하고 있다.

     - public ServletContext getServletContext()
=> getServletContext() 메서드는 리턴하는 ServletContext 객체는 JSP의 application 기본 객체외 동일한 객체로서, ServletContext 객체를 이용하면 web.xml 파일에 설정된 어플리케이션 초기화 파라미터를 구할 수 있다. 어플리케이션 초기화 파라미터는 다으뫄 같이 <context-param> 태그를 사용해서 web.xml 파일에 설정할 수 있다.

ex)

<?xml version="1.0" encoding="UTF-8"?>
<web-app ...>
    ...

   <context-param>
        <param-name>jdbcdriver</param-name>
        <param-value>com.mysql.jdbc.Driver</param-value>
    </context-param>

    ...
</web-app>

ServletContext가 제공하는 초기화 파라미터 관련 메서드
- String getInitParameter(String name) : 지정한 이름을 갖는 초기화 파라미터의 값을 리턴한다. 존재하지 않을 경우 null을 리턴한다. 
name 파라미터에는 <param-name> 태그로 지정한 이름을 입력한다.

- java.util.Enumeration getInitParameterNames() : web.xml 파일에 정의된 초기화 파라미터의 이름 목록을 Enumeration 타입으로 리턴한다.

*/
