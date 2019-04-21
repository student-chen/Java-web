<%@ page language="java" pageEncoding="gbk"%>
<jsp:directive.page
	import="com.tsinghuait.st0717.hospitalsystem.service.OperationRoomWuJiRuiService;" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>My JSP 'updateOprationRoom.jsp' starting page</title>
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
		<form
			action="<%=request.getContextPath()%>/operationRoomWuJiRuiServlet?opertion=3"
			method="post">
			<table  class="simple textCss">
				<c:forEach items="${showOperationRoom}" var="showoperationRoom">
					<tr>
    					<th align="center" width="30%">手术室编号</th>
						<td>
							<input type="text" value="${showoperationRoom.orNo}" name="orNo" class="txt">
							<input type="hidden" value="${showoperationRoom.id}" name="id">
						</td>
						<td></td>
					</tr>
					<tr>
    					<th align="center" width="30%">地&nbsp;&nbsp;&nbsp;址</th>
						<td>
							<input type="text" value="${showoperationRoom.address}" name="address" class="txt">
						</td>
						<td></td>
					</tr>
					<tr>
    					<th align="center" width="30%">备&nbsp;&nbsp;&nbsp;注</th>
						<td>
							<input type="text" value="${showoperationRoom.info}" name="info" class="txt">
						</td>
						<td></td>
					</tr>
					<%
						//调用 OperatingRoomService中的addoperationgetNurseListName
						String sql = "select *from nurse";
						OperationRoomWuJiRuiService operatingRoomService = new OperationRoomWuJiRuiService();
						request.setAttribute("nurselistName", operatingRoomService
								.addoperationgetNurseListName(sql));
					%>
					<tr>
						<th align="center" width="30%">护士列表</th>
						<td class="txt">
							<c:forEach items="${updatenurseNameList}" var="updatenurseNameList">
								<font color="blue">${updatenurseNameList.name} </font>
							</c:forEach>
							<%--   
	                 			 显示的护士是从UpdateOperationRoomServlet中的updatenurseNameList传过来的
	               			 --%>
						</td>
						<td>
							<select name="updateNurseName" onclick="nurseName();" multiple="multiple" size="3">
								<c:forEach items="${nurselistName}" var="nurselist">
									<option value="${nurselist.id}">
										${nurselist.name}
									</option>
								</c:forEach>
							</select>

							<%--
	              				 该护士列表是从该页面的〈%  %〉中的nurselistName中传过来的
	               			--%>
						</td>
					</tr>
					<tr>
						<th align="center" width="30%">是否空闲</th>
					    <td>
				   			<c:if test="${showoperationRoom.isUseable==1}">
				   			   <input type="radio" name="isUseable" value="1" checked>是
				   			   <input type="radio" name="isUseable" value="0">否
				   			</c:if>
				   			<c:if test="${showoperationRoom.isUseable==0}">
				   			    <input type="radio" name="isUseable" value="1">是
				   			    <input type="radio" name="isUseable" value="0" checked>否
				   			</c:if>  注:(是,否)
			   		    </td>					
		            </tr>
				</c:forEach>
				<tr>
					<td colspan="7" align="center">
						<input type="submit" value="修改" class="buttonClass">
						 <input type="button" value="返回" class="buttonClass" onclick="window.location.href='<%=request.getContextPath()%>/operationRoomWuJiRuiServlet?opertion=4'">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>