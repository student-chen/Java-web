<%@ page language="java" pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
	</head>
	<body>
		<table class="simple textCss">
			<tr class="simple">
				<th align="center" width="12%">
					挂号号码
				</th>
				<th align="center" width="12%">
					姓名
				</th>
				<th align="center" width="10%">
					性别
				</th>
				<th align="center" width="10%">
					年龄
				</th>
				<th align="center" width="20%">
					科别
				</th>
				<c:if test="${diagnoPatient!=null}">
					<th align="center" width="36%">
						操作
					</th>
				</c:if>
			</tr>
			<c:forEach items="${diagnoPatient}" var="patient">
				<tr>
					<td align="center" width="12%">
						${patient.patientNo}
					</td>
					<td align="center" width="12%">
						<a
							href="<%=request.getContextPath()%>/topQueryServlet?opertion=2&oid=${patient.oid}">${patient.name}</a>
					</td>
					<td align="center" width="10%">
						${patient.sex}
					</td>
					<td align="center" width="10%">
						${patient.age}
					</td>
					<td align="center" width="20%">
						${patient.mcName}
					</td>
					<td align="center" width="36%">
						<input type="button" value="诊断书"
							onclick="window.location.href='<%=request.getContextPath()%>/diagnosisServlet?opertion=4&name=${patient.name}&id=${patient.oid }'"
							class="buttonClass">
						&nbsp;&nbsp;&nbsp;
					</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>
