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
					<table class="table table-hover table-bordered">
						<tr>
							<th>商品名称</th>
							<td>
								<c:if test="${attribute.goods_id!=null&&attribute.goods_id!='' }">
									<input type="text"  name="goods_id" value="${attribute.goods_id}" hidden>
								</c:if>
								
								<c:if test="${attribute.goods_id==null||attribute.goods_id=='' }">
									<input type="text"  name="goods_id" value="${goods_id}" hidden>
								</c:if>
							</td>
						</tr>
						<tr>
							<th>属性名称</th>
							<td>
								<input type="text"  name="attribute_id" value="${attribute.attribute_id}" hidden>
								<input type="text" value="${attribute.attribute_name}" name="attribute_name">

							</td>
						</tr>
						<tr>
							<th>库存</th>
							<td>
								<input type="text" value="${attribute.attribute_repertory}" name="attribute_repertory">
							</td>
							
						</tr>
						<tr>
							<th>进货价格</th>
							<td><input type="text" value="${attribute.attribute_price0}" name="attribute_price0"></td>	
						</tr>
						<tr>
							<th>销售价格</th>
							<td><input type="text" value="${attribute.attribute_price}" name="attribute_price"></td>	
						</tr>
						<tr>
							<th>代理商价格</th>
							<td><input type="text" value="${attribute.attribute_price_agent}" name="attribute_price_agent"></td>	
						</tr>
						<tr>
							<th>VIP价格</th>
							<td><input type="text" value="${attribute.attribute_price_vip}" name="attribute_price_vip"></td>	
						</tr>
						<tr>
							<th>备注</th>
							<td><input type="text" value="${attribute.attribute_memo}" name="attribute_memo"></td>	
						</tr>
						<tr>
							<td colspan="2">
								<c:if test="${attribute.attribute_id == null}">
		          					<button type="submit" class="btn btn-default" formaction="${pageContext.request.contextPath}/goods/attributeadd">添加</button>
		          				</c:if>
		          				<c:if test="${attribute.attribute_id != null}">
		          					<button type="submit" class="btn btn-default" formaction="${pageContext.request.contextPath}/goods/attributeupdate">修改</button>
		          				</c:if>
		          					<button type="submit" class="btn btn-default" onClick="javascript:history.back(-1);">取消</button>	
							</td>
						</tr>	
						
					</table>
				</div>
			</div>
		</div>
	</form>
</body>
</html>
