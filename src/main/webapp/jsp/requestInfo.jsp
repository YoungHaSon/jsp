<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- 스크립틀릿 <% %> : 자바 로직을 작성하는 공간 --%>
	<%-- 표현식 <% %> : 결과물을 출력 --%>
	
	<%
		String msg = "test";
		msg += "_append";
		
		// jsp의 내장객체, 묵시적 객체(implict) -> 이미 선언되어 있기 때문에 별도의 선언 없이 사용가능한 객체의 하나
	%>
		<!-- 요청을 보낸 ip,   -->
		request.getRemoteAddr() : <%=request.getRemoteAddr() %> <br>
		request.getLocalAddr() : <%=request.getLocalAddr() %> <br>
		request.getContentType() : <%=request.getContentType() %> <br>
		request.getMethod() : <%=request.getMethod() %> <br>
		request.getProtocol() : <%=request.getProtocol() %> <br>
		<!-- 믿에꺼는 개발할때 쓸수도 있음  -->
		request.getContextPath() : <%=request.getContextPath() %> <br>
		request.getRequestURI() : <%=request.getRequestURI() %> <br>
		
		<img src="<%= request.getContextPath() %>/img/ryan.png">



</body>
</html>