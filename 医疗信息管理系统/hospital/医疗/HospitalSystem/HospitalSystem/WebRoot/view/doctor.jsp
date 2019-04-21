<%@ page language="java"  pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
    <title>医生信息表</title>
    <script type="text/javascript">
		function loadIsActive(){
		<%
			Object active=request.getAttribute("isActiveType");
			if(active!=null){
				if("0".equals(active+"")){
		%>
				document.doctorForms.weizaizhi.checked=true;
		<%}else{
		%>
				document.doctorForms.zaizhi.checked=true;
		<%}
		}
		%>
		}
	</script>
	<script type="text/javascript">
  		function onch(){
  			var page = document.doctorForms.textPages.value;
  			if(page==null||page==0||page==""){
  				alert("请输入要查询的有效页数！");
  				return;
  			}
  			window.location.href ="<%=request.getContextPath()%>/doctorServlet?opertion=4&page="+page;
  		}
	</script>
	<script type="text/javascript">
	function go(form){
  		  if(form.selectedAll.checked) {
	  		   for(var i=0;i<form.elements.length;i++){
	  		        var e=form.elements[i];
	  		        if(e.type=="checkbox") {
	  		          e.checked=true;
	  		        }
	  		     }
	  		   } 
  		  else if(!form.selectedAll.checked){
	  		    for(var i=0;i<form.elements.length;i++){
	  		        var e=form.elements[i];
	  		        if(e.type=="checkbox"){
	  		          e.checked=false;
	  		        }
	  		     }
  		  }
  	  }
  		function goto(obj) {
      	document.forms[1].submit();
      }      
      function Delete(){
  		    var e="";
  		    if(document.all.c.length){
  		    var emp=document.all.c.length;
  		    for(var i=0;i<emp;i++){
  		       if(document.all.c[i].checked){
  		        e+=document.all.c[i].value+";";
  		       }
  		    }
  		  } else{
  		     e+=document.all.c.value+";"
  		    }
  		    e=e.substring(0,e.length-1)
  		    window.location.href="<%=request.getContextPath()%>/doctorServlet?opertion=2&doctorid="+e;
  	 }
	</script>
	${alertMsg} 
   </head>
  <body onload="loadIsActive();">
 <form action="<%=request.getContextPath()%>/doctorServlet?opertion=4" method="post" name="doctorForms">
	 <table class="simple textCss">
	 	<tr>
	 		<td width="25%" align="center" class="title">按类型查询:</td>
	 		<td width="20%" align="center" class="title">
	 			<select name="Scount">
	 				<option value="staffNo">职工号</option>		
	 				<option value="name" selected="selected">姓名</option>		
	 				<option value="post">职称</option>		
	 				<option value="mcName">科别</option>				
	 			</select>
	 		</td>
	 		<td width="40%" class="title">
		    	<input type="text" name="name" class="txt">
	 		</td>
	 		<td width="20%" class="title">
		    	<input type="submit" value="查询" class="buttonClass">
	 		</td>
	 	</tr>
	 </table>
      <table  class="simple textCss">
      <tr>
      	<th colspan="11" align="center" class="title">医生信息表</th>
      </tr>
      <tr><%--
        <th width="5%" align="center">选择
         <input type="checkbox" name="selectedAll" onclick="go(this.form);"></th>
        --%><th width="5%" align="center">职工号</th>
        <th width="7%" align="center">姓名</th>
        <th width="9%" align="center">职称</th>
        <th width="5%" align="center">性别</th>        
        <th width="12%" align="center">出生日期</th>
        <th width="10%" align="center">科别名称</th>
        <th width="7%" align="center">登录名</th>
        <th width="25%" align="center">备注</th>
        <th width="6%" align="center">是否在职</th>
        <th width="15%" align="center">操作</th>
      </tr>
      <tr>
	     <td colspan="11" background="imgs/color/color_qianse.jpg"></td>
	  </tr>
     <c:forEach items="${doctorservice}" var="doctor">
     <tr><%--
    		        <td><input type="checkbox" value="${doctor.id}" name="c"></td>
	    			--%><td align="center">${doctor.staffNo}</td>
	    			<td align="center">${doctor.name}</td>
	    			<td align="center">${doctor.post}</td>
	    			<td align="center">${doctor.sex}</td>
	    			<td align="center">${doctor.birthday}</td>
	    			<td align="center">${doctor.mcName}</td>
	    			<td align="center">${doctor.loginName}</td>
	    			<td align="center">${doctor.info}</td>
	    			<td align="center">
	    				<c:if test="${doctor.isActive==1}">在职</c:if>
	    				<c:if test="${doctor.isActive==0}">未在职</c:if>
	    			</td>
	    			<td align="center">
	    				<a href="<%=request.getContextPath()%>/doctorServlet?opertion=2&id=${doctor.id}">删除</a>
	                    <a href="view/doctorupdate.jsp?id=${doctor.id}">修改</a></td>
	  </tr>
	</c:forEach>
	  <tr>
	  	  <td colspan="11" align="right">
    				<font color=red>◆★◆☆
    		医生在职状态(是否激活):</font>0未在职,1在职:
	    	<input type="radio" name="active" value="未在职"id="weizaizhi" onclick="window.location.href='doctorServlet?opertion=4&isActive=0'">未在职&nbsp;&nbsp;&nbsp;&nbsp;
	    	<input type="radio" name="active" value="在职" id="zaizhi" onclick="window.location.href='doctorServlet?opertion=4&isActive=1'">在职员工
	     </td>    	
	  </tr>
   </table>
   <table class="simple textCss">
		<tr>
   			<td align="right" width=100% colspan="5">共<font color="red">${page.pageNum}</font>个搜索结果&nbsp;&nbsp;&nbsp;共有<font color="red">${page.lastPage}</font>页
   			&nbsp;&nbsp;&nbsp;当前是第<font color="red">${page.pageSize}</font>页&nbsp;&nbsp;&nbsp;
   			<input type="button" value="第一页" class="patientButton" onclick="window.location.href='<%=request.getContextPath()%>/doctorServlet?opertion=4&page=1&isActive=${page.isActive}'">&nbsp;&nbsp;&nbsp;
   			<input type="button" value="上一页" class="patientButton" onclick="window.location.href='<%=request.getContextPath()%>/doctorServlet?opertion=4&page=${page.priorPage}&isActive=${page.isActive}'">&nbsp;&nbsp;&nbsp;
   			<input type="button" value="下一页" class="patientButton" onclick="window.location.href='<%=request.getContextPath()%>/doctorServlet?opertion=4&page=${page.nextPage}&isActive=${page.isActive}'">&nbsp;&nbsp;&nbsp;
   			<input type="button" value="最后页" class="patientButton" onclick="window.location.href='<%=request.getContextPath()%>/doctorServlet?opertion=4&page=${page.lastPage}&isActive=${page.isActive}'">&nbsp;&nbsp;&nbsp;
   			跳到第&nbsp;<input type=text name="textPages" value="1" size="7" onkeyup="this.value=this.value.replace(/\D/g,'')">
   			页&nbsp;&nbsp;&nbsp;<input type="button" value="GO" onclick="onch();" class="patientButton">&nbsp;&nbsp;&nbsp;</td>
   		</tr>  
   	</table>
   	<table>
   		<tr>
   			<td align="center">
   			<input type="button" value="添加" onclick="window.location.href='view/doctorinsert.jsp'" class="buttonClass">
		    &nbsp;&nbsp;&nbsp;&nbsp;
		    <%--<input type="button" value="批量删除" onclick="Delete()" class="buttonClass">
   			--%></td>
   		</tr>
   	</table>
    </form>
    </body>
</html>     