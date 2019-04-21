<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="Css/LightBlue_Css.css">
		<script type="text/javascript"
			src="${pageContext.request.contextPath }/time.js">
	</script>
		<script type="text/javascript">
	 function mycheck() {
	     <%--    var today=new Date();--%>
	    if(document.form.startdate.value=="")  {
	      alert('请选择住院日期');
	      return false;
	    }
	    else if(document.form.enddate.value=="") {
	      alert('请选择出院日期');
	      return false;
	    }
	    else if(document.form.startdate.value==""&&document.form.enddate.value=="")
	    {
	      alert("请将该病人住院的信息填完整");
	      return false;
	    }  
	  <%--      else if(document.form.startdate.value!=today)
	    {
	      alert('对不起，您只能安排当天住院信息');
	      return false;
	    }--%>
	 } 
	</script>
	</head>
	<%
    String patientName=(String)request.getAttribute("pName").toString();
    String oid=request.getAttribute("oid").toString();
    %>
	<body>
		<form action="<%=request.getContextPath()%>/inHospitalServlet?opertion=1" method="post" name="form">
			<table class="simple textCss">
				<tr>
					<th colspan="2" align="center">添加病人住院</th>
				</tr>
				<tr>
					<th width="30%" align="right">
						病人科别:
					</th>
					<td>
						<input type="text" name="patientType"
							value="<%=session.getAttribute("doctorLoginTree")%>"
							readOnly="true" class="txt">
					</td>
				</tr>
				<tr>
					<th width="30%" align="right">
						病人姓名:
					</th>
					<td>
						<input type="hidden" name="pId" value="<%=oid%>">
						<input type="text" name="patientName" value="<%=patientName%>" class="txt">
					</td>
				</tr>
				<tr>
					<th width="30%" align="right">
						病床编号:
					</th>
					<td>
						<select name="bed">
							<c:forEach items="${bedNo}" var="bn">
								<option>
									${bn.bedNo}
								</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<th width="30%" align="right">
						住院日期:
					</th>
					<td>
						<input type="text" name="startdate" size="30" style="CURSOR:hand"
							onclick="setday(this)" class="txt">
					</td>
				</tr>
				<tr>
					<th width="30%" align="right">
						出院日期:
					</th>
					<td>
						<input type="text" name="enddate" size="30" style="CURSOR:hand"
							onclick="setday(this)" class="txt">
					</td>
				</tr>
				<tr>
					<th width="30%" align="right">
						医师签名:
					</th>
					<td>
						<input type="text" name="pId"
							value="<%=session.getAttribute("doctorName")%>" readOnly="true" class="txt">
					</td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						<input type="submit" value="提交" onClick="return mycheck()" class="buttonClass">
						<input type="reset" value="重置" class="buttonClass">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
