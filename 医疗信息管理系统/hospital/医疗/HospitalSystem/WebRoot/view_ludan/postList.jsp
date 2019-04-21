<%@ page language="java" contentType="text/html;charset=GBK" pageEncoding="gbk"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>科室操作</title>
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
  		    window.location.href="<%=request.getContextPath()%>/postServlets?opertion=2&doctorid="+e;
  	 }
	</script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/> 
</head>
<body class=".buttonClass">
<form action="<%=request.getContextPath()%>/postServlets?opertion=4" method="post" name="postLilstForms">
	<table class="simple textCss">
		<tr>
			<td width="15%" align="right" class="title">职称名称:</td>				
			<td width="40%" align="center" class="title"><input type="text" name="name" class="txt"></td>
			<td width="25%" class="title"><input type="submit" value="查询" class="buttonClass"></td>
			<td width="25%" class="title">
			<input type="button" value="添加职称" onclick="javaScript:window.location.href='<%=request.getContextPath()%>/view_ludan/addPost.jsp'" class="buttonClass">
			</td>
		</tr>
	</table>
	<c:if test="${not empty postList}">
		<table  class="simple textCss">
			<tr>
				<th width="10%" align="center" class="title">请选择
         			<input type="checkbox" name="selectedAll" onclick="go(this.form);"></th>
				<th align="center" class="title">职称名称</th>
				<th align="center" class="title">操作</th>
			</tr>
				<c:forEach items="${postList}" var="post">
				<tr>
					<td align="center"><input type="checkbox" value="${post.id}" name="c"></td>
					<td align="center">${post.name}</td>
					<td align="center">	
						<input type="button" value="删除" class="patientButton" onclick="window.location.href='<%=request.getContextPath()%>/postServlets?opertion=2&id=${post.id}'">&nbsp;&nbsp;
					    <input type="button" value="修改" class="patientButton" onclick="window.location.href='view_ludan/updatePost.jsp?id=${post.id}&name=${post.name}'">
					</td>
				</tr>
				</c:forEach>
			<tr>
				<td colspan="3" align="center">
				<input type="button" value="继续添加" onclick="javaScript:window.location.href='view_ludan/addPost.jsp'" class="buttonClass">
			    &nbsp;&nbsp;&nbsp;<input type="button" value="批量删除" onclick="Delete();" class="buttonClass">
				</td>
			</tr>
		</table>		
	</c:if>		
</form>
</body>
</html>