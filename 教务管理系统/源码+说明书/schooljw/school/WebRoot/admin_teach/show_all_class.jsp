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
	bordercolor="black">
	<tr class="category" align="center" bgcolor="COCOCO">
		<th width="30%">系统号</th>
		<th width="10%">班级名</th>
		<!--<th width="10%">姓名</th>
		<th width="20%">班级名</th>-->
		<th width="30%">班级类型</th>
	</tr>
	<!--<tr class="category" align="center" bgcolor="C0C0C0">-->
	<c:forEach var="list" items="${mylist}">
		<tr align="center">
			<c:forEach var="temp" items="${list}">
				<td>${temp}</td>
			</c:forEach>
		</tr>
	</c:forEach>
	<!--</tr>-->

</table>
</div>

</body>
</html>
