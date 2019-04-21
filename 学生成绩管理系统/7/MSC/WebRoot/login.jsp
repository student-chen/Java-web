<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>学生成绩管理系统-登录</title>
		<link rel="stylesheet" type="text/css" href="image/style1.css">
		<meta http-equiv="windows-Target">
<SCRIPT Language="JavaScript">
 <!--
  function isValid()
  {	
  	if(formlogin.id.value == "")
  	{	
  		window.alert("请输入账号！"); 
 		document.formlogin.elements(0).focus();
  		return  false;
  	}
  	if(formlogin.password.value == "")
  	{
  		window.alert("请输入密码！");
  		document.formlogin.elements(1).focus();
  		return  false; 
  	}
  	formlogin.image();
 }
  -->
  </SCRIPT>
	</head>

	<body>
		<form name="formlogin" action="login_conf" method="post" onSubmit="return isValid(this);">
			<table width="8oo" height="600" border="0" align="center">
				<tr>
					<td>
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<th width="800" height="80" colspan="3">
									<img src="image/login1.jpg" />
								</th>
							</tr>
							<tr>
								<th width="800" height="138" colspan="3">
									<img src="image/login3.jpg" />
								</th>
							</tr>
							<tr>
								<td width="165" height="187">
									<img src="image/login5.jpg" />
								</td>
								<td>
									<div align="center">
									</div>
									<table width="481" height="187" border="0" cellpadding="0"
										cellspacing="0">
										<tr height="84">
											<td width="130" align="center">
												用户ID：
											</td>
											<td width="180">
												<input type="text" name="id"></input>
											</td>
											<th width="171" rowspan="3">
												<input type="image" src="image/login.gif" />
											</th>
										</tr>
										<tr height="43">
											<td width="130" align="center">
												密&nbsp;&nbsp;码：
											</td>
											<td width="180">
												<input type="password" name="password"></input>
											</td>
										</tr>
										<tr height="60">
											<td align="center">
												<input type="radio" name="kind" value="admin" checked />
												管理员
											</td>
											<td>
												<input type="radio" name="kind" value="teacher" />
												老师&nbsp;&nbsp;&nbsp;&nbsp;
												<input type="radio" name="kind" value="student" />
												学生
											</td>
										</tr>
									</table>
								</td>
								<td width="154" height="187">
									<img src="image/login6.jpg" />
								</td>
							</tr>
							<tr>
								<th width="800" height="106" colspan="3" align="right"
									background="image/login4.jpg">
									<marquee style="FILTER: blur(direction = 135, strength = 8)"
										behavior="alternate">
										<font size="+3" face="华文行楷" color="#0e87d1"><i>欢迎使用学生成绩管理系统！</i>
										</font>
									</marquee>
								</th>
							</tr>
							<tr>
								<th width="800" height="79" colspan="3">
									<img src="image/login2.jpg" />
								</th>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
