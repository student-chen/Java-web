<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>思远2030教学管理系统 - powered by ThinkBank!</title>



<style type="text/css"><!--
a			{ text-decoration: none; color: #003366 }
a:hover			{ text-decoration: underline }
body			{ scrollbar-base-color: #000000; scrollbar-arrow-color: #000000; font-size: 12px; background-color: #000000 }
table			{ font: 12px Tahoma, Verdana; color: #000000 }
input,select,textarea	{ font: 11px Tahoma, Verdana; color: #000000; font-weight: normal; background-color: #F8F8F8 }
form			{ margin: 0; padding: 0}
select			{ font: 11px Arial, Tahoma; color: #000000; font-weight: normal; background-color: #F8F8F8 }
.nav			{ font: 12px Tahoma, Verdana; color: #000000; font-weight: bold }
.nav a			{ color: #000000 }
.header			{ font: 11px Tahoma, Verdana; color: #FFFFFF; font-weight: bold; background-color: #000000 }
.header a		{ color: #FFFFFF }
.category		{ font: 11px Arial, Tahoma; color: #000000; background-color: #EFEFEF }
.tableborder		{ background: #000000; border: 1px solid #FFFFFF } 
.singleborder		{ font-size: 0px; line-height: 1px; padding: 0px; background-color: #F8F8F8 }
.smalltxt		{ font: 11px Arial, Tahoma }
.outertxt		{ font: 12px Tahoma, Verdana; color: #000000 }
.outertxt a		{ color: #000000 }
.bold			{ font-weight: bold }
.altbg1			{ background: #F8F8F8 }
.altbg2			{ background: #FFFFFF }
.maintable		{ width: 98%; background-color: #FFFFFF }
--></style>
<script language="JavaScript"
	src="file:///C|/Documents and Settings/Administrator/Desktop/include/common.js"></script>
</head>

<body leftmargin="0" rightmargin="0" topmargin="0">

<table bgcolor="#FFFFFF" width="98%" cellpadding="0" cellspacing="0"
	border="0" align="center">



	<!--<div class="maintable"><br>
	<table cellspacing="0" cellpadding="0" border="0" width="98%"
		align="center" style="table-layout: fixed">
		<tr>
			<td class="althg1" width="90%" align="left" nowrap>思远2030教务管理系统<a
				href="index.jsp"></a> &raquo; 学生注册</td>
			<td align="right" width="10%">&nbsp;<a href="#bottom"></a></td>
		</tr>
	</table>
	<br>
	-->
	<form method="post" name="register" action="SchemeUpdateServlet">

	<table cellspacing="1" cellpadding="4" width="98%" align="center"
		class="tableborder">
		<tr>
			<td colspan="2" class="header"><a href="" target=""></a>排课信息修改</td>
		</tr>
		<tr>
			<td class="altbg1" width="21%">唯一系统时间号（不可修改）:</td>
			<td class="altbg2"><c:forEach var="list" items="${mylist}">

				<c:forEach var="temp" items="${list}" begin="0" end="0">
					<input type="text" name="TIME_ID" size="25" maxlength="25"
						value="${temp}" readonly="readonly">
				</c:forEach>

			</c:forEach>
		</tr>
		<tr>
			<td class="altbg1" width="21%">班级名:</td>
			<td class="altbg2"><c:forEach var="list" items="${mylist}">

				<c:forEach var="temp" items="${list}" begin="1" end="1">
					<input type="text" name="C_NAME" size="25" maxlength="25"
						value="${temp}">
				</c:forEach>

			</c:forEach>
		</tr>
		<tr>
			<td class="altbg1" width="21%">课程名:</td>
			<td class="altbg2"><c:forEach var="list" items="${mylist}">

				<c:forEach var="temp" items="${list}" begin="2" end="2">
					<input type="text" name="L1_NAME" size="25" maxlength="25"
						value="${temp}">
				</c:forEach>
			</c:forEach></td>
		</tr>
		<tr>
			<td class="altbg1">老师名:</td>
			<td class="altbg2"><c:forEach var="list" items="${mylist}">

				<c:forEach var="temp" items="${list}" begin="3" end="3">
					<input type="text" name="T_NAME" size="25" maxlength="25"
						value="${temp}">
				</c:forEach>
			</c:forEach></td>
		</tr>

		<tr>
			<td class="altbg1">教室名:</td>
			<td class="altbg2"><c:forEach var="list" items="${mylist}">

				<c:forEach var="temp" items="${list}" begin="4" end="4">
					<input type="text" name="CR_NAME" size="25" maxlength="25"
						value="${temp}">
				</c:forEach>
			</c:forEach></td>
		</tr>



		<tr>
			<td colspan="2" class="header">排课信息修改</td>
		</tr>


	</table>
	<br>
	<center><input type="submit" name="regsubmit" value="保存修改信息"></center>
	</form>



	<br>
	<br>
	</div>
	<a name="bottom"></a>
	<div class="maintable"></div>

	<div class="maintable">
	<table cellspacing="2" cellpadding="0" align="center"
		style="font-size: 11px; font-family: Tahoma, Arial">
		<tr>
			<td align="right"><a href="http://shulixi.hbut.edu.cn/" target="_blank"></a>
			&nbsp;</td>
			<td>Powered by <a href="http://shulixi.hbut.edu.cn/" target="_blank"><b>thinkbank</b></a><b
				style="color:#FF9900"></b> &nbsp;&copy; 2006-2007 理学院 版权所有<a
				href="http://shulixi.hbut.edu.cn/" target="_blank">.</a> <br>
			Processed in 0.096299 second(s), 5 queries , Gzip enabled</td>
		</tr>
	</table>
	<br>
	</div>

	<div class="maintable">
	<table cellspacing="0" cellpadding="1" width="100%" class="outertxt">
		<tr>
			<td>
			<table cellspacing="0" cellpadding="4" width="100%" class="smalltxt">

				<tr
					style="font-size: 0px; line-height: 0px; spacing: 0px; padding: 0px; background-color: #000000">
					<td colspan="3">&nbsp;</td>
				</tr>
			</table>
			</td>
		</tr>
	</table>
	</div>
	</center>
	<br>
</body>
</html>
