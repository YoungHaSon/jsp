<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		System.out.println("userId : " +  request.getParameter("userId"));
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/requestDispatchTarget.jsp");
		
		//위임하는 녀석에게 밑에 매개변수를 전달해주겠다?
		rd.forward(request, response);
		
	%>
</body>
</html>