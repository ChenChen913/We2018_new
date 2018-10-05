<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>进货管理</title>
	<style type="text/css">
		
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
				<h1 class="page-header">历史进货</h1>
				<div class="row placeholders">
					<br>
					<br>
					<h2 class="page-header">未收到的进货</h2>
					<table class="table table-hover table-bordered">
						<tr>
							<th>进货号</th>
							<th>商品名称</th>
							<th>属性名</th>
							<th>数量</th>
							<th>状态</th>
						</tr>	
						<c:forEach	items="${list1}" var="supplierOrder">
							<tr>
								<td>${supplierOrder.order_number}</td>
								<td>${supplierOrder.goods_name}
									<%-- <input name="goods_id" value="${supplierOrder.goods_id}"> --%>
								</td>					
								<td>${supplierOrder.attribute_name}
									<%-- <input name="goods_id" value="${supplierOrder.attribute_id}"> --%>
								</td>					
								<td>${supplierOrder.goods_num}</td>
								<td>
									<c:if test="${supplierOrder.order_state==1}">
									<a class="glyphicon glyphicon-ok " aria-hidden="true" title="收货" href="${pageContext.request.contextPath}/supplierOrder/update?supplier_order_id=${supplierOrder.supplier_order_id}"></a>
									</c:if>
								</td>
							</tr>
						</c:forEach>
					</table>
					
					<h2 class="page-header">已经收到的进货</h2>
					<table class="table table-hover table-bordered">
						<tr>
							<th>进货号</th>
							<th>商品名称</th>
							<th>属性名</th>
							<th>数量</th>
							<th>状态</th>
						</tr>	
						<c:forEach	items="${list2}" var="supplierOrder">
							<tr>
								<td>${supplierOrder.order_number}</td>
								<td>${supplierOrder.goods_name}
									<%-- <input name="goods_id" value="${supplierOrder.goods_id}"> --%>
								</td>					
								<td>${supplierOrder.attribute_name}
									<%-- <input name="goods_id" value="${supplierOrder.attribute_id}"> --%>
								</td>					
								<td>${supplierOrder.goods_num}</td>
								<td>已经收货</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</form>
</body>
</html>
