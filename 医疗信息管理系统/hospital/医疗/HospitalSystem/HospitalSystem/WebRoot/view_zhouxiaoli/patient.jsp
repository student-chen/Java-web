<%@ page language="java"pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>My JSP 'patient.jsp' starting page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
	<%
	pageContext.setAttribute("patient",request.getAttribute("patientList"));
	 %>
  </head>
 <body> 
  	<form action="<%=request.getContextPath()%>/patientServlet?operation=3" method="post">
  	<table  class="simple textCss">
	<tr>
  		<th align="center" colspan="2">病人信息</th>
  	</tr>
  	<tr>
  		<th width="30%" align="right">编&nbsp;&nbsp;&nbsp;&nbsp;号:</th>
  		<td><input type="text" name="oid" value="${patient.oid }" ReadOnly=true class="txt"></td>
  	</tr>
  	<tr>
  		<th width="30%" align="right">住院&nbsp;&nbsp;号:</th>
  		<td><input type="text" name="patientNo" value="${patient.patientNo }" class="txt"></td>
  	</tr>
  	<tr>
  		<th width="30%" align="right">姓&nbsp;&nbsp;&nbsp;&nbsp;名:</th>
  		<td><input type="text" name="name" value="${patient.name }" class="txt"></td>
  	</tr>
  	<tr>
  		<th width="30%" align="right">性&nbsp;&nbsp;&nbsp;&nbsp;别:</th>
  		<td><input type="radio" name="r1">男<input type="radio" name="r1">女</td>
  	</tr>
  	<tr>
  		<th width="30%" align="right">地&nbsp;&nbsp;&nbsp;&nbsp;址:</th>
  		<td><input type="text" name="address" value="${patient.address }" class="txt"></td>
  	</tr>
  	<tr>
  		<th width="30%" align="right">年&nbsp;&nbsp;&nbsp;&nbsp;龄:</th>
  		<td><input type="text" name="age" value="${patient.age }" class="txt"></td>
  	</tr>
  	<tr>
  		<th width="30%" align="right">是否处理:</th>
  		<td>
  			<input type="radio" name="r">是
  			<input type="radio" name="r">否</td>
  	</tr>
  	<tr>
  		<th width="30%" align="right">科别&nbsp;&nbsp;ID:</th>
  		<td><input type="text" name="mcID" value="${patient.mcID }" ReadOnly=true class="txt"></td>
  	</tr>
  	<tr>
  	 <th width="30%" align="right">科&nbsp;&nbsp;&nbsp;&nbsp;别:</th>
	  	<td>
	  	<select name="aa">
		  	<option name="a" value="皮肤科" selected>皮肤科</option>
		  	<option name="b" value="骨科" selected>骨科</option> 
		   <option name="c" value="ICU" selected>ICU</option>
		   <option name="d" value="口腔科" selected>口腔科</option>
 	   </select>
		 </td>
		 </tr>
		 <tr>
		 	<td align="center" colspan="2">
			 	<input type="submit"  value="提交" class="buttonClass">&nbsp;&nbsp;
			 	<input type="reset"  value="重置" class="buttonClass"></td>
		 </tr>
	 </table>
 </form>
  </body>
</html>
