<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>login</title>
<script type="javaScript">
function submitForm()
{
	if(document.form1.userName.value=="")
        {
           alert("请输入用户名");
           document.form1.userName.focus();
           return false;
        }else if(document.form1.userPassword.value=="")
        {
           alert("请输入密码");
           document.form1.userPassword.focus();
           return false;
        }else
        {
          return true;
        }
}
</script>
</head>
<STYLE TYPE="text/css">
<!--
h3 { color: black; font-size: 20px; font-family: impact }
P.first { color: green }
P.second { color: purple }
P.third { color: gray } 
-->
</STYLE>

<body bgcolor="#bbccdd">
<center>
<h3><strong>校务系统登录</strong></h3>
<hr color="green" size="1" align="center" width="300">
<form name="form1" method="post" action="CcheckUserServlet">
<table align="center">
	<tr>
		<td>用户名</td>
		<td><input type="text" name="userName" /></td>
	</tr>
	<tr>
		<td>密码</td>
		<td><input type="password" name="userPassword" /></td>
	</tr>
	<tr>
		<td>用户类型</td>
		<td><select name="userType" size="1">
			<option value="3" selected>学生</option>
			<option value="2">老师</option>
			<option value="1">管理员</option>
			</select></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" onclick="return submitForm()" name="Submit"
			value="登录"> &nbsp;&nbsp; <input type="reset" value="重置"></td>
	</tr>

</table>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<p CLASS=first><font color="#800080" size="2">程序调试通过by:双鱼林&nbsp;QQ:287307421&nbsp;手机:13558690869&nbsp;更多系统请到双鱼林的淘宝店:<a href='http://shop34864101.taobao.com' target='_blank'>http://shop34864101.taobao.com</a>查询</font></p>
<p CLASS=second>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <font color="#800080" size="2">测试环境为:windows xp+jdk1.5+Tomcat6.0+MyEclipse5.5+SQLServer2000</font></p>
<br>
<br>
</form>
</center>
</body>
</html>
