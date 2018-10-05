<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<style type="text/css">
	.sort1{
			background: #F69730;
			font-size: 1.5em;
			margin: 10px 5px;
			
		}
		.sort2{
			background: #E2E2E3;
			margin: 5px 30px;
			font-size: 1.3em;
		}
		.sort3{
			padding: 5px 30px;
			font-size: 1.1em;
		}
</style>
</head>

<body>
<c:forEach items="${sortlist}" var="sort">
	<div class="sort1">
		<a href="${pageContext.request.contextPath}/mall/list?sort_id=${sort.sort_id}&store_id=${sort.store_id}">${sort.sort_name}</a>
	</div>
</c:forEach>  
</body>
</html>