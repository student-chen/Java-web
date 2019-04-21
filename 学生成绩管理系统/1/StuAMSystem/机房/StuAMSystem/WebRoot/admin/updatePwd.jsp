<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'updatePwd.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
<style type="text/css">
.div_list {
	width: 700px;
	height: 500px;
	margin: auto;
	margin-top: 50px;
}

font {
	color: red;
	font-weight: bold;
	text-align: center;
}
table{
margin:0 auto;

}
table tr td{
text-align: center;
width:150px;
height:40px;
}
a{
text-decoration: none;
}
.btn{
width:55px;
height:34px;
}
</style>
<script type="text/javascript">

function checked(fm){
	var flag=true;
	if(fm.pwd.value!=fm.pwdn.value){
		alert("两次密码不一致");
		fm.pwd.focus();
		flag=false;
	}
	return flag;
}
</script>
</head>

<body>
		<div class="div_list">
		<form action="ServletEditPwd" method="post" onsubmit="return checked(this)">

			<table border="1" cellpadding="0" cellspacing="0">

				<tr>
					<td>姓名</td>
					<td>${username}</td>
				</tr>
				<tr>
					<td>旧密码</td>
					<td>${password }</td>
				</tr>
				<tr>
					<td>新密码</td>
					<td><input type="password" name="pwd">
					</td>
				</tr>
				<tr>
					<td>确认密码</td>
					<td><input type="password" name="pwdn">
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="修改" class="btn" />
					</td>
					<td><input type="reset" value="取消" class="btn" />
					</td>
				</tr>


			</table>



		</form>
	</div>
</body>
</html>
