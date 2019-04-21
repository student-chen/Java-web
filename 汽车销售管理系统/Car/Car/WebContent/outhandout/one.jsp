<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="./pub.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"
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
<link href="${pageContext.request.contextPath}/css/input.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap-table.js"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap-table-zh-CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/outcar/one.js"></script>
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

<body>
<div class='container' style='width:100%'>
	<div class="panel-body" style="padding-bottom:0px;">
		<table class="table table-bordered" id="tab" style='text-align:center;'>
			<tbody>
				<tr>
					<th colspan="4" style="text-align: center;">客户信息</th>
				</tr>
				<tr>
					<td style="width:25%;">客户姓名：</td>
					<td id="customname"  style="width:25%">安娜</td>
					<td  style="width:25%">客户电话：</td>
					<td id="customtel"  style="width:25%">15141753165</td>
				</tr>
				<tr>
					<th colspan="4" style="text-align: center;">汽车信息</th>
				</tr>
				<tr>
					<td style="width:25%;">汽车系列：</td>
					<td id="detailname"  style="width:25%"></td>
					<td  style="width:25%">入库价格：</td>
					<td id="price"  style="width:25%"></td>
				</tr>
				<tr>
					<td>市场价格：</td>
					<td id="newprice"></td>
					<td>车型：</td>
					<td id="guige"></td>
				</tr>
				<tr>
					<td>型号：</td>
					<td id="shouzi"></td>
					<td>车架号：</td>
					<td id="cjh"></td>
				</tr>
				<tr>
					<td>合格证：</td>
					<td id="hgz"></td>
					<td>发动机：</td>
					<td id="fdjh"></td>
				</tr>
				<tr>
					<td>汽车颜色：</td>
					<td id="color"></td>
					<td>仓库：</td>
					<td id="storename"></td>
				</tr>
				<tr>
					<td>图片：</td>
					<td colspan="3" align="center"><img alt="" src="" width="200px" height="200px" id="img"></td>
				</tr>
				<tr>
					<td>详细配置参数：</td>
					<td id="chanshu" colspan="3" style='height: 100px;'></td>
				</tr>	
				<tr>
					<th colspan="4" style="text-align: center;">赠品信息</th>
				</tr>	
			</tbody>
		</table>
	</div>
</div>
		<input type="hidden"  id="id" value="<%=request.getParameter("id")%>">
		<input type="hidden"  id="path" value="${pageContext.request.contextPath }/">
</body>
</html>
