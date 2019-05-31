<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>
td {
	border: 1px solid red;
}
</style>
</head>
<body>


	<c:set var="num1" value="${param.num1}"/>
	<c:set var="num2" value="${param.num2}"/>
	
	<table>
		<c:choose>
			<c:when test="${num1 && num2 == null}">
				<c:forEach var="i" begin="1" end="9">
					<tr>
						<c:forEach var="j" begin="${num1 }" end="${num2 }">
							<td>${j}*${i}= ${j*i }</td>
						</c:forEach>
					</tr>
				</c:forEach>
			</c:when>
			
			<c:otherwise>
				<c:when test="${num1 && num2 != null}">
				<c:forEach var="i" begin="1" end="9">
					<tr>
						<c:forEach var="j" begin="${num1 }" end="${num2 }">
							<td>${j}*${i}= ${j*i }</td>
						</c:forEach>
					</tr>
				</c:forEach>
			</c:when>
			</c:otherwise>
		</c:choose>
	</table>



</body>
</html>