<%@ page language="java" pageEncoding="GB18030"%>
<html>
  <head> 
    <title>My JSP 'serchDiagnosis.jsp' starting page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
    <style type="text/css">
<!--
a:link {
	text-decoration: none;
}
a:visited {
	text-decoration: none;
}
a:hover {
	text-decoration: none;
}
a:active {
	text-decoration: none;
}
-->
</style>
  </head>
  <body>
	<table class="simple textCss">
		<tr>
			<th colspan="5" align="center">
				<input type="button" value="查看诊断书" class="buttonClass" 
					onclick="window.location.href=''">&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" value="查看手术表" class="buttonClass" 
					onclick="window.location.href=''">&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" value="查看手术室" class="buttonClass" 
					onclick="window.location.href='${pageContext.request.contextPath }/showOprtionRoom.jsp'">&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" value="查看病床表" class="buttonClass" 
					onclick="window.location.href='${pageContext.request.contextPath }/sickBedServlet?opertion=4'">&nbsp;&nbsp;&nbsp;&nbsp;
			</th>
		</tr>	
	</table>
  </body>
</html>