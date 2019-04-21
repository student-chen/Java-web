<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/login/style.css" rel='stylesheet' type='text/css' />
 <script type="text/javascript" src="plug-in/jquery/jquery-1.11.2.min.js"></script>
 <script type="text/javascript" src="js/system/login.js"></script>
</head>
<body>
<script>$(document).ready(function(c) {
	$('.close').on('click', function(c){
		$('.login-form').fadeOut('slow', function(c){
	  		$('.login-form').remove();
		});
	});	  
});
</script>
<section class="login-form-wrap">
 <!--SIGN UP-->
 <h1>学生成绩管理系统</h1>
<div class="login-form">
	<div class="close"> </div>
		<div class="head-info">
			<label class="lbl-1"> </label>
			<label class="lbl-2"> </label>
			<label class="lbl-3"> </label>
		</div>
			<div class="clear"> </div>
	<div class="avtar">
		<img src="image/login/avtar.png" />
	</div>
	<div style="color: white">动力节点学生作品</div>
			<form action="loginController.do?doLogin" method="post" check="loginController.do?doCheck" >
				<input type="text"  id="username" name="username"  placeholder="用户名" >
				<input type="password"  id="password" name="password" placeholder="密码">
				<input type="text"  id="captcha" name="captcha" placeholder="验证码">
				<div>
	          		<img style=" float:right;" title="点击更换" id="img_captcha" onclick="javascript:refreshCaptcha();" src="captchaCode">
          		</div>
          		<br/>
          		<div id="errormsg" style="color: red"></div>
          		
			</form>
	<div class="signin">
		<input id="login" type="button" value="登陆">
	</div>
</div>
</section>
 <div class="copy-rights">
					<p>Copyright &copy; 北京动力节点教育科技有限公司 <a href="http://www.bjpowernode.com" target="_blank" title="动力节点Java培训">动力节点Java培训</a></p>
			</div>

</body>
</html>