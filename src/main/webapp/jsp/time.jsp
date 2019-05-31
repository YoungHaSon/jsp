<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>



<!-- localhost/jsp/jsp/time.jsp  -->
<!-- 9*9단 출력 (2~9단) -->

<!-- jsp에서 매개변수로 받는 방법  -->
<%
 	String param = request.getParameter("i");
 	String param2 = request.getParameter("j");
%>


	<table>  
<% for(int i = 1; i<=Integer.parseInt(param2); i++) {%>
	<tr>
	<% for(int j = 2; j <=Integer.parseInt(param); j++ ){%>
		<td><%=j %> * <%=i %> = <%=j*i %></td>
		<%} %>		
		</tr>
<%} %>
	</table>


<!--http://localhost/jsp/jsp/time.jsp?i=3&&j=6  -->



</body>
</html>