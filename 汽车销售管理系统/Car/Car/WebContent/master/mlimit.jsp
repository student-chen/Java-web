<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link href="${pageContext.request.contextPath}/css/mycss.css" rel="stylesheet" type="text/css"/>
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
<link href="${pageContext.request.contextPath}/css/simplify.min.css" rel="stylesheet">
<!-- Animate -->
<link href="${pageContext.request.contextPath}/css/animate.min.css"
	rel="stylesheet">

<!-- Owl Carousel -->
<link href="${pageContext.request.contextPath}/css/owl.carousel.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/css/owl.theme.default.min.css"
	rel="stylesheet">
<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
 <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap-table.css" type="text/css"></link>
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/input.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
	  <script src="${pageContext.request.contextPath }/js/bootstrap-table.js"></script>
	   <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
	  <script src="${pageContext.request.contextPath }/js/bootstrap-table-zh-CN.js"></script>
	<!-- Bootstrap -->
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
	
	<!-- Slimscroll -->
	<script src='${pageContext.request.contextPath}/js/jquery.slimscroll.min.js'></script>
	
	<!-- Popup Overlay -->
	<script src='${pageContext.request.contextPath}/js/jquery.popupoverlay.min.js'></script>

	<!-- Modernizr -->
	<script src='${pageContext.request.contextPath}/js/modernizr.min.js'></script>
	
	<!-- Simplify -->
	<script src="${pageContext.request.contextPath}/js/simplify/simplify.js"></script>
	
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
	<script src="${pageContext.request.contextPath}/js/layer/layer.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/master/group.js">
	</script>
	<input type="hidden" id="id" value="<%=request.getParameter("id")%>">
	<input type="hidden" id="path" value="${pageContext.request.contextPath}/">
		<div style="float: right;">
			<button type="button" class="btn btn-info" style="background-color:#4b5f6f;" id="save">确认保存</button>
		</div>
		<br>
		<div id="toolbar"></div>
			<table id="tb_departments"></table>
			
			
</body>
</html>