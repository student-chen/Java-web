<%@ page language="java"  pageEncoding="GBK"%>
<jsp:directive.page import="com.tsinghuait.st0717.hospitalsystem.service.OperationRoomWuJiRuiService;"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>  
    <title>My JSP 'addSickBed.jsp' starting page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
    <script type="text/javascript">
     function check(form){
	   if(form.bedNo.value==""){
	     alert("病床编号不能为空");
	   }else{
	     document.formSickBed.submit();
	   }
	 }
    </script>
  </head>
  <body>
    <form action="${pageContext.request.contextPath}/sickBedServlet?opertion=1" method="post" name="formSickBed" onsubmit="return check(formSickBed);">
         <table class="simple textCss">
          	<tr>
	            <th align="center" colspan="2">添加病床信息</th>
            </tr>
          	<tr>
	            <th width="30%" align="right">病床号:</th>
	            <td><input type="text" name="bedNo" class="txt"></td>
            </tr>
            <tr>
	            <th width="30%" align="right">类&nbsp;&nbsp;&nbsp;型:</th>
	            <td>	            	
		            <input type="radio" name="type" value="一等级">一等级
		            <input type="radio" name="type" value="二等级">二等级
		            <input type="radio" name="type" value="三等级">三等级
		            <input type="radio" name="type" value="四等级" checked="checked">四等级
	            	<%--<input type="text" name="type" class="txt">--%>
	           </td>
            </tr>         
             <%  
            	String sql="select *from nurse";       
            	OperationRoomWuJiRuiService operatingRoomService=new OperationRoomWuJiRuiService();            	
		      	request.setAttribute("nurselistName",operatingRoomService.addoperationgetNurseListName(sql));
		     %>
            <tr>
            <th width="30%" align="right">护士列表:</th>
            <td>
                <select name="nurseNameList"  onclick="nurseName();" multiple="multiple" size="3">          
	               <c:forEach items="${nurselistName}" var="nurselist">
	                   <option value="${nurselist.id}">${nurselist.name}</option>
	               </c:forEach>
	            </select>
            </td>
            </tr> 
            <tr>
	            <th width="30%" align="right">是否空闲:</th>
	             <td>
	             	<input type="radio" name="isUseable" value="1">是
	             	<input type="radio" name="isUseable" value="0" checked="checked">否
	             </td>
            </tr>
            <tr>
	            <td colspan="2" align="center">
		            <input type="button" value="添加"  class="buttonClass" onclick="check(this.form);">&nbsp;&nbsp;
		            <input type="reset" value="重置" class="buttonClass">&nbsp;&nbsp;
		            <input type="button" value="返回" class="buttonClass" onclick="window.location.href='<%=request.getContextPath()%>/sickBedServlet?opertion=4'">
	            </td>
            </tr>
       </table>
       </form>
  </body>
</html>