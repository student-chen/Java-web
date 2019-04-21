<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%-- <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> --%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%-- <base href="<%=basePath%>"> --%>

<title>My JSP 'adminMenuI.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
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
	<div class="content_left">
		<div class="title">
			<span>您的身份：管理员</span>
		</div>
		<div class="left_nav">
			<ul>
				<li>
					<div class="t">
						<i></i><a class="head"><h3>个人信息</h3>
						</a>
					</div>
					<div class="txt">
						<p>
							<a href="ServletselectPwd" target="mainRight">查询登录密码</a>
						</p>
						<p>
							<a href="ServletInfo" target="mainRight">查询个人信息</a>
						</p>
					</div>
				</li>
				<li>
					<div class="t">
						<i></i><a class="head"><h3>课程管理</h3>
						</a>
					</div>
					<div class="txt">
						<p>
							<a href="ServletFindAllCos" target="mainRight">课程信息查看</a>
						</p>
						<p>
							<a href="admin/addCourse.jsp" target="mainRight">添加课程信息</a>
						</p>
					</div>
				</li>
				<li>
					<div class="t">
						<i></i><a class="head"><h3>成绩管理</h3>
						</a>
					</div>
					<div class="txt">
						<p>
							<a href="ServletFindAllScore" target="mainRight">成绩信息查看</a>
						</p>
						<p>
							<a href="admin/addScore.jsp" target="mainRight">添加学生成绩</a>
						</p>
						<p>
							<a href="ServletStuSum" target="mainRight">学生成绩总分</a>
						</p>
						<p>
							<a href="ServletStuSumList?f=1" target="mainRight">学生成绩排名</a>
						</p>
					</div>
				</li>
				<li>
					<div class="t">
						<i></i><a class="head"><h3>教师管理</h3>
						</a>
					</div>
					<div class="txt">
						<p>
							<a href="ServletFindAllTea" target="mainRight">查询教师信息</a>
						</p>
						<p>
							<a href="admin/addTeacher.jsp" target="mainRight">添加教师信息</a>
						</p>
					</div>
				</li>
				<li>
					<div class="t">
						<i></i><a class="head"><h3>学生管理</h3>
						</a>
					</div>
					<div class="txt">
						<p>
							<a href="ServletFindAllStu" target="mainRight">查询学生信息</a>
						</p>
						<p>
							<a href="admin/addStudent.jsp" target="mainRight">添加学生信息</a>
						</p>
					</div>
				</li>
				<li>
					<div class="t">
						<i></i><a class="head"><h3>账号管理</h3>
						</a>
					</div>
					<div class="txt">
						<p>
							<a href="PageServlet" target="mainRight">查询所有账号</a>
						</p>
						<!-- <p>ServletFindAllUser
									<a href="admin/addStudent.jsp" target="mainRight">查询</a>
								</p> -->
					</div></li>
					<li>
					<div class="t">
						<i></i><a class="head"><h3>文件管理</h3>
						</a>
					</div>
					<div class="txt">
						<p>
							<a href="admin/fileUpload.jsp" target="mainRight">文件上传</a>
						</p>
						 <p>
									<a href="ServletListFile" target="mainRight">文件下载</a>
								</p> 
					</div></li>
			</ul>
		</div>
	</div>
	<!-- <script charset="utf-8" type="text/javascript" src="js/jquery.js"></script>
			<script charset="utf-8" type="text/javascript" src="js/theme.js"></script> -->
</body>
</html>
