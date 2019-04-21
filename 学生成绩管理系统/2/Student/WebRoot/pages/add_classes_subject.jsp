<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>subject_regist page</title>
		<link href="../css/add_class_subject.css" rel="stylesheet"
			type="text/css" />
		<script src="../js/jquery-1.8.3.min.js" type="text/javascript">
	
</script>
		<script src="../js/add_classes_subject.js" type="text/javascript">
	
</script>
		<script src="../js/search.js">
	
</script>
	</head>

	<body>

		<div class="main">
			<form action="/Student/AddCla2SubServlet" method="post">
				<c:if test="${sessionScope.message!=null}">
					<input type="hidden" value="${sessionScope.message}" id="message" />
				</c:if>
				<c:remove var="message" scope="session" />
				<p class="s1">
					添加班级课程
				</p>
				<br />
				<br />
				<p style="padding: 3px;">
					选 择 &nbsp; 班 级：
					<select id="cla_id" name="cla_id">
						<option value="0">
							请选择班级
						</option>
						<c:forEach items="${sessionScope.list_classes}" var="text">
							<option value="${text.id}">
								${text.name}
							</option>
						</c:forEach>
					</select>
				</p>
				<p>
					选 择 主 讲 教 &nbsp;师：
					<select id="tec_id" name="tec_id">
						<c:forEach items="${sessionScope.list_teacher}" var="teacher">
							<option value="${teacher.id}">
								${teacher.name}
							</option>
						</c:forEach>
					</select>
				</p>
				<br />
				<p>
					可选课程：
				</p>
				<br />
				<div id="select_able">

				</div>
				<p>
					已选课程：
				</p>
				<br />
				<div id="select_unable">

				</div>
				<br />
				<input style="width: 65px; height: 30px;" type="submit"
					value=" 提 交 " />
			</form>
		</div>
	</body>
</html>