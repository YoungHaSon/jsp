<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="kr.or.ddit.paging.model.PageVo"%>
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
	
	<h2>Core 라이브러리의 set! + c:set -로그인 후 테스트 할 것</h2>
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
	<%-- <c:set target="${USER_INFO }" property="alias" value="bear" />  --%>
	
	USER_INFO.alias : ${USER_INFO.alias }<br>

	<h2>c:if 태그  --> java의 if-else if -else와는 다른 개념이다 [if]에만 해당 (c:choose)태트가 일반적인 if문</h2>
	
	<!-- java로 비유하자면 if(test) 이부분과 같다 단일 if 가능 -->
	
	<!-- USER_INFO의 아이디가 brown 이면 밑에 문장 실행! -->
	<c:if test="${USER_INFO.userId == 'brown' }">
		userId는 ${USER_INFO.userId } 입니다.<br>
	</c:if>
	
	<h2>c:choose 자바의 if -else if -else</h2>
	<%
		request.setAttribute("code", "03");
	%>
	<!-- eq, == 같은뜻 -->	
	<c:choose>
		<c:when test="${code eq '01' }">
			code is '01'
		</c:when>
		<c:when test="${code == '02' }">
			code is '02'
		</c:when>
		<c:when test="${code == '03' }">
			code is '03'
		</c:when>
		<c:otherwise>
			code is ${code }
		</c:otherwise>
	</c:choose>
	
	<h2>el 연산</h2>
	<%
		PageVo pageVo = new PageVo(1,10);
		request.setAttribute("pageVo", pageVo);
	%>
	page +2 : ${pageVo.page +2 }
	
	<h2>c:forEach 일반 반복문</h2>
	<c:forEach var="i" begin="1" end="10" step="2">
		${i }<br>
	</c:forEach>
	
	<h2>foreach Map</h2>
	<%
		Map<String, String> dataMap = new HashMap<String, String>();
		//name, age, hp
		dataMap.put("name", "cony");
		dataMap.put("age", "7");
		dataMap.put("hp", "010-0000-0000");
		
		//java에서 Map을 for돌리려면 -->dataMap.entrySet() or dataMap.keySet() --> 으로 for문을 돌려야함
		for(String key : dataMap.keySet())
			out.write(dataMap.get(key) + "<br>");
		
		//el에서 for문을 돌리려면 속성값이어야한다.
		request.setAttribute("dataMap", dataMap);
	%>
	<hr style="border : 1px solid red">
	<c:forEach items="${dataMap}" var="data">
		${data.key} /  ${data.value}<br>
	</c:forEach>
	
			
</body>
</html>