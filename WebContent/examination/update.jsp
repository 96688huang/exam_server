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
		<br /> <a
			href="<%=basePath %>/exam_part/multi_choice/add.jsp?exam_id=${examination.id }">添加单选题</a>
		<a href="<%=basePath %>/choice!list.do?exam_id=${examination.id }">单选题列表</a><br />

		<a
			href="<%=basePath %>/exam_part/multi_choice/add.jsp?exam_id=${examination.id }"><font color="green">添加多选题</font></a>
		<a
			href="<%=basePath %>/multiChoice!list.do?exam_id=${examination.id }"><font color="green">多选题列表</font></a><br />
		<a
			href="<%=basePath %>/exam_part/judge/add.jsp?exam_id=${examination.id }"><font color="red">添加判断题</font></a>
		<a
			href="<%=basePath %>/judge!list.do?exam_id=${examination.id }"><font color="red">判断题列表</font></a><br />
		<a
			href="<%=basePath %>/exam_part/fill/add.jsp?exam_id=${examination.id }"><font color="pink">添加填空题</font></a>
		<a
			href="<%=basePath %>/fill!list.do?exam_id=${examination.id }"><font color="pink">填空题列表</font></a><br />
		<a
			href="<%=basePath %>/exam_part/essay/add.jsp?exam_id=${examination.id }"><font color="gray">添加论述题</font></a>
		<a
			href="<%=basePath %>/essay!list.do?exam_id=${examination.id }"><font color="gray">论述题列表</font></a>
	</form>
</body>
</html>