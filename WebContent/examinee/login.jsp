<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>login</title>
</head>
<body>
	<jsp:include page="/common/head.jsp" />
	<form id="loginForm" name="loginForm" method="post"
		action="../examinee!login.do">
		用户名: <input name="account"><br /> 密码: <input name="password"><br />
		<button type="submit">登陆</button>
	</form>
</body>
</html>