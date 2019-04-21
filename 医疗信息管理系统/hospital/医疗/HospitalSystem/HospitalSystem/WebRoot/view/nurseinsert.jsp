<%@ page language="java" import="com.tsinghuait.st0717.hospitalsystem.service.NurseService,
	com.tsinghuait.st0717.hospitalsystem.service.PostService" pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
    <title>护士信息表</title>
   <script>
  function on(obj)
  		{
  		     var to=obj.value;
  		     window.location.href="nurseServlet?opertion=1";
  		}
  		
   function check(form)
  {
   if(form.staffNo.value=="")
   {
     alert("职工号不能为空");
   }
   else if(form.name.value=="")
   {
     alert("姓名不能为空");
   }
  else if(form.loginName.value=="")
   {
     alert("登录名不能为空");
   }
   else
   {
     document.f1.submit();
   }
 }
</script>
<%
		String sql="select * from post";
		PostService ps=new PostService();
		request.setAttribute("postlistSelected",ps.selectRowsPost(sql));
 %>
  <%
		String sql2="select * from nurse";
		NurseService ns=new NurseService();
		request.setAttribute("loginPasswordSelected", ns.selectNurse(sql2));
 %>
</head>

  <body>
  <form action="<%=request.getContextPath()%>/nurseServlet?opertion=1" method="post" name="f1">
    <div>
      <center>
      <table  class="simple textCss">
      <tr>
      <th colspan="4" valign="center" background="imgs/color/color_qianse.jpg">护士信息注册</th>
      </tr>
        <tr>
        	<th width="20%" align="center">职工号:</th>
        	<td width="40%"><input onkeyup="value=value.replace(/[^0-9\A-Z]/g,'')" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^0-9\A-Z]/g,''))" class="txt" name="staffNo"></td><%--只能输入数字和大写字母--%>
        	<td width="40%" align="left">备注：职工号为护士工作的标志 如:HD[1076]</td>
        	<td></td>
       </tr>
        <tr>
        	<th width="20%" align="center">姓名:</th>
        	<td width="40%"><input onkeyup="value=value.replace(/[^\u4E00-\u9FA5\A-Za-z]/g,'')" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\u4E00-\u9FA5\A-Za-z]/g,''))" class="txt" name="name"></td><%--允许下划线,数字字母和汉字
        --%></tr>
        <tr>
        	<th width="20%" align="center">性别:</th>
        	<td width="40%"><input type="radio" name="sex" value="男" checked="checked">
               <img src="<%=request.getContextPath()%>/imgs/sex/boy.GIF">&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="sex" value="女">
               <img src="<%=request.getContextPath()%>/imgs/sex/girl.GIF"></td><td></td>
        </tr>
        <tr>
        	<th width="20%" align="center">职称:</th>
        	<td width="40%">
        	<select name="post">
                     <c:forEach items="${postlistSelected}" var="ps">
                         <option value="${ps.id},${ps.name}">${ps.name}</option>
                      </c:forEach>         
                 </select>
             </td>
             <td>备注：请选择该护士的相应职称</td>
        </tr>
        <tr>
        	<th width="20%" align="center">登录名:</th>
        	<td width="40%"><input onkeyup="value=value.replace(/[^\u4E00-\u9FA5\A-Za-z]/g,'')" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\u4E00-\u9FA5\A-Za-z]/g,''))" class="txt" name="loginName"></td><%--允许下划线,数字字母和汉字
        --%></tr>
        <tr>
        	<th width="20%" align="center">登录密码:</th>
        	<td width="40%">
        		<input type="text" name="loginPassword" value="123"disabled="disabled" class="txt">	
        	</td><td>注:登录后请修改密码..</td>
       </tr>
        <tr>
        	<th width="20%" align="center">是否激活:</th>
        	<td width="40%"><input type="radio" name="isActive" value="1" checked>是
        		<input type="radio" name="isActive" value="0">否</td>
       </tr>
        <tr>
        	<td colspan="12" background="imgs/color/color_qianse.jpg"></td>
        </tr>
        <tr>
        	<td colspan="3" align="center">
        	<input type="button" value="提交" class="buttonClass" onclick="check(this.form)">
        	<input type="reset" value="取消" class="buttonClass">
        	</td>
       </tr>
      </table>
      </center>
      </div>
    </form>
   </body>
</html>
