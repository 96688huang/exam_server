<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
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
	<form id="registerForm" name="registerForm" method="post"
		action="../examinee!register.do">
		用户名: <input name="account"><br /> 密码: <input name="password"><br />
		昵称: <input name="name">
		<button type="submit">注册</button>
	</form>
</body>
</html>