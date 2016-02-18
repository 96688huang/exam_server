<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>在线教育网-试题在线|教育在线</title>
<meta name="keywords" content="试题在线|教育在线">
<meta name="description" content="为广大用户提供学习培训的服务, 提高用户的知识水平">
<script type="text/javascript" src="./js/jquery.min.js"></script>
<script type="text/javascript" src="./js/exam.js"></script>
</head>
<body>
	<jsp:include page="/common/head.jsp" />
	<h5>添加试题</h5>
	<br />
	<form id="examinationForm" name="examinationForm" method="post"
		action="<%=basePath%>/examination!add.do">
		<input name="category_id" value="${param.category_id }" type="hidden">
		类别id: ${param.category_id } <br /> 试题名称: <input name="name"><br />
		说明: <input name="description"><br />
		<button type="submit">添加</button>
	</form>
</body>
</html>