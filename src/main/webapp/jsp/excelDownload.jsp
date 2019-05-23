<%@ page language="java" contentType="application/vnd.ms-excel; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%
	response.setHeader("Content-Disposition", "attachment; filename=line.xls");
%>    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>이름</th>
			<th>영문명</th>
		</tr>
		<tr>
			<td>셀리</td>
			<td>sally</td>
		</tr>
		<tr>
			<td>브라운</td>
			<td>brown</td>
		</tr>
		<tr>
			<td>마이크</td>
			<td>mike</td>
		</tr>
		
	</table>
</body>
</html>