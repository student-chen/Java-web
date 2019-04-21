<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>首页</title>
<script src="common/layui/layui.all.js"></script>
<link rel="stylesheet" href="common/layui/css/layui.css">
<script src="../js/jquery-1.8.3.js"></script>
<script src="common/layui/layui.js"></script>
<script src="common/js/yuangong.js"></script>
</head>
<body>
	<header style="width: 100%;height: 40px;background-color: #E3E3E3;">
		<h2
			style="text-align: left;padding-left: 15px;padding-top: 5px;font: 18px/30px 宋体;">
			<b>员工管理</b>
		</h2>
	</header>
	<form class="layui-form">
	<section
		style="width: 600px;height: 45px;margin-left: 25px;margin-top: 17px;">
		姓名：
		<div class="layui-inline" style="margin-right: 15px;">
			<input class="layui-input" name="name" id="name" autocomplete="off">
		</div>
		权限：
		<div class="layui-inline" style="width: 130px;">
			<select id="mtype" name="mtype" class="layui-select">
				<option value="-1">请选择类型</option>
				<option value="1">系统管理员</option>
				<option value="2">总经理</option>
				<option value="3">员工</option>
			</select>
		</div>
		<button id="search" class="layui-btn" type="button"
			style="margin-left: 10px;">搜索</button>
	</section>
	</form>
	<table class="layui-hide" id="tabs" lay-filter="tab"></table>
<script type="text/html" id="bar">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script type="text/html" id="quanxian">
{{#  if(d.URole == 1){ }}
	系统管理员
{{#  } else if(d.URole == 2){ }}
	总经理
{{#  } else if(d.URole == 3){ }}
	前台
{{# } else if(d.URole == 4){ }}
	员工
{{# } }}
</script>
</body>
</html>
