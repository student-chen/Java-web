<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./pub.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>无标题文档</title>


<!-- 使用tree插件的主题包 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/js/tree/css/metroStyle/metroStyle.css" />
<!-- 依赖于jquery包 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<!-- tree的核心包 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tree/js/jquery.ztree.core.js"></script>
<!-- tree的扩展包 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tree/js/jquery.ztree.all.js"></script>
<script src="${pageContext.request.contextPath}/js/layer/layer.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tpart/main.js"></script>
<script src="${pageContext.request.contextPath}/js/layer/layer.js"></script>
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">

</head>


<body>
	<div class='container' style='width:100%'>
		<div class='row'>
			<div class='col-md-12 col-sm-12'>
				<div class="btn-group" style="float: right;">
					<button type="button" class="btn btn-default" id="switch1">
						<a href="javascript:void(0);">展开</a>
					</button>
					<button type="button" class="btn btn-default" id="switch2">
						<a href="javascript:void(0);">关闭</a>
					</button>
				</div>
			</div>
		</div>
		<div class='row'>
			<div class='col-md-12 col-sm-12'>
				<input type="hidden" value="${pageContext.request.contextPath}/" id="path">
				<ul id="treeDemo" class="ztree"></ul>
			</div>
		</div>
	</div>

</body>

</html>
