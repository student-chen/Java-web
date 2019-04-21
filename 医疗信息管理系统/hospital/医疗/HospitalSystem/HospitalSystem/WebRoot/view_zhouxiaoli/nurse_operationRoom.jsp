<%@ page language="java"pageEncoding="gbk"%>
<html>
  <head>
    <title>护士手术室</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
  </head>  
  <body>
   <form action="<%=request.getContextPath()%>/nurse_operationRoomServlet?opertion=4" method="post">
   <table class="simple textCss">
   <tr>
	   	<th width="20%" align="right">护士姓名:</th>
	   	<th width="30%"><input type="text" name="name" class="txt"></th>
	   	<th width="20%"><input type="submit" value="查询" class="buttonClass"></th> 
	   	<th width="30%"><input type="button" value="添加手术室" class="buttonClass" 
	   		onclick="window.location.href='<%=request.getContextPath()%>/view_wujirui/addOprationRoom.jsp'">
	   	</th>   	
    </tr>
   </table>
   </form>
   </body>
</html>
   	
