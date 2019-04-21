<%@ page language="java"
	import="com.tsinghuait.st0717.hospitalsystem.service.OperationRoomWuJiRuiService"
	pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>添加手术室信息</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
	
	<script type="text/javascript">
        function checkerror()  {
          var username=document.loginform.username.value;
          var password=document.loginform.password.value;
          var err=true;
          var errstr="验证错误:";        
          if(username==""||username.length<5||username.length>20)
          {
             err=false;
             errstr=errstr+"\n"+"用户名不能少于5位或超过20位字符";
          }
          if(password==""||password.length<3)
          {
            err=false;
            errstr=errstr+"\n"+"密码不能少于5位字符";
          }
          if(err==false)
          {
             alert(errstr);
             return false;
           }
           else
           {
              return true;
           }
        }
        function nurseName(){
        	if(document.formsRoomNurse.listName.selected){
        		var nameNurse=document.formNurseRoom.nurseName.value;
        		alert(nameNurse);
        		document.formNurseRoom.nurseListName.value=nameNurse;
        	}
        }		
	     function check(formNurseRoom){
	     var orNo=document.formNurseRoom.orNo.value;
	     var address=document.formNurseRoom.address.value;
	     var info=document.formNurseRoom.info.value;
	     var nurse=document.formNurseRoom.nurseName.value;
		   if(orNo==""){
		     alert("手术室编号不能为空");
		     return false;
		   }
          if(address=="" ) {
		     alert("地址不能为空");
		     return false;
		   }
       if(info=="" ){
		   		alert("备注不能为空!");
		   		return false;
		   }
		   
		   if(nurse=="" ){
		   		alert("护士不能为空!");
		   		return false;
		   }
		 }
    </script>
	</head>
	<body>
		<%--<form action="${pageContext.request.contextPath}/operationRoomWuJiRuiServlet?opertion=1"
			method="post" name="formNurseRoom" id="formsRoomNurse onsubmit="return check(formNurseRoom);">
			--%>
			<form action="${pageContext.request.contextPath}/operationRoomWuJiRuiServlet?opertion=1"
			method="post" name="formNurseRoom" id="formsRoomNurse" onsubmit="return check(formNurseRoom);">
			<table  class="simple textCss">
			<tr>
				<th colspan="2">添加手术室信息</th>
			</tr>
				<tr>
					<th width="30%" align="right">
						手术室编号:
					</th>
					<td>
						<input type="text" name="orNo" class="txt">
					</td>
				</tr>
				<tr>
					<th width="30%" align="right">
						地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址:
					</th>
					<td>
						<input type="text" name="address" class="txt">
					</td>
				</tr>
				<tr>
					<th width="30%" align="right">
						备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注:
					</th>
					<td>
						<input type="text" name="info" class="txt">
					</td>
				</tr>
				<%
					String sql = "select *from nurse";
					OperationRoomWuJiRuiService operatingRoomService = new OperationRoomWuJiRuiService();
					request.setAttribute("nurselistName", operatingRoomService
							.addoperationgetNurseListName(sql));
				%>
				<tr>
					<th width="30%" align="right">护&nbsp;士列表:</th>
					<td width="70%" align="center">
						<select name="nurseName" onclick="nurseName();" multiple="multiple" size="4">
							<c:forEach items="${nurselistName}" var="nurselist">
								<option value="${nurselist.id}">
									${nurselist.name}
								</option>
							</c:forEach>
						</select>
					</td>

				</tr>
				<tr>
					<th width="30%" align="right">
						是&nbsp;否空闲:
					</th>
					<td>
						<input type="radio" name="kongxian" value="1">是
						<input type="radio" name="kongxian" value="0" checked="checked">否
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
							<%--<input type="button" value="添加" class="buttonClass" onclick="this.check(this.form);">
							--%>
						<input type="submit" value="添加" class="buttonClass">
					  <input type="reset" value="重置"class="buttonClass">
				 <input type="button" value="返回" class="buttonClass" onclick="window.location.href='<%=request.getContextPath()%>/operationRoomWuJiRuiServlet?opertion=4'">
		
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
