<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'studentAll.jsp' starting page</title>
    
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
table{
margin:0 auto;

}
table tr td{
text-align: center;
width:150px;
height:40px;
}
a{
text-decoration: none;
}
</style>
  </head>
  
  <body>
    
    <div class="div_list">
		<font>${msg}</font>
		<table border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>工号号</td>
				<td>姓名</td>
				<td>性别</td>
				<td>年龄</td>
				<td>所任课程</td>
				<td>专业</td>
				<td>院系</td>
				<td>操作</td>
			</tr>
			<c:forEach var="list" items="${list }">
			<tr>
				<td>${list.getTeaNum() }</td>
				<td>${list.getTeaName() }</td>
				<td>${list.getTeaSex() }</td>
				<td>${list.getTeaAge() }</td>
				<td>${list.getTeaCourse() }</td>
				<td>${list.getMajor() }</td>
				<td>${list.getDepartment() }</td>
				<td><a href="ServletSelectTea?teanum=${list.getTeaNum() }">修改</a>&nbsp;&nbsp;&nbsp;<a href="ServletDeleteTea?teanum=${list.getTeaNum() }" onclick="return confirm('是否确认删除？')">删除</a></td>
				
			</tr>
			</c:forEach>
		</table>
	</div>
  </body>
</html>
