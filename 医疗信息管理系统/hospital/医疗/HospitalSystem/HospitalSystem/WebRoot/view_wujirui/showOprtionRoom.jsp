<%@ page language="java" pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>My JSP 'showOprtionRoom.jsp' starting page</title>
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/Css/LightBlue_Css.css" />
		<script type="text/javascript">
        function ch(obj){
           var page=obj.value;
           window.location.href="${pageContext.request.contextPath}/operationRoomServlet?&opertion=4&page="+page;
        }          
		function loadRadioIsUseable(){
		<%
			Object type=request.getAttribute("isUseableType").toString();
			System.out.println("========="+request.getAttribute("isUseableType"));
			if(type!=null){
				if("0".equals(type+"")){
		%>
				document.formoper.feikongxian.checked=true;
		<%}else	if("1".equals(type+"")){
		%>
				document.formoper.kongxian.checked=true;
		<%}else{
		%>
				document.formoper.souyouxinxi.checked=true;
		<%}
		}
		%>
		}
   		</script>
	<style type="text/css">
	<!--
	a:link {text-decoration: none;}
	a:visited {	text-decoration: none;}
	a:hover {text-decoration: none;}
	a:active {text-decoration: none;}
	-->
	</style>
	</head>
	<body onload="loadRadioIsUseable();"> 
		<form action="${pageContext.request.contextPath }/operationRoomWuJiRuiServlet?opertion=4" method="post" name="formoper" id="formoper">
			<table class="simple textCss">
				<tr>
					<th width="20%">请输入要查询的名称：</th>
					<th width="35%">
						<input type="text" name="orNo" class="txt">
					</th>
					<th width="35%">
					    <input type="radio" name="isUseable" id="kongxian" value="1" checked>空闲
						<input type="radio" name="isUseable" id="feikongxian" value="0">非空闲
						<input type="radio" name="isUseable" id="souyouxinxi" value="2">所有信息
					</th>
					<th width="15%">
						<input type="submit" value="查询" class="buttonClass">
					</th>
				</tr>
			</table>
			<c:if test="${not empty requestScope.operationRoomList}">
				<table class="simple textCss">
					<tr>
						<th colspan="7" align="center">手术室表信息</th>
					</tr>
					<tr><%--
						<th width="7%" align="right">选择</th>
						--%>
						<th width="13%" align="right">手术室编号</th>
						<th width="20%" align="right">地址</th>
						<th width="20%" align="right">备注</th>
						<th width="10%" align="right">是否空闲</th>
						<th width="20%" align="right">操作</th>						
					</tr>
					<c:forEach items="${operationRoomList}" var="operationRoom">
						<tr>
							<%--<td align="center">
								<input type="checkbox" name="che">
							</td>
							--%><td align="center">
								<a href="<%=request.getContextPath()%>/showNurseServlet?id=${operationRoom.id}">${operationRoom.orNo}</a>
							</td>
							<td align="center">
								${operationRoom.address}
							</td>
							<td align="center">
								${operationRoom.info}
							</td>
							<td align="center">
								<c:choose>
									<c:when test="${operationRoom.isUseable==1}">
										<c:out value="是"></c:out>
									</c:when>
									<c:otherwise>
										<c:out value="否"></c:out>
									</c:otherwise>
								</c:choose>
							</td>
							<td align="center">
								<input type="button" value="删除" class="buttonClass"
									onclick="window.location.href='<%=request.getContextPath()%>/operationRoomWuJiRuiServlet?&opertion=2&id=${operationRoom.id}'">&nbsp;&nbsp;&nbsp;
								<input type="button" value="修改" class="buttonClass"
									onclick="window.location.href='<%=request.getContextPath()%>/updateOperationRoomServlet?id=${operationRoom.id}'">
							</td>
						</tr>
					</c:forEach>
				</table>
		</c:if>
		<table class="simple textCss">
				<tr>
					<td width="100%" align="center">
					<input type="button" value="添加" class="buttonClass"
					   onclick="window.location.href='<%=request.getContextPath()%>/view_wujirui/addOprationRoom.jsp'">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
