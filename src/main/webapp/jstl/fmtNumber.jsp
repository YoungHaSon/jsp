<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
  
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
	#fs2{
		border : 2px solid black;
		text-aglin : center;
		width : 400px;
		margin : 0 auto;
	}

</style>
</head>
<body>

<%-- 
	<c:set value="1000000" var="num"/> 을 스크립틀릿으로 표현하면
	pageContext.setAttribute("num", 1000000);
 --%>
 
<fieldset id="fs1"> 
	<legend>fmt 국제화 태그 formatNumber (1000000 --> 1,000,000)</legend>
<c:set value="1000000.55" var="num"/>
	num : ${num} <br>
	
	<h3> 한국어 형식에 맞게 숫자를 format을 바꾸어 출력해줌 </h3>
<fmt:setLocale value="ko_KR"/>
ko : <fmt:formatNumber value="${num}"/><br>	

<!-- type : number, currency원화, or percent% -->
ko : <fmt:formatNumber value="${num}" type="currency"/><br>	
ko : <fmt:formatNumber value="${num}" type="percent"/><br>	

	<h3> 독일어 형식에 맞게 숫자를 format을 바꾸어 출력해줌 </h3>
<fmt:setLocale value="de_DE"/>
de : <fmt:formatNumber value="${num}"/><br>	
de : <fmt:formatNumber value="${num}" type="currency"/><br>	
de : <fmt:formatNumber value="${num}" type="percent"/><br>
</fieldset>
 
<fieldset id="fs2"> 
<%-- <fmt:setLocale value="ko"/> --%>
	<legend>parseNumber(String --> int / 1,000,000 --> 1000000)</legend>
<c:set value="1,000,000" var="numStr"/>
numStr: ${numStr } <br>
parseNumber numStr : <fmt:parseNumber value="${numStr}" pattern="0,000"/>
</fieldset>


</body>
</html>