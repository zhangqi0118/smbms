<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>
<div class="page-bar">
	<ul class="page-num-ul clearfix">
		<c:if test="${pageInfo.total>0}">
			<form action="<%=request.getContextPath()%>/getUserByUserNameAndroleName" id="form" >
				<li>共${pageInfo.total}条记录&nbsp;&nbsp; ${pageInfo.pageNum}/${pageInfo.pages }页</li>
				<a href="<%=request.getContextPath()%>/getUserByUserNameAndroleName?pn=1&&pageSize=${pageInfo.pageSize}&&queryname=${queryname}&&queryUserRole=${queryUserRole}">首页</a>
				<a href="<%=request.getContextPath()%>/getUserByUserNameAndroleName?pn=${pageInfo.pageNum-1}&&pageSize=${pageInfo.pageSize}&&queryname=${queryname}&&queryUserRole=${queryUserRole}">上一页</a>
				<a href="<%=request.getContextPath()%>/getUserByUserNameAndroleName?pn=${pageInfo.pageNum+1}&&pageSize=${pageInfo.pageSize}&&queryname=${queryname}&&queryUserRole=${queryUserRole}">下一页</a>
				<a href="<%=request.getContextPath()%>/getUserByUserNameAndroleName?pn=${pageInfo.pages}&&pageSize=${pageInfo.pageSize}&&queryname=${queryname}&&queryUserRole=${queryUserRole}">末页</a>

				<span class="page-go-form"><label>跳转至</label>
					<input type="hidden" name="queryUserRole" value="${queryUserRole}">
					<input type="hidden" name="queryname" value="${queryname}">
	     <input type="text" name="pn" id="inputPage" class="page-key"  value="${pageInfo.pageNum}"/>页
	     <button type="button" class="page-btn" onClick='jump_to(document.forms[0],document.getElementById("inputPage").value)'>GO</button>
		</span>
			</form>
			<form id="from_1" action="<%=request.getContextPath()%>/getUserByUserNameAndroleName" >
				<select id="pageSize" name="pageSize" >
					<option>${pageInfo.pageSize}</option>
					<option>3</option>
					<option>5</option>
					<option>10</option>
					<option>15</option>
				</select></form>
		</c:if>
	</ul>
</div>
</body>
<script src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/rollpage.js"></script>
<script>
	$("#pageSize>option").click(function () {
		$("#from_1").submit();
	})
</script>
</html>