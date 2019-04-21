<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="./pub.jsp" %>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/incarmx/add.js"></script>
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
<div class='container' style='width:100%'>
	<div class="row">
		<div class="col-md-6 col-sm-6 col-xs-6">
			<div class="input-group" style="">
				<span class="input-group-addon" style="background-color:white;">
					汽车系列 :
				</span> 
				<input class="form-control" id="name" disabled="disabled" type="text" value="<%=new String(request.getParameter("name").getBytes("ISO-8859-1"),"utf-8")%>"/>
			</div><br>
			<div class="input-group" style="">
				<span class="input-group-addon" style="background-color:white;">
					入库价格 :
				</span> 
				<input class="form-control" id="price" type="text" placeholder="请输入入库价格"/>
			</div><br>
			<div class="input-group" style="">
				<span class="input-group-addon" style="background-color:white;">
					车型型号 :
				</span> 
				<input class="form-control" id="shouzi" type="text" placeholder="如:(BC2017SGY)"/>
			</div><br>
			<div class="input-group" style="">
				<span class="input-group-addon" style="background-color:white;">
					合格证号 :
				</span> 
				<input class="form-control" id="hgz" type="text" placeholder="如:(12 32 56 87 1)"/>
			</div><br>
			<div class="input-group" style="">
				<span class="input-group-addon" style="background-color:white;">
					车身颜色 :
				</span> 
				<input class="form-control" id="color" type="text" placeholder="请输入颜色"/>
			</div><br>
		</div>
		<div class="col-md-6 col-sm-6 col-xs-6">
			<div class="input-group" style="">
				<span class="input-group-addon" style="background-color:white;">
					选择仓库 :
				</span> 
				<select class="form-control" id="house"></select>
			</div><br>
			<div class="input-group" style="">
				<span class="input-group-addon" style="background-color:white;">
					市场价格 :
				</span> 
				<input class="form-control" id="newprice" type="text" placeholder="请输入市场价格"/>
			</div><br>
			<div class="input-group" style="">
				<span class="input-group-addon" style="background-color:white;">
					车架号 :
				</span> 
				<input class="form-control" id="cjh" type="text" placeholder="如:(CJBC20170304W)"/>
			</div><br>
			<div class="input-group" style="">
				<span class="input-group-addon" style="background-color:white;">
					发动机号:
				</span> 
				<input class="form-control" id="fdjh" type="text" placeholder="如:(2.0L 150马力 L4)"/>
			</div><br>
			<div class="input-group" style="">
				<span class="input-group-addon" style="background-color:white;">
					车辆图片 :
				</span> 
				<input class="form-control" id="img" name="img" type="file"/>
			</div><br>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12 col-sm-12">
			<div class="input-group" style="">
					<span class="input-group-addon" style="background-color:white;">
						详细配置参数：
					</span> 
					<textarea class="form-control" id="note" rows="5"  placeholder="请输入详细配置参数"></textarea>
			</div><br>
			<div class="input-group"  style="margin-left: 25%">
				<button type="button" class="btn btn-info" style="background-color:#4b5f6f;" id="adds">确认保存</button>
			</div>
			<input type="hidden"  id="path" value="${pageContext.request.contextPath }/">
			<input type="hidden"  id="id" value="<%=request.getParameter("id")%>">
			<input type="hidden"  id="did" value="<%=request.getParameter("did")%>">
		</div>
	</div>
</div>
</body>
</html>
