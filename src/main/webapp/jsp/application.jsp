<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.DataInputStream"%>
<%@page import="java.io.FileInputStream"%>
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
	request.setCharacterEncoding("utf-8");
	
	out.write("application.getContextPath() : " + application.getContextPath() + "<br>");
	out.write("application.getServerInfo() : " + application.getServerInfo() + "<br>");
	out.write("application.getMajorVersion() : " + application.getMajorVersion() + "<br>");
	out.write("application.getMinorVersion() : " + application.getMinorVersion() + "<br>");
	
	out.write("application.getInitParameter(\"ADMIN\") : " + application.getInitParameter("ADMIN") + "<br>");
	
	/*파일의 위치를 출력하주는 */
	out.write("application.getRealPath(\"/res/190522.txt\")" + application.getRealPath("/res/190522.txt"));	
	out.write("<br><br>");
	try{
// 		FileReader fr = new FileReader("D:/D_Other/test.txt");
		FileReader fr = new FileReader(application.getRealPath("/res/190522.txt"));
		//줄단위로 읽어옵니당 readLine() 요 메서드로 
		BufferedReader br = new BufferedReader(fr);
		
		String temp = "";
		
		for(int i=1; (temp=br.readLine())!=null; i++){
			out.write(temp + "<br>");
		}
		br.close();
	}catch (IOException e){
		e.printStackTrace();
	}
	
%>	

</body>
</html>