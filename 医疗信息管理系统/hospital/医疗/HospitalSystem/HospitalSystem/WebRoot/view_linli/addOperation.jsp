<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
	<script type="text/javascript" src="${pageContext.request.contextPath }/time.js"></script>
		<script type="text/javascript">
		function my(){
	        var today=new Date();
		    var reg=new RegExp(/^[-\+]?\d+(\.\d+)?$/);
            if(document.frm.pay.value=="") {
               alert("请输入病人所需费用"); 
                return false;
            }
            else if(!reg.test(document.frm.pay.value)){
                alert("请在费用栏中填入数字");
                return false;
            }
           else if(document.frm.date.value==""){
	            alert('请选择手术日期');
	            return false;
	       }
	  <%--     else if(document.frm.date.value<=today)
	       {
	             alert('对不起，您只能安排当天或以后的手术');
	             return false;
	       }--%>
	     }
	</script>
	</head>
	<%
		String name = (String) request.getAttribute("pName").toString();
		String oids = request.getAttribute("oid").toString();
	%>
	<body onload="loadType();">
		<form
			action="<%=request.getContextPath()%>/operationServlet?opertion=1"
			method="post" name="frm" id="forforms">
			<table class="simple textCss">
				<tr>
					<th colspan="2" align="center">添加病人的手术单</th>
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
						<input type="hidden" name="pId" value="<%=oids%>">
						<input type="text" name="patientName" value="<%=name%>" class="txt">
					</td>
				</tr>
				<%--<td width="10%" align="center">手术日期:</td>
            <td><select name="checkbox1" id="year" onchange="toDate()">
		             <script>
						var today=new Date();
						  for(var i=today.getYear();i<=today.getYear()+100;i++)
						   {
						      document.write("<option>"+i+"</option> selected");
						   }
					 </script>
		        </select>年
	    	    <select name="checkbox2" id="month" onchange="toDate()">
		             <script>
			             for(var i=1;i<=12;i++)
			             {
				           document.write("<option>"+i+"</option> selected");
			             }
		              </script>
		        </select>月
		        <select name="checkbox3" id="day">
		              <script>
							for(var i=1;i<=31;i++)
							{
								document.write("<option>"+i+"</option> selected");
							}
	                  </script>
		        </select>日
	        </td>
      --%>
				<tr>
					<th width="30%" align="right">
						手术室编号:
					</th>
					<td>
						<select name="No">
							<c:forEach items="${roomOrNo}" var="no">
								<option>
									${no.orNo }
								</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<th width="30%" align="right">
						手术日期:
					</th>
					<td>
						<input type="text" name="date" size="30" style="CURSOR:hand"
							onclick="setday(this)" class="txt">
					</td>
				</tr>
				<tr>
					<th width="30%" align="right">
						手术开始时间:
					</th>
					<td>
						<select name="shour">
							<%
							for (int sh = 8; sh <= 24; sh++) {
							%>
							<option>
								<%=sh%>
							</option>
							<%
							}
							%>
						</select>
						时
						<select name="sminute">
							<option>
								00
							</option>
							<option>
								20
							</option>
							<option>
								40
							</option>
						</select>
						分
					</td>
				</tr>
				<tr>
					<th width="30%" align="right">
						手术结束时间:
					</th>
					<td>
						<select name="ehour">
							<%
							for (int eh = 8; eh <= 24; eh++) {
							%>
							<option>
								<%=eh%>
							</option>
							<%
							}
							%>
						</select>
						时
						<select name="eminute">
							<option>
								00
							</option>
							<option>
								20
							</option>
							<option>
								40
							</option>
						</select>
						分
					</td>
				</tr>
				<tr>
					<th width="30%" align="right">
						病人所需支付金额:
					</th>
					<td>
						<input type="text" name="pay" class="txt">￥
					</td>
				</tr>
				<tr>
					<th width="30%" align="right">
						辅助医师姓名:
					</th>
					<td>
						<select name="extDoctorName">
							<c:forEach items="${DoctorName}" var="dn">
								<option>
									${dn.name}
								</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<th width="30%" align="right">
						主刀医师签名:
					</th>
					<td>
						<input name="pkDoctorName"
							value="<%=session.getAttribute("doctorName")%>" readOnly="true" class="txt">
					</td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						<input type="submit" value="提交" class="buttonClass" onClick="return my()">
						<input type="reset" value="重置" class="buttonClass">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
