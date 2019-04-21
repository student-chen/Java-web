<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<html>
  <head>
    <title>护士病床表</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
  </head>
  <body>
   <form action="<%=request.getContextPath()%>/nurse_sickbedServlet?opertion=4" method="post">
   	<table class="simple textCss">
 	 <tr><th colspan="3" align="center">护士病床表</th></tr>
   <tr>
   	<td width=30% align="center">标识</td>
   	<td width=50% align="center">护士姓名</td>
   	<td width=20% align="center">病床编号</td>
   	</tr>
  <%
	ArrayList arr=(ArrayList)request.getAttribute("MybedList");
	if(arr!=null&&arr.size()>=3)
	{
   %>
   <tr>
   	<td align="center"><%=arr.get(0) %></td>
   	<td align="center"><%=arr.get(1) %></td>
   	<td align="center"><%=arr.get(arr.size()-1) %></td>
   <%}else{
   		out.println("对不起，没有您要查询的护士在病床中工作......");
   }%>
   </tr>
   <tr>
   	<td colspan="3"><input type="button" class="buttonClass" value="返回" onClick="window.location.href='${pageContext.request.contextPath}/view_zhouxiaoli/nurse_sickbed.jsp'">
   </tr>
   </table>
   </form>
  </body>
</html>   	