<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>职称添加</title>
    <link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
  </head>
  
  <body>
  <form action="doctorServlet?operation=1" method="post">
  <table class="simple textCss">
  <tr>
  	<th colspan="2">职称添加</th>
  </tr>
  <tr>
  	<td width="20%"> 职称：</td>
  	<td><input type="text" name="" class="txt"></td>
  </tr>
  <tr>
  	<td colspan="2">
  		<input type="button" value="提交" class="buttonClass"/>
  		<input type="button" value="重置" class="buttonClass"/>
  	</td>
  </tr>
  </table>
  </form>
  </body>
</html>
