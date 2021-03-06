<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>ko</h2>
	<fmt:setLocale value="ko"/>
	<fmt:bundle basename="kr.or.ddit.msg.msg">
		<fmt:message key="GREETING"/><br>
		<fmt:message key="VISITOR">
		<!-- VISITOR  파라미터를 보낼수있따!-->
			<fmt:param value="brown"/>
		</fmt:message>
	</fmt:bundle>	
	
	<h2>en</h2>
	<fmt:setLocale value="en"/>
	<fmt:bundle basename="kr.or.ddit.msg.msg">
		<fmt:message key="GREETING"/><br>
		<fmt:message key="VISITOR">
		<!-- VISITOR  파라미터를 보낼수있따!-->
			&nbps;<fmt:param value="brown"/>
		</fmt:message>
	</fmt:bundle>
	
	<h2>ja</h2>
	<fmt:setLocale value="ja"/>
	<fmt:bundle basename="kr.or.ddit.msg.msg">
		<fmt:message key="GREETING"/><br>
		<fmt:message key="VISITOR">
		<!-- VISITOR  파라미터를 보낼수있따!-->
			<fmt:param value="brown"/>
		</fmt:message>
	</fmt:bundle>	
	
	<h2>setbundle</h2>
	<fmt:setBundle basename="kr.or.ddit.msg.msg" var="message"/>
	<fmt:message key="GREETING" bundle="${message}"/><br>
	<fmt:message key="VISITOR" bundle="${message}">
		<fmt:param value="cony"/>
	</fmt:message>
	

</body>
</html>