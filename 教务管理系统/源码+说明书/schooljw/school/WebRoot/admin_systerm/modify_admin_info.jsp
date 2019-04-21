 <%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>修改管理员信息</title>



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
<script language="JavaScript">
	 
function checkspace(checkstr) {
  var str = '';
  for(i = 0; i < checkstr.length; i++) {
    str = str + ' ';
  }
  return (str == checkstr);
 }
function checkuserinfo()
{   
  if (checkspace(document.modify.username.value)) {
	document.modify.username.focus();
    alert("对不起，姓名不能为空");
	return false;
  }
    if(checkspace(document.modify.password.value) || document.modify.password.value.length < 3 || document.modify.password.value.length >20) {
	document.modify.password.focus();
    alert("密码长度不符,请重新输入,长度在6-20之间");
	return false;
  }  
 } 
</script>
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
	<form method="post" name="modify" action="UpdataServlet">

	<table cellspacing="1" cellpadding="4" width="98%" align="center"
		class="tableborder">
		<tr>
			<td colspan="2" class="header"><a href="" target=""></a>管理员信息修改(必填)</td>
		</tr>
		<tr>
			<td class="altbg1" width="21%">唯一系统号（不可修改）:</td>
			<td class="altbg2"><c:forEach var="list" items="${mylist}">

				<c:forEach var="temp" items="${list}" begin="0" end="0">
					<input type="text" name="aid" size="25" maxlength="25"
						value="${temp}" readonly="readonly">
				</c:forEach>

			</c:forEach>
		</tr>
		<tr>
			<td class="altbg1" width="21%">用户名:</td>
			<td class="altbg2"><c:forEach var="list" items="${mylist}">

				<c:forEach var="temp" items="${list}" begin="1" end="1">
					<input type="text" name="username" size="25" maxlength="25"
						value="${temp}">
				</c:forEach>
                 
			</c:forEach>
		</tr>
		 
		<tr>
			<td class="altbg1">密&nbsp;&nbsp;码:</td>
			<td class="altbg2"><input type="password" name="password" size="25"></td>
		</tr>

		<tr>
			<td class="altbg1">确认密码:</td>
			<td class="altbg2"><input type="password" name="password2" size="25"></td>
		</tr>
		
		 <tr>
			<td class="altbg1" valign="top">添加类型:</td>			
			<td class="altbg2">	   
			  <select class="INPUT_text" name="LoginType" >
			  <option value="1">系统管理员</option>
			  <option value="2" selected="selected">教学管理员</option>
			  <option value="3">图书管理员</option>
			  <option value="4">BBS管理员</option>
			  </select></td>
		</tr>
		<tr>
			<td colspan="2" class="header">修改 - 选填内容</td>
		</tr>

		<tr>
			<td class="altbg1">安全提问:</td>
			<td class="altbg2"><select name="questionid">
				<option value="0">无安全提问</option>
				<option value="1">母亲的名字</option>
				<option value="2">爷爷的名字</option>
				<option value="3">父亲出生的城市</option>
				<option value="4">您其中一位老师的名字</option>
				<option value="5">您个人计算机的型号</option>
				<option value="6">您最喜欢的餐馆名称</option>
				<option value="7">驾驶执照的最后四位数字</option>
			</select> <span class="smalltxt"><span class="bold">如果您启用安全提问，登录时需填入相应的项目才能登录</span></span></td>
		</tr>

		<tr>
			<td class="altbg1">回答:</td>
			<td class="altbg2"><input type="text" name="answer" size="25"></td>
		</tr>

		<tr>
			<td colspan="2" class="singleborder">&nbsp;</td>
		</tr>
		<tr>
			<td class="altbg1">性别:</td>
			<td class="altbg2"><input type="radio" name="gendernew" value="1"> 男
			&nbsp; <input type="radio" name="gendernew" value="2"> 女 &nbsp; <input
				type="radio" name="gendernew" value="0" checked> 保密</td>
		</tr>

		<tr>
			<td class="altbg1">生日:</td>
			<td class="altbg2"><input type="text" name="year" size="25"></td>
		</tr>


		<tr>
			<td class="altbg1">QQ:</td>
			<td class="altbg2"><input type="text" name="qq" size="25"></td>
		</tr>


		<tr>
			<td class="altbg1">MSN:</td>
			<td class="altbg2"><input type="text" name="msn" size="25"></td>
		</tr>





		<tr>
			<td class="altbg1" valign="top">自我介绍:</td>
			<td class="altbg2"><textarea rows="5" cols="30" name="bio"></textarea></td>
		</tr>
	</table>
	<br>
	<center><input onClick="return checkuserinfo();" type="submit" name="regsubmit" value="保存修改信息"></center>
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
			<td align="right"><a href="http://www.i2030.org" target="_blank"></a>
			&nbsp;</td>
			<td>Powered by <a href="http://www.i2030.org" target="_blank"><b>thinkbank</b></a><b
				style="color:#FF9900"></b> &nbsp;&copy; 2001-2006 思远国际 版权所有<a
				href="http://www.i2030.org" target="_blank">.</a> <br>
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
 