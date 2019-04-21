<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<html>
  <head>
    <title>护士和手术室查看</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
  </head> 
  <body>
  	<form action="<%=request.getContextPath()%>/nurse_operationRoomServlet?opertion=4" method="post">  	
  	<table class="simple textCss">
  	<tr><th align="center" colspan="4">护士和手术室表</th></tr>
  	<tr>
  		<th width="20%" align="center">护士编号</th>
  		<th width="30%" align="center">护士姓名</th>
  		<th width="20%" align="center">手术室编号</th>
  		<th width="30%" align="center">手术室名称</th>
  	</tr>
  	<%
  		ArrayList arr=(ArrayList)request.getAttribute("nurse_operationRoomList");
  		if(arr!=null){
  	 %>
  	 <tr>
  	 	<td align="center"><%=arr.get(0)%></td>
  	 	<td align="center"><%=arr.get(1)%></td>
  	 	<td align="center"><%=arr.get(2)%></td>
  	 	<td align="center"><%=arr.get(arr.size()-1)%></td>
  	 </tr>
  	 <% }%>
  	 </table>
  	 <table class="simple textCss">  	 
  		<tr><th align="center" colspan="4">
			<input type="button" class="buttonClass" value="返回" 
				onclick="window.location.href='<%=request.getContextPath()%>/view_zhouxiaoli/nurse_operationRoom.jsp'">
		</th></tr>
  	 </table>
  	 </form>
  </body>
</html>
