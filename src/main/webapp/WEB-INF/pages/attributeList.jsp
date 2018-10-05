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
				<h1 class="page-header">商品管理</h1>
				<div class="row placeholders">
					<button class="btn btn-success"><a class="glyphicon glyphicon-plus" href="${pageContext.request.contextPath}/goods/attributeopenBatch?goods_id=${goods_id}">批量添加属性</a></button>
					<button class="btn btn-success"><a class="glyphicon glyphicon-plus" href="${pageContext.request.contextPath}/goods/attributeopen?goods_id=${goods_id}">添加属性</a></button>
					<br>
					<br>
					<table class="table table-hover table-bordered">
						<tr>
							<th>属性名称</th>
							<th>库存数量</th>
							<th>采购价格</th>
							<th>出售价格</th>
							<th>代理商价格</th>
							<th>vip客户价格</th>
							<th>备注</th>
							<th>操作</th>
						</tr>	
						<c:forEach	items="${list}" var="attribute">
							<tr>
								<td>${attribute.attribute_name}</td>					
								<td>${attribute.attribute_repertory}</td>					
								<td>
									${attribute.attribute_price0}
								</td>					
								<td>${attribute.attribute_price}</td>					
								<td>${attribute.attribute_price_agent}</td>					
								<td>${attribute.attribute_price_vip}</td>					
								<td>${attribute.attribute_memo}</td>					
								<td>
									<button class="btn btn-warning"><a class="glyphicon glyphicon-remove" href="${pageContext.request.contextPath}/goods/attributedelete?attribute_id=${attribute.attribute_id}&goods_id=${goods_id}">删除</a></button>
									<button class="btn btn-info"><a class="glyphicon glyphicon-pencil" href="${pageContext.request.contextPath}/goods/attributequery?attribute_id=${attribute.attribute_id}">修改</a></button>
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
