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
<title>试题类别修改</title>
</head>
<body>
	<jsp:include page="/common/head.jsp" />
	<br />
	<br />
	<h3>${message }</h3>
	<br />
	<form action="<%=basePath%>/examCategory!update.do" method="post">
		<h4>id:</h4>
		<input name="id" value="${examCategory.id }" readonly="true"><br />
		<h4>owner_id:</h4>
		<input name="owner_id" value="${examCategory.owner_id }"
			readonly="true"><br />
		<h4>parent_id:</h4>
		<input name="parent_id" value="${examCategory.parent_id }"
			readonly="true"><br />
		<h4>名称：</h4>
		<input name="name" value="${examCategory.name }"> <br />
		<h4>描述：</h4>
		<input name="description" value="${examCategory.description }">
		<br />
		<button type="submit">提交</button>
	</form>
	<a
		href="<%=basePath%>/exam_category/add.jsp?parent_id=${examCategory.id }">添加子类别</a>
	<a
		href="<%=basePath%>/examination/add.jsp?category_id=${examCategory.id }">添加试题</a>
	<a
		href="<%=basePath%>/examination!list.do?category_id=${examCategory.id }">试题列表</a>
</body>
</html>