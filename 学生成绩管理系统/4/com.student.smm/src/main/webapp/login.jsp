<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录界面</title>
<meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=no">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<link href="/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="<%=basePath %>assets/js/bootstrap.js"></script>
<script src="/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
 <link href="Style/Style.css" rel="stylesheet" type="text/css" />
<link href="iconfont/style.css" type="text/css" rel="stylesheet">
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://code.jquery.com/jquery-2.2.1.min.js"></script>
<style>
	body{color:#fff; font-family:"微软雅黑"; font-size:14px;}
	.wrap1{position:absolute; top:0; right:0; bottom:0; left:0; margin:auto }/*把整个屏幕真正撑开--而且能自己实现居中*/
	.main_content{background:url(images/main_bg.png) repeat; margin-left:auto; margin-right:auto; text-align:left; float:none; border-radius:8px;}
	.form-group{position:relative;}
	.login_btn{display:block; background:#3872f6; color:#fff; font-size:15px; width:100%; line-height:50px; border-radius:3px; border:none; }
	.login_input{width:100%; border:1px solid #3872f6; border-radius:3px; line-height:40px; padding:2px 5px 2px 30px; background:none;}
	.icon_font{position:absolute; bottom:15px; left:10px; font-size:18px; color:#3872f6;}
	.font16{font-size:16px;}
	.mg-t20{margin-top:20px;}
	@media (min-width:200px){.pd-xs-20{padding:20px;}}
	@media (min-width:768px){.pd-sm-50{padding:50px;}}
	#grad {
	  background: -webkit-linear-gradient(#4990c1, #52a3d2, #6186a3); /* Safari 5.1 - 6.0 */
	  background: -o-linear-gradient(#4990c1, #52a3d2, #6186a3); /* Opera 11.1 - 12.0 */
	  background: -moz-linear-gradient(#4990c1, #52a3d2, #6186a3); /* Firefox 3.6 - 15 */
	  background: linear-gradient(#4990c1, #52a3d2, #6186a3); /* 标准的语法 */
	}
	.one{
	  
	}
</style>
</head>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
	<script src="js/jquery.cookie.js" type="text/javascript"></script>
	<script src="js/jquery.base64.js" type="text/javascript"></script>
<body style="background:url(images/bg.jpg) no-repeat;" onload="getmcCookie();">    
    <div class="container wrap1" style="height:450px;">
            <h2 class="mg-b20 text-center">学生信息管理系统</h2>
            <div class="col-sm-8 col-md-5 center-auto pd-sm-50 pd-xs-20 main_content">
                <p class="text-center font16">用户登录</p>
                <form action="logindos" method="post" onsubmit="setmcCookie()">
                    <div class="form-group mg-t20">
                        <i class="icon-user icon_font"></i>
                        <input type="text" class="login_input" id="username" name="username"  placeholder="请输入用户名" autocomplete="off" />
                    </div>
                    <div class="form-group mg-t20">
                        <i class="icon-lock icon_font"></i>
                        <input type="password" class="login_input" id="password" name="password" placeholder="请输入密码"  autocomplete="off"/>
                    </div>
                    <div class="checkbox mg-b25">
                        <label>
                            <input type="checkbox" id="autologin"/>记住我的登录信息                                   
                        </label>                 
                         
                    </div>
              <button class="btn btn-primary" type="submit" style="width:150px;height:45px;">登录</button>
			 <button type="button" class="btn btn-default"  style="width:150px;height:45px;float:right" data-toggle="modal"
			 data-target="#empAddModal">注册</button> 
                    <H2 style="color: red; text-align: center;">${error}${errmsg}${zhuce}</H2>
               </form>         

        </div><!--row end-->
    </div><!--container end-->
<script type="text/javascript">
  function checkreg()
  {
            if (document.form1.zhucename.value=="")
   {
    alert("请输入您的用户名!");
    form1.zhucename.focus();
    return false;
   }
            if (document.form1.zhucename.value.length<4 || document.form1.zhucename.value.length>15)
   {
    alert("用户名长度限制在4-15位!");
    form1.zhucename.focus();
    return false;
   }
   if (document.form1.name 

.value=="")
   {
    alert("请输入您的真实姓名!");
    form1.name 

.focus();
    return false;
   }
                        if (document.form1.zhucepwd.value=="")
   {
    alert("请输入密码!");
    form1.zhucepwd.focus();
    return false;
   }
                        if (document.form1.zhucepwd.value.length<6 || document.form1.zhucepwd.value.length>15)
   {
    alert("密码长度限制在6-15位!");
    form1.zhucepwd.focus();
    return false;
   }
            if(document.form1.zhucepwd.value!=document.form1.querenpwd.value)
   {
    alert("两次输入的密码不同!");
    form1.zhucepwd.focus();
    return false;
   }
                        if (document.form1.zhuphone.value=="")
   {
    alert("请输入您的手机号码!");
    form1.zhuphone.focus();
    return false;
   }

      if (document.form1.zhuceEmailAddress.value=="")
   {
    alert("请输入您的Email地址!");
    form1.zhuceEmailAddress.focus();
    return false;
   }
      var myRegex = /@.*\.[a-z]{2,6}/;
      var email = form1.zhuceEmailAddress.value;
      email = email.replace(/^ | $/g,"");
      email = email.replace(/^\.*|\.*$/g,"");
      email = email.toLowerCase();
       
                        //验证电子邮件的有效性
                        if (email == "" || !myRegex.test(email))
      {
        alert ("请输入有效的E-MAIL!");
        form1.zhuceEmailAddress.focus();
        return false;
      }
                       return true;
  }
    function Isval(val,name)
    {
                     if (val.value!='' && (isNaN(val.value) || val.value==0))
     {
      alert(name+"应填数字！");
       val.value="";
       val.focus();
     }
     }

     var root="<%=basePath %>";
     $(document).ready(function () {
    		$(":input").attr("autocomplete","off");
     });  
		function setmcCookie() { //设置cookie
			var loginCode = $("#username").val(); //获取用户名信息    
			var pwd = $("#password").val(); //获取登陆密码信息    
			var checked = $("[type='checkbox']"); //获取“是否记住密码”复选框  
			if($("#autologin").prop("checked")) {
				//判断是否选中了“记住密码”复选框    
				$.cookie("login_code", loginCode, {
					path: '/',
					expires: 7
				}); //调用jquery.cookie.js中的方法设置cookie中的用户名    
				$.cookie("mcpwd", $.base64.encode(pwd), {
					path: '/',
					expires: 7
				}); //调用jquery.cookie.js中的方法设置cookie中的登陆密码，并使用base64（jquery.base64.js）进行加密    
			} else {
				$.cookie("mcpwd", null, {
					path: '/',
					expires: -1
				});
			}
		}

		function getmcCookie() { //获取cookie
			var loginCode = $.cookie("login_code"); //获取cookie中的用户名    
			var pwd = $.cookie("mcpwd"); //获取cookie中的登陆密码    
			if(loginCode) { //用户名存在的话把用户名填充到用户名文本框    
				$("#username").val(loginCode);
			}
			if(pwd) { //密码存在的话把密码填充到密码文本框  
				$("#password").val($.base64.decode(pwd));
				$("#autologin").prop("checked", "true");
			}

		}
 </script>
 <!-- 注册用户的模态框 -->
<div class="modal fade" id="empAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
      </div>
      <form class="form-horizontal" action="Savazhuce" method="post" onsubmit="return checkreg()" name="form1">    
		  <div class="form-group">
		    <label class="col-sm-3 control-label"><Strong>请输入用户名:</Strong></label>
		    <div class="col-sm-7">
		      <input type="text" name="username" id="zhucename" class="form-control" placeholder="请输入用户名">
		      <span id="zhucename" class="onshow"></span>
		    </div>
		  </div>
		   <div class="form-group">
		    <label class="col-sm-3 control-label"><Strong>请输入你的真实姓名:</Strong></label>
		    <div class="col-sm-7">
		      <input type="text" name="name" id="name" class="form-control" placeholder="请输入真实姓名">
		      <span id="zhucename" class="onshow"></span>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-3 control-label"><Strong>请输入密码:</Strong></label>
		    <div class="col-sm-7">
		      <input type="password" name="password" id="zhucepwd" class="form-control" placeholder="请输入密码">
		      <span id="zhucepwd" class="onshow"></span>
		    </div>
		  </div>	
		  <div class="form-group">
		    <label class="col-sm-3 control-label">请确认密码:</label>
		     <div class="col-sm-7">
		      <input type="password" id="querenpwd" class="form-control" placeholder="请确认密码">
		      <span id="querenpwd" class="onshow"></span>
		    </div>
		  </div>		 
		   <div class="form-group">
		    <label class="col-sm-3 control-label"><strong>请输入手机号码:</strong></label>
		     <div class="col-sm-7">
		      <input type="text" name="phone" id="zhuphone" class="form-control" placeholder="请输入您的手机号码">
		      <span id="zhuceage" class="onshow"></span>
		    </div>
		  </div>     		  
		   <div class="form-group">
		    <label class="col-sm-3 control-label"><strong>请输入邮箱地址:</strong></label>
		     <div class="col-sm-7">
		      <input type="text" name="email" id="zhuceEmailAddress"class="form-control" placeholder="请输入邮箱地址">
		      <span id="zhuceEmailAddress" class="onshow"></span>
		    </div>
		  </div>		  
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="submit" class="btn btn-primary">注册</button>
      </div>
      </form>
    </div>
  </div>
</div>
</body>
</html>

