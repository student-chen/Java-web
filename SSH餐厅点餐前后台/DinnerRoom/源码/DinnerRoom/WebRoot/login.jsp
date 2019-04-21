<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset="utf-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>统一登录</title>
	<link rel="stylesheet" href="admin/common/css/normalize.css">
	<link rel="stylesheet" href="admin/common/css/demo.css">
	<!--必要样式-->
	<link rel="stylesheet" href="admin/common/css/component.css">
	<script src="admin/common/js/jquery-1.8.3.js"></script>
	<!--[if IE]>
	<script src="admin/common/js/html5.js"></script>
	<![endif]-->
</head>
<body>
		<div class="container demo-1">
			<div class="content">
				<div id="large-header" class="large-header">
					<canvas id="demo-canvas"></canvas>
					<div class="logo_box">
						<h3>餐厅点餐管理系统—登陆</h3>
						<form action="#" method="post">
							<div class="input_outer">
								<span class="u_user"></span>
								<input name="logname" id="logname" class="text" autocomplete="off" style="background-color: transparent;color: #FFFFFF !important" type="text" placeholder="请输入账户">
							</div>
							<div class="input_outer">
								<span class="us_uer"></span>
								<input name="logpass" id="logpass" class="text" autocomplete="off" style="background-color: transparent;color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="password" placeholder="请输入密码">
							</div>
							<div class="mb2">
								<a class="act-but submit" id="loginbtn" href="javascript:;" style="color: #FFFFFF">登录</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div><!-- /container -->
		<script src="admin/common/js/TweenLite.min.js"></script>
		<script src="admin/common/js/EasePack.min.js"></script>
		<script src="admin/common/js/rAF.js"></script>
		<script src="admin/common/js/demo-1.js"></script>
		<script src="admin/common/layui/layui.all.js"></script>
		<script src="js/jquery.cookie.js"></script>
		<script src="js/login.js"></script>
	</body>
</html>