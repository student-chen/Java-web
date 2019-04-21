<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>教务管理系统登录</title>
    
<script type="text/javascript">
   function J(form1)
{
   if(form1.select.value=="0")
   {
    window.alert("请输入用户类型！"); 
    form1.select.focus(); 
    return (false); 
   }
 
 }
</script>
</head>
<body bgcolor="#FFFFFF" style="margin: 0 auto;">

    <form action="login.action" method="post" id="form1" onsubmit="return J(form1);">
    <div>
        <center>
            <table id="__01" width="1361" height="648" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td colspan="9">
			<img src="images/login_01.png" width="1360" height="124" alt=""></td>
		<td>
			<img src="1.gif" width="1" height="124" alt=""></td>
	</tr>
	<tr>
		<td rowspan="12">
			<img src="images/login_02.png" width="381" height="523" alt=""></td>
		<td colspan="7">
			<img src="images/login_01-04.png" width="598" height="118" alt=""></td>
		<td rowspan="12">
			<img src="images/login_04.png" width="381" height="523" alt=""></td>
		<td>
			<img src="1.gif" width="1" height="118" alt=""></td>
	</tr>
	<tr>
		<td>
			<img src="images/login_01-06.png" width="120" height="1" alt=""></td>
		<td colspan="2" rowspan="4">
			<img src="images/login_06.png" width="179" height="53" alt=""></td>
		<td colspan="4">
			<img src="images/login_01-08.png" width="299" height="1" alt=""></td>
		<td>
			<img src="1.gif" width="1" height="1" alt=""></td>
	</tr>
	<tr>
		<td rowspan="10">
			<img src="images/login_08.png" width="120" height="404" alt=""></td>
		<td colspan="4">
			<img src="images/login_09.png" width="299" height="8" alt=""></td>
		<td>
			<img src="1.gif" width="1" height="8" alt=""></td>
	</tr>
	<tr>
		<td rowspan="7">
			<img src="images/login_10.png" width="10" height="165" alt="" /></td>
		<td>
        <script type="text/javascript">
            var s = document.getElementById("select").val();
            if (s == "0") {
                alert('请选择用户类型');
            }
                </script>
			<select name="usertype" id="select" style="height: 33px;width: 158px;">
			<option value="0">用户类型</option>
			<option value="1">学生</option>
			<option value="2">教师</option>
			<option value="3">管理员</option>
			</select> 
		<td colspan="2" rowspan="7">
			<img src="images/login_12.png" width="126" height="165" alt=""></td>
		<td>
			<img src="1.gif" width="1" height="35" alt=""></td>
	</tr>
	<tr>
		<td rowspan="3">
			<img src="images/login_13.png" width="163" height="18" alt=""></td>
		<td>
			<img src="1.gif" width="1" height="9" alt=""></td>
	</tr>
	<tr>
		<td colspan="2">
			<img src="images/login_14.png" width="179" height="1" alt=""></td>
		<td>
			<img src="1.gif" width="1" height="1" alt=""></td>
	</tr>
	<tr>
		<td colspan="2" rowspan="3">
			<img src="images/login_15.png" width="179" height="53" alt=""></td>
		<td>
			<img src="1.gif" width="1" height="8" alt=""></td>
	</tr>
	<tr>
		<td>
         <script type="text/javascript">
             var ee = document.getElementById('userID');
             if (ee.value == "") {
                alert('用户ID不能为空！');
            }
                </script>
            <input type="password" name="userid"  />
			</td>
		<td>
			<img src="1.gif" width="1" height="37" alt=""></td>
	</tr>
	<tr>
		<td rowspan="2">
			<img src="images/login_17.png" width="163" height="75" alt=""></td>
		<td>
			<img src="1.gif" width="1" height="8" alt=""></td>
	</tr>
	<tr>
		<td colspan="2">
			<img src="images/login_18.png" width="179" height="67" alt=""></td>
		<td>
			<img src="1.gif" width="1" height="67" alt=""></td>
	</tr>
	<tr>
		<td rowspan="2">
			<img src="images/login_19.png" width="1" height="231" alt=""></td>
		<td colspan="4">
            <input type="image" name="submit" src="images/login_20.png"/>
            
			</td>
		<td rowspan="2">
			<img src="images/login_21.png" width="120" height="231" alt=""></td>
		<td>
			<img src="1.gif" width="1" height="59" alt=""></td>
	</tr>
	<tr>
		<td colspan="4">
			<img src="images/login_22.png" width="357" height="172" alt=""></td>
		<td>
			<img src="1.gif" width="1" height="172" alt=""></td>
	</tr>
	<tr>
		<td>
			<img src="1.gif" width="381" height="1" alt=""></td>
		<td>
			<img src="1.gif" width="120" height="1" alt=""></td>
		<td>
			<img src="1.gif" width="1" height="1" alt=""></td>
		<td>
			<img src="1.gif" width="178" height="1" alt=""></td>
		<td>
			<img src="1.gif" width="10" height="1" alt=""></td>
		<td>
			<img src="1.gif" width="163" height="1" alt=""></td>
		<td>
			<img src="1.gif" width="6" height="1" alt=""></td>
		<td>
			<img src="1.gif" width="120" height="1" alt=""></td>
		<td>
			<img src="1.gif" width="381" height="1" alt=""></td>
		<td></td>
	</tr>
</table>
        </center>
  </div>
    </form>
</body>
</html>
