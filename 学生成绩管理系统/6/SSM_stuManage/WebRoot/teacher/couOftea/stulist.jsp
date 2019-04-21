<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/styles/main.css"/>"  type="text/css" rel="stylesheet" />
<title>查看学生</title>
</head>
<body>
    <div class="main">
        <h2 class="title"><span>课程管理</span></h2>
        <form action="<c:url value="/cou/getMyStu?pageNO=${pageNO}"/>" method="post">
        <table border="1" width="100%" class="tab">
            <tr>
                <th>学生姓名</th>
                <th>学生性别</th>
                <th>联系电话</th>
                <th>所选课程</th>
                <th>操作</th>
            </tr>
            <c:forEach var="entity" items="${stulist}" varStatus="status">
                <tr>
                    <td>${entity.name}</td>
                    <td>
                      <c:if test="${entity.sex==1}">
                                                   男
                      </c:if>
                      <c:if test="${entity.sex==0}">
                                                   女
                      </c:if>
                    </td>
                    <td>${entity.tel}</td>
                    <td>${entity.couname}</td>
                    <td> <a href="setGrades/${entity.id}/${entity.name}/${entity.cid}" class="abtn">录入成绩</a></td>
                </tr>
            </c:forEach>
        </table>
        <div id="pager"></div>
        <p style="color: red">${msg}</p>
        <!--分页 -->
        <script type="text/javascript" src="<c:url value="/scripts/jquery-1.10.2.min.js"/>" ></script>
        <link href="<c:url value="/scripts/pagination.css"/>"  type="text/css" rel="stylesheet" />
        <script type="text/javascript" src="<c:url value="/scripts/jquery.pagination.js"/>" ></script>
        <script type="text/javascript">
           //初始化分页组件
           var count=${count};
           var size=${size};
           var pageNO=${pageNO};
           $("#pager").pagination(count, {
              items_per_page:size,
               current_page:pageNO-1,
               next_text:"下一页",
               prev_text:"上一页",
               num_edge_entries:2,
               load_first_page:false,
              callback:handlePaginationClick
            });
           
           //回调方法
           function handlePaginationClick(new_page_index, pagination_container){
               location.href="<c:url value="/cou/"/>getMyStu?pageNO="+(new_page_index+1);
           }
           
           /* var defaultSrc="<c:url value="/images/default.jpg"/>";
           $(".tab img").bind("error",function(){
               $(this).prop("src",defaultSrc);
           }); */
        </script>
    </form>
    </div>
</body>
</html>
