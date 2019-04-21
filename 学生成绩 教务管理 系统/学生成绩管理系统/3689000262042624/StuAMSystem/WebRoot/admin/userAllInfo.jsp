<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'userAllInfo.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<style type="text/css">
.div_list {
	width: 700px;
	height: 500px;
	margin: auto;
	margin-top: 50px;
}

font {
	color: red;
	font-weight: bold;
	text-align: center;
}

table {
	margin: 0 auto;
}

table tr td {
	text-align: center;
	width: 150px;
	height: 40px;
}

a {
	text-decoration: none;
}
</style>


</head>

<body>
<form action="PageServlet" method="post">
	<div class="div_list">
		<font>${msg}</font>
		<table border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>学号</td>
				<td>姓名</td>
				<td>密码</td>
				<td>联系电话</td>
				<td>身份</td>
				<td>操作</td>
			</tr>
			<c:forEach var="list" items="${list.getPbjs() }">
				<tr>
					<td>${list.getUserNum() }</td>
					<td>${list.getUserName() }</td>
					<td>${list.getPassword() }</td>
					<td>${list.getPhone() }</td>
					<td>${list.getRoleName() }</td>
					<td>&nbsp;<a
						href="ServletSelectUser?userID=${list.getUserID() }">修改</a>&nbsp;</td>
				</tr>
			</c:forEach>
			<tr>

				<td colspan="6">
					
					<a href="PageServlet?pageNo=1&totalPage=${list.totalPage}">首页</a>
					<a href="PageServlet?pageNo=${list.pageNo-1}&totalPage=${list.totalPage}">上一页</a>
					<a href="PageServlet?pageNo=${list.pageNo+1}&totalPage=${list.totalPage}">下一页</a>
					<a href="PageServlet?pageNo=${list.totalPage}&totalPage=${list.totalPage}"> 最后一页 </a>
					<br/>
					跳转到： <input id="pageNo" type="text"
					name="pageNo" value="${list.pageNo}" /> 每页记录数： <input
					type="text" name="pageCount" value="${list.pageCount}" /> <input
					type="submit" value="跳转" /> 共有 ${list.totalPage} 页 
				</td>

			</tr>
		</table>
		
	</div>
	</form>
</body>
</html>

