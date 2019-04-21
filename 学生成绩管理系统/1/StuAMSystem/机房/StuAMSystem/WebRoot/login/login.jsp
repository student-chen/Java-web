<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'Login.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->


<style type="text/css">
#_top {
	text-align: center;
	height: 100px;
	font-size: 30px;
	padding-top: 30px;
	letter-spacing: 10px; /*字与字之间的间距*/
}

#_body {
	float: right;
	height: 360px;
	width: 500px;
}

#_foot { /* margin-left: auto;
	margin-right: auto; */
	text-align: center;
	height: 50px;
	padding-top: 30px;
}

#tab {
	height: 80px;
}

#td {
	width: 200px;
	height: 30px;
	text-align: center;
}

#put {
	width: 55px;
	height: 34px;
}

table tr td {
	font-size: 20px;
	font-family: "隶书";
	font-weight: 600px;
}

.div_body {
	height: 360px;
}

body {
	background-image: url("images/book.jpg");
	background-size: auto 650px;
}

b {
	color: #1eadfb;
}
.msg{
	color:red;
}
</style>
<script type="text/javaScript">
function checked(th){
   var flag=true;
   if (th.ID.value == "")  {
       alert("账号不能为空！！");
       flag=false;
   }else if(th.pwd.value==""){
       alert("密码不能为空！！");
       flag=false;
   }
   return flag;
   
}
</script>

</head>

<body>
	<div id="_top">
		<b><marquee>学生成绩管理系统</marquee>
		</b>
	</div>
	<div class="div_body">
		<div id="_body">
		<h3 class="msg">${massage }</h3>
			<form action="ServletLogin" method="post"
				onsubmit="return checked(this)">

				<table>

					<tr id="tab">
						<td width="100px">账&nbsp;&nbsp;号</td>
						<td colspan="2"><input type="text" name="ID" id="td">
						</td>

					</tr>
					<tr id="tab">
						<td width="100px">密&nbsp;&nbsp;码</td>
						<td colspan="2"><input type="password" name="pwd" id="td">
						</td>
					</tr>
					<tr id="tab">
						<td width="100px">权&nbsp;&nbsp;限</td>
						<td colspan="2"><input type="radio" name="role" value="0" checked="checked">学生 
							<input type="radio" name="role" value="1">教师 
							<input type="radio" name="role" value="2">管理员
						</td>
					</tr>
					<tr id="tab">
						<td style="text-align:center;" width="120px">&nbsp;&nbsp;&nbsp;&nbsp;<input
							type="submit" value="登录" id="put"></td>
						<td style="text-align:center;">&nbsp;&nbsp;&nbsp;&nbsp;<input
							type="button" name="register" value="注册"
							onclick="window.open('register/register.jsp')" id="put">
						</td>
						<td style="text-align:center;">&nbsp;&nbsp;&nbsp;&nbsp;<input
							type="reset" value="取消" id="put"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div id="_foot">
		<h4>版权所有&copy;&nbsp;&nbsp;湖北理工学院 计算机学院 陈 政    2018年06月15日</h4>
	</div>
	
</body>
</html>
