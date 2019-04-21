<%@ page language="java" contentType="text/html; charset=gbk"
	pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
  response.setIntHeader("Refresh",10);
 %>
<html>
	<head>
		<title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
	</head>
	<body>
		<center>
			<%
					if (request.getAttribute("Statsptlist") != null)
					session.setAttribute("money", request
					.getAttribute("Statsptlist"));
				else {
			%>
			<script type="text/javascript">
			      alert("null");
			    </script>
			<%
			}
			%>
			<form action="view_liuhaiqing/cart.jsp" method="post" name="f">
				<table class="simple textCss">
					<tr>
						<th width="30%">
							项目
						</th>
						<th width="10%">
							金额
						</th>
						<th width="10%">
							收款人
						</th>
						<th width="10%">
							付款人
						</th>
						<th width="30%">
							日期
						</th>
						<th width="10%">
							是否收讫
						</th>
					</tr>
					<c:set var="all" value="0"></c:set>
					<c:forEach items="${Statsptlist}" var="Stat">
						<c:set var="all" value="${all+ Stat.pay }"></c:set>
						<tr>
							<td align="center">
								${ Stat.items }&nbsp;
							</td>
							<td align="center">
								${ Stat.pay }&nbsp;
							</td>
							<td align="center">
								${ Stat.payee }&nbsp;
							</td>
							<td align="center">
								${ Stat.name }&nbsp;
							</td>
							<td align="center">
								${ Stat.pdate }&nbsp;
							</td>
							<td align="center">
								<c:choose>
									<c:when test="${ Stat.isFinished ==0}">
										<c:out value="否"></c:out>
									</c:when>
									<c:otherwise>
										<c:out value="是"></c:out>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
					<tr>
						<td align="center" colspan="6">
						 <c:if test="${requestScope.finish ==1 }">
						   <input type="submit" value="下载成Excel" class="buttonClass">
						 </c:if>
						 <c:if test="${requestScope.finish ==0 }">
						  <input type="button" value="退出"
							onclick="window.location.href='${pageContext.request.contextPath}/receiptLiuHaiQingServlet?operation=0'" class="buttonClass" >
						 </c:if>
						</td>
					</tr>
				</table>
				<hr>
				统计：金额${all }元.
			</form>
		</center>
	</body>
</html>
