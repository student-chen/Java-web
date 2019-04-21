<%@ page language="java"  pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>后台管理</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="Bluth Company">
<%--     <link rel="shortcut icon" href="<%=basePath %>assets/ico/favicon.html"> --%>
    <link href="<%=basePath %>assets/css/bootstrap.css" rel="stylesheet">
        <!-- Latest compiled and minified CSS -->
    <link href="<%=basePath %>assets/css/theme.css" rel="stylesheet">
    <link href="<%=basePath %>assets/css/font-awesome.min.css" rel="stylesheet">
    <link href="<%=basePath %>assets/css/alertify.css" rel="stylesheet">
    <link rel="Favicon Icon" href="<%=basePath %>assets/favicon.ico">
     <script src="http://code.jquery.com/jquery-2.2.1.min.js"></script>
    <script >
    
    $(document).ready(function () {
    	$(":input").attr("autocomplete","off");
    });
    </script>
    <script language="JavaScript">
    function checkForm(){
		var oldPassword=document.getElementById("oldPassword").value;
		var newPassword=document.getElementById("newpassword").value;
		var rPassword=document.getElementById("rPassword").value;
		//var oldd=document.getElementById("old").value; 
		if(oldPassword==""||newPassword==""||rPassword==""){
			document.getElementById("error").innerHTML="信息填写不完整！";
			return false;
		/* } else if(newPassword!=rPassword){
			document.getElementById("error").innerHTML="密码填写不一致！";
			return false;
		}else if(oldPassword!=oldd){
			document.getElementById("error").innerHTML="原始密码填写不一致！";
			return false;	 */			
	}		
				return true;						
	}
function yuan() {
	var oldPassword=$("#oldPassword").val();
	var $span=$("#oldPassword + span");
	
	
	var oldd=$("#old").val(); 
	if(oldPassword == oldd){				
		$span.css("color","green");
		$span.text("√输入正确");
		return true;
	}else if(oldPassword==""){
		$span.css("color","red");
		$span.text("×原始密码不能为空！");
		return false;	
	}else{
		$span.css("color","red");
		$span.text("×原始密码不正确！");
		return false;
	}
}

function xinmi() {
	//var oldPassword=$("#oldPassword").val();
	var newPassword=$("#newpassword").val();
	var $span=$("#newpassword + span");
	var oldd=$("#old").val(); 
	if(newPassword == oldd){
		$span.css("color","red");
		$span.text("×新密码不能和原始密码一样");
		return false;		
	}else if(newPassword!=""){
		$span.css("color","green");
		$span.text("√输入正确");
		return true;	
	}else{
		$span.css("color","red");
		$span.text("×新密码不能为空");
		return false;
	}	
}


function chongfu() {
	var rPassword=$("#rPassword").val();
	var $span=$("#rPassword + span");
	var newPassword=$("#newpassword").val();
	
	if(rPassword == newPassword){
		$span.css("color","green");
		$span.text("√输入正确");
		return true;					
	}else if(rPassword ==""){
		$span.css("color","red");
		$span.text("×密码不能为空");
		return false;	
	}else{
		$span.css("color","red");
		$span.text("×密码和新密码不一致");
		return false;	
	}
}


 function checkper(){
      var flag=true;
      if(!checkForm()) flag=false;  
      if(!yuan()) flag=false;  
      if(!xinmi()) flag=false;  
      if(!chongfu()) flag=false;  
      return flag;
   }

function isNull(str){
if ( str == "" ) return true;
var regu = "^[ ]+$";
var re = new RegExp(regu);
return re.test(str);
}
</script>
  </head>
  <body>
    <div id="wrap">
    <div class="navbar navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container-fluid">
          <div class="logo"> 
          	<span style="color: white;font-size: 24px;">学生信息管理系统</span>
           <!-- <img src="assets/img/logo.png" alt="Realm Admin Template">-->
          </div>
           <a class="btn btn-navbar visible-phone" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
           <a class="btn btn-navbar slide_menu_left visible-tablet">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>

          <div class="top-menu visible-desktop">
            <ul class="pull-right">  
              <li><a href="<%=basePath %>login.jsp""><i class="icon-off"></i> 退出</a></li>
            </ul>
          </div>

        
        </div>
      </div>
    </div>

   
     
      <!-- Side menu -->
      <div class="sidebar-nav nav-collapse collapse">
        <div class="user_side clearfix">
          <img src="<%=basePath %>assets/img/u=2193226168,4120396026&fm=27&gp=0.jpg" alt="无法显示">
          <h5>${ sessionScope.user.name}</h5>
              
        </div>
       <div class="accordion" id="accordion2">
				<div class="accordion-group">
					<div class="accordion-heading">
						<a class="accordion-toggle active b_F79999" href="index.jsp"><i
							class="icon-dashboard"></i> <span>控制台</span>
						</a>
					</div>
				</div>

				<div class="accordion-group">
					<div class="accordion-heading">
						<a class="accordion-toggle b_F6F1A2" href="StudentOAselect"><i
							class="icon-tasks"></i> <span>学生信息列表</span>
						</a>
					</div>
				</div>
				<div class="accordion-group">
					<div class="accordion-heading">
						<a class="accordion-toggle b_F5C294" href="ClassOAselect"><i
							class="icon-tasks"></i> <span>班级信息列表</span>
						</a>
					</div>
				</div>
				<div class="accordion-group">
             <div class="accordion-heading">
              <a class="accordion-toggle b_F5C294" href="TeacherSelect"><i class="icon-tasks"></i> <span>老师信息列表</span></a>
            </div> 
          </div>  
				<div class="accordion-group">
					<div class="accordion-heading">
						<a class="accordion-toggle b_F5C294"
							href="password.jsp"><i class="icon-user"></i>
							<span>修改密码</span>
						</a>
					</div>
				</div>
				<div class="accordion-group"></div>
			</div>
		</div>
      <!-- /Side menu -->

      <!-- Main window -->
      <form action="OAUserupdates?id=${id}" method="post" onsubmit="return checkper()">
      <table style="width: 60%; margin:auto">
				 <tr><td><input type="hidden" id="old" value="${password}"/></td> 
                 <td><input type="hidden" id="id" name="id" value="${id}"/></td>  
                 </tr> 
					    <tr>
                    <td height="30" align="right"><span style="color:red;"></span>请输入原密码：</td>  
                                     
                    <td><input type="password" id="oldPassword"  name="oldPassword"   style="margin-top:5px;height:30px;" onBlur="yuan()"/><span></span></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;"></span>请输入新密码：</td>
                    <td><input type="password" id="newpassword"  name="password"  style="margin-top:5px;height:30px;" onBlur="xinmi()"/><span></span></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;"></span>请重复新密码：</td>
                    <td><input type="password" id="rPassword"  name="rPassword"  style="margin-top:5px;height:30px;" onBlur="chongfu()"/><span></span></td>
                  </tr>
                  <tr>
					 <td height="50" align="right">
					<button style="height:35px;width:100px;background:#0271BC;font-size: 20px;"
					class="layui-btn layui-btn-danger layui-btn-mini" type="submit" >提交</button>
					</tr>
					
				       

</table>
<div align="center">
						<font id="error" color="red">${error}</font>
					</div>
</form>


    <script type="text/javascript" src="<%=basePath %>assets/js/jquery.min.js">
    </script>
  </body>
</html>
