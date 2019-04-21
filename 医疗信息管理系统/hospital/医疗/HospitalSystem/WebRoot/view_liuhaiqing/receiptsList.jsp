<%@ page language="java" import="com.tsinghuait.st0717.hospitalsystem.dto.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
  response.setIntHeader("Refresh",10);
 %>
<html>
  <head>
    <title>收据维护</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
    <script type="text/javascript">
    	 function onch(obj)
			{
			   var page = obj.value;
			   window.location.href="receiptLiuHaiQingServlet?operation=0&page="+page;
			}
    </script>
  </head>
  <body>
  		<form method="post">
			<table class="simple textCss">
				<tr>
					<td>
					  <input type="radio" name="Stat" value="0" onclick="window.location.href='<%=request.getContextPath()%>/Stat1Servlet?operation=0&Stat=0'">未收费
					  <input type="radio" name="Stat" value="1" onclick="window.location.href='<%=request.getContextPath()%>/Stat1Servlet?operation=0&Stat=1'" checked>收费
					</td>
				</tr>
				<tr>
					<th width="30%" align="center">
						项目
					</th>
					<th width="10%"align="center">
						金额
					</th>
					<th width="10%"align="center">
						收款人
					</th>
					<th width="20%"align="center">
						付款人
					</th>
					<th width="20%"align="center">
						日期
					</th>
					<th width="10%"align="center">
						是否收讫
					</th>
				</tr>
				<c:forEach items="${receiptlist}" var="post">
					<tr>
						<td align="center">
							${ post.items }&nbsp;
						</td>
						<td align="center">
							${ post.pay }&nbsp;
						</td>
						<td align="center">
							${ post.payee }&nbsp;
						</td>
						<td align="center">
							${post.name}&nbsp;
						</td>
						<td align="center">
							${ post.pdate }&nbsp;
						</td>
						<td align="center">
						  <c:choose>
						   <c:when test="${ post.isFinished ==0}">
						     <c:out value="否"></c:out>
						   </c:when>
						   <c:otherwise>
						    <c:out value="是"></c:out>
						   </c:otherwise>
						  </c:choose>&nbsp;&nbsp;
						</td>
					</tr>
				</c:forEach>
			</table>
				<%
				  PageFairy pf = (PageFairy)request.getAttribute("pageFairy");
				 %>		
		   <table class="simple textCss">
				<tr>
		   			<td align="center" width=100% colspan="5">
		   			<input type="button" value="第一页" class="patientButton" onclick="window.location.href='<%=request.getContextPath()%>/receiptLiuHaiQingServlet?operation=0&page=1'">&nbsp;&nbsp;&nbsp;
		   			<input type="button" value="上一页" class="patientButton" onclick="window.location.href='<%=request.getContextPath()%>/receiptLiuHaiQingServlet?operation=0&page=<%=pf.getPriorPage()%>'">&nbsp;&nbsp;&nbsp;
		   			<input type="button" value="下一页" class="patientButton" onclick="window.location.href='<%=request.getContextPath()%>/receiptLiuHaiQingServlet?operation=0&page=<%=pf.getNextpage()%>'">&nbsp;&nbsp;&nbsp;
		   			<input type="button" value="最后页" class="patientButton" onclick="window.location.href='<%=request.getContextPath()%>/receiptLiuHaiQingServlet?operation=0&page=<%=pf.getPageCount()%>'">&nbsp;&nbsp;&nbsp;
		   			共<%=pf.getRowsCount() %>条纪录|共<%=pf.getPage() %>/<%=pf.getPageCount() %> 页|跳到
					<select name="x" onchange="onch(this);">
					<%
						int size = pf.getPageCount();
						for (int i=1;i<=size;i++){
							if (i==pf.getPage()){
								out.print("<option value="+i+" selected>"+i+"</option>");
							} else {
								out.print("<option value="+i+">"+i+"</option>");
							}
						}%>
				</select>
				页
					</td>
		   		</tr>  
		   		<tr>
		   			<td colspan="7" align="center">
		   				<input type="button" value="统计" class="buttonClass" onclick="window.location.href='view_liuhaiqing/Stat.jsp'">
		 			</td>
		   		</tr>
		   	</table>
		   </form>
  </body>
</html>
