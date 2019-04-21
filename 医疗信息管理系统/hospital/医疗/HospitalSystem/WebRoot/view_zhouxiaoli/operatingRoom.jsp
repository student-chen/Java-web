<%@ page language="java" pageEncoding="GBK"%>
<html>
  <head>    
    <title>手术室的添加</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
    <script type="text/javascript">
     function check(form){
	   if(form.orNo.value==""){
	     alert("手术室编号不能为空");
	   }else if(form.address.value=="") {
	     alert("手术地址不能为空");
	   }else{
	     document.operationRoomformsad.submit();
	   }
	 }
	</script>
  </head>  
  <body>
    <form action="<%=request.getContextPath()%>/operatingRoomServlet?opertion=3" method="post" name="operationRoomformsad">
    <table class="simple textCss">
    	<tr><th align="center" colspan="2">手术室信息</th></tr>
    	<tr>
    		<th width="30%" align="right">手术室编号:</th>
    		<td><input type="text" name="orNo" class="txt"></td>
    	</tr>
    	<tr>
  		   <th width="30%" align="right">类&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;型:</th>
  		   <td>
	  		<select name="leixing">
		  		<option name="a" value="大型手术" selected>大型手术</option>
		  		<option name="b" value="中型手术" selected>中型手术</option> 
		  	 	<option name="c" value="小型手术" selected>小型手术</option>
 			</select>
	 	   </td>
		 </tr>
		 <tr>
		 	<th width="30%" align="right">地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址:</th>
		 	<td><input type="text" name="address" class="txt"></td>
		 </tr>
		 <tr>
		 	<th width="30%" align="right">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注:</th>
		 	<td><input type="text" name="info" class="txt"></td>
		 </tr>
		 <%--<tr>
		 	<th width="30%" align="right">护士列表&nbsp;:</th>
		 	<td><input type="text" name="nurseList" class="txt"></td>
		 </tr>
		 --%><tr>
		 	<th width="30%" align="right">是否空闲&nbsp;:</th>
			 <td>
			 	<input type="radio" name="r" value="1">是
			 	<input type="radio" name="r" value="0" checked="checked">否
			</td>
		 </tr>
		 <tr>
		 	<td colspan="2" align="center">
			 	<input type="button" value="提交" class="buttonClass" onclick="return check(this.form);">&nbsp;&nbsp;&nbsp;&nbsp;
			 	<input type="reset" value="重置" class="buttonClass">
		 	</td>
		 </tr>
    </table>
  </form>
  </body>
</html>