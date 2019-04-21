<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head> 
    <title>My JSP 'listOperationRoom.jsp' starting page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
  </head>
  <body>
     <table class="simple textCss">
     <%
     	ArrayList arr=(ArrayList)request.getAttribute("showList");
     	if(arr!=null&&arr.size()>=4){
      %><tr>
	        <th width="30%" align="right"> 手术室编号：</th>
	        <td>
	        	<input type="text" value="<%=arr.get(0)%>" class="txt">
	        </td>
         </tr>
         <%--<tr>
         <th  width="30%" align="right">类&nbsp;&nbsp;&nbsp;型：</th>    
         <td><%=arr.get(1) %></td>
         </tr>
         --%><tr>
		        <th  width="30%" align="right"> 地&nbsp;&nbsp;&nbsp;址：</th>
		        <td>
	        		<input type="text" value="<%=arr.get(2) %>" class="txt">
	        	</td>
          </tr>
          <tr>
	         <th  width="30%" align="right">备&nbsp;&nbsp;&nbsp;注：</th>
	         <td> 
	        		<input type="text" value="<%=arr.get(3) %>" class="txt">
	         </td>
         </tr>
         <tr>
	         <th  width="30%" align="right">是否空闲：</th>
	         <td>
		         <c:if test="<%=arr.get(arr.size()-1).equals("1")%>">
		         	 <input type="text" value="是" class="txt">
		         </c:if> 
		         <c:if test="<%=arr.get(arr.size()-1).equals("0")%>">
		         	 <input type="text" value="否" class="txt">
		         </c:if>
	         </td>
         </tr>
         <tr>
	        <th  width="30%" align="right"> 相关护士：</th>
	        <td>     
		        <c:forEach items="${nurseNameList}" var="nurseNamelist">
		        	<font color="blue">${nurseNamelist.name}  </font>
		        </c:forEach>   
	        </td>
         </tr> 
         <%}else{%>
         <tr>
         		<td colspan="3" align="center">对不起，此手术室还没有安排护士...</td>
         </tr>
         <%} %>
         <tr>
         	<th colspan="3">
         	<input type="button" value="返回" class="buttonClass"
         		onclick="window.location.href='<%=request.getContextPath()%>/operationRoomWuJiRuiServlet?opertion=4'"></th>
         </tr>
         </table>
  </body>
</html>
