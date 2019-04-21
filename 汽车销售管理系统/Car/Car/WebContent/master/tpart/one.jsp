<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="./pub.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link href="${pageContext.request.contextPath}/css/font-awesome.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/input.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js">
	</script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/master/one.js">
	
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
	<input type="hidden" id="id" value="<%=request.getParameter("id")%>">
	<input type="hidden" id="path" value="${pageContext.request.contextPath}/">
	<div class='panel-body'>
		<table width='100%' class='table table-bordered table-hover' id='dataTables-example' style="text-align: center;">
			<thead>
				<tr><td colspan="4">员工详细信息</td> </tr>
			</thead>
			<tbody>
				<tr>
					<td>员工编号：</td><td id="mid"></td>
					<td rowspan="3" colspan="2"><img alt="相片" src="" id="img" width="150px" height="100px"></td>
				</tr>
				<tr>
					<td>员工登录名：</td><td id="name"></td>
				</tr>
				<tr>
					<td>员工姓名：</td><td id="realname"></td>
				</tr>
				<tr>
					<td>员工电话：</td><td id="tel"></td>
					<td>所在部门：</td><td id="pid"></td>
				</tr>
				<tr>
					<td>所得职称：</td><td id="zc"></td>
					<td>所在岗位：</td><td id="gw"></td>
				</tr>
				<tr>
					<td colspan="4">
						<button type="button" style='margin-left: 0px' class="btn btn-outline btn-default">
							<span id='she'>设置权限</span>
						</button>
					</td>
				</tr>
			</tbody> 
		
		</table>
	</div>

</body>
</html>
