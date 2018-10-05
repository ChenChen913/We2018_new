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
				<h1 class="page-header">进货管理</h1>
				<div class="row placeholders">
					<button class="btn btn-info"><a class="glyphicon glyphicon-pencil" href="${pageContext.request.contextPath}/supplierOrder/list0">历史进货单</a></button>
					<br>
					<br>
					<table class="table table-hover table-bordered">
						<tr>
							<th>商品名称</th>
							<th>属性名</th>
							<th>数量</th>
						</tr>	
						<c:forEach	items="${list}" var="supplierOrder">
							<tr>
								<td>${supplierOrder.goods_name}
									<%-- <input name="goods_id" value="${supplierOrder.goods_id}"> --%>
								</td>					
								<td>${supplierOrder.attribute_name}
									<%-- <input name="goods_id" value="${supplierOrder.attribute_id}"> --%>
								</td>					
								<td>${supplierOrder.goods_num}</td>
							</tr>
						</c:forEach>
					</table>
					<button class="btn btn-info"><a class="glyphicon glyphicon-pencil" href="${pageContext.request.contextPath}/supplierOrder/add">生成订单</a></button>
				</div>
			</div>
		</div>
	</form>
</body>
</html>
