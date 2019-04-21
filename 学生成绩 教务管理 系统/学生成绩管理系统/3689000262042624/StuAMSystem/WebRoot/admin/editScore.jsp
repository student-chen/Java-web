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
    
    <title>My JSP 'editScore.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<style type="text/css">
.div_ads {
	width: 400px;
	
	margin: auto;
	margin-top: 50px;
}

table {
	margin: 0 auto;
}

table tr td {
	text-align: center;
	width:150px;
	height:44px;
}
.putb{
 	width:55px;
 	height:34px;
}
.put{
	width:150px;
	height:34px;
}
font{
	color:red;
	font-weight: bold;
}
</style>
</head>

<body>
	<form action="ServletEditScore" method="post">
	
		<div class="div_ads">
		<font>${msg }</font>
		<c:forEach var="list" items="${list }">
			<table>
				<tr>
					<td>编&nbsp;&nbsp;&nbsp;号：</td>
					<td><input type="text" name="scoreID" class="put" value="${list.getScoreID() }" readonly="readonly" /></td>
				</tr>
				<tr>
					<td>学&nbsp;&nbsp;&nbsp;号：</td>
					<td><input type="text" name="stuNum" class="put" value="${list.getStuNum() }" /></td>
				</tr>
				<tr>
					<td>姓&nbsp;&nbsp;&nbsp;名：</td>
					<td><input type="text"  name="stuName" class="put" value="${list.getStuName() }"  />
						
					</td>
				</tr>
				<tr>
					<td>班&nbsp;&nbsp;&nbsp;级：</td>
					<td><input type="text" name="stuClass" class="put" value="${list.getStuClass() }" /></td>
				</tr>
				<tr>
					<td>科&nbsp;&nbsp;&nbsp;目：</td>
					<td><input type="text" name="courseName" class="put" value="${list.getCourseName() }" /></td>
				</tr>
				<tr>
					<td>成&nbsp;&nbsp;&nbsp;绩：</td>
					<td><input type="text" name="scoreGrade" class="put" value="${list.getScoreGrade() }" /></td>
				</tr>
				<tr>
					<td>专&nbsp;&nbsp;&nbsp;业：</td>
					<td><input type="text" name="major" class="put" value="${list.getMajor() }" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="修改" class="putb" /></td>
					<td><input type="reset" value="清空" class="putb" /></td>
				</tr>
			</table>
			</c:forEach>
		</div>
	</form>
</body>
</html>
