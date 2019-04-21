<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<link href="<c:url value="/bootstrap/css/main.css" />" type="text/css"
    rel="stylesheet" />
<title>查看个人信息</title>
<%-- <base href="<c:url value="/" />" /> --%>
<link href="<c:url value="/bootstrap/css/bootstrap.min.css"/>"  type="text/css" rel="stylesheet" />
</head>
<body>
           <div class="panel panel-default">
		    <div class="panel-heading">
		        <h3 class="panel-title">个人信息</h3>
		    </div>
		    <table class="table">
		        
		        
		        <tr>
			        <th>姓名</th>
			        <td><label class="label label-info">${student.name}</label></td>
		        </tr>
		        <tr>
			        <th>年龄</th>
			        <td><label class="label label-info" >${student.sex }</label></td>
		        </tr>
		        <tr>
			        <th>电话</th>
			        <td><label class="label label-info">${student.tel }</label></td>
		        </tr>
		        <tr>
			        <th>居住地址</th>
			        <td><label class="label label-info">${student.address}</label></td>
		        </tr>
		        <tr>
		           <th>密码</th>
			       <td>
			           <form action="savePwd">
			           <input type="password" name="password" value="${student.password }" placeholder="请输入密码">
			           <input type="submit" value="修改密码"/>
			           </form>
			       </td>
		        </tr>
		    </table>
		</div>
</body>
</html>