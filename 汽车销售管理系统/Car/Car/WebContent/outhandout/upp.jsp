<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="./pub.jsp" %>
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
	src="${pageContext.request.contextPath}/js/outhandout/upp.js">
	
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
			<div class="input-group" style="width: 58%; margin-left: 20px;">
				<span class="input-group-addon" style="background-color:white;">
					选择赠品 :
				</span> 
				<select class="form-control" id="handout"></select>
			</div><br>
			<div class="input-group" style="width: 58%; margin-left: 20px;">
				<span class="input-group-addon" style="background-color:white;">
					客户姓名：
				</span> 
				<input type="text" class="form-control" id="name" placeholder="请输入客户姓名"/>
			</div><br>
			<div class="input-group" style="width: 58%; margin-left: 20px;">
				<span class="input-group-addon" style="background-color:white;">
					客户电话：
				</span> 
				<input type="text" class="form-control" id="tel" placeholder="请输入客户电话"/>
			</div><br>
			<div class="row">
				<div class="col-xs-7" style="margin-left: 17px;padding:0px;">
					<div class="input-group" style="margin-left: 20px;">
						<span class="input-group-addon" style="background-color:white;">
							出售量：
						</span> 
						<input type="text" class="form-control" id="count" placeholder="请输入数量"/>
					</div>
				</div>
				<div class="col-xs-4"  style="margin: 0px;padding:0px;">
					<span id="num" style="color:red;line-height: 30px;">&nbsp;&nbsp;目前库存量：<b></b></span>
				</div>
			</div>
			<br>
			<div class="input-group" style="width: 58%; margin-left: 20px;">
				<span class="input-group-addon" style="background-color:white;">
					备注：
				</span> 
				<textarea class="form-control" id="note" rows="5"  placeholder="请输入备注"></textarea>
			</div><br>
			<div class="input-group" style="margin-left: 25%">
				<button type="button" class="btn btn-info" style="background-color:#4b5f6f;" id="adds">确认保存</button>
			</div>
			<input type="text" id="path" style="display: none" value="${pageContext.request.contextPath}/">
			<input type="text" id="id" style="display: none" value="<%=request.getParameter("id") %>">
</body>
</html>
