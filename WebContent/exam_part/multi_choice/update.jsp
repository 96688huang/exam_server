<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<h5>修改多选题</h5>
	<br />
	<form id="multiChoiceForm" name="multiChoiceForm" method="post"
		action="<%=basePath%>/multiChoice!add.do">
		试题id: <input name="exam_id" value="${multiChoice.exam_id }"
			readonly="readonly"> <br /> 
		题目内容: <input name="content"  value="${multiChoice.content }"><br /> 
		答案选项(json):	${multiChoice.options }<br /> 
		题目解析: <input name="analysis" value="${multiChoice.analysis }"><br /> 
		说明: <input
			name="description" value="${multiChoice.description }"><br />
		<button type="submit">添加</button>
	</form>
</body>
</html>