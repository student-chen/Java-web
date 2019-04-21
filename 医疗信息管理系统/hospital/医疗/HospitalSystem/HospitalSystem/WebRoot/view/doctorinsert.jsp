<%@ page language="java" import="com.tsinghuait.st0717.hospitalsystem.service.MedicalcoursesService,
com.tsinghuait.st0717.hospitalsystem.service.PostService" pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
    <title>医生信息表</title>
   <script>
   function toDate(){						//日期
		with(document.all){
			var vYear=parseInt(year.options[year.selectedIndex].text);
			var vMonth=parseInt(month.options[month.selectedIndex].text);
			day.length=0;
			for(i=0;i<(new Date(vYear,vMonth,0)).getDate();i++){
				day.options[day.length++].value=day.length;
				day.options[day.length-1].text=day.length;
			}
		}
   }
     function check(form){
	   if(form.staffNo.value==""){
	     alert("职工号不能为空");
	   }
	   else if(form.name.value=="") {
	     alert("姓名不能为空");
	   }
	   else if(form.info.value=="") {
	     alert("备注不能为空");
	   }
	    else if(form.loginName.value==""){
	     alert("登录名不能为空");
	   }
	   else{
	     document.f.submit();
	   }
	 }
</script>
<%
		String sql1="select * from medicalcourses";
		MedicalcoursesService medicalcoursesService=new MedicalcoursesService();
		request.setAttribute("medicalcoursesSelected", medicalcoursesService.selectRowsMedicalcourses(sql1));
 %>
 <%
		String sql="select * from post";
		PostService ps=new PostService();
		request.setAttribute("postlistSelected", ps.selectRowsPost(sql));
 %>
</head>
  <body>
  <form action="<%=request.getContextPath()%>/doctorServlet?opertion=1" method="post" name="f">
    <table class="simple textCss">
      <tr>
      <th colspan="4" valign="center" background="imgs/color/color_qianse.jpg">医生信息注册</th>
      </tr>
        <tr>
        	<th width="20%" align="right">职工号:</th>
        	<td width="40%"><input onkeyup="value=value.replace(/[^0-9\A-Z]/g,'')" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^0-9\A-Z]/g,''))" class="txt" name="staffNo"></td><%--只能输入数字和大写字母--%>
        	<td width="40%" align="left">备注：职工号为医生工作的标志 如:HD[1076]</td>
        	<td></td>
       </tr>
        <tr>
        	<th width="20%" align="right">姓名:</th>
        	<td width="40%"><input onkeyup="value=value.replace(/[^\u4E00-\u9FA5\A-Za-z]/g,'')" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\u4E00-\u9FA5\A-Za-z]/g,''))" class="txt" name="name"></td>
        	<%--允许字母和汉字--%>
        	</tr>
        <tr>
        	<th width="20%" align="right">职称:</th>
        	<td width="40%">
        		<select name="post">
                     <c:forEach items="${postlistSelected}" var="ps">
                         <option value="${ps.id},${ps.name}">${ps.name}</option>
                      </c:forEach>         
                 </select>
             </td>
             <td>备注：请选择该医生的相应职称</td>
        </tr>
        <tr>
        	<th width="20%" align="right">性别:</th>
        	<td width="40%"><input type="radio" name="sex" value="男" checked="checked">
               	<img src="<%=request.getContextPath()%>/imgs/sex/boy.GIF">&nbsp;&nbsp;&nbsp;
               <input type="radio" name="sex" value="女">
               <img src="<%=request.getContextPath()%>/imgs/sex/girl.GIF">
            </td><td></td>
        </tr>
        <tr>
        	<th width="20%" align="right">出生日期:</th>
			  <td width="40%">
			        <select name="checkbox1" id="year" onchange="toDate()">
						 <script type="text/javascript">
							var today=new Date();
							for(var i=1975;i<=today.getYear();i++){
								document.write("<option>"+i+"</option>");
							}
						</script>
					</select>年
					<select name="checkbox2" id="month" onchange="toDate()">
						 <script type="text/javascript">
							for(var i=1;i<=12;i++){
								document.write("<option>"+i+"</option>");
							}
						</script>
					</select>月
					<select name="checkbox3" id="day" >
						 <script type="text/javascript">
							for(var i=1;i<=31;i++){
								document.write("<option>"+i+"</option>");
							}
						</script>
					</select>日
			</td>
		</tr>
        <tr>
        	<th width="20%" align="right">备注:</th>
        	<td width="40%"><input type="text" name="info"class="txt"></td><td></td>
        </tr>
        <tr>
        	<th width="20%" align="right">科别名称:</th>
        	<td width="40%">
        		<select name="mcName">
                   <c:forEach items="${medicalcoursesSelected}" var="mc">
                       <option value="${mc.name}">${mc.name}</option>
                   </c:forEach>
               	</select>
            </td><td>备注：请选择该医生的工作科室</td>
        </tr>
        <tr>
        	<th width="20%" align="right">登录名:</th>
        	<td width="40%"><input onkeyup="value=value.replace(/[^\u4E00-\u9FA5\A-Za-z]/g,'')" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\u4E00-\u9FA5\A-Za-z]/g,''))" class="txt" name="loginName"></td>
        	<%--允许字母和汉字--%>
        <tr>
        	<th width="20%" align="right">登录密码:</th>
        	<td width="40%"><input type="text" name="loginPassword" value="123" disabled="disabled" class="txt"></td>
        	<td width="40%" align="left">备注：登录后请修改您的密码</td>
        </tr>
        <tr>
        	<th width="20%" align="right">是否激活:</th>
        	<td width="40%"><input type="radio" name="isActive" value="1" checked="checked">是
        		<input type="radio" name="isActive" value="0">否
        	</td>	
        </tr>
        <tr>
        	<td colspan="12" background="imgs/color/color_qianse.jpg"></td>
       	</tr>
        <tr>
        	<td colspan="12" align="center">
        	<input type="button" value="提交" class="buttonClass" onclick="check(this.form);">
        	<input type="reset" value="取消" class="buttonClass">
        	</td>
       </tr>
      </table>
    </form>
   </body>
</html>