<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
		<!-- Bootstrap core CSS -->
	    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		
		<!-- Font Awesome -->
		<link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet">

		<!-- ionicons -->
		<link href="${pageContext.request.contextPath}/css/ionicons.min.css" rel="stylesheet">
		
		<!-- Slider -->
		<link href="${pageContext.request.contextPath}/css/bootstrap-slider.css" rel="stylesheet"/>

		
		<!-- Simplify -->
		<link href="${pageContext.request.contextPath}/css/simplify.min.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js">
	</script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/ajaxfileupload.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/master/upp.js">
	
</script>

<script src="${pageContext.request.contextPath}/js/layer/layer.js"></script>

<STYLE type="text/css">
* {
	font-size: 12px;
}

tr {
	height: 40px;
}
</STYLE>

</head>

<body>
			<br>
			<div class="input-group" style="width: 65%; margin-left: 20px;">
				<span class="input-group-addon" style="background-color:white;">
					所属部门  :
				</span> <select class="form-control" id="parentPart"></select>
			</div><br>
			<div class="input-group" style="width: 65%; margin-left: 20px;">
				<span class="input-group-addon" style="background-color:white;">
					所属岗位 :
				</span> 
				<select class="form-control" id="gw"><option value="0">---请选择---</option></select>
			</div><br>
			<div class="input-group" style="width: 65%; margin-left: 20px;">
				<span class="input-group-addon" style="background-color:white;">
					所得职称 :
				</span> 
				<select class="form-control" id="zc"></select>
			</div><br>
			<div class="input-group" style="width: 65%; margin-left: 20px;">
				<span class="input-group-addon" style="background-color:white;">
					登录名：
				</span> 
				<input type="text" class="form-control" id="name" placeholder="请输入登录名"/>
			</div><br>
			<div class="input-group" style="width: 65%; margin-left: 20px;">
				<span class="input-group-addon" style="background-color:white;">
					真实姓名：
				</span> 
				<input type="text" class="form-control" id="realname" placeholder="请输入真实名称"/>
			</div><br>
			<div class="input-group" style="width: 65%; margin-left: 20px;">
				<span class="input-group-addon" style="background-color:white;">
					手机号码：
				</span> 
				<input type="text" class="form-control" id="tel" placeholder="请输入手机号码"/>
			</div><br>
			<div class="input-group" style="width: 65%; margin-left: 20px;">
				<span class="input-group-addon" style="background-color:white;">
					登录密码：
				</span> 
				<input type="password" class="form-control" id="psw" placeholder="请输入登录密码"/>
			</div><br>
			<div class="input-group" style="width: 65%; margin-left: 20px;">
				<span class="input-group-addon" style="background-color:white;">
					用户头像：
				</span> 
				<input type="file" class="form-control" name="img" id="img" />
			</div><br>
			<div class="input-group" style="margin-left: 25%">
				<button type="button" class="btn btn-info" style="background-color:#4b5f6f;" id="add">确认修改</button>
			</div>
	<input type="text" id="path" style="display: none"
		value="${pageContext.request.contextPath}/">
		<input type="hidden" id="old"/>
		<input type="hidden" id="oldtel"/>
		<input type="hidden" id="id" value="<%=request.getParameter("id")%>"/>
</body>
</html>
