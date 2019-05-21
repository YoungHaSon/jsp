<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! public String hello(){
		return "hello!";
	}
%> 

	hello() : <%=hello() %> <br>
	
	<!--재귀 호출  -->
<%! long factorial(int num){
		long result = 0;
		//0!은 수학적 정의에 따라 1
		if(num==0){
			result = 1;
		} else {
			result = num * factorial(num-1);
		}
		return result;
	}
%>
	
	factorial(1) <%=factorial(1) %> <br>
	factorial(2) <%=factorial(2) %> <br>
	factorial(3) <%=factorial(3) %> <br>
	factorial(4) <%=factorial(4) %> <br>
	factorial(5) <%=factorial(5) %> <br>
	factorial(6) <%=factorial(6) %> <br>
	factorial(7) <%=factorial(7) %> <br>
	factorial(8) <%=factorial(8) %> <br>
	factorial(9) <%=factorial(9) %> <br>


</body>
</html>