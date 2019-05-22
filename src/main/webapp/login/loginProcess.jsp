<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>loginProces</title>


</head>
<body>
	loginProcess.jsp <br>
	<!-- post 방식 한글 파라미터  -->
	<%request.setCharacterEncoding("utf-8"); %>
	
	<!-- 매개변수 받는 방법 2개  getParameter 해당 매개변수 하나의 값만,
	getParameterValues 해당 매개변수에 해당하는 값의 배열을 가져온다  -->
	
	<h2>request객체의 getParameter, getParameterValues</h2>
	request.getParameter("userId") : <%= request.getParameter("userId") %> <br>
	request.getParameter("userId") : 
	
						<% String[] userIds = request.getParameterValues("userId");
							for(String userId : userIds){%>
							<%=userId %> 
							<%}%>
	<br>
	request.getParameter("password") : <%= request.getParameter("password") %> <br>
		
	<!--   -->	
	<h2>request 객체의 getParameterMap </h2>
	<% Map<String, String[]> parameterMap =  request.getParameterMap(); %><br>
		<!-- //parameter : userId, password -->
		
		<%String[] userIdsFromMap = parameterMap.get("userId");%>
		<%String[] password = parameterMap.get("password");%>
	
		<%for(String userId : userIdsFromMap){%>
			<%=userId%>
		<%}%>
		
		<%for(String password2 : password){%>
			<%=password2%>
		<%}%>

<br><br>
	<!-- 주소???  -->
	request.getParameterMap() : <%=request.getParameterMap() %> <br>
	
	<!--일반화 유형 Enumeration(String>을 이용하면 e.nextElement()에서 String으로 자료유형 변환이 필요 없이 
	반환 값을 String유형 변수 name에 저장할 수 있는 장점이 있다. -->
	
	<h2> request.getParameterNames</h2>
	<% Enumeration<String> parameterNames = request.getParameterNames(); 
		while(parameterNames.hasMoreElements()){%>
			parameterNames : <%= parameterNames.nextElement() + "<br>" %>
			<%}
	%>
	
	
	
	
	
	
	
	
</body>
</html>