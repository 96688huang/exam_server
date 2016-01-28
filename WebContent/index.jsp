<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>在线教育网-试题在线|教育在线</title>
<meta name="keywords" content="试题在线|教育在线">
<meta name="description" content="为广大用户提供学习培训的服务, 提高用户的知识水平">
<script type="text/javascript" src="./js/jquery.min.js"></script>
</head>
<body>
	<h1>
		<a href="./">首页</a>
	</h1>
	<h5>
		<span style="color: red;">${message }</span>
	</h5>
	<c:choose>
		<c:when test="${examinee == null}">
			<a href="./examinee/login.jsp">登陆</a>
			<br />
			<a href="./examinee/register.jsp">注册</a>
			<br />
		</c:when>
		<c:otherwise>
			<h5>${examinee.name}欢迎您！</h5>
			<br />
			<br />
			<a href="./examinee!list.do">用户列表</a>
			<br />
			<a href="./examCategory!list.do">试题类别</a>
		</c:otherwise>
	</c:choose>
</body>
</html>