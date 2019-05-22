<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 어디로 요청을 보낼지 지정 해야한다. -->
	
	<!-- form 태그 action속성을 이용한다. 어떻게 보낼지  (http method) ??? form 태그 method 속성 (get-default/ post) -->
	
	<%-- /login/login.jsp --> /login/loginProcess.jsp --%>


	<form action="<%= request.getContextPath() %>/login/loginProcess.jsp" method="post">
	<!-- 별도의 방식 지정이 없으면 get방식으로 간다   URL의 주소가 다르다 get, post로 했을때!-->
	
		userId : <input type="text" name="userId" value="sally" /> <br> 
		userId : <input	type="text" name="userId" value="셀리" /> <br> 
		password : <input type="password" name="password" value="pass1234" /> <br>
		<input type="submit" value="로그인" />
		<!-- submit을 누르면 form action부분으로 간다! name안써주면 매개 못 받아요  -->
		
	</form>






</body>
</html>