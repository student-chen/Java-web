<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">

	<title></title>
	<link href="styles/bootstrap/css/bootstrap.css" rel="stylesheet" />
     <!-- FONTAWESOME STYLES-->
    <link href="styles/bootstrap/css/font-awesome.css" rel="stylesheet" />
        <!-- CUSTOM STYLES-->
    <link href="styles/bootstrap/css/custom.css" rel="stylesheet" />
     <!-- GOOGLE FONTS-->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
   <style type="text/css">
    .sidebar-collapse .nav{margin-top: -50px}
   </style>
</head>
<body>
<br/>
<ul class="nav nav-pills nav-stacked">
    <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                   <c:if test="${user.usertype==1}">
                    <li>
                        <a href="stu/list" target="right"><i class="fa fa-desktop "></i>学生管理 </a>
                    </li>

                    <li>
                        <a href="tea/list"  target="right"><i class="fa fa-table "></i>教师管理</a>
                    </li>
                    <li>
                        <a href="cou/list"  target="right"><i class="fa fa-edit "></i>课程管理</a>
                    </li>
                    <li>
                        <a  href="cla/list"  target="right"><i class="fa fa-qrcode "></i>班级管理</a>
                    </li>
                    </c:if>
                    
                    <c:if test="${user.usertype==3}">
                    <li>
                        <a href="homepage/test2.jsp" target="right"><i class="fa fa-desktop "></i>查看课表 </a>
                    </li>

                    <li>
                        <a href="tea/getMyStu"  target="right"><i class="fa fa-table "></i>学生管理</a>
                    </li>
                   
                    <li>
                        <a href="homepage/test.jsp"  target="right"><i class="fa fa-bar-chart-o"></i>修改密码</a>
                    </li>
                    </c:if>
                    
                    <c:if test="${user.usertype==2}">
                    <li>
                        <a href="stu/getStuCourse" target="right"><i class="fa fa-desktop "></i>查看课表 </a>
                    </li>

                    <li>
                        <a href="homepage/test3.jsp"  target="right"><i class="fa fa-table "></i>成绩查询</a>
                    </li>
                    <li>
                        <a  href="stu/getXuXiu"  target="right"><i class="fa fa-qrcode "></i>选课</a>
                    </li>
                    <li>
                        <a href="homepage/test.jsp"  target="right"><i class="fa fa-bar-chart-o"></i>修改密码</a>
                    </li>
                    </c:if>
                </ul>
             </div>

        </nav>
</ul>
</body>
</html>
