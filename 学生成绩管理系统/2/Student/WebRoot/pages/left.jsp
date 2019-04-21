<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>left page</title>
		<link href="../css/left.css" rel="stylesheet" type="text/css" />
		<script src="../js/jquery-1.8.3.min.js"></script>
		<script src="../js/left.js"></script>
	</head>

	<body>
		<c:forEach items="${sessionScope.list}" var="pri">
			<div class="big">
				${pri.menu_name}
			</div>

			<div class="box">
				<c:forEach items="${sessionScope.list_privilege}" var="privilege">
					<c:choose>
						<c:when test="${privilege.menu_name == pri.menu_name}">
							<div class="small">
								<a href="${privilege.url}" target="main">${privilege.name}</a>
							</div>
						</c:when>
					</c:choose>
				</c:forEach>
			</div>
		</c:forEach>
	</body>
</html>