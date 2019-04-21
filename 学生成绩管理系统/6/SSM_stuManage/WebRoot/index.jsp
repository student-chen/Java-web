<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="zh-CN">
	<head>
		<base href="<%=basePath%>">
		<title></title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="">
		<meta name="author" content="">
		<style>
body {
	background: url(images/loginbg.png) repeat-x;
	min-height: 600px;
	position: relative;
}

* {
	font-family: "微软雅黑";
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 14px;
	color: white;
}

html,body {
	height: 100%;
	width: 100%;;
}

.kuico {
	background: url(images/coolyun.png) no-repeat;
	display: inline-block;
	width: 26px;
	height: 16px;
	margin-right: 5px;
}

.kuintro {
	color: white;
	padding-right: 5px;
	rgba
	(255,
	255,
	255,
	0.8);
}

.kutrg {
	background: url(image/triangle.png) no-repeat;
	display: inline-block;
	width: 10px;
	height: 6px;
}

a {
	text-decoration: none;
	color: rgba(255, 255, 255);
	cursor: pointer;
}

.robot {
	background: url(image/android.png) no-repeat;
	display: inline-block;
	width: 18px;
	height: 20px;
	padding-right: 5px;
}

.question {
	background: url(image/question.png) no-repeat;
	display: inline-block;
	width: 20px;
	height: 20px;
	padding-right: 5px;
}

.downIntro,.introYun,.account {
	float: left;
	margin-right: 25px;
}

.name,.pwd,.role {
	width: 310px;
	height: 44px;
	line-height: 44px;
	padding-left: 15px;
	outline: none;
	border-radius: 20px;
	background-color: #0A3C78;
	border: 1px solid #329BE0;
}

.role:hover,.name:hover,.pwd:hover,.role:focus,.name:focus,.pwd:focus {
	background-color: #052b64;
}

#login {
	background: #3fb9ff;
	font-size: 18px;
	width: 329px;
	height: 44px;
	outline: none;
	color: white;
	background: -webkit-linear-gradient(#3fb9ff, #099be7, #229de3);
	background: -o-linear-gradient(#3fb9ff, #099be7, #229de3);
	background: -moz-linear-gradient(#3fb9ff, #099be7, #229de3);
	background: linear-gradient(#3fb9ff, #099be7, #229de3);
	border-radius: 20px;
}

#login:hover {
	background: -webkit-linear-gradient(#229de3, #099be7, #3fb9ff);
	background: -o-linear-gradient(#229de3, #099be7, #3fb9ff);
	background: -moz-linear-gradient(#229de3, #099be7, #3fb9ff);
	background: linear-gradient(#229de3, #099be7, #3fb9ff);
}

#hLeft {
	float: left;
	height: 32px;
	vertical-align: middle;
	line-height: 32px;
	width: 172px;
	text-align: center;
	cursor: pointer;
}

#hright {
	float: right;
	margin-right: 10px;
}

#head {
	height: 50px;
	padding-top: 25px;
	margin-left: 14px;
}

#middle {
	margin-top: 100px;
	/* height:600px; */
}

#footer {
	text-align: center;
	bottom: 15px;
	position: absolute;
	width: 100%;
}

#footer a {
	color: black;
}

#middle li {
	list-style-type: none;
	margin-top: 15px;
}

#children li {
	list-style-type: none;
	height: 42px;
	line-height: 42px;
	border-bottom: 1px double rgb(5, 33, 113);
}

#children li a {
	color: rgba(255, 255, 255);
}

.register {
	padding-right: 25px;
}

.downApk {
	background: url(image/android.png) no-repeat 30px;
	text-indent: 25px;
	display: inline-block;
	height: 32px;
	line-height: 32px;
	width: 232px;
	text-align: center;
}

.downApk:hover {
	background-color: #354d8d;
	border-radius: 16px;
}

.introduce {
	background: url(img/question.png) no-repeat 20px;
	text-indent: 20px;
	display: inline-block;
	height: 32px;
	line-height: 32px;
	width: 140px;
	text-align: center;
}

.introduce:hover {
	background-color: #354d8d;
	border-radius: 16px;
}

.reg {
	height: 32px;
	line-height: 32px;
	width: 129px;
	display: inline-block;
	text-align: center;
}

.reg:hover {
	background-color: #354d8d;
	border-radius: 16px;
}

.forgetPwd {
	height: 32px;
	line-height: 32px;
	width: 129px;
	display: inline-block;
	text-align: center;
}

.forgetPwd:hover {
	background-color: #354d8d;
	border-radius: 16px;
}

#children {
	position: absolute;
	margin-top: 35px;
	left: 14px;
	width: 172px;
	text-align: center;
	background-color: #1f377f;
	display: none;
}

#hLeft:hover {
	background-color: #1f377f;
	border-radius: 16px;
}

#children li:hover {
	background-color: #354d8d;
}

#cloud {
	background: url(images/cloud.png) repeat;
	width: 100%;
	height: 356px;
	position: absolute;
	bottom: 0px;
	-webkit-animation: cloud 60s linear infinite alternate;
	-moz-animation: clouds 60s linear infinite alternate;
	z-index: -10;
}

@
-webkit-keyframes cloud { 0%{
	background-position: top left
}

100%{
background-position
:top
 
right
}
}
@
-moz-keyframes clouds { 0%{
	background-position: top left
}

100%{
background-position
:top
 
right
}
}
#err {
	display: none;
	color: red;
}

#sky {
 	background: url(images/sky.png) repeat;
 	width: 100%;
	heigth: 462px;
	z-index: -20;
	height: 462px;
	position: absolute;
	top: 0px;
}

#valid {
	height: 44px;
	width: 150px;
	text-indent: 1em;
	vertical-align: middle;
	line-height: 46px;
	outline: none;
	border-radius: 20px;
	background-color: #0A3C78;
	border: 1px solid #329BE0;
}

#validcode {
	display: inline-block;
	width: 100px;
	height: 30px;
	margin-left: 5px;
	vertical-align: middle;
}

#changeimg {
	margin-left: 15px;
	cursor: pointer;
}

#tlogin:focus {
	outline: none;
}
</style>
	</head>
	<body>
		<div id="sky"></div>
		<div id="head"></div>
		<div id="middle">
			<form action="admin/login" method="post">
				<ul style="text-align: center;">
					<li style="font-size: 48px"> 
						通用教学管理系统
					</li>
					<li>
						<input class="name" name="name" placeholder="请输入用户名">
					</li>
					<li>
						<input type="password" name="password" class="pwd" placeholder="请输入密码">
					</li>
					<li>
					    <select name="usertype" class="role">
					       <option value="1">系统管理员</option>
					       <option value="2">学生</option>
					       <option value="3">教师</option>
					    </select>
					</li>
					<li>
						<button id="login">
							立即登录
						</button>
					</li>
					<li><span id="err" style="display: inline-block;">${ msg }</span></li>
				</ul>
			</form>
		</div>
		<div id="footer">
		</div>
		<div id="cloud"></div>
		<script src="script/jquery-2.1.1.js" type="text/javascript"
			charset="UTF-8"></script>
	</body>
</html>
