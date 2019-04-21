<%@ page language="java"  pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title>17医院医生护士操作--关爱健康，为您助行</title>
    <meta http-equiv="content-type" content="text/html;charset=gb2312">	
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
	<script type="text/javascript">
		function loadIsfinished(){
		<%
			Object isfinished=request.getAttribute("isfinished");
			if(isfinished!=null){
				if("1".equals(isfinished+"")){
		%>
				document.patientListFrom.chuli.checked=true;
		<%}else{
		%>
				document.patientListFrom.weichuli.checked=true;
		<%}}
		%>
		}
	</script>
  </head>  
  <body onload="loadIsfinished();">
    <form name="patientListFrom">
    	<table class="simple textCss">
    	<tr>
	    	<td colspan="6">病人处理状态:
	    		<input type="radio" name="isfinished" value="未处理"id="weichuli" 
	    			onclick="window.location.href='<%=request.getContextPath()%>/patientServlet?isfinished=0'">未处理病人&nbsp;&nbsp;&nbsp;&nbsp;
	    		<input type="radio" name="isfinished" value="处理"id="chuli" 
	    			onclick="window.location.href='<%=request.getContextPath()%>/patientServlet?isfinished=1'">处理过的病人
	    	</td>
    	</tr>
    		<tr class="simple">
    			<th align="center" width="12%">挂号号码</th>
    			<th align="center" width="12%">姓名</th>
    			<th align="center" width="10%">性别</th>
    			<th align="center" width="10%">年龄</th>
    			<th align="center" width="20%">科别</th>
    			<c:if test="${patientSer!=null}">
    				<th align="center" width="36%">操作</th>
    			</c:if>
    		</tr>
    		<c:forEach items="${patientSer}" var="patient">
    			<tr>
	    			<td align="center" width="12%">${patient.patientNo}</td>
	    			<td align="center" width="12%">
	    				<a href="<%=request.getContextPath()%>/topQueryServlet?opertion=2&oid=${patient.oid}">${patient.name}</a>
	    			</td>
	    			<td align="center" width="10%">${patient.sex}</td>
	    			<td align="center" width="10%">${patient.age}</td>
	    			<td align="center" width="20%">${patient.mcName}</td>
	    			<td align="center" width="36%">
						<input type="button" value="开诊断书" onclick="window.location.href='<%=request.getContextPath()%>/diagnosisServlet?opertion=4&name=${patient.name}&id=${patient.oid }'" class="patientButton">&nbsp;&nbsp;&nbsp;
						<input type="button" value="手术" onclick="window.location.href='<%=request.getContextPath()%>/operationServlet?opertion=4&name=${patient.name}&id=${patient.oid }'" class="patientButton">&nbsp;&nbsp;&nbsp;
						<input type="button" value="住院" onclick="window.location.href='<%=request.getContextPath()%>/inHospitalServlet?opertion=4&name=${patient.name}&id=${patient.oid }'" class="patientButton">
					</td>
    			</tr>
    		</c:forEach>
    		<c:forEach items="${patientSerIsfinished}" var="patie">
    			<tr>
	    			<td align="center" width="12%">${patie.patientNo}</td>
	    			<td align="center" width="12%">
	    				<a href="<%=request.getContextPath()%>/topQueryServlet?opertion=2&oid=${patie.oid}">${patie.name}</a>
	    			</td>
	    			<td align="center" width="10%">${patie.sex}</td>
	    			<td align="center" width="10%">${patie.age}</td>
	    			<td align="center" width="20%">${patie.mcName}</td>
	    			<td align="center" width="36%"></td>
    			</tr>
    		</c:forEach>
    	</table>
    </form>
  </body>
</html>
