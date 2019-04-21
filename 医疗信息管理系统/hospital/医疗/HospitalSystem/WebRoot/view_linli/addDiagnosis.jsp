<%@ page language="java" contentType="text/html;charset=GBK"%>
<html>
	<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
		<script type="text/javascript">
	  function mycheck() {
	     if(document.Operation.symptom.value==""){
	       alert("请填入病人的病情诊断");
	       return false;
	     }
	  }
	</script>
	</head>
	<body>
		<%
			String pName = (String) request.getAttribute("patientName");
			if (pName == null) {
				request.getRequestDispatcher("addDiagnosis.jsp");
			}
			System.out.print(pName);
		%>
		<form
			action="<%=request.getContextPath()%>/diagnosisServlet?opertion=1"
			method="post" name="Operation">
			<table class="simple textCss">
				<tr>
					<th colspan="2" align="center">添加病人的诊断书</th>
				</tr>
				<tr>
					<th width="30%" align="right">
						病人科别:
					</th>
					<td>
						<input type="text" name="type" width="50" height="10"
							value="<%=session.getAttribute("doctorLoginTree")%>" class="txt">
					</td>
				</tr>
				<tr>
					<th width="30%" align="right">
						病人姓名:
					</th>
					<td>
						<input type="text" name="patientName" value="<%=pName%>" class="txt">
						<input type="hidden" name="diaoid" value="<%=request.getAttribute("doid")%>">
					</td>
				</tr>
				<tr>
					<th width="30%"  align="right">
						病人病情诊断:
					</th>
					<td>
						<textarea name="symptom" width="20%" height="10%" class="txt"></textarea>
					</td>
				</tr>
				<tr>
					<th width="30%" align="right">
						医师签名:
					</th>
					<td>
						<input type="text" name="doctorName" width="50" height="10"
							value="<%=session.getAttribute("doctorName")%>" readOnly="true" class="txt">
					</td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						<input type="submit" value="提交" onclick="return mycheck()" class="buttonClass">
						<input type="reset" value="重置" class="buttonClass">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>