<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="./pub.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/mycss.css"
	rel="stylesheet" type="text/css" />
<!-- Font Awesome -->
<link href="${pageContext.request.contextPath}/css/font-awesome.min.css"
	rel="stylesheet">
<!-- ionicons -->
<link href="${pageContext.request.contextPath}/css/ionicons.min.css"
	rel="stylesheet">

<!-- Morris -->
<link href="${pageContext.request.contextPath}/css/morris.css"
	rel="stylesheet" />

<!-- Datepicker -->
<link href="${pageContext.request.contextPath}/css/datepicker.css"
	rel="stylesheet" />
<!-- Animate -->
<link href="${pageContext.request.contextPath}/css/animate.min.css"
	rel="stylesheet">

<!-- Owl Carousel -->
<link href="${pageContext.request.contextPath}/css/owl.carousel.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/css/owl.theme.default.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/bootstrap-table.css"
	type="text/css"></link>
<!-- Simplify -->
<link href="${pageContext.request.contextPath}/css/simplify.min.css"
	rel="stylesheet">

<link href="${pageContext.request.contextPath}/css/simplify.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/bootstrap-table.css"
	type="text/css"></link>
<link
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap-table.js"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath }/js/bootstrap-table-zh-CN.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/shouhoumx/upp.js"></script>
<script src="${pageContext.request.contextPath}/js/layer/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ajaxfileupload.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/showdate.js"></script>
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
		<span class="input-group-addon" style="background-color: white;">
			客户: </span> <input class="form-control" id="name" disabled="disabled"
			type="text"
			value="<%=new String(request.getParameter("name").getBytes("ISO-8859-1"), "utf-8")%>" />
	</div>
	<br>
	<div class="input-group" style="width: 65%; margin-left: 20px;">
			<span class="input-group-btn" style="background-color: white;"> 
		  	 	<button class="btn btn-default" type="button">是否收费:</button>
			</span>
			<span class="input-group-addon" style="background-color: white;padding-left:50px ;padding-right:50px ;">
				<div class="custom-radio m-right-xs">
					<input type="radio" id="inlineRadio1" name="inlineRadio" value="0" checked="checked">
					<label for="inlineRadio1"></label>
				</div>
				<div class="inline-block vertical-top">是</div>
				<div class="custom-radio m-right-xs">
					<input type="radio" id="inlineRadio2" name="inlineRadio" value="1">
					<label for="inlineRadio2"></label>
				</div>
				<div class="inline-block vertical-top">否</div>
			</span>
	</div>
	<!-- <div class="input-group" style="width: 65%; margin-left: 20px;">
		<span class="input-group-addon" style="background-color: white;">
			收费： </span> <select class="form-control" id="flag">
			<option value="1">收费</option>
			<option value="0">免费</option>
		</select>
	</div> -->
	<br>
	<div class="input-group" style="width: 65%; margin-left: 20px;">
		<span class="input-group-addon" style="background-color: white;">
			费用： 
		</span> 
		<input class="form-control" id="shmoney" type="text" placeholder="请输入费用" />
	</div>
	<br>
	<div class="input-group" style="width: 65%; margin-left: 20px;">
		<span class="input-group-addon" style="background-color: white;">
			时间： 
		</span>
		<input class="form-control" id="time" type="text" 
			onclick="return Calendar('time');" placeholder="请输入时间" />
	</div>
	<br>
	<div class="input-group" style="width: 65%; margin-left: 20px;">
		<span class="input-group-addon" style="background-color: white;">
			服务内容： </span>
		<textarea class="form-control" id="fwnr" rows="5"
			placeholder="请输入服务内容"></textarea>
	</div>
	<br>
	<div class="input-group" style="margin-left: 25%">
		<button type="button" class="btn btn-info"
			style="background-color: #4b5f6f;" id="add">确认修改</button>
	</div>
	<input type="hidden"  id="id" value="<%=request.getParameter("id")%>">
	<input type="hidden"  id="path" value="${pageContext.request.contextPath}/">
</body>
</html>
