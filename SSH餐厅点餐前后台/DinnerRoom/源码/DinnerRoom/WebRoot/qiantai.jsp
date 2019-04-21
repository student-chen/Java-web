<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>前台</title>
<script src="js/layui/layui.all.js"></script>
<link rel="stylesheet" href="js/layui/css/layui.css">
<script src="js/jquery-1.8.3.js"></script>
<script src="js/layui/layui.js"></script>
<script src="js/jquery.cookie.js"></script>
<script src="js/qiantai.js"></script>
</head>
<body class="layui-layout-body layui-bg-gray">
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo">餐厅点餐系统</div>
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item"><a href="javascript:;">
						${user.UName} </a></li>
				<li class="layui-nav-item"><a href="#" id="outSys">退出系统</a>
					<input type="text" id="OutloginName" value="${user.ULoginname}" readonly="readonly" hidden="hidden">
				</li>
			</ul>
		</div>

		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<ul class="layui-nav layui-nav-tree" lay-filter="test">
					<li class="layui-nav-item layui-this"><a href="javascript:;"
						onclick="ShowMain('canzhuosyqk')">餐桌使用情况</a></li>
					<li class="layui-nav-item"><a href="javascript:;"
						onclick="ShowMain('orderJieSuan.jsp')">订单结算</a></li>
					<li class="layui-nav-item"><a href="javascript:;"
						onclick="ShowMain('MemberPlate.jsp')">会员管理</a></li>
				</ul>
			</div>
		</div>

		<div class="layui-body">
			<!-- 内容主体区域 -->
			<iframe src="canzhuosyqk" frameborder="0" id="AdminMain"
				style="width: 100%; height: 100%;"></iframe>
		</div>

		<div class="layui-footer">
			<!-- 底部固定区域 -->
			© ls.2017.12 - 餐厅点餐前台结算系统
		</div>
	</div>
</body>
</html>