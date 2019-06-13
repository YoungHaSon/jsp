<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 만들 tag의 디렉토리 폴더 명까지만 -->
<%@ taglib prefix="ct" tagdir="/WEB-INF/tags" %>    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Ruda&display=swap" rel="stylesheet">
<title>Insert title here</title>
<style>
 * {font-family: 'Ruda', sans-serif; font-size : 1.3em;}
</style>

</head>
<body>

1. 고정 문자열 : =================================================================<br>
2. loop : <c:forEach begin="1" end="66">=</c:forEach><br>
3. customTag : <ct:logging/> <br>
4. loopLogging : <ct:loopLogging/>
5. colorLogging : <ct:colorlogging color="blue" size="10"/><br>
6. colorLogging : <ct:colorlogging color="red" size="-10" /><br>
7. ragersTag : <ct:rangers rangers="cherry,brown,cony,sally,moon,james"/><br>
8. ragersTag : <ct:prod code="P201"/><br>

</body>
</html>
