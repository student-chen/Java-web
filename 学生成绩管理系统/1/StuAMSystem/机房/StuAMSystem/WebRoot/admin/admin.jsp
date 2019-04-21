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

<title>My JSP 'Teacher.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->


 <!-- <link type="text/css" rel="stylesheet" href="css/theme.css">  -->
<style type="text/css">
*{
	margin:auto;
	padding:auto;
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
	background-color: #9cfafc;
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


</style>

<!-- <script src="js/jquery-1.11.2.min.js" type="text/javascript"></script> -->

</head>

<body>
	<div class="div_top">
		<%@ include file="/top.jsp"%>
	</div>
	<div class="div_body">
	  	<div class="div_left">
			 <%@ include file="adminMenuI.jsp"%>
		</div>
		<div class="div_right">
			<iframe frameBorder="0" id="main" name=mainRight scrolling="yes"
				src="main.jsp"
				style="HEIGHT: 100%; VISIBILITY: inherit; WIDTH: 100%; Z-INDEX: 1"></iframe>
		</div>
	</div>
	<div class="div_foot">
		<%@ include file="/foot.jsp"%>
	</div>
</body>
</html>
