<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>个人信息修改</title>
</head>
<body>
	<jsp:include page="/common/head.jsp" />
	<br />
	<br />
	<h3>${message }</h3>
	<br />
	<form action="<%=basePath%>/examinee!update.do" method="post">
		<h4>id:</h4>
		<input name="id" value="${examinee.id }"><br />
		<h4>用户名：</h4>
		<input name="account" value="${examinee.account }"> <br />
		<h4>密码：</h4>
		<input name="password" value="${examinee.password }"> <br />
		<h4>名字：</h4>
		<input name="name" value="${examinee.name }"> <br />
		<button type="submit">提交</button>
	</form>
</body>
</html>