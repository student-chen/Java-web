<%@ page language="java" pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title>17医院病人挂号--关爱健康，为您助行</title>
    <meta http-equiv="content-type" content="text/html;charset=gb2312">	
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
	<script type="text/javascript">
		function load(){
		<%
			Object type=request.getAttribute("type");
			if(type!=null){
				if("1".equals(type+"")){
		%>
				document.f1.neike.checked=true;
		<%}else{
		%>
				document.f1.waike.checked=true;
		<%}}
		%>
		}
		function isthis1(){		//内外科状况
			if(document.f1.neike.checked){
				document.patientRegisterForms.mcid.disabled=false;
				window.location.href="topQueryServlet?opertion=0&type=1";
			}else if(document.f1.waike.checked){
				document.patientRegisterForms.mcid.disabled=true;
				window.location.href="topQueryServlet?opertion=0&type=0";
			}
		}
		function toAge(){   //验证年龄的有效性
			var age=document.patientRegisterForms.age.value;
			if(isNaN(age)){ //如果年龄不是数字，就宣示相关信息
				alert("年龄必须是数字型的！！！");
				document.all("age").value="";
				return false;
			}
			else if(age>115||age<7){
				alert("年龄太大和太小！！！");
				document.all("age").value="";
				return false;
			}
			return true;	
		}	
		function tochange(){
			var name=document.patientRegisterForms.name.value;
			if(name==null||name==""){
				alert("你的用户名为空！");
				return false;
			}else if(name.length>13||name.length<2){
				alert("姓名不合法！！");
               document.patientRegisterForms.name.value="";
				return false;
			}
			return true;
		}		
     function check(form){
	   if(form.patientNo.value==""){
	     alert("挂号不能为空");
	   }else if(form.name.value=="") {
	     alert("姓名不能为空");
	   }else if(form.address.value=="") {
	     alert("地址不能为空");
	   }else{
	     document.patientRegisterForms.submit();
	   }
	 }
	</script>
	
	</head>  
  <body onload="load();">
    <form action="topQueryServlet?opertion=1" method="post" name="patientRegisterForms" id="f1">
    	<table  class="simple textCss"> 
    		<tr>
    			<th colspan="3">病人挂号注册信息</th>
    		</tr>   
    		<tr>	
    			<td width="20%" align="right">科室类型:</td>
    			<td width="40%" align="left">
    				<input type="radio" name="mcid" value="0" id="waike" onclick="isthis1()">外科
    				<input type="radio" name="mcid" value="1" id="neike" onclick="isthis1()">内科
    			</td>
    			<td width="40%" align="left">注：是该病人应该要去看病的科室类型</td>
    		</tr>   
    		<tr>	
    			<td width="20%" align="right">科室名称:</td>
    			<td width="40%" align="left">
    				<select name="mcName">
    					<c:forEach items="${medicalcoursesNameSelected}" var="na">
    						<option value="${na.name}">${na.name}</option>
    					</c:forEach>
    				</select>
    			</td>
    			<td width="40%" align="left">注：是该病人应该要去看病的科室名称</td>
    		</tr>
    		<tr>	
    			<td width="20%" align="right">挂号号码:</td>
    			<td width="40%" align="left"><input type="text" name="patientNo" class="txt"></td>
    			<td width="40%" align="left">注：挂号号码为病人挂号的标志&nbsp;&nbsp;如:[S1002]</td>
    		</tr>    	
    		<tr>	
    			<td width="20%" align="right">姓名:</td>
    			<td width="40%" align="left">
    				<input type="text" name="name" class="txt" onblur="return tochange();" 
    					onkeyup="value=value.replace(/[^\u4E00-\u9FA5\A-Za-z]/g,'')"></td>
    			<td width="40%" align="left">注：病人姓名</td>
    		</tr>    	
    		<tr>	
    			<td width="20%" align="right">性别:</td>
    			<td width="40%" align="left">    				
    				<input type="radio" name="sex" id="m" value="男" checked>男
    				<input type="radio" name="sex" id="w" value="女">女</td>
    			<td width="40%" align="left"></td>
    		</tr>    	
    		<tr>	
    			<td width="20%" align="right">年龄:</td>
    			<td width="40%" align="left">
    				<input type="text" name="age" value="24" onBlur="return toAge();" class="txt"></td>
    			<td width="40%" align="left"></td>
    		</tr>   
    		<tr>	
    			<td width="20%" align="right">家庭地址:</td>
    			<td width="40%" align="left"><input type="text" name="address" class="txt"></td>
    			<td width="40%" align="left">注：是该病人家庭的详细信息</td>
    		</tr>   
    		<tr height="40">	
    			<td width="20%" align="right">是否激活:</td>
    			<td width="40%" align="left">
    				<input type="radio" name="isfinished" value="是" checked>是
    				<input type="radio" name="isfinished" value="否">否	
    			</td>
    			<td width="40%" align="left">注：激活后病人马上可以进行治疗!</td>
    		</tr>   
    		<tr>
    			<td colspan="2" align="center" width="60%">
    				<input type="button" value="提交" class="buttonClass" onclick="return check(this.form);">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="reset" value="重置" class="buttonClass">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td align="right" width="40%">
    				<font color=red>◆★◆☆我们承诺我们终身对您的信息保密！！</font>
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>