<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>곱하쉴?</h2>
	<form action="${cp}/mulCalculation" method="post">
		mul1 : <input type="number" name="mul1" value="9"/><br>
		mul2 : <input type="number" name="mul2" value="9"/><br>
		<button>가랏!!</button>
	</form>
</body>
</html>