<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html >
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	$(document).ready(function(){
		$('#locale').val("${locale}");
		$("#locale").change(function(){
			$('#frm').submit();
		});
	});
</script>

<style>
#fs1{
	border : 2px solid black;
	text-aglin : center;
	width : 250px;
	margin : 0 auto;
	}
</style>
</head>
<body>
<fieldset id="fs1">
	<legend>select locale</legend>
	<form id="frm" action="${cp}/selectLocale" method="post">
		<select id="locale" name="locale">
			<option value="ko">한국어</option>
			<option value="en">English</option>
			<option value="ja">日本言</option>
		</select>
	</form>
	
	<fmt:setLocale value="${locale}"/>
	<fmt:bundle basename="kr.or.ddit.msg.msg">
		<fmt:message key="GREETING"/><br>
		<fmt:message key="VISITOR">
			<!-- VISITOR  파라미터를 보낼수있따!-->
			<fmt:param value="brown"/>
		</fmt:message>
	</fmt:bundle>
</fieldset>	
</body>
</html>