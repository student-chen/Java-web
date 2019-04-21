<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>登录</title>
    <link href="style.css" type="text/css" rel="stylesheet" rev="stylesheet"/>
  </head>
  
  <body class="denglu">
  	<div class="dl">
  	<div class="biaoti">
  		<table width="550" border="0" cellspacing="0" cellpadding="0" align="center">
  		<tr>
  		<td height="150" style="FILTER: mask(color=#E1E4EC)shadow(color=#0066cc,direction=135)chroma(color=#E1E4EC)" align="center"><font face="黑体" color="#0066cc" size="7">
			<b>学生信息管理系统――JSP</b></font>
   		</td>
   		</tr>
   		</table>
   	</div>
   	
   		<div class="log">
   			<ul class="miaoshu">
   				<li class="ms">登录页面</li>
   				<li>制作小组：姜弘扬、李淑娟</li>
   				<li>制作时间：2016.11</li>
   			</ul>
   		</div>
   		
	<form method="POST" action="login">
	<div class="deng">
		<table>
			<tr>
				<td style="float:left;font-size:25px; color:#666;line-height:30px; ">用户名称：</td>
				
				<td>
					<input name="username" value="" style="width:200px;height:37px;border: 1px solid #999;box-shadow: 1px 1px 1px #dfe4e8 inset;color:#CCC;border-width:1;"/>
				</td>
			</tr>
			
			<tr>
				<td style="float:left;font-size:25px; color:#666;line-height:30px; ">用户密码：</td>
				
				<td>
						<input name="password" value="" type="password" style="width:200px;height:37px;border: 1px solid #999;box-shadow: 1px 1px 1px #dfe4e8 inset;color:#CCC;border-width:1;"/>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="提交" class="btn-login"/></td>
			</tr>
		</table>
	</div>
	</form>
	</div>
  </body>
</html>
