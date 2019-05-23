<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	//4가지 파라미터를 받아서, 4개의 영역에 속성으로 넣어준다.
	//속성으로 넣는 방법! : scope객체.setAttribute("속성명", 속성(객체));
	//scope객체  : pageContext, request, session, application
	
	pageContext.setAttribute("pageAttribute", request.getParameter("pageParam"));
	session.setAttribute("sessionAttribute", request.getParameter("sessionParam"));
	
	request.setAttribute("requestAttribute", request.getParameter("requestParam"));
	application.setAttribute("applicationAttribute", request.getParameter("applicationParam"));
	
	//forward
	
	request.getRequestDispatcher("/scope/scopePrint.jsp").forward(request, response);
	
	
 


%>
