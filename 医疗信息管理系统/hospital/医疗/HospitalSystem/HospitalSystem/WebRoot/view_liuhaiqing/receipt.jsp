<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>收据维护</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
  </head>
  
  <body>
  <form action="<%=request.getContextPath()%>/doctorServlet?operation=1" method="post">
  <table class="simple textCss">
  <tr>
  	<th colspan="2" align="center">收据维护</th>
  </tr>
  <tr>
  	<th width="20%" align="center"> 职称：</th>
  	<td><input type="text" name="" class="txt"></td>
  </tr>
  <tr>
  	<td colspan="2" align="center">
  		<input type="button" value="提交" class="buttonClass"/>&nbsp;&nbsp;&nbsp;
  		<input type="button" value="重置" class="buttonClass"/>
  	</td>
  </tr>
  </table>
  </form>
  </body>
</html>