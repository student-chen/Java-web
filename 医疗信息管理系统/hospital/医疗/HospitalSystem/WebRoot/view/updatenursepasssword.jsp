<%@ page language="java"  pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
    <script type="text/javascript">    
     function check(form){
	   if(form.password1.value==""){
	     alert("请输入密码,检查您输入的是否正确!");
	   }else{
	     document.nursePasswordForms.submit();
	   }
	 }
    </script>
    <title>护士信息表</title>
</head>
  <body>
  <form action="<%=request.getContextPath()%>/updatePasswordServlet?opertion=3" method="post" name="nursePasswordForms">
      <table class="simple textCss">
      <tr>
      	   <th colspan="2" align="center" class="title">护士密码修改</th>
      </tr>
      <tr>
	      <th width="30%" align="right">登录名:</th>
	      <td><input type="text" name="loginName" value="<%=session.getAttribute("nurseName")%>" class="txt" disabled="disabled"></td>
      </tr>
      <tr>
	      <th width="30%" align="right">旧密码:</th>
	      <td>
	      <input type="password" name="loginPassword" class="txt" onchange="pass(this)">
	         <script type="text/javascript">
	       			function pass(obj){
	       				var ob=obj.value;
	       				var pa=<%=(String)session.getAttribute("nursePassword")%>
	       				if(ob!=pa){
	       					alert("您输入的密码和登录时的密码不一样!!");
	       					obj.value="";
	       					return;
	       				}	       				
	       			}
	       		</script></td>
      </tr>
     <tr>
	     <th width="30%" align="right">新密码:</th>
	     <td>
	     <input type="password" name="password" class="txt" onchange="nursepass1(this)">
	      <script type="text/javascript">
		       		function nursepass1(obj){
		       			var pass1=obj.value;
	       				var pa2=<%=(String)session.getAttribute("nursePassword")%>
		       			if(pass1==pa2){
		       				alert("您输入的新密码和原密码相同!!");
		       				document.nursePasswordForms.password.value="";
		       				return ;
		       			}
		       		}		       
		       </script></td>
     </tr>
     <tr>
	     <th width="30%" align="right">确认密码:</th>
	     <td>
	     <input type="password" name="password1" class="txt" onchange="nursepass()">
	     <script type="text/javascript">
		       		function nursepass(){
		       			var pass3=document.nursePasswordForms.password.value;
		       			var pass2=document.nursePasswordForms.password1.value;
		       			if(pass3!=pass2){
		       				alert("您两次输入的密码不一样!!");
		       				document.nursePasswordForms.password1.value="";
		       				return;
		       			}
		       		}		       
		       </script></td>
     </tr>
     <tr>
     	<td colspan="2" background="imgs/color/color_qianse.jpg">
     </td>
     </tr>
     <tr>
     	<td colspan="2" align="center">
        <input type="button" value="提交" class="buttonClass"onclick="return check(this.form);"></td>
    </tr>
      </table>
    </form>
   </body>
</html>
