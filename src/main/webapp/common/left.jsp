<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li class="active"><a href="#">오호..아하..어허... <span class="sr-only">(current)</span></a></li>
	
		<li class="active"><a href="<%= request.getContextPath()%>/userList">UserList</a></li>
		
		<!-- a 태그는 기본적으로 get방식을 사용 -->
		<li class="active"><a href="<%= request.getContextPath()%>/userPagingList">User_PageList</a></li>
		
		<!-- a 태그는 기본적으로 get방식을 사용 -->
		<li class="active"><a href="<%= request.getContextPath()%>/lprodpagination">Lprod_PageList</a></li>
	</ul>
</div>