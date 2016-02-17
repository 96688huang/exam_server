<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户列表</title>
</head>
<body>
	<jsp:include page="/common/head.jsp" />
	<h3>用户列表</h3>
	<br />
	<table width="800">
		<tr>
			<td>id</td>
			<td>account</td>
			<td>password</td>
			<td>name</td>
		</tr>
		<c:forEach items="${list}" var="vo" varStatus="status">
			<tr>
				<form action="<%=basePath%>/examinee!update.do" method="post">
					<td><input name="id" value="${vo.id }"></td>
					<td><input name="account" value="${vo.account }"></td>
					<td><input name="password" value="${vo.password }"></td>
					<td><input name="name" value="${vo.name }"></td>
					<td><button type="submit">提交</button></td>
					<td><a href="<%=basePath%>/examinee!find.do?id=${vo.id }">查看</a></td>
					<td><a href="<%=basePath%>/examinee!delete.do?id=${vo.id }">删除</a></td>
				</form>
			</tr>
		</c:forEach>
	</table>
</body>
</html>