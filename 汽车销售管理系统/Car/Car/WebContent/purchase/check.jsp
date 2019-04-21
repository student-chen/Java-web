<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<link
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js">
	</script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/purchase/check.js">
	
</script>
<script src="${pageContext.request.contextPath}/js/layer/layer.js">
	
</script>
<STYLE type="text/css">
* {
	font-size: 12px;
}

tr {
	height: 40px;
}
</STYLE>

</head>

<body>
			<br>
			<div class="input-group" style="width: 65%; margin-left: 20px;">
				<span class="input-group-addon" style="background-color:white;">
					审核意见：
				</span> 
				<textarea class="form-control" id="note" rows="5"  placeholder="请输入申请备注"></textarea>
			</div><br>
			<div class="input-group">
				<button type="button" class="btn btn-info" style="background-color:#4b5f6f;margin-left: 60px;" id="agree">同意</button>
				<button type="button" class="btn btn-info" style="background-color:#4b5f6f;margin-left: 10px;" id="back">打回</button>
				<button type="button" class="btn btn-info" style="background-color:#4b5f6f;margin-left: 10px;" id="disagree">不同意</button>
			</div>
			<input type="hidden" id="path" value="${pageContext.request.contextPath}/">
			<input type="hidden" id="id" value="<%=request.getParameter("id")%>">
</body>
</html>
