<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title>查看病人详细信息</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
	<script type="text/javascript">
  		function onch(){
  			var page = document.patientListFormsabc.textPages.value;
  			if(page==null||page==0||page==""){
  				alert("请输入要查询的有效页数！");
  				return;
  			}
  			window.location.href ="<%=request.getContextPath()%>/patientListServlet?opertion=4&num=1&page="+page;
  		}   
	</script>
  </head>
  <body>
  <form action="<%=request.getContextPath()%>/patientListServlet?opertion=4" method="post" name="patientListFormsabc">
  <table class="simple textCss">
 <tr>
  	<td class="title">
  		<input type="submit" value="查询全部" class="buttonClass" onClick="window.location.href='<%=request.getContextPath()%>/patientListServlet?opertion=4&num=1'">
  		&nbsp;&nbsp;&nbsp;<input type="button" value="按内科查询" class="buttonClass" onClick="window.location.href='<%=request.getContextPath()%>/patientListServlet?opertion=4&num=2'">
  		&nbsp;&nbsp;&nbsp;<input type="button" value="按外科查询" class="buttonClass" onClick="window.location.href='<%=request.getContextPath()%>/patientListServlet?opertion=4&num=3'">
  		&nbsp;&nbsp;&nbsp;<input type="button" value="已处理的病人" class="buttonClass" onClick="window.location.href='<%=request.getContextPath()%>/patientListServlet?opertion=4&num=4'">
  		&nbsp;&nbsp;&nbsp;<input type="button" value="未处理的病人" class="buttonClass" onClick="window.location.href='<%=request.getContextPath()%>/patientListServlet?opertion=4&num=5'">
  	</td>
 </tr>	
 </table>
  <table  class="simple textCss">
  <tr>
  	<th width="10%" align="center">病人编号</th>
  	<th width="10%" align="center">姓名</th>
  	<th width="5%" align="center">性别</th>
  	<th width="15%" align="center">地址</th>
  	<th width="5%" align="center">年龄</th>
  	<th width="10%" align="center">是否处理</th>
  	<th width="10%" align="center">科别</th>
	<th width="15%" align="center">操作</th>
  </tr>
  <c:forEach items="${patientList}" var="patient">
  <tr>
  		<td width=10% align="center">${patient.patientNo}</td>
    	<td width=10% align="center">${patient.name}</td>
    	<td width=5% align="center">${patient.sex}</td>
    	<td width=15% align="center">${patient.address}</td>
    	<td width=5% align="center">${patient.age}</td>
    	<td width=10% align="center">
    		<c:if test="${patient.isfinished==1}">已处理</c:if>
    		<c:if test="${patient.isfinished==0}">未处理</c:if>
    	</td>
    	<td width=10% align="center">${patient.mcName}</td>
    	<td width=15% align="center">
			<input type="button" value="删除"
							onclick="window.location.href='<%=request.getContextPath()%>/patientListServlet?opertion=2&oid=${patient.oid}'"
							class="buttonClass">
		</td>
 </tr>  
  </c:forEach>
    </table>
   <table class="simple textCss">
		<tr>
   			<td align="right" width=100% colspan="5">共<font color="red">${page.pageNum}</font>个搜索结果&nbsp;&nbsp;&nbsp;共有<font color="red">${page.lastPage}</font>页
   			&nbsp;&nbsp;&nbsp;当前是第<font color="red">${page.pageSize}</font>页&nbsp;&nbsp;&nbsp;
   			<input type="button" value="第一页" class="patientButton" onclick="window.location.href='<%=request.getContextPath()%>/patientListServlet?opertion=4&page=1&num=${page.currentType}'">&nbsp;&nbsp;&nbsp;
   			<input type="button" value="上一页" class="patientButton" onclick="window.location.href='<%=request.getContextPath()%>/patientListServlet?opertion=4&page=${page.priorPage}&num=${page.currentType}'">&nbsp;&nbsp;&nbsp;
   			<input type="button" value="下一页" class="patientButton" onclick="window.location.href='<%=request.getContextPath()%>/patientListServlet?opertion=4&page=${page.nextPage}&num=${page.currentType}'">&nbsp;&nbsp;&nbsp;
   			<input type="button" value="最后页" class="patientButton" onclick="window.location.href='<%=request.getContextPath()%>/patientListServlet?opertion=4&page=${page.lastPage}&num=${page.currentType}'">&nbsp;&nbsp;&nbsp;
   			跳到第&nbsp;<input type=text name="textPages" value="1" size="7" onkeyup="this.value=this.value.replace(/\D/g,'')">
   			页&nbsp;&nbsp;&nbsp;<input type="button" value="GO" onclick="onch();" class="patientButton">&nbsp;&nbsp;&nbsp;</td>
   		</tr>
   	</table>
 </form>
  </body>
</html>
