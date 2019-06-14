<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>
	td{
		border : 1px solid red;
	}

</style>
</head>
<body>
	
	<%-- application(getServletContext()) : requestMap --%>
	
	<table>
		<tr>
			<th>uri</th>
			<th>요청횟수</th>
		</tr>
			<c:forEach items="${requestMap}" var="m">
			<tr>
				<td>${m.key}</td>  
				<td>${m.value}</td>
			</tr>
			</c:forEach>
	</table>

</body>
</html>