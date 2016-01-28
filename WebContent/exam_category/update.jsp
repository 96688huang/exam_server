<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>试题类别修改</title>
</head>
<body>
	<jsp:include page="/common/head.jsp" />
	<br />
	<br />
	<h3>${message }</h3>
	<br />
	<form action="../examCategory!update.do" method="post">
		<h4>id:</h4>
		<input name="id" value="${examCategory.id }"><br />
		<h4>owner_id:</h4>
		<input name="owner_id" value="${examCategory.owner_id }"><br />
		<h4>名称：</h4>
		<input name="name" value="${examCategory.name }"> <br />
		<h4>描述：</h4>
		<input name="description" value="${examCategory.description }">
		<br />
		<button type="submit">提交</button>
	</form>
</body>
</html>