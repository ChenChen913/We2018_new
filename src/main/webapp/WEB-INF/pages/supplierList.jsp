<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>供应商管理</title>
	<style type="text/css">
		.glyphicon{
			color: white !important;
		}
		a:hover{
			TEXT-DECORATION:none !important;
		}
		.table,.table th,.table tr td{
			text-align: center;
			vertical-align: middle !important;
		}
		
	</style>
</head>
<body>
	<form class="user-form" method="post" name="myform">
		<!-- 头部 -->
		<jsp:include page="header.jsp" />

		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-3 col-md-2 sidebar">
					<jsp:include page="navibar.jsp" />
				</div>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">供应商管理</h1>
				<div class="row placeholders">
					<button class="btn btn-success"><a class="glyphicon glyphicon-plus" href="${pageContext.request.contextPath}/supplier/open">添加供应商</a></button>
					<br>
					<br>
					<table class="table table-hover table-bordered">
						<tr>
							<th>供应商名称</th>
							<th>联系人</th>
							<th>手机号</th>
							<th>支付宝</th>
							<th>操作</th>
						</tr>	
						<c:forEach	items="${list}" var="supplier">
							<tr>
								<td>${supplier.supplier_name}</td>					
								<td>${supplier.supplier_contacts}</td>					
								<td>${supplier.supplier_phone}</td>					
								<td>${supplier.supplier_epay}</td>					
								<td>
									<button class="btn btn-warning"><a class="glyphicon glyphicon-remove" href="${pageContext.request.contextPath}/supplier/delete?supplier_id=${supplier.supplier_id}">删除</a></button>
									<button class="btn btn-info"><a class="glyphicon glyphicon-pencil" href="${pageContext.request.contextPath}/supplier/query?supplier_id=${supplier.supplier_id}">修改</a></button>
								</td>					
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</form>
</body>
</html>
