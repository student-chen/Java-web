<%@ page language="java" pageEncoding="gbk"%>
<jsp:directive.page
	import="com.tsinghuait.st0717.hospitalsystem.service.OperationRoomWuJiRuiService;" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>My JSP 'updateSickBed.jsp' starting page</title>
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Css/LightBlue_Css.css" />
		<style type="text/css">
<!--
a:link {text-decoration: none;}
a:visited {	text-decoration: none;}
a:hover {	text-decoration: none;}
a:active {	text-decoration: none; }
-->
</style>
	</head>
	<body>
		<form action="<%=request.getContextPath()%>/sickBedServlet?opertion=3"
			method="post">
			<center>
				<table class="simple textCss">
					<c:forEach items="${sickBedList}" var="sickBedList">
						<tr>
							<th align="center" width="30%">床位号</th>
							<td>
								<input type="text" value="${sickBedList.bedNo}" name="bedNo" class="txt">
								<input type="hidden" value="${sickBedList.id}" name="id">
							</td>
							<td></td>
						</tr>
						<tr>
    						<th align="center" width="30%">类&nbsp;&nbsp;&nbsp;型</th>
							<td>
								<input type="text" value="${sickBedList.type}" name="type" class="txt">
							</td>
							<td></td>
						</tr>
						<tr>
    						<th align="center" width="30%">是否空闲</th>
							<td>
								<c:if test="${sickBedList.isUseable==1}">
									<input type="radio" name="isUseable" value="1" checked>是
   			  						<input type="radio" name="isUseable" value="0">否
   								</c:if>
								<c:if test="${sickBedList.isUseable==0}">
									<input type="radio" name="isUseable" value="1">是
   			  					    <input type="radio" name="isUseable" value="0" checked>否
   								</c:if>
							</td>
							<td>注:(是,否)</td>
						</tr>
					</c:forEach>
					<%
						String sql = "select *from nurse";
						OperationRoomWuJiRuiService operatingRoomService = new OperationRoomWuJiRuiService();
						request.setAttribute("sickNurselistName", operatingRoomService
								.addoperationgetNurseListName(sql));
					%>
				<tr>
					<th align="center" width="30%">相关护士:</th>
					<td>
						<c:forEach items="${updatesickbedNurse}" var="updatesickbedNurse">
							<font color="blue">${updatesickbedNurse.name} </font>
						</c:forEach>
						<%--   
	                 	 显示的护士是从updateSickBedServlet中的updatesickbedNurse传过来的
	                	--%>
					</td>
					<td>
						<select name="sickNurseNameList" onclick="nurseName();" multiple="multiple" size="3">
							<c:forEach items="${sickNurselistName}" var="nurselist">
								<option value="${nurselist.id}">${nurselist.name}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
					<tr>
						<td colspan="3" align="center">
							<input type="submit" value="修改" class="buttonClass">&nbsp;&nbsp;&nbsp;
							<input type="button" value="返回" class="buttonClass" onclick="window.location.href='<%=request.getContextPath()%>/sickBedServlet?opertion=4'">
						</td>
					</tr>
				</table>
			</center>
		</form>
	</body>
</html>