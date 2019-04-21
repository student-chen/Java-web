<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>餐厅管理系统--By：L's</title>
<script src="common/layui/layui.all.js"></script>
<link rel="stylesheet" href="common/layui/css/layui.css">
<script src="../js/jquery-1.8.3.js"></script>
<script src="common/layui/layui.js"></script>
<script src="common/js/jquery.cookie.js"></script>
<script src="common/js/index.js"></script>
</head>
<body class="layui-layout-body layui-bg-gray">
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo">餐厅点餐系统</div>
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item"><a href="javascript:;"> <img
						src="common/image/login-bg-2.jpg" class="layui-nav-img">
						${user.UName}
				</a></li>
				<li class="layui-nav-item"><a href="#" id="outSys">退出系统</a> <input
					type="text" id="OutloginName" value="${user.ULoginname}"
					readonly="readonly" hidden="hidden"></li>
			</ul>
		</div>

		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<ul class="layui-nav layui-nav-tree" lay-filter="test">
					<li class="layui-nav-item layui-this"><a href="javascript:;"
						onclick="ShowMain('home')">首页</a></li>
					<li class="layui-nav-item layui-nav-itemed"><a
						href="javascript:;">菜谱管理</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;" onclick="ShowMain('showcaipu')">查看菜谱</a>
							</dd>
							<dd>
								<a href="javascript:;" onclick="ShowMain('showAddcaipu')">添加菜谱</a>
							</dd>
							<dd>
								<a href="javascript:;" onclick="ShowMain('caiputype.jsp')">管理菜谱类型</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item"><a href="javascript:;">会员管理</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;" onclick="ShowMain('showMember')">会员列表</a>
							</dd>
							<!-- <dd><a href="javascript:;" onclick="ShowMain('showAddMember')">添加会员</a></dd> -->
							<dd>
								<a href="javascript:;" onclick="ShowMain('huiyuantype.jsp')">管理会员类型</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item"><a href="javascript:;">餐桌管理</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;" onclick="ShowMain('canzhuo.jsp')">餐桌列表</a>
							</dd>
							<dd>
								<a href="javascript:;" onclick="ShowMain('Addcanzhuo.jsp')">添加餐桌</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item"><a href="javascript:;"
						onclick="ShowMain('dingdan.jsp')">订单管理</a></li>
					<li class="layui-nav-item"><a href="javascript:;">系统管理</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;" onclick="ShowMain('Addyuangong.jsp')">添加员工</a>
							</dd>
							<dd>
								<a href="javascript:;" onclick="ShowMain('yuangong.jsp')">员工管理</a>
							</dd>
							<dd>
								<a href="javascript:;" onclick="ShowMain('UpdataPwd.jsp')">修改密码</a>
							</dd>
							<dd>
								<a href="javascript:;" onclick="ShowMain('SystemInfo.jsp')">系统信息</a>
							</dd>
						</dl></li>
				</ul>
			</div>
		</div>

		<div class="layui-body">
			<!-- 内容主体区域 -->
			<iframe src="home" frameborder="0" id="AdminMain"
				style="width: 100%; height: 100%;"></iframe>
		</div>

		<div class="layui-footer">
			<!-- 底部固定区域 -->
			© ls.2017.12 - 餐厅点餐后台系统
		</div>
	</div>
</body>
</html>
