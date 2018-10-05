<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>商品管理</title>
	<style type="text/css">
		
		
		
		.placeholders{
			text-align: center !important;
			
		}
		.form-control{
			width:500px !important;
			display: inline-block !important;
		}
		.store{
			display: inline-block !important;
			-moz-box-shadow:1px 2px 11px #666666;
			-webkit-box-shadow:1px 2px 11px #666666;
			box-shadow:1px 2px 11px #666666;
			padding: 20px;
		}
		.store:hover{
			-moz-box-shadow:1px 2px 11px #333333;
			-webkit-box-shadow:1px 2px 11px #333333;
			box-shadow:1px 2px 11px #333333;
		}
		img {
			display: block !important;
		}
		.store_name{
			font-size: 1.5em;
			color: black;
		}
		
	</style>
</head>
<body>
	<form class="user-form" method="post" name="myform">
		<!-- 头部 -->
		<jsp:include page="header.jsp" />

		<div class="container-fluid">
			<div class="row placeholders">
				<br><br><br>
				<input type="search" placeholder="店铺名称" class="form-control" name="store_name">
				<input type="submit" value="搜索店铺" class="btn" formaction="${pageContext.request.contextPath}/mall/storeList">
				<br><br><br>
				<c:forEach items="${list}" var="store">
					<div class="store">
						<a href="${pageContext.request.contextPath}/mall/list?store_id=${store.store_id}">
							<img alt="" src="${pageContext.request.contextPath}/we_file/${store.store_img}" class="ptoto">
							<font class="store_name">${store.store_name}</font>
						</a>
					</div>
				</c:forEach>
			</div>
				</div>
	</form>
</body>
</html>
