<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h2>Core 라이브러리의 set!</h2>
	<!-- var : 속성명, value : 값, scope : page(default), request, session, application -->
	<!-- 로그인 한 상태의 별명을 userId 속성에 담고 request공간에 담는?  -->
	<c:set var="userId" value="${USER_INFO.alias }" scope="request"/> <!-- 요놈은 가끔 사용 한데요...  -->
		<!-- 밑에 2줄이랑 같은 뜻...;; -->
		<%-- <%
			UserVo USER_INFO = (UserVo)session.getAttribute("USER_INFO");
			pageContext.setAttribute("userId", USER_INFO.getAlias());
		%> --%>
	
	<!-- userId라는 속성에 Brown이라는 값을 넣어라? -->
	<!-- request에 있는 userId 값을 뽑아오는? -->
	userId : ${userId }<br>
	requestScope.userId : ${requestScope.userId }<br>
	
	<!-- target 대상 속성, property : 대상 속성의 필드 value : 대입값 -->
	<!-- USER_INFO 안에 있는 alias 값을 bear로 바꾸고 싶다! -->
	<c:set target="${USER_INFO }" property="alias" value="bear" />
	USER_INFO.alias : ${USER_INFO.alias }<br>

	<h2>c:if 태그  --> java의 if-else if -else와는 다른 개념이다 [if]에만 해당 (c:choose)태트가 일반적인 if문</h2>
	
	<!-- java로 비유하자면 if(test) 이부분과 같다 단일 if 가능 -->
	
	<!-- USER_INFO의 아이디가 brown 이면 밑에 문장 실행! -->
	<c:if test="${USER_INFO.userId == 'brown' }">
		userId는 ${USER_INFO.userId } 입니다.<br>
	</c:if>
	
	
</body>
</html>