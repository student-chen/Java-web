<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>    
    <title>查看收据</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
    <script type="text/javascript">
    	function showPayMoney(){
    		  var obj=document.reforms.payMoney.value;
    		  if(obj==null){
    		  	alert("请付款...");
    		  	return false;
    		  }
    		 return true;
    	}
     function check(formq){
     	var id = formq.childNodes[0].firstChild.value;
     	var payMon = formq.childNodes[2].firstChild.value;
     	var payMoney = formq.childNodes[7].firstChild.value;
	   if(payMoney==""||payMoney==null){
	     alert("请输入要缴款的钱数!");
	     return false;
	   }else{
	   		if(payMon<=payMoney){
	   			alert("付款成功....");
	     		window.location.href="<%=request.getContextPath()%>/receiptServlet?opertion=3&id="+id+"&payMoney="+payMoney;
	     	}else{
	     		alert("请继续付款，你的钱数不够..");
	     		return false;
	     	}
	   	}
	 }
    </script>    
  </head>
  <body>
  <form method="post" name="reforms${receipt.id}" action="<%=request.getContextPath()%>/receiptServlet?opertion=4">
  <table class="simple textCss">
	  <tr>
	    <th width="5%" align="center">编号</th> 
	    <th width="10%" align="center">项目</th> 
	  	<th width="8%" align="center">金额</th>
	  	<th width="10%" align="center">收款人</th>
	  	<th width="10%" align="center">付款人</th>
	  	<th width="15%" align="center">日期</th>
	  	<th width="8%" align="center">是否收讫</th>
	  			<th width="10%" align="center">收款</th>
	  			<th width="10%" align="center">操作</th>
	  </tr>
	 <c:forEach items="${receiptList}" var="receipt">
		 <tr>
		 	 <td align="center"><input type="text" name="payMon" value="${receipt.id}" class="txt"></td>
		 	 <td align="center">${receipt.items}</td>
			 <td align="center"><input type="text" name="payMon" value="${receipt.pay}" class="txt"></td>
			 <td align="center">${receipt.payee}</td>
			 <td align="center">${receipt.payeeId}&nbsp;&nbsp;
			 	<a href="<%=request.getContextPath()%>/patientListServlet?opertion=3&oid=${receipt.payeeId}">付款人</a>
			 </td>
			 <td align="center">${receipt.pdate}</td>
			 <td align="center">
			 	<c:if test="${receipt.isFinished==1}">已交款</c:if>
			 	<c:if test="${receipt.isFinished==0}">未交款</c:if>
			 </td>
			<c:if test="${receipt.isFinished==0}">
			 <td align="center">
			 	<input type="text" name="payMoney" class="txt" value="" onkeyup="this.value=this.value.replace(/\D/g,'')">
			 </td>
			 <%--<td align="center">
			 	<input type="button" value="付款" class="buttonClass"
			 		onclick="window.location.href='<%=request.getContextPath()%>/receiptServlet?opertion=3&id=${receipt.id}'">
			 </td>			
			 --%>
			 <td align="center">
			 	<input type="button" value="付款" class="buttonClass" onclick="return check(this.parentNode.parentNode);">
			 </td>
			</c:if>
		 </tr>
	 </c:forEach>
	 <tr>
	 	<th colspan="8" align="center">
	 		<input type="button" value="已交款查询" class="buttonClass"
	 			onclick="window.location.href='<%=request.getContextPath()%>/receiptServlet?opertion=4&isFinsh=1&oid=${receipt.payeeId}'">
	 		<input type="button" value="未交款查询" class="buttonClass"
	 		onclick="window.location.href='<%=request.getContextPath()%>/receiptServlet?opertion=4&isFinsh=0&oid=${receipt.payeeId}'">
	 		<input type="button" value="返回" class="buttonClass" onClick="window.location.href='${pageContext.request.contextPath}/view_zhouxiaoli/patientsSelect.jsp'">
	 	</th>
	 </tr>
 </table>
 </form>
  </body>
</html>