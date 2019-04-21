<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <style type="text/css">
.div_ads {
	width: 400px;
	
	margin: auto;
	margin-top: 50px;
}

table {
	margin: 0 auto;
}

table tr td {
	text-align: center;
	width:150px;
	height:44px;
}
.putb{
 	width:55px;
 	height:34px;
}
.put{
	width:150px;
	height:34px;
}
font{
	color:red;
	font-weight: bold;
}
body{
	background-image: url("images/book3.jpg");
	background-size:auto 850px; 
}
h3{
text-align: center;
}
</style>

<script type="text/javascript">
	
	function AjaxChecked(){
		var xmlHttpRequest=null;
		if(XMLHttpRequest){
			xmlHttpRequest=new XMLHttpRequest();
		}else{
			xmlHttpRequest=new ActiveXObject("Microsoft.XMLHTTP");
		}
		if(xmlHttpRequest!=null){
			//拿到账号
			var stuNum=document.getElementById("stuNum");
			if(stuNum.value==""){
				document.getElementById("stuNumcheck").innerHTML = "学号不能为空";
			}else{
			
				var url="ServletRegisterStu?stuNum="+stuNum.value;
				xmlHttpRequest.open("get",url,true);
				
				xmlHttpRequest.send();
				xmlHttpRequest.onreadystatechange=function(){
					if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
						var text = xmlHttpRequest.responseText;
						//alert(text);
						document.getElementById("stuNumcheck").innerHTML = text;
					}
				};
			}
		}
	}
	
	function namecheck(){
		var stuName=document.getElementById("stuName").value;
		var rename=/^[\u4e00-\u9fa5]+$/gi;          //中文判断
		if(stuName==""){
			document.getElementById("stuNamecheck").innerHTML = "用户名不能为空";
		}
		else if (!rename.test(stuName))
		{
			document.getElementById("stuNamecheck").innerHTML = "请输入中文名，如：王文军";
		}else{
			document.getElementById("stuNamecheck").innerHTML = "正确";
		}
	}
	
	function pwdcheck(){
		var pwd1=document.getElementById("password").value;
		if(pwd1==""){
			document.getElementById("stuPwdcheck").innerHTML = "密码不能为空";
		}else if(pwd1.length<6){
			document.getElementById("stuPwdcheck").innerHTML = "密码不能小于六位";
		}else {
			document.getElementById("stuPwdcheck").innerHTML = "正确";
		}
	}
	
	function pwdc(){
		
		var pwd1=document.getElementById("password").value;
		var pwd2=document.getElementById("pwd").value;
		
		if(pwd1!=pwd2){
			
			document.getElementById("stuPwdrcheck").innerHTML = "两次密码不一致";
		}else {
			document.getElementById("stuPwdrcheck").innerHTML = "正确";
		}
	}
</script>
</head>

<body>
	 <form action="ServletRegistersStudent" method="post"> 
	
		<div class="div_ads">
		<h3>注册页面</h3><br/>
		<font>${msg}</font>
			<table>
				<tr>
					<td>学&nbsp;&nbsp;&nbsp;号：</td>
					<td><input type="text" name="stuNum" class="put" id="stuNum" onblur="AjaxChecked();"/></td>
					<td><font id="stuNumcheck"></font></td>
				</tr>
				<tr>
					<td>姓&nbsp;&nbsp;&nbsp;名：</td>
					<td><input type="text" name="stuName" class="put" id="stuName" onblur="namecheck();" /></td>
					<td><font id="stuNamecheck"></font></td>
				</tr>
				<tr>
					<td>密&nbsp;&nbsp;&nbsp;码：</td>
					<td><input type="password" name="password" class="put" id="password" onblur="pwdcheck();"/></td>
					<td><font id="stuPwdcheck"></font></td>
				</tr>
				<tr>
					<td>确认密码：</td>
					<td><input type="password" name="pwd" class="put" id="pwd" onblur="pwdc();" /></td>
					<td><font id="stuPwdrcheck"></font></td>
				</tr>
				<tr>
					<td>性&nbsp;&nbsp;&nbsp;别：</td>
					<td><input type="radio"  name="stuSex" value="男" checked="checked" />男&nbsp;&nbsp;
						<input type="radio" name="stuSex" value="女" />女
					</td>
				</tr>
				<tr>
					<td>年&nbsp;&nbsp;&nbsp;龄：</td>
					<td><input type="text" name="stuAge" class="put" /></td>
				</tr>
				<tr>
					<td>班&nbsp;&nbsp;&nbsp;级：</td>
					<td><input type="text" name="stuClass" class="put" /></td>
				</tr>
				<tr>
					<td>专&nbsp;&nbsp;&nbsp;业：</td>
					<td><input type="text" name="major" class="put" /></td>
				</tr>
				<tr>
					<td>院&nbsp;&nbsp;&nbsp;系：</td>
					<td><input type="text" name="department" class="put" /></td>
				</tr>
				<tr>
					<td>联系电话：</td>
					<td><input type="text" name="phone" class="put" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="hidden" name="role" value="0" /></td>
					
				</tr>
				<tr>
					<td><input type="submit" value="注册" class="putb" /></td>
					<td><input type="reset" value="清空" class="putb" /></td>
				</tr>
			</table>
		</div>
	 </form> 
</body>
</html>
  