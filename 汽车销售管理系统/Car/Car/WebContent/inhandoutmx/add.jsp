<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css"
	rel="stylesheet">
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
<!-- Animate -->
<link href="${pageContext.request.contextPath}/css/animate.min.css"
	rel="stylesheet">

<!-- Owl Carousel -->
<link href="${pageContext.request.contextPath}/css/owl.carousel.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/owl.theme.default.min.css"
	rel="stylesheet">
 <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap-table.css" type="text/css"></link>
<!-- Simplify -->
<link href="${pageContext.request.contextPath}/css/simplify.min.css" rel="stylesheet">

<link href="${pageContext.request.contextPath}/css/simplify.min.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap-table.css" type="text/css"></link>
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap-table.js"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap-table-zh-CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/inhandoutmx/add.js"></script>
<script src="${pageContext.request.contextPath}/js/layer/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ajaxfileupload.js"></script>
<STYLE type="text/css">
* {
	font-size: 12px;
}

tr {
	height: 40px;
}
</STYLE>

</head>

<body><br>
		<div class="input-group" style="width: 65%; margin-left: 20px;">
				<span class="input-group-addon" style="background-color:white;">
					赠品名称 :
				</span> 
				<input class="form-control" id="name" disabled="disabled" type="text" value="<%=new String(request.getParameter("name").getBytes("ISO-8859-1"),"utf-8")%>"/>
		</div><br>
		<div class="input-group" style="width: 65%; margin-left: 20px;">
				<span class="input-group-addon" style="background-color:white;">
					选择仓库 :
				</span> 
				<select class="form-control" id="house"></select>
		</div><br>
		<div class="input-group" style="width: 65%; margin-left: 20px;">
				<span class="input-group-addon" style="background-color:white;">
					赠品颜色 :
				</span> 
				<input class="form-control" id="color" type="text" placeholder="请输入颜色"/>
		</div><br>
		<div class="input-group" style="width: 65%; margin-left: 20px;">
				<span class="input-group-addon" style="background-color:white;">
					赠品尺寸 :
				</span> 
				<input class="form-control" id="size" type="text" placeholder="请输入尺寸"/>
		</div><br>
		<div class="input-group" style="width: 65%; margin-left: 20px;">
				<span class="input-group-addon" style="background-color:white;">
					赠品图片 :
				</span> 
				<input class="form-control" id="img" name="img" type="file"/>
		</div><br>
		<div class="input-group" style="width: 65%; margin-left: 20px;">
				<span class="input-group-addon" style="background-color:white;">
					入库数量:
				</span> 
				<input class="form-control" id="num" type="text" placeholder="请输入数量"/>
		</div><br>
		<div class="input-group" style="width: 65%; margin-left: 20px;">
				<span class="input-group-addon" style="background-color:white;">
					备注：
				</span> 
				<textarea class="form-control" id="note" rows="5"  placeholder="请输入备注说明"></textarea>
		</div><br>
		<input type="hidden"  id="path" value="${pageContext.request.contextPath }/">
		<input type="hidden"  id="hid" value="<%=request.getParameter("hid")%>">
		<input type="hidden"  id="id" value="<%=request.getParameter("id")%>">
		<div class="input-group" style="margin-left: 25%">
			<button type="button" class="btn btn-info" style="background-color:#4b5f6f;" id="adds">确认保存</button>
		</div>
</body>
</html>
