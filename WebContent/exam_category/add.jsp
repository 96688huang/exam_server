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
	<h5>添加试题类别</h5>
	<br />
	<form id="examCategoryForm" name="examCategoryForm" method="post"
		action="<%=basePath%>/examCategory!add.do">
		<c:if test="${param.parent_id != null }">
			<input name="parent_id" value="${param.parent_id }" type="hidden">
		父类别id: ${param.parent_id } <br />
		</c:if>
		类别名称: <input name="name"><br /> 说明: <input name="description"><br />
		<button type="submit">添加</button>
	</form>
</body>
</html>