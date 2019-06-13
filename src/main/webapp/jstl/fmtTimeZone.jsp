<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<title>Insert title here</title>
<style>
#fs1 {
	border: 2px solid black;
	text-aglin: center;
	width: 400px;
	margin: 0 auto;
}
</style>
</head>
<body>

	<fieldset id="fs1">

		<legend>timeZone</legend>
		<c:set var="dt" value="<%=new Date() %>" />
		dt : <fmt:formatDate value="${dt }" type="both" />
		<br>

		<fmt:setTimeZone value="Poland" var="pol" />
		dt-pol : <fmt:formatDate value="${dt }" timeZone="${pol }" type="both" />
		<br>

		<!-- 위, 아래 방식만 다르지 결과는 같다. -->

		<fmt:timeZone value="Poland">
		dt : <fmt:formatDate value="${dt }" type="both" />
		<br>
		</fmt:timeZone>

	</fieldset>

</body>
</html>