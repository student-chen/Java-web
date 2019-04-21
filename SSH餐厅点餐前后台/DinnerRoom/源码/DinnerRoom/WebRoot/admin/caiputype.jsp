<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>订单管理</title>
<link rel="stylesheet" href="common/layui/css/layui.css">
<script src="../js/jquery-1.8.3.js"></script>
<script src="common/layui/layui.js"></script>
<script src="common/js/caiputype.js"></script>
</head>
<body>
	<header style="width: 100%;height: 40px;background-color: #E3E3E3;">
		<h2
			style="text-align: left;padding-left: 15px;padding-top: 5px;font: 18px/30px 宋体;">
			<b>管理菜谱类型</b>
		</h2>
	</header>
	<section
		style="width: 550px;height: 45px;margin-left: 25px;margin-top: 17px;">
			添加菜谱类型：
			<div class="layui-inline" style="margin-right: 15px;">
				<input class="layui-input" name="type_name" placeholder="请输入要添加的菜谱类型" id="type_name"
					autocomplete="off">
			</div>
			<button id="addcaiputype" class="layui-btn"
				style="margin-left: 10px;">添加</button>
	</section>
	<table class="layui-hide" id="tabs" lay-filter="tab"></table>
	<script type="text/html" id="bar">
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
</body>
</html>
