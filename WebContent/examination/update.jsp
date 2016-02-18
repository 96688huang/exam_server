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
<title>试题修改</title>
</head>
<body>
	<jsp:include page="/common/head.jsp" />
	<br />
	<br />
	<h3>${message }</h3>
	<br />
	<form action="<%=basePath%>/examination!update.do" method="post">
		<h4>id:</h4>
		<input name="id" value="${examination.id }" readonly="true"><br />
		<h4>category_id:</h4>
		<input name="category_id" value="${examination.category_id }"
			readonly="true"><br />
		<h4>名称：</h4>
		<input name="name" value="${examination.name }"> <br />
		<h4>描述：</h4>
		<input name="description" value="${examination.description }">
		<br />
		<button type="submit">提交</button>
	</form>
</body>
</html>