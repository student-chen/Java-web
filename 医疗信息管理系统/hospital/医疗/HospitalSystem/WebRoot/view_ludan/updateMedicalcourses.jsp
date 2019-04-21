<%@ page language="java" pageEncoding="GBK"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=GBK">
<title>职称修改</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>    
</head>
<body>
	<form action="<%=request.getContextPath()%>/medicalcoursesServlets?opertion=3" method="post">
	<%
	String id=request.getParameter("id");
	String name1=request.getParameter("name");
	String name=new String(name1.trim().getBytes("iso-8859-1"),"gbk");
	String type=request.getParameter("type");
	if(type==null||type==""||type=="1"){
		type="内科";
	}else{
		type="外科";
	}
	 %>
	 <table class="simple textCss">
	 	<tr>
	 		<td colspan="3" class="title" align="center"><h3><font face="隶书">修改科别信息</font></h3></td>
	 	</tr>
		 <tr>
			 <td width="30%%" align="right" class="title">科别ID:</td>
			 <td><input type="text" name="id" value=<%=id%> readonly class="txt"></td>
		 </tr>
		 <tr>
			 <td width="30%%" align="right" class="title">科别名称:</td>
			 <td><input type="text" name="name" value=<%=name%> class="txt"></td>
	     </tr>
	     <tr>
			 <td width="30%%" align="right" class="title">科别类型:</td>
			 <td><input type="text" name="type" value=<%=type%> class="txt"></td>
		 </tr>
		<tr>
			<td colspan="3" align="center">
				<input type="submit" value="修改" class="buttonClass">&nbsp;&nbsp;&nbsp;
				<input type="button" value="返回" class="buttonClass"
				onclick="window.location.href='<%=request.getContextPath()%>/medicalcoursesServlets?opertion=4'">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>