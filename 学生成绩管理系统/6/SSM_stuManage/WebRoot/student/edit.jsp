<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<link href="<c:url value="/styles/main.css" />" type="text/css"
    rel="stylesheet" />
<title>编辑商品</title>
<base href="<c:url value="/" />" />
</head>
<body>
    <div class="main">
        <h2 class="title">
            <span>编辑商品</span>
        </h2>
        <form:form action="stu/editSave" modelAttribute="entity">
            <fieldset>
                <legend>商品</legend>
               <p>
                <label for="name">学生姓名：</label>
                <form:input path="name" size="50"/>
                <form:errors path="name" cssClass="error"></form:errors>
            </p>
            <p>
                <label for="sex">学生性别：</label>
                <form:select path="sex">
                     <form:option value="0">男</form:option>
                     <form:option value="1">女</form:option>
                </form:select>
                <form:errors path="sex" cssClass="error"></form:errors>
            </p>
            <p>
                <label for="tel">学生电话：</label>
                <form:input path="tel" size="11"/>
                <form:errors path="tel" cssClass="error"></form:errors>
            </p>
            <p>
                <label for="address">居住地址：</label>
                <form:input path="address" size="50"/>
                <form:errors path="address" cssClass="error"></form:errors>
            </p>
             <p>
                <label for="classid">班级</label>
                <%-- <form:select path="productType.id">
                     <form:option value="0">--请选择--</form:option>
                     <form:options items="${productTypes}"  itemLabel="name" itemValue="id"/>
                </form:select> --%>
                <form:select path="classid">
                   <form:option value="0">--请选择班级--</form:option>
                   <form:options items="${clist}" itemLabel="name" itemValue="id"></form:options>
                </form:select>
            </p>
            
            <form:hidden path="id" />
            <input type="submit" value="保存" class="btn out">
            </fieldset>
        </form:form>
        <p style="color: red">${message}</p>
        <form:errors path="*"></form:errors>
        <p>
            <a href="stu/list" class="abtn out">返回列表</a>
        </p>
    </div>
</body>
</html>