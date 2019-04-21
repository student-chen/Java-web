<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%-- <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> --%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <%--  <base href="<%=basePath%>"> --%>
    
    <title>My JSP 'adminMenu.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
/**{box-sizing:border-box;-moz-box-sizing:border-box;-webkit-box-sizing:border-box;}*/
/*body{background:#f0f0f0;}*/
.content{width:260px;margin:20px auto;}
.filterinput{
	background-color:rgba(249, 244, 244, 0);
	border-radius:15px;
	width:90%;
	height:30px;
	border:thin solid #FFF;
	text-indent:0.5em;
	font-weight:bold;
	color:#FFF;
}
#demo-list a{
	overflow:hidden;
	text-overflow:ellipsis;
	-o-text-overflow:ellipsis;
	white-space:nowrap;
	width:100%;
}
</style>	
	
<script src="js/jquery-1.8.1.js" type="text/javascript"></script>
<script src="js/jquery-accordion-menu.js" type="text/javascript"></script>
<script type="text/javascript">

$(function(){	
	//顶部导航切换
	$("#demo-list li").click(function(){
		$("#demo-list li.active").removeClass("active");
		$(this).addClass("active");
	});	
});	
</script>

  </head>
  
  <body>
    <div style="text-align:center;clear:both">
				<script src="/gg_bd_ad_720x90.js" type="text/javascript"></script>
				<script src="/follow.js" type="text/javascript"></script>
			</div>
			<div class="content">

				<div id="jquery-accordion-menu" class="jquery-accordion-menu white">
					<div class="title">
						<span>您的身份：管理员</span>
					</div>
					
					<ul id="demo-list">

						<li class="active"><a ><i class="fa fa-user"></i>个人信息</a>
							<ul class="submenu">
								<li><a href="q.jsp" target="mainRight">修改信息</a>
								</li>
								<li><a href="ServletselectPwd" target="mainRight">查询密码</a>
								</li>
							</ul></li>
						<li><a href="#"><i class="fa fa-envelope"></i>成绩管理</a>
							<ul class="submenu">
								<li><a href="#">查询成绩</a>
								</li>
								<li><a href="#">修改成绩 </a>
								</li>
								<li><a href="#">Design </a>
								</li>
								<li><a href="#">Consulting </a>
								</li>
							</ul></li>
						</li>
						<li><a href="#"><i class="fa fa-cog"></i>课程管理</a>
							<ul class="submenu">
								<li><a href="#">查询课程</a>
								</li>
								<li><a href="#">修改课程</a>
								</li>
								<li><a href="#">添加课程 </a>
								</li>
								<li><a href="#">Consulting </a>
								</li>
							</ul></li>
						
						<li><a href="#"><i class="fa fa-suitcase"></i>学生管理 </a>
							<ul class="submenu">
								<li><a href="#">Web Design </a>
								</li>
								<li><a href="#">Graphics </a><span
									class="jquery-accordion-menu-label">10 </span></li>
								<li><a href="#">Photoshop </a>
								</li>
								<li><a href="#">Programming </a>
								</li>
							</ul></li>
							<li><a href="#"><i class="fa fa-home"></i>教师管理 </a>
							<ul class="submenu">
								<li><a href="#">Web Design </a>
								</li>
								<li><a href="#">Graphics </a><span
									class="jquery-accordion-menu-label">10 </span></li>
								<li><a href="#">Photoshop </a>
								</li>
								<li><a href="#">Programming </a>
								</li>
							</ul></li>
							<li><a href="#"><i class="fa fa-home"></i>专业管理 </a>
							<ul class="submenu">
								<li><a href="#">Web Design </a>
								</li>
								<li><a href="#">Graphics </a><span
									class="jquery-accordion-menu-label">10 </span></li>
								<li><a href="#">Photoshop </a>
								</li>
								<li><a href="#">Programming </a>
								</li>
							</ul></li>
							<li><a href="#"><i class="fa fa-home"></i>系统管理 </a>
							<ul class="submenu">
								<li><a href="#">Web Design </a>
								</li>
								<li><a href="#">Graphics </a><span
									class="jquery-accordion-menu-label">10 </span></li>
								<li><a href="#">Photoshop </a>
								</li>
								<li><a href="#">Programming </a>
								</li>
							</ul></li>


					</ul>

				</div>
			</div>

			<script type="text/javascript" src="js/them.js"></script>

			<script type="text/javascript">
				jQuery("#jquery-accordion-menu").jqueryAccordionMenu();
			</script>
  </body>
</html>
