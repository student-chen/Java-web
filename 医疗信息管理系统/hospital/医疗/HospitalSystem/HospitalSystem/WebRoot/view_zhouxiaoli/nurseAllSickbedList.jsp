<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>查看手术室</title>
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Css/LightBlue_Css.css" />
	</head>
	<body>
		<form action="${pageContext.request.contextPath}/operatingRoomServlet?opertion=0"
			method="post">
			<input type="button" class="buttonClass" value="空手术室"
				onClick="window.location.href='<%=request.getContextPath()%>/operatingRoomServlet?opertion=1&isUseable=true'">
			<input type="button" value="已用手术室" class="buttonClass"
				onClick="window.location.href='<%=request.getContextPath()%>/operatingRoomServlet?opertion=1&isUseable=false'">
			<table class="simple textCss">
				<tr>
					<th colspan="8" align="center">
						手术室表
					</th>
				</tr>
				<tr>
					<th width="7%" align="center">
						手术室编号
					</th>
					<th width="10%" align="center">
						类型
					</th>
					<th width="20%" align="center">
						地址
					</th>
					<th width="20%" align="center">
						备注
					</th>
					<%--<th width="10%" align="center">
						护士列表
					</th>
					--%><th width="10%" align="center">
						是否空闲
					</th>
					<th width="15%" align="center">
						操作
					</th>
				</tr>
				<c:forEach items="${operatingRoomList}" var="operating">
					<tr>
						<td>
							${operating.orNo}
						</td>
						<td>
							${operating.type}
						</td>
						<td>
							${operating.address}
						</td>
						<td>
							${operating.info}
						</td><%--
						<td>
							${operating.nurseList}
						</td>
						--%><td>
							<c:if test="${operating.isUseable==1}">是</c:if>
							<c:if test="${operating.isUseable==0}">否</c:if>
						</td>
						<td>
							<input type="button" class="buttonClass" value="删除" 
							onclick="window.location.href='<%=request.getContextPath()%>/operatingRoomServlet?opertion=2&id=${operating.id}'">
						</td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</body>
</html>
