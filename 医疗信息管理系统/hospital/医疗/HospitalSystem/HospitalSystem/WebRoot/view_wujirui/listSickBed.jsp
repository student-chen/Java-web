<%@ page language="java" pageEncoding="gbk"%>
<jsp:directive.page import="java.util.ArrayList" />
<jsp:directive.page import="java.util.Iterator" />
<jsp:directive.page
	import="com.tsinghuait.st0717.hospitalsystem.dto.Sickbed" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>My JSP 'listSickBed.jsp' starting page</title>
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Css/LightBlue_Css.css" />
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
			<%
				ArrayList arrayList = (ArrayList) request.getAttribute("sickbed");
				if (arrayList != null) {
					Iterator it = arrayList.iterator();
					if(it.hasNext()) {
						Sickbed sickbed = (Sickbed) it.next();
			%>
			<tr>
				<th align="center" colspan="3">病床表信息</th>
			</tr>
			<tr>
				<th width="30%" align="right">
					床位号:
				</th>
				<td><input type="text" value="<%=sickbed.getBedNo()%>" class="txt"></td>		
			</tr>
			<tr>
				<th width="30%" align="right">
					类&nbsp;&nbsp;型:
				</th>
				<td><input type="text" value="<%= sickbed.getType() %>" class="txt"></td>
			</tr>
			<tr>
				<th width="30%" align="right">
					是否空闲:
				</th>
				<td>
					<c:if test="<%=sickbed.getIsUseable() ==1%>"> 
						<input type="text" value=" 是 " class="txt">
					</c:if>
					<c:if test="<%=sickbed.getIsUseable() ==0%>">					
						<input type="text" value=" 否" class="txt">
					</c:if>
				</td>
			</tr>
			<tr>
				<th width="30%" align="right">相关护士:</th>
				<td class="txt">
					<c:forEach items="${showNurseList}" var="showNurseList"> ${showNurseList.name} </c:forEach>
				</td>
			</tr>
			<%}
			}else{
				%>      
	     <tr>
         	<th colspan="3">对不起，还没有安排相关护士</th>
         </tr>
         <%}%>
         <tr>
         	<th colspan="3">
         	<input type="button" value="返回" class="buttonClass"
         		onclick="window.location.href='<%=request.getContextPath()%>/sickBedServlet?opertion=4'"></th>
         </tr>
		</table>
	</body>
</html>