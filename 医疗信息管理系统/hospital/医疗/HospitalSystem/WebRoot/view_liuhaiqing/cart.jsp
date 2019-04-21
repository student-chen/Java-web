<%@page pageEncoding="gbk" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    response.setCharacterEncoding("gbk");
	response.setContentType("application/vnd.ms-excel;charset=gbk"); 
	response.setCharacterEncoding("gbk");
	response.setHeader("Content-Disposition","attachment; filename=\"cart.xls\"");	
%>
<html>
<head>
<title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
</head>
<body>
    <center>
    <form action="view_liuhaiqing/cart.jsp" method="post" name="f">
		    <%
		     	session.getAttribute("money");
		     %>
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
				<c:forEach items="${money}" var="Stat">
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
						     <c:out value="是"></c:out>
						   </c:when>
						   <c:otherwise>
						    <c:out value="否"></c:out>
						   </c:otherwise>
						  </c:choose>
						</td>
					</tr>
				</c:forEach>
			</table>
			<hr>
			统计：金额${all }元.
		 </form>
		</center> 
</body>
</html>