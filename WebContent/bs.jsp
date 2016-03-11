<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap 实例</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- 引入 Bootstrap -->
<link href="./bootstrap-3.3.6-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script type="text/javascript" src="./js/jquery.min.js"></script>
<script type="text/javascript"
	src="./bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>

<!-- HTML5 Shim 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
<!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
<!--[if lt IE 9]>
         <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
         <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
      <![endif]-->
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1>我的第一个 Bootstrap 页面</h1>
			<p>重置窗口大小，查看响应式效果！</p>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<h3>第一列</h3>
				<p>学的不仅是技术，更是梦想！</p>
				<p>再牛逼的梦想,也抵不住你傻逼似的坚持！</p>
			</div>
			<div class="col-sm-4">
				<h3>第二列</h3>
				<p>学的不仅是技术，更是梦想！</p>
				<p>再牛逼的梦想,也抵不住你傻逼似的坚持！</p>
			</div>
			<div class="col-sm-4">
				<h3>第三列</h3>
				<p>学的不仅是技术，更是梦想！</p>
				<p>再牛逼的梦想,也抵不住你傻逼似的坚持！</p>
			</div>
		</div>
	</div>

</body>
</html>
