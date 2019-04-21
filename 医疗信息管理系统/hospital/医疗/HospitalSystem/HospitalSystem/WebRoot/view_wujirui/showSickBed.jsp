<%@ page language="java" import="com.tsinghuait.st0717.hospitalsystem.dto.*" pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>My JSP 'showSickBed.jsp' starting page</title>
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
		<table  class="simple textCss">
					<tr>
						<th colspan="5" align="center">病床表信息</th>
					</tr>
					<tr>
						<%--<th width="10%" align="right">选择</th>
						--%>
						<th width="20%" align="right">床位号</th>
						<th width="20%" align="right">类型</th>
						<th width="20%" align="right">是否空闲</th>
						<th width="30%" align="right">操作</th>						
					</tr>
				<c:forEach items="${sickbedList}" var="sickbed">
					<tr>
						<%--<td align="center">
							<input type="checkbox" name="che">
						</td>
						--%><td align="center">
							<a href="<%=request.getContextPath()%>/showSickBedServlet?id=${sickbed.id}">${sickbed.bedNo}</a>
						</td>
						<td align="center">
							${sickbed.type}
						</td>
						<td align="center">
								<c:choose>
									<c:when test="${sickbed.isUseable==1}">
										<c:out value="是"></c:out>
									</c:when>
									<c:otherwise>
										<c:out value="否"></c:out>
									</c:otherwise>
								</c:choose>
						</td>
						<td align="center">
							<input type="button" value="删除" class="buttonClass"
								onclick="window.location.href='<%=request.getContextPath()%>/sickBedServlet?opertion=2&id=${sickbed.id}'">
							&nbsp;&nbsp;<input type="button" value="修改" class="buttonClass"
								onclick="window.location.href='<%=request.getContextPath()%>/updateSickBedServlet?&id=${sickbed.id}'">
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="5" align="center">
						<%--<input type="button" value="删除所选" class="buttonClass">
						--%>
						<input type="button" value="添加" class="buttonClass"
							onclick="window.location.href='${pageContext.request.contextPath}/view_wujirui/addSickBed.jsp'">
					</td>
				</tr>
			</table>
	</body>
</html>
