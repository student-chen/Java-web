<%@ page session="true" language="java"
	contentType="text/html; charset=gb2312" pageEncoding="gb2312"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<LINK href="../res/css/main.css" rel=stylesheet>
<title>Insert title here</title>
</head>
<script>
function check()
{  
  var  rule = /^[A-Za-z0-9]\w{0,19}$/;
  if(document.update.oldpwd.value=="")
           {
              alert("密码不可为空！！！");
              return false;
           }
if (document.update.oldpwd.value!=<%=request.getAttribute("pwd")%>)
 {
     
	document.update.oldpwd.focus();
    alert("旧密码不正确");
	return false;
  }
    if(!rule.test(update.oldpwd.value))
     {
           	 alert("密码只能由数字和字母组成！");
             return false;
     }
  if (checkspace(document.update.newpwd.value)) 
  {
	document.update.newpwd.focus();
    alert("新密码不能为空");
	return false;
  }
  
  if (document.update.checkpwd.value!=document.update.newpwd.value)
   {
	document.update.checkpwd.focus();
    alert("新密码不一致");
	return false;
  }
  
  function checkspace(check) {
  var str = '';
  for(i = 0; i < check.length; i++) {
    str = str + ' ';
  }
  return (str == check);
 } 
   
}</script>
<body>
<form method="post" name="update" action="Update">

<table>
	
	<tr>
		<td>name</td>
		<td><input type="text" name="username" value=${student.s_name } disabled="faulse"></td>
	</tr>
	<tr>
		<td>username</td>
		<td><input type="text" name="s_number" value =<%=request.getAttribute("s_num")%> disabled="faulse"></td>
	</tr>
	<tr>
		<td>oldpassword</td>
		<td><input type="password" name="oldpwd"></td>
	</tr>
	<tr>
		<td>newpassword</td>
		<td><input type="password" name="newpwd"></td>
	</tr>
	<tr>
		<td>checkpassword</td>
		<td><input type="password" name="checkpwd"></td>
	</tr>
	<tr>
		<td>c_id</td>
		<td><input type="text" name="c_id"value=<%=request.getAttribute("c_id") %> disabled="faulse"></td>
	</tr>
	 <tr>
	 <td>classtype</td>
	 <td><input tyep="text" name="c_type"value=<%=request.getAttribute("c_type")%> disabled="faulse"></td>
	 </tr>
<tr>
	<td><input type="submit" name="tijiao" onClick=" return check();"></td>
</tr>
</table>
</form>
</body>
</html>
