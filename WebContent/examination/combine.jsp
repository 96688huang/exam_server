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
<title>试题</title>
</head>
<body>
	<jsp:include page="/common/head.jsp" />
	<h3>单选题列表</h3>
	<table width="100%" border="1px">
		<tr>
			<td>id</td>
			<td>exam_id</td>
			<td>content</td>
			<td>options</td>
			<td>answer</td>
			<td>analysis</td>
			<td>desciption</td>
		</tr>
		<c:forEach items="${choiceList}" var="vo" varStatus="status">
			<tr>
				<td><input name="id" value="${vo.id }" readonly="true"></td>
				<td><input name="exam_id" value="${vo.exam_id }"
					readonly="true"></td>
				<td><input name="content" value="${vo.content }"></td>
				<td>${vo.options }</td>
				<td><input name="answer" value="${vo.answer }"></td>
				<td><input name="analysis" value="${vo.analysis }"></td>
				<td><input name="description" value="${vo.description }"></td>
				<td><a href="<%=basePath%>/choice!find.do?id=${vo.id }">查看</a></td>
				<td><a
					href="<%=basePath%>/choice!delete.do?id=${vo.id }&exam_id=${vo.exam_id }">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<h3>
		<font color="green">多选题列表</font>
	</h3>
	<table width="100%" border="1px">
		<tr>
			<td>id</td>
			<td>exam_id</td>
			<td>content</td>
			<td>options</td>
			<td>answer</td>
			<td>analysis</td>
			<td>desciption</td>
		</tr>
		<c:forEach items="${multiChoiceList}" var="vo" varStatus="status">
			<tr>
				<td><input name="id" value="${vo.id }" readonly="true"></td>
				<td><input name="exam_id" value="${vo.exam_id }"
					readonly="true"></td>
				<td><input name="content" value="${vo.content }"></td>
				<td>${vo.options }</td>
				<td><input name="answer" value="${vo.answer }"></td>
				<td><input name="analysis" value="${vo.analysis }"></td>
				<td><input name="description" value="${vo.description }"></td>
				<td><a href="<%=basePath%>/multiChoice!find.do?id=${vo.id }">查看</a></td>
				<td><a
					href="<%=basePath%>/multiChoice!delete.do?id=${vo.id }&exam_id=${vo.exam_id }">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<h3>
		<font color="red">判断题列表</font>
	</h3>
	<table width="100%" border="1px">
		<tr>
			<td>id</td>
			<td>exam_id</td>
			<td>content</td>
			<td>answer</td>
			<td>analysis</td>
			<td>desciption</td>
		</tr>
		<c:forEach items="${judgeList}" var="vo" varStatus="status">
			<tr>
				<td><input name="id" value="${vo.id }" readonly="true"></td>
				<td><input name="exam_id" value="${vo.exam_id }"
					readonly="true"></td>
				<td><input name="content" value="${vo.content }"></td>
				<td><input name="answer" value="${vo.answer }"></td>
				<td><input name="analysis" value="${vo.analysis }"></td>
				<td><input name="description" value="${vo.description }"></td>
				<td><a href="<%=basePath%>/judge!find.do?id=${vo.id }">查看</a></td>
				<td><a
					href="<%=basePath%>/judge!delete.do?id=${vo.id }&exam_id=${vo.exam_id }">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<h3>
		<font color="pink">填空题列表</font>
	</h3>
	<table width="100%" border="1px">
		<tr>
			<td>id</td>
			<td>exam_id</td>
			<td>content</td>
			<td>answer</td>
			<td>analysis</td>
			<td>desciption</td>
		</tr>
		<c:forEach items="${fillList}" var="vo" varStatus="status">
			<tr>
				<td><input name="id" value="${vo.id }" readonly="true"></td>
				<td><input name="exam_id" value="${vo.exam_id }"
					readonly="true"></td>
				<td><input name="content" value="${vo.content }"></td>
				<td><input name="answer" value="${vo.answer }"></td>
				<td><input name="analysis" value="${vo.analysis }"></td>
				<td><input name="description" value="${vo.description }"></td>
				<td><a href="<%=basePath%>/fill!find.do?id=${vo.id }">查看</a></td>
				<td><a
					href="<%=basePath%>/fill!delete.do?id=${vo.id }&exam_id=${vo.exam_id }">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<h3>
		<font color="blue">论述题列表</font>
	</h3>
	<table width="100%" border="1px">
		<tr>
			<td>id</td>
			<td>exam_id</td>
			<td>content</td>
			<td>answer</td>
			<td>analysis</td>
			<td>desciption</td>
		</tr>
		<c:forEach items="${essayList}" var="vo" varStatus="status">
			<tr>
				<td><input name="id" value="${vo.id }" readonly="true"></td>
				<td><input name="exam_id" value="${vo.exam_id }"
					readonly="true"></td>
				<td><input name="content" value="${vo.content }"></td>
				<td><input name="answer" value="${vo.answer }"></td>
				<td><input name="analysis" value="${vo.analysis }"></td>
				<td><input name="description" value="${vo.description }"></td>
				<td><a href="<%=basePath%>/essay!find.do?id=${vo.id }">查看</a></td>
				<td><a
					href="<%=basePath%>/essay!delete.do?id=${vo.id }&exam_id=${vo.exam_id }">删除</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>