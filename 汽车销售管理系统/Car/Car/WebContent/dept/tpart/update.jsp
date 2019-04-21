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
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tpart/update.js">
	
</script>
<script src="${pageContext.request.contextPath}/js/layer/layer.js">
	
</script>
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
					部门名称:
				</span> 
				<input class="form-control" id="part" type="text" placeholder="请输入名称"/>
			</div><br>
			<div class="input-group" style="width: 65%; margin-left: 20px;">
				<span class="input-group-addon" style="background-color:white;">
					部门备注：
				</span> 
				<textarea class="form-control" id="note" rows="5"  placeholder="请输入备注"></textarea>
			</div><br>
			<div class="input-group" style="margin-left: 25%">
				<button type="button" class="btn btn-info" style="background-color:#4b5f6f;" id="upp">确认修改</button>
			</div>
		<input type="text" id="paths" style="display: none" value="${pageContext.request.contextPath}/">
		<input type="hidden" id="id"  value="<%=request.getParameter("id")%>">
		<input type="hidden" id="zjid">
		<input type="hidden" id="old">
		<input type="hidden" id="sjid" value="<%=request.getParameter("sjid")%>">
</body>
</html>
