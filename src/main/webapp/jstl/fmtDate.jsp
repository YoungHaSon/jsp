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
<style>
	#fs1{
		border : 2px solid black;
		text-aglin : center;
		width : 400px;
		margin : 0 auto;
	}
</style>
</head>
<body>
	<fieldset id="fs1"> 
		<legend>formatDate</legend>
			<c:set var="dt" value="<%= new Date() %>"/>
			
			<h3>한국</h3>
			Date : ${dt} <br> 
			Date : <fmt:formatDate value="${dt}" pattern="yyyy-MM-dd"/> <br>
			Date FULL : <fmt:formatDate value="${dt}" type="date" dateStyle="FULL"/> <br>
			Date MEDIUM : <fmt:formatDate value="${dt}" type="date" dateStyle="MEDIUM"/> <br>
			Date LONG : <fmt:formatDate value="${dt}" type="date" dateStyle="LONG"/> <br>
			Date SHORT : <fmt:formatDate value="${dt}" type="date" dateStyle="SHORT"/> <br>
			Date : <fmt:formatDate value="${dt}" type="time"/> <br>
			Date : <fmt:formatDate value="${dt}" type="both"/> <br>
			
			<h3>독일</h3>
			<fmt:setLocale value="de_DE"/>
			Date : <fmt:formatDate value="${dt}"/> <br>
			Date : <fmt:formatDate value="${dt}" type="date" /> <br>
			Date : <fmt:formatDate value="${dt}" type="time" /> <br>
			Date : <fmt:formatDate value="${dt}" type="both" /> <br>
			
			<h3>parse (String --> date / 2019.6.13)--> date</h3>
			<fmt:setLocale value="ko_KR"/>
			<c:set value="2019.6.13" var="dtStr"/>
			dtStr : ${dtStr} <br>
			dtStr : <fmt:parseDate value="${dtStr }" pattern="yyyy.MM.dd"/><br>
			
	</fieldset>
	
	
	
		

</body>
</html>