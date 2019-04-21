<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>
<style type="text/css"><!--
a			{ text-decoration: none; color: #ffffff }
a:hover			{ text-decoration: underline }
body			{ scrollbar-base-color: #000000; scrollbar-arrow-color: #000000; font-size: 12px; background-color: #000000 }
table			{ font: 12px Tahoma, Verdana; color: #ffffff}
input,select,textarea	{ font: 11px Tahoma, Verdana; color: #ffffff; font-weight: normal; background-color: #F8F8F8 }
form			{ margin: 0; padding: 0}
select			{ font: 11px Arial, Tahoma; color: #000000; font-weight: normal; background-color: #F8F8F8 }
.nav			{ font: 12px Tahoma, Verdana; color: #000000; font-weight: bold }
.nav a			{ color: #000000 }
.header			{ font: 11px Tahoma, Verdana; color: #ffffff; font-weight: bold; background-color: #000000 }
.header a		{ color: #FFFFFF }
.category		{ font: 11px Arial, Tahoma; color: #000000; background-color: #EFEFEF }
.tableborder		{ background: #000000; border: 1px solid #FFFFFF } 
.singleborder		{ font-size: 0px; line-height: 1px; padding: 0px; background-color: #F8F8F8 }
.smalltxt		{ font: 11px Arial, Tahoma }
.outertxt		{ font: 12px Tahoma, Verdana; color: #ffffff }
.outertxt a		{ color: #ffffff }
.bold			{ font-weight: bold }
.altbg1			{ background: #F8F8F8 }
.altbg2			{ background: #FFFFFF }
.maintable		{ width: 98%; background-color: #FFFFFF }
--></style>
</head>
<body>

<div align=center>
<table cellpadding="1" border="1" width="99%" align="center"
	bordercolor="black" cellspacing="1">
	<tr class="category" align="center" bgcolor="COCOCO">
		<th width="20%">系统号</th>
		
		<th width="20%">必修课名称</th>
		<th width="20%">预修课名称</th>
		<th width="20%">操作</th>
	</tr>

	<c:forEach var="list" items="${mylist}">
		<tr align="center">
			<c:forEach var="temp" items="${list}">
				<td>${temp}</td>
			</c:forEach>
			<c:forEach var="temp" items="${list}" begin="0" end="0">
				<td><a
					href="DelLesson2Servlet?action=deletelesson2&L2_ID=${temp}">删除</a></td>
			</c:forEach>
			
		</tr>
	</c:forEach>
	</div>

</body>
</html>