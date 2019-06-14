<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>실습합니다.</h2>
	<form action="${cp}/sumCalculation" method="post">
		start : <input type="text" name="sum1" value="1" /><br>
		end : <input type="text" name="sum2" value="2" /><br>
		<button>전송하자</button>
	</form>


</body>
</html>