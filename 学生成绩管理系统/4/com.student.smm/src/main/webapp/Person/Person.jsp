<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript">
	function jump(pageNo,pageSize){
	$('#pageNo').val(pageNo);
	$('#pageSize').val(pageSize);
	$('#searchForm').submit();
     }
	</script>
<div style="margin:0 auto;text-align:center;width:800px;">
<a href="javascript:void(0)"
     onclick="jump(1,${pagerBooks.pageSize})">首页</a>&nbsp;
    <c:if test="${pagerBooks.hasPrev eq true}">
    <a href="javascript:void(0)" onclick="jump(${pagerBooks.pageNo - 1},${pagerBooks.pageSize})">上一页</a>&nbsp;
    </c:if>
    <c:if test="${pagerBooks.hasPrev eq false}">
	上一页&nbsp;
    </c:if>
	<c:forEach var="pageNo" begin="1" end="${pagerBooks.totalPage }" step="1">
	<a href="javascript:void(0)" onclick="jump(${pageScope.pageNo},${pagerBooks.pageSize})">${pageScope.pageNo }</a>&nbsp;
	</c:forEach>
	<c:if test="${pagerBooks.hasNext eq true}">
    <a href="javascript:void(0)" onclick="jump(${pagerBooks.pageNo + 1},${pagerBooks.pageSize})">下一页</a>&nbsp;
    </c:if>
    <c:if test="${pagerBooks.hasNext eq false}">
	下一页&nbsp;
    </c:if>
    <a href="javascript:void(0)"
     onclick="jump(${pagerBooks.totalPage},${pagerBooks.pageSize})">末页</a> 
	第${pager.pageNo}页/共${pager.totalPage }页&nbsp;
</div>