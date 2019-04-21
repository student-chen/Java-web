<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=GBK">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/> 
	<script type="text/javascript">
	     function check(form){
		   if(form.name.value==""){
		     alert("科别名称不能为空");
		   }else{
		     document.mediForsm.submit();
		   }
		 }
	</script>   
	<title>科别添加</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/medicalcoursesServlets?opertion=1" method="post" name="mediForsm">
		<table class="simple textCss">
			<tr>
				<th colspan="2" class="title">科别添加</th>
			</tr>
			<tr>
				<td align="right" width="30%" class="title">科别名称</td>
				<td><input type="text" name="name" class="txt"></td>
			</tr>
			<tr>
				<td align="right" width="30%" class="title">科别类型</td>
				<td>
					<input type="radio" name="type" value="0" checked="checked">外科
					<input type="radio" name="type" value="1">内科
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="添加" class="buttonClass" onclick="return check(this.form);">&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" value="重置" class="buttonClass">&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" value="返回" class="buttonClass"
						 onclick="window.location.href='<%=request.getContextPath()%>/medicalcoursesServlets?opertion=4'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>