<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%--  <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>  --%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%--  <base href="<%=basePath%>">  --%>

<title>My JSP 'top.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
.h_top {
	margin-top: 15px;
	text-align: center;
	font-size: 35px;
	font-family: "楷体";
	letter-spacing: 10px;
	
	
}

.t_top,.t_left{
	width:450px;
	color:red;
	font-weight:bold;
	float:right;
	margin-top:56px;
	
}
.t_left{
	color:black;
	float:left;
}
.time {
	font-size: 9pt;
	/*
	*该属性一共有四个参数： Color代表投射阴影的颜色。 
	*Offx和offy分别X方向和Y方向阴影的偏移量。偏移量必须用整数值来设置。
	*如果设置为正整数，代表X轴的右方向和Y轴的向下方向。设置为负整数则相反。 
	*/
	/* filter: dropshadow(color = #FFFFFF, offx = 1, offy = 1, positive = 1); */
	color: #000000;
 	padding-left:30px;
	
}

.menu,a{
	
	text-decoration: none;
	cursor:pointer;
	color:red;
	font-weight: bold;
	
}
.menu{
	padding-left:280px;
}
body {
	background-image: url("images/lan.jpg");
	background-size: 100% 110%;
}
</style>
<script>
	function tick() {
		var ye, mo, da;
		var hours, minutes, seconds, xfile;
		var intHours, intMinutes, intSeconds;
		var today;
		today = new Date();
		ye = today.getFullYear();
		mo = today.getMonth() + 1;
		if (mo < 10) {
			mo = "0" + mo;
		}
		da = today.getDate();
		if (da < 10) {
			da = "0" + da;
		}
		intHours = today.getHours();
		intMinutes = today.getMinutes();
		intSeconds = today.getSeconds();
		if (intHours == 0) {
			hours = "12:";
			xfile = "PM";//午夜
		} else if (intHours < 12) {
			hours = intHours + ":";
			xfile = "AM";//上午
		} else if (intHours == 12) {
			hours = "12:";
			xfile = "PM";//正午
		} else {
			intHours = intHours - 12;
			hours = intHours + ":";
			xfile = "PM";//下午
		}
		if (intHours < 10) {
			hours = "0" + intHours + ":";
		}
		if (intMinutes < 10) {
			minutes = "0" + intMinutes + ":";
		} else {
			minutes = intMinutes + ":";
		}
		if (intSeconds < 10) {
			seconds = "0" + intSeconds + " ";
		} else {
			seconds = intSeconds + " ";
		}
		var color, size, face, out;
		var text = "black";
		var font_size = 1;
		var font_face = "Arial";
		color = (text) ? text : "black";
		size = (font_size) ? font_size : 1;
		face = (font_face) ? font_face : "Arial";
		timeString = "<font style='font-size:16px;color:red;'>当前时间:";
		timeString += ye + "-" + mo + "-" + da + "  ";
		timeString += hours + minutes + seconds + " " + xfile
				+ "&nbsp;&nbsp;&nbsp;";
		Clock.innerHTML = timeString;
		window.setTimeout("tick();", 100);
	}
	window.onload = tick;
</script>
</head>
<%
	if (application.getAttribute("counter") == null) {
		application.setAttribute("counter", "1");
	} else {
		String strnum = null;
		strnum = application.getAttribute("counter").toString(); //如果有值，拿到页面的值
		int intcount = 0;
		intcount = Integer.valueOf(strnum).intValue(); //把拿到的值变成int类型
		intcount++; //再给其加1

		//	application.setAttribute("counter", Integer.toString(intcount));

		String n = String.valueOf(intcount);
		application.setAttribute("counter", n);
	}
%>
<body>
	<br />
	<div class="h_top">
		<i> 学生管理系统</i>
	</div>
	<div class="t_left">
	<font >&nbsp;&nbsp;欢迎：${username}</font>
	</div>
	<div class="t_top">
		<font id="Clock" class="time">&nbsp; </font>&nbsp; 总访问人数：<%=application.getAttribute("counter")%><br/>
	<!-- 	欢迎：<br/> -->
		<font class="menu">&nbsp;&nbsp;<a href="ServletPwd" target="mainRight">修改密码</a>&nbsp;&nbsp;<a href="login/login.jsp" target="_top">退出系统</a></font>
	</div>

</body>
</html>
