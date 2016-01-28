<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>试题类别列表</title>
</head>
<body>
	<jsp:include page="/common/head.jsp" />
	<h3>试题类别列表</h3>
	<br />
	<a href="./exam_category/add.jsp">添加类别</a>
	<br />
	<table width="800">
		<tr>
			<td>id</td>
			<td>owner_id</td>
			<td>name</td>
			<td>desciption</td>
		</tr>
		<c:forEach items="${list}" var="vo" varStatus="status">
			<tr>
				<form action="../examCategory!update.do" method="post">
					<td><input name="id" value="${vo.id }"></td>
					<td><input name="owner_id" value="${vo.owner_id }"></td>
					<td><input name="name" value="${vo.name }"></td>
					<td><input name="description" value="${vo.description }"></td>
					<td><button type="submit">提交</button></td>
					<td><a href="./examCategory!find.do?id=${vo.id }">查看</a></td>
					<td><a href="./examCategory!delete.do?id=${vo.id }">删除</a></td>
				</form>
			</tr>
		</c:forEach>
	</table>
</body>
</html>