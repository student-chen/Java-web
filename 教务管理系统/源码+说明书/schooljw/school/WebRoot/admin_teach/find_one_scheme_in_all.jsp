<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>思远2030教学管理系统 - powered by ThinkBank!</title>



<style type="text/css">
<!--
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
.STYLE1 {color: #FFFFFF}
.STYLE2 {font-weight: bold; color: #FFFFFF; }
-->
</style>
<script language="JavaScript" src="../../include/common.js"></script>
</head>

<body leftmargin="0" rightmargin="0" topmargin="0">

<table bgcolor="#FFFFFF" width="98%" cellpadding="0" cellspacing="0"
	border="0" align="center">

	

	<table cellspacing="1" cellpadding="4" width="98%" align="center"
		class="tableborder">
		<tr>
			<td colspan="2" class="header"><a href="" target=""></a>班级周排课提交页面</td>
		</tr>
		<tr>
			
		<tr class="category" align="center" bgcolor="COCOCO">
		<th width="15%">星期与节数</th>
		<th width="15%">星期一</th>
		<th width="15%">星期二</th>
		<th width="15%">星期三</th>
		<th width="15%">星期四</th>
		<th width="15%">星期五</th>
	    </tr>
			
		</tr>
		<tr>
		<td width="15%" align="center" class="STYLE2">一，二节</td>
        <td width="15%" align="center" class="altbg2"><span class="STYLE1">
          <c:forEach var="list" items="${A0111}">
		    <c:forEach var="temp" items="${list}" begin="0" >
			<a
					href="ChangeLesson1listServlet?action=findoneschemeinfo&TIME_ID=${list[0]}&C_ID=${list[1]}&L1_NAME=${list[2]}&T_NAME=${list[3]}&CR_NAME=${list[4]}" title="点击我进入资料修改">${temp}</a>			</c:forEach>
		  </c:forEach>
		  </span>
        </td>
        <td width="15%" align="center" class="altbg2"><span class="STYLE1">
          <c:forEach var="list" items="${A0121}">
		    <c:forEach var="temp" items="${list}" begin="0" >
			<a
					href="ChangeLesson1listServlet?action=findoneschemeinfo&TIME_ID=${list[0]}&C_ID=${list[1]}&L1_NAME=${list[2]}&T_NAME=${list[3]}&CR_NAME=${list[4]}" title="点击我进入资料修改">${temp}</a>			            </c:forEach>
		  </c:forEach></span>
        </td>
		  <td width="15%" align="center" class="altbg2"><span class="STYLE1">
          <c:forEach var="list" items="${A0131}">
		    <c:forEach var="temp" items="${list}" begin="0" >
			<a
					href="ChangeLesson1listServlet?action=findoneschemeinfo&TIME_ID=${list[0]}&C_ID=${list[1]}&L1_NAME=${list[2]}&T_NAME=${list[3]}&CR_NAME=${list[4]}" title="点击我进入资料修改">${temp}</a>			            </c:forEach>
		  </c:forEach></span>
        </td>
		  <td width="15%" align="center" class="altbg2"><span class="STYLE1">
          <c:forEach var="list" items="${A0141}">
		    <c:forEach var="temp" items="${list}" begin="0" >
			<a
					href="ChangeLesson1listServlet?action=findoneschemeinfo&TIME_ID=${list[0]}&C_ID=${list[1]}&L1_NAME=${list[2]}&T_NAME=${list[3]}&CR_NAME=${list[4]}" title="点击我进入资料修改">${temp}</a>			            </c:forEach>
		  </c:forEach></span>
        </td>
		<td width="15%" align="center" class="altbg2"><span class="STYLE1">
          <c:forEach var="list" items="${A0151}">
		    <c:forEach var="temp" items="${list}" begin="0" >
			<a
					href="ChangeLesson1listServlet?action=findoneschemeinfo&TIME_ID=${list[0]}&C_ID=${list[1]}&L1_NAME=${list[2]}&T_NAME=${list[3]}&CR_NAME=${list[4]}" title="点击我进入资料修改">${temp}</a>			            </c:forEach>
		  </c:forEach></span>
        </td>
	  <tr>
	    <td width="15%" align="center" class="STYLE2">三，四节</td>
        <td width="15%" align="center" class="altbg2"><span class="STYLE1">
          <c:forEach var="list" items="${A0112}">
		    <c:forEach var="temp" items="${list}" begin="0" >
			<a
					href="ChangeLesson1listServlet?action=findoneschemeinfo&TIME_ID=${list[0]}&C_ID=${list[1]}&L1_NAME=${list[2]}&T_NAME=${list[3]}&CR_NAME=${list[4]}" title="点击我进入资料修改">${temp}</a>			            </c:forEach>
		  </c:forEach></span>
        </td>
		  <td width="15%" align="center" class="altbg2"><span class="STYLE1">
          <c:forEach var="list" items="${A0122}">
		    <c:forEach var="temp" items="${list}" begin="0" >
			<a
					href="ChangeLesson1listServlet?action=findoneschemeinfo&TIME_ID=${list[0]}&C_ID=${list[1]}&L1_NAME=${list[2]}&T_NAME=${list[3]}&CR_NAME=${list[4]}" title="点击我进入资料修改">${temp}</a>			            </c:forEach>
		  </c:forEach></span></td>
        <td width="15%" align="center" class="altbg2"><span class="STYLE1">
          <c:forEach var="list" items="${A0132}">
		    <c:forEach var="temp" items="${list}" begin="0" >
			<a
					href="ChangeLesson1listServlet?action=findoneschemeinfo&TIME_ID=${list[0]}&C_ID=${list[1]}&L1_NAME=${list[2]}&T_NAME=${list[3]}&CR_NAME=${list[4]}" title="点击我进入资料修改">${temp}</a>			            </c:forEach>
		  </c:forEach></span>
        </td>
		  <td width="15%" align="center" class="altbg2"><span class="STYLE1">
          <c:forEach var="list" items="${A0142}">
		    <c:forEach var="temp" items="${list}" begin="0" >
			<a
					href="ChangeLesson1listServlet?action=findoneschemeinfo&TIME_ID=${list[0]}&C_ID=${list[1]}&L1_NAME=${list[2]}&T_NAME=${list[3]}&CR_NAME=${list[4]}" title="点击我进入资料修改">${temp}</a>			            </c:forEach>
		  </c:forEach></span>
        </td>
		<td width="15%" align="center" class="altbg2"><span class="STYLE1">
          <c:forEach var="list" items="${A0152}">
		    <c:forEach var="temp" items="${list}" begin="0" >
			<a
					href="ChangeLesson1listServlet?action=findoneschemeinfo&TIME_ID=${list[0]}&C_ID=${list[1]}&L1_NAME=${list[2]}&T_NAME=${list[3]}&CR_NAME=${list[4]}" title="点击我进入资料修改">${temp}</a>			            </c:forEach>
		  </c:forEach></span>
        </td>
		  <tr>
		  <td width="15%" align="center" class="STYLE2">五，六节</td>
        <td width="15%" align="center" class="altbg2"><span class="STYLE1">
          <c:forEach var="list" items="${A0113}">
		    <c:forEach var="temp" items="${list}" begin="0" >
			<a
					href="ChangeLesson1listServlet?action=findoneschemeinfo&TIME_ID=${list[0]}&C_ID=${list[1]}&L1_NAME=${list[2]}&T_NAME=${list[3]}&CR_NAME=${list[4]}" title="点击我进入资料修改">${temp}</a>			            </c:forEach>
		  </c:forEach></span>
        </td>
		  <td width="15%" align="center" class="altbg2"><span class="STYLE1">
          <c:forEach var="list" items="${A0123}">
		    <c:forEach var="temp" items="${list}" begin="0" >
			<a
					href="ChangeLesson1listServlet?action=findoneschemeinfo&TIME_ID=${list[0]}&C_ID=${list[1]}&L1_NAME=${list[2]}&T_NAME=${list[3]}&CR_NAME=${list[4]}" title="点击我进入资料修改">${temp}</a>			            </c:forEach>
		  </c:forEach>
        </span></td>
		 
		  <td width="15%" align="center" class="altbg2"><span class="STYLE1">
          <c:forEach var="list" items="${A0133}">
		    <c:forEach var="temp" items="${list}" begin="0" >
			<a
					href="ChangeLesson1listServlet?action=findoneschemeinfo&TIME_ID=${list[0]}&C_ID=${list[1]}&L1_NAME=${list[2]}&T_NAME=${list[3]}&CR_NAME=${list[4]}" title="点击我进入资料修改">${temp}</a>			            </c:forEach>
		  </c:forEach>
        </span></td>
		  
		  <td width="15%" align="center" class="altbg2"><span class="STYLE1">
          <c:forEach var="list" items="${A0143}">
		    <c:forEach var="temp" items="${list}" begin="0" >
			<a
					href="ChangeLesson1listServlet?action=findoneschemeinfo&TIME_ID=${list[0]}&C_ID=${list[1]}&L1_NAME=${list[2]}&T_NAME=${list[3]}&CR_NAME=${list[4]}" title="点击我进入资料修改">${temp}</a>			            </c:forEach>
		  </c:forEach>
        </span></td>
		
		  <td width="15%" align="center" class="altbg2"><span class="STYLE1">
          <c:forEach var="list" items="${A0153}">
		    <c:forEach var="temp" items="${list}" begin="0" >
			<a
					href="ChangeLesson1listServlet?action=findoneschemeinfo&TIME_ID=${list[0]}&C_ID=${list[1]}&L1_NAME=${list[2]}&T_NAME=${list[3]}&CR_NAME=${list[4]}" title="点击我进入资料修改">${temp}</a>			            </c:forEach>
		  </c:forEach>
        </span></td></tr>
		  <tr>
		  <td width="15%" align="center" class="STYLE2">七，八节</td>
		  <td width="15%" align="center" class="altbg2"><span class="STYLE1">
          <c:forEach var="list" items="${A0114}">
		    <c:forEach var="temp" items="${list}" begin="0" >
			<a
					href="ChangeLesson1listServlet?action=findoneschemeinfo&TIME_ID=${list[0]}&C_ID=${list[1]}&L1_NAME=${list[2]}&T_NAME=${list[3]}&CR_NAME=${list[4]}" title="点击我进入资料修改">${temp}</a>			            </c:forEach>
		  </c:forEach>
        </span></td>
		<td width="15%" align="center" class="altbg2"><span class="STYLE1">
          <c:forEach var="list" items="${A0124}">
		    <c:forEach var="temp" items="${list}" begin="0" >
			<a
					href="ChangeLesson1listServlet?action=findoneschemeinfo&TIME_ID=${list[0]}&C_ID=${list[1]}&L1_NAME=${list[2]}&T_NAME=${list[3]}&CR_NAME=${list[4]}" title="点击我进入资料修改">${temp}</a>			            </c:forEach>
		  </c:forEach>
        </span></td>
		<td width="15%" align="center" class="altbg2"><span class="STYLE1">
          <c:forEach var="list" items="${A0134}">
		    <c:forEach var="temp" items="${list}" begin="0" >
			<a
					href="ChangeLesson1listServlet?action=findoneschemeinfo&TIME_ID=${list[0]}&C_ID=${list[1]}&L1_NAME=${list[2]}&T_NAME=${list[3]}&CR_NAME=${list[4]}" title="点击我进入资料修改">${temp}</a>			            </c:forEach>
		  </c:forEach>
        </span></td>
		<td width="15%" align="center" class="altbg2"><span class="STYLE1">
          <c:forEach var="list" items="${A0144}">
		    <c:forEach var="temp" items="${list}" begin="0" >
			<a
					href="ChangeLesson1listServlet?action=findoneschemeinfo&TIME_ID=${list[0]}&C_ID=${list[1]}&L1_NAME=${list[2]}&T_NAME=${list[3]}&CR_NAME=${list[4]}" title="点击我进入资料修改">${temp}</a>			            </c:forEach>
		  </c:forEach>
        </span></td>
		<td width="15%" align="center" class="altbg2"><span class="STYLE1">
          <c:forEach var="list" items="${A0154}">
		    <c:forEach var="temp" items="${list}" begin="0" >
			<a
					href="ChangeLesson1listServlet?action=findoneschemeinfo&TIME_ID=${list[0]}&C_ID=${list[1]}&L1_NAME=${list[2]}&T_NAME=${list[3]}&CR_NAME=${list[4]}" title="点击我进入资料修改">${temp}</a>			            </c:forEach>
		  </c:forEach>
        </span></td>
		  </tr>
		<tr>
			<td colspan="2" class="header">班级周排课提交页面</td>
		</tr>
	</table>
	<br>
	




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
