<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>后台管理</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="Bluth Company">
<%--     <link rel="shortcut icon" href="<%=basePath %>assets/ico/favicon.html"> --%>
    <link href="<%=basePath %>assets/css/bootstrap.css" rel="stylesheet">
        <!-- Latest compiled and minified CSS -->
    <link href="<%=basePath %>assets/css/theme.css" rel="stylesheet">
    <link href="<%=basePath %>assets/css/font-awesome.min.css" rel="stylesheet">
    <link href="<%=basePath %>assets/css/alertify.css" rel="stylesheet">
    <link rel="Favicon Icon" href="<%=basePath %>assets/favicon.ico">
    <script type="text/javascript" src="<%=basePath %>assets/js/jquery.min.js"></script>
    <script >
    $(document).ready(function () {
    	$(":input").attr("autocomplete","off");
    });
    </script>
    
<style type="text/css">
ul,li{
	padding: 0;
	margin:0;
} 
a {
	color: rgb(1, 124, 185);
	text-decoration: none;
}
body{
 	font-size:16px;
/* 	color: #5a5d63;
	background: #d6d7d9; */
/* 	background: -webkit-radial-gradient(#eeefef, #d6d7d9);
	background: -moz-radial-gradient(#eeefef, #d6d7d9); */
 	background: -o-radial-gradient(#eeefef, #d6d7d9); 
 	background: -ms-radial-gradient(#eeefef, #d6d7d9);
	background: radial-gradient(#eeefef, #d6d7d9); 
	/*  padding: 50px;  */
}
.box{
	width: 492px;
	height: 200px;
	margin: 50px auto;
}
.box li{
	position: relative;
	text-align: center;
	list-style-type: none;
	display: inline-block;
	width: 150px;
	height:160px;
	text-shadow:0 2px 1px #f4f4f4;
	border:1px solid #9fa2ad;
	border-radius: 5px;
	margin-right:10px;
	background: -webkit-gradient(linear,0 0, 0 100%,
	color-stop(.2,rgba(248,248,248,.3)),
	color-stop(.5,rgba(168,173,190,.5)),
	color-stop(.51,rgba(168,173,190,.3)),
	color-stop(.9,rgba(248,248,248,.2)));
	background: -webkit-linear-gradient(top,rgba(248,248,248,.3) 20%,rgba(168,173,190,.5) 50%,rgba(168,173,190,.3) 51%, rgba(248,248,248,.2) 90%);
	background: -moz-linear-gradient(top, rgba(248,248,248,.3) 20%,rgba(168,173,190,.5) 50%,rgba(168,173,190,.3) 51%, rgba(248,248,248,.2) 90%);
	background: -o-linear-gradient(top, rgba(248,248,248,.3) 20%, rgba(168,173,190,.5) 50%, rgba(168,173,190,.3) 51%, rgba(248,248,248,.2) 90%);
	background: -ms-linear-gradient(top, rgba(248,248,248,.3) 20%, rgba(168,173,190,.5) 50%, rgba(168,173,190,.3) 51%, rgba(248,248,248,.2) 90%);
	background: linear-gradient(top, rgba(248,248,248,.3) 20%, rgba(168,173,190,.5) 50%, rgba(168,173,190,.3) 51%, rgba(248,248,248,.2) 90%);
	box-shadow:inset 0 -2px 0 #f1f1f1,0 1px 0 #f1f1f1,0 2px 0 #9fa2ad,0 3px 0 #f1f1f1,0 4px 0 #9fa2ad;
}
.box li:before,
.box li:after{
	display: block;
	content: "";
	position: absolute;
	width: 150px;
}
.box li:before{
	top:50%;
	height: 1px;
	box-shadow: 0 1px 0 #868995,0 2px 1px #fff;
}
.box li:after{
	bottom: -65px;
	height: 60px;
	border-radius:0 0 5px 5px;
	background: -webkit-gradient(linear,0 0,0 100%,from(rgba(0,0,0,.1)),to(rgba(0,0,0,0)));
	background: -webkit-linear-gradient(top,rgba(0,0,0,.1),rgba(0,0,0,0));
	background: -moz-linear-gradient(top,rgba(0,0,0,.1),rgba(0,0,0,0));
	background: -o-linear-gradient(top,rgba(0,0,0,.1),rgba(0,0,0,0));
	background: -ms-linear-gradient(top,rgba(0,0,0,.1),rgba(0,0,0,0));
	background: linear-gradient(top,rgba(0,0,0,.1),rgba(0,0,0,0));
	z-index: 1
}
.box li span:first-child{
	font:120px 'BitstreamVeraSansMonoBold';
	color: #52555a;
	display: block;
	height: 130px;
	line-height: 150px;
}
</style>
  </head>
  <body>
    <div id="wrap">
    <div class="navbar navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container-fluid">
          <div class="logo"> 
          	<span style="color: white;font-size: 24px;">学生信息管理系统</span>
           <!-- <img src="assets/img/logo.png" alt="Realm Admin Template">-->
          </div>
           <a class="btn btn-navbar visible-phone" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
           <a class="btn btn-navbar slide_menu_left visible-tablet">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>

          <div class="top-menu visible-desktop">
            <ul class="pull-right">  
              <li><a href="<%=basePath %>login.jsp"><i class="icon-off"></i>退出</a></li>
            </ul>
          </div>

        
        </div>
      </div>
    </div>

   
     
      <!-- Side menu -->
      <div class="sidebar-nav nav-collapse collapse">
        <div class="user_side clearfix">
          <img src="<%=basePath %>assets/img/u=2193226168,4120396026&fm=27&gp=0.jpg" alt="无法显示">
          <h5>登录角色:欢迎[${userOA.name}]哈!</h5>           
        </div>
        <div class="accordion" id="accordion2">
          <div class="accordion-group">
            <div class="accordion-heading">
              <a class="accordion-toggle active b_F79999" href="index.jsp" ><i class="icon-dashboard"></i> <span>控制台</span></a>
            </div>
          </div>

          <div class="accordion-group">
            <div class="accordion-heading">
              <a class="accordion-toggle b_F6F1A2" href="StudentOAselect"><i class="icon-tasks"></i> <span>学生信息列表</span></a>
            </div>
          </div>  
          <div class="accordion-group">
             <div class="accordion-heading">
              <a class="accordion-toggle b_F5C294" href="ClassOAselect"><i class="icon-tasks"></i> <span>班级信息列表</span></a>
            </div> 
          </div> 
          <div class="accordion-group">
             <div class="accordion-heading">
              <a class="accordion-toggle b_F5C294" href="TeacherSelect"><i class="icon-tasks"></i> <span>老师信息列表</span></a>
            </div> 
          </div>        
          <div class="accordion-group">
             <div class="accordion-heading">
              <a class="accordion-toggle b_F5C294" href="password.jsp"><i class="icon-user"></i> <span>修改密码</span></a>
            </div> 
          </div>      
        </div>
      </div>
      <!-- /Side menu -->

      <!-- Main window -->
      <div class="main_container" id="dashboard_page">
 

        <!-- CHARTS  -->
        <div class="row-fluid">
        
            <!-- <div class="widget-header">
              <i class="icon-bar-chart"></i>
              <h5>案件列表</h5>
             
            </div>  
            
 -->       
		
			
			<div class="box">
				<ul>
					<li><span id="hour"></span><span>时</span></li>
					<li><span id="minute"></span><span>分</span></li>
					<li><span id="second"></span><span>秒</span></li>
				</ul>
			</div>
			<div>
<form name="form1" method="post" action="LogOAselect" id="searchForm">
  <input type="hidden" id="pageNo" name="pageNo" value="${pagerBooks.pageNo}"/>
  <input type="hidden" id="pageSize" name="pageSize" value="${pagerBooks.pageSize}"/> 
<table width="100%" border="1" cellspacing="20" cellpadding="3" style="text-align:center">
<tr>
<td height="25">用户名</td>
<td height="25">姓名</td>
<td height="25">登陆时间</td>
<td height="25">IP地址</td>
<td height="25">登录设备</td>
</tr>
<c:forEach var="list" items="${pagerBooks.entitiesList}" varStatus="status">
                  <tr align="center"<c:if test="${status.index % 2==1}">
                      style="background-color:#D5E4F4;"
                      </c:if>> 
                      <td><input type="checkbox" name="id" value="${list.remoteAddr}"></td>   
                      <td height="25" align="center">${list.userAgent}</td>
                      <td height="25" align="center">${list.createBy}</td>
                      <td>${list.createTime}</td>
                      <td>${list.type}</td></tr> 
  </c:forEach>  

</table>
</form>
</div>
			
        </div> <!-- /row-fluid -->
 </div> 

 </div> 

<script type="text/javascript">
var hour=document.getElementById('hour');
var minute=document.getElementById('minute');
var second=document.getElementById('second');
function showTime(){
	var oDate=new Date();
	var iHours=oDate.getHours();
	var iMinute=oDate.getMinutes();
	var iSecond=oDate.getSeconds();
	hour.innerHTML=AddZero(iHours);
	minute.innerHTML=AddZero(iMinute);
	second.innerHTML=AddZero(iSecond);
}
showTime();
setInterval(showTime,1000);
function AddZero(n){
	if(n<10){
		return '0'+n;
	}
	return ''+n;
}
</script>

  </body>
</html>
