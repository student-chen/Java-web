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
<script language="JavaScript" src="../include/common.js"></script>
</head>

<body leftmargin="0" rightmargin="0" topmargin="0">

<table bgcolor="#FFFFFF" width="98%" cellpadding="0" cellspacing="0"
	border="0" align="center">

	<form method="post" name="register" action="DaySchemeMaker">

	<table cellspacing="1" cellpadding="4" width="98%" align="center"
		class="tableborder">
		<tr>
			<td colspan="2" class="header"><a href="" target=""></a>班级日排课提交页面</td>
		</tr>
		<tr>
			<td class="header" width="23%" align="center">选择班级:</td>
			<td width="25%" class="altbg2"><select name="cname">

				<c:forEach var="list" items="${class}">

					<c:forEach var="temp" items="${list}" begin="0" end="0">
						<option value="${temp}" selected="selected">
					</c:forEach>
					<c:forEach var="temp" items="${list}" begin="1">
					              ${temp}</option>
					</c:forEach>

				</c:forEach>
		  </select></td>
		<tr class="category" align="center" bgcolor="COCOCO">
		<th width="24%">时间</th>
		<th width="25%">课程</th>
		<th width="27%">老师</th>
		<th width="24%">教室</th>
		
	</tr>
			
		</tr>
		<tr>
        <td width="25%" class="altbg2"><select name="time1">

				<c:forEach var="list" items="${time}">

					<c:forEach var="temp" items="${list}" begin="0" end="0">
						<option value="${temp}" selected="selected">
					</c:forEach>
					<c:forEach var="temp" items="${list}" begin="0" end="0">
					              ${temp}</option>
					</c:forEach>

				</c:forEach>
		  </select></td>
		  <td width="25%" class="altbg2"><select name="lesson11">

				<c:forEach var="list" items="${lesson1}">

					<c:forEach var="temp" items="${list}" begin="0" end="0">
						<option value="${temp}" selected="selected">
					</c:forEach>
					<c:forEach var="temp" items="${list}" begin="1">
					              ${temp}</option>
					</c:forEach>

				</c:forEach>
		  </select></td>
		  <td width="25%" class="altbg2"><select name="teacher1">

				<c:forEach var="list" items="${teacher}">

					<c:forEach var="temp" items="${list}" begin="0" end="0">
						<option value="${temp}" selected="selected">
					</c:forEach>
					<c:forEach var="temp" items="${list}" begin="1">
					              ${temp}</option>
					</c:forEach>

				</c:forEach>
		  </select></td>
		  <td width="25%" class="altbg2"><select name="classroom1">

				<c:forEach var="list" items="${classroom}">

					<c:forEach var="temp" items="${list}" begin="0" end="0">
						<option value="${temp}" selected="selected">
					</c:forEach>
					<c:forEach var="temp" items="${list}" begin="1">
					              ${temp}</option>
					</c:forEach>

				</c:forEach>
		  </select></td>
		  
		  <tr>
        <td width="25%" class="altbg2"><select name="time2">

				<c:forEach var="list" items="${time}">

					<c:forEach var="temp" items="${list}" begin="0" end="0">
						<option value="${temp}" selected="selected">
					</c:forEach>
					<c:forEach var="temp" items="${list}" begin="0" end="0">
					              ${temp}</option>
					</c:forEach>

				</c:forEach>
		  </select></td>
		  <td width="25%" class="altbg2"><select name="lesson12">

				<c:forEach var="list" items="${lesson1}">

					<c:forEach var="temp" items="${list}" begin="0" end="0">
						<option value="${temp}" selected="selected">
					</c:forEach>
					<c:forEach var="temp" items="${list}" begin="1">
					              ${temp}</option>
					</c:forEach>

				</c:forEach>
		  </select></td>
		  <td width="25%" class="altbg2"><select name="teacher2">

				<c:forEach var="list" items="${teacher}">

					<c:forEach var="temp" items="${list}" begin="0" end="0">
						<option value="${temp}" selected="selected">
					</c:forEach>
					<c:forEach var="temp" items="${list}" begin="1">
					              ${temp}</option>
					</c:forEach>

				</c:forEach>
		  </select></td>
		  <td width="25%" class="altbg2"><select name="classroom2">

				<c:forEach var="list" items="${classroom}">

					<c:forEach var="temp" items="${list}" begin="0" end="0">
						<option value="${temp}" selected="selected">
					</c:forEach>
					<c:forEach var="temp" items="${list}" begin="1">
					              ${temp}</option>
					</c:forEach>

				</c:forEach>
		  </select></td>
		  <tr>
        <td width="25%" class="altbg2"><select name="time3">

				<c:forEach var="list" items="${time}">

					<c:forEach var="temp" items="${list}" begin="0" end="0">
						<option value="${temp}" selected="selected">
					</c:forEach>
					<c:forEach var="temp" items="${list}" begin="0" end="0">
					              ${temp}</option>
					</c:forEach>

				</c:forEach>
		  </select></td>
		  <td width="25%" class="altbg2"><select name="lesson13">

				<c:forEach var="list" items="${lesson1}">

					<c:forEach var="temp" items="${list}" begin="0" end="0">
						<option value="${temp}" selected="selected">
					</c:forEach>
					<c:forEach var="temp" items="${list}" begin="1">
					              ${temp}</option>
					</c:forEach>

				</c:forEach>
		  </select></td>
		  <td width="25%" class="altbg2"><select name="teacher3">

				<c:forEach var="list" items="${teacher}">

					<c:forEach var="temp" items="${list}" begin="0" end="0">
						<option value="${temp}" selected="selected">
					</c:forEach>
					<c:forEach var="temp" items="${list}" begin="1">
					              ${temp}</option>
					</c:forEach>

				</c:forEach>
		  </select></td>
		  <td width="25%" class="altbg2"><select name="classroom3">

				<c:forEach var="list" items="${classroom}">

					<c:forEach var="temp" items="${list}" begin="0" end="0">
						<option value="${temp}" selected="selected">
					</c:forEach>
					<c:forEach var="temp" items="${list}" begin="1">
					              ${temp}</option>
					</c:forEach>

				</c:forEach>
		  </select></td>
		  <tr>
        <td width="25%" class="altbg2"><select name="time4">

				<c:forEach var="list" items="${time}">

					<c:forEach var="temp" items="${list}" begin="0" end="0">
						<option value="${temp}" selected="selected">
					</c:forEach>
					<c:forEach var="temp" items="${list}" begin="0" end="0">
					              ${temp}</option>
					</c:forEach>

				</c:forEach>
		  </select></td>
		  <td width="25%" class="altbg2"><select name="lesson14">

				<c:forEach var="list" items="${lesson1}">

					<c:forEach var="temp" items="${list}" begin="0" end="0">
						<option value="${temp}" selected="selected">
					</c:forEach>
					<c:forEach var="temp" items="${list}" begin="1">
					              ${temp}</option>
					</c:forEach>

				</c:forEach>
		  </select></td>
		  <td width="25%" class="altbg2"><select name="teacher4">

				<c:forEach var="list" items="${teacher}">

					<c:forEach var="temp" items="${list}" begin="0" end="0">
						<option value="${temp}" selected="selected">
					</c:forEach>
					<c:forEach var="temp" items="${list}" begin="1">
					              ${temp}</option>
					</c:forEach>

				</c:forEach>
		  </select></td>
		  <td width="25%" class="altbg2"><select name="classroom4">

				<c:forEach var="list" items="${classroom}">

					<c:forEach var="temp" items="${list}" begin="0" end="0">
						<option value="${temp}" selected="selected">
					</c:forEach>
					<c:forEach var="temp" items="${list}" begin="1">
					              ${temp}</option>
					</c:forEach>

				</c:forEach>
		  </select></td>
		  
		<tr>
			<td colspan="2" class="header">班级日排课提交页面</td>
		</tr>
		
	</table>
	<br>
	<center><input type="submit" name="regsubmit" value="提 &nbsp; 交"></center>
	</form>



	<br>
	<br>
	</div>
	<a name="bottom"></a>
	<div class="maintable"></div>

	<div class="maintable">
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
