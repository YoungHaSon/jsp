<%@tag import="kr.or.ddit.prod.service.IprodService"%>
<%@tag import="kr.or.ddit.prod.vo.ProdVo"%>
<%@tag import="java.util.List"%>
<%@tag import="ch.qos.logback.core.Context"%>
<%@tag import="kr.or.ddit.prod.service.ProdService"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="code" type="java.lang.String" required="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String prod_lgu = (String)jspContext.getAttribute("code");
	IprodService prodService = new ProdService();
	List<ProdVo> prodList = prodService.prodList(prod_lgu);
	request.setAttribute("prodList", prodList);
%>
	
<select>	
	<c:forEach items="${prodList}" var="i">
		<option>${i.prod_name}</option>
	</c:forEach>
</select>