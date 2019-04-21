<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'Student.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->


<style type="text/css">
* {
	margin: auto;
	padding: auto;
}

.div_top {
	height: 180px;
	background-image: url("images/lan.jpg");
	background-size: 100% 110%;
}

.div_body,.div_left,.div_right {
	height: 600px;
	background: red;
}

.div_left {
	width: 20%;
	background: white;
	float: left;
}

.div_right {
	width: 80%;
	background: #00ffff;
	float: left;
}

.div_foot {
	height: 50px;
}

a {
	text-decoration: none;
}

.head {
	cursor: pointer;
}

h3 {
	color: black;
}

.content_left .title {
	height: 45px;
	background: #ff6637;
	color: #fff;
	padding: 0 20px;
	line-height: 45px;
	font-size: 16px
}

.content_left .title span {
	background: url(images/ioc.png) no-repeat 0 center;
	padding-left: 22px;
}
</style>

<script type="text/javaScript" src="js/jquery-1.8.1.js"></script>
<script type="text/javaScript">
	$(document).ready(function() {

		/*  $("a").mouseover(function(){
			$("a").css("color","yellow");
		 });
		 $("a").mouseout(function(){
			$("a").css("color","#333300");
		 }); */
		$(".txt").hide();
		$(".t").click(function() {
			$(".txt").slideToggle("slow");
		});

	});
</script>


</head>

<body>
	<div class="div_top">
		<%@ include file="/top.jsp"%>
	</div>
	<div class="div_body">
		<div class="div_left">
			<div class="content_left">
				<div class="title">
					<span>您的身份：学生</span>
				</div>
				<div class="left_nav">
					<ul>
						<li>
							<div class="t">
								<i></i><a class="head"><h3>个人信息</h3> </a>
							</div>
							<div class="txt">
								<p>
									<a href="ServletselectPwd" target="mainRight">查询登录密码</a>
								</p>
								<p>
									<a href="ServletStudentInfo" target="mainRight">查询个人信息</a>
								</p>
								<p>
									<a href="ServletSelectStudentInfo" target="mainRight">修改个人信息</a>
								</p>
							</div></li>
						<!-- <li>
							<div class="t">
								<i></i><a class="head"><h3>课程管理</h3> </a>
							</div>
							<div class="txt">
								<p>
									<a href="ServletFindAllCos" target="mainRight">课程信息查看</a>
								</p>
								<p>
									<a href="admin/addCourse.jsp" target="mainRight">添加课程信息</a>
								</p>
							</div></li> -->
						<li>
							<div class="t">
								<i></i><a class="head"><h3>成绩管理</h3> </a>
							</div>
							<div class="txt">
								<p>
									<a href="ServletFindStudentScore" target="mainRight">成绩信息查看</a>
								</p>
								<!-- <p>
									<a href="admin/addScore.jsp" target="mainRight">添加学生成绩</a>
								</p> -->
							</div></li>
							<li>
					<div class="t">
						<i></i><a class="head"><h3>文件管理</h3>
						</a>
					</div>
					<div class="txt">
					
						 <p>
									<a href="ServletListFile" target="mainRight">文件下载</a>
								</p> 
					</div></li>
					<!--  
						<li>
							<div class="t">
								<i></i><a class="head"><h3>学生管理</h3> </a>
							</div>
							<div class="txt">
								<p>
									<a href="ServletFindAllStu" target="mainRight">查询学生信息</a>
								</p>
								<p>
									<a href="admin/addStudent.jsp" target="mainRight">添加学生信息</a>
								</p>
							</div></li> -->
						<!-- <li>
							<div class="t">
								<i></i><a class="head"><h3>账号管理</h3> </a>
							</div>
							<div class="txt">
								<p>
									<a href="ServletFindAllUser" target="mainRight">查询所有账号</a>
								</p>
								<p>
									<a href="admin/addStudent.jsp" target="mainRight">查询</a>
								</p>
							</div>
						</li> -->
					</ul>
				</div>
			</div>
		</div>
		<div class="div_right">
			<iframe frameBorder="0" id="main" name="mainRight" scrolling="yes"
				src="main.jsp"
				style="HEIGHT: 100%; VISIBILITY: inherit; WIDTH: 100%; Z-INDEX: 1"></iframe>
		</div>
	</div>
	<div class="div_foot">
		<%@ include file="/foot.jsp"%>
	</div>
</body>
</html>

