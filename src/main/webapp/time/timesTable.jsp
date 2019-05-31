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

	<table>
		<c:forEach var="i" begin="1" end="${param.num2 eq null ? 9 : param.num2}">
			<tr>
				<c:forEach var="j" begin="2" end="${param.num1 eq null ? 9: param.num1}">
					<td>${j}*${i}= ${j*i }</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>

</body>
</html>