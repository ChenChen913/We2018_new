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
					<table class="table table-hover table-bordered">
						<tr>
							<th>供应商名称</th>
							<td>
								<input type="text"  name="supplier_id" value="${supplier.supplier_id}" hidden >
								<input type="text" value="${supplier.supplier_name}" name="supplier_name" required>
								
							</td>
						</tr>
						<tr>
							<th>联系人</th>
							<td><input type="text" value="${supplier.supplier_contacts}" name="supplier_contacts" required></td>
						</tr>
						<tr>
							<th>手机号</th>
							<td><input type="text" value="${supplier.supplier_phone}" name="supplier_phone" required></td>	
						</tr>
						<tr>
							<th>支付宝</th>
							<td><input type="text" value="${supplier.supplier_epay}" name="supplier_epay" required></td>	
						</tr>
						<tr>
							<td colspan="2">
								<c:if test="${supplier.supplier_id == null}">
		          					<button type="submit" class="btn btn-default" formaction="${pageContext.request.contextPath}/supplier/add">添加</button>
		          				</c:if>
		          				<c:if test="${supplier.supplier_id != null}">
		          					<button type="submit" class="btn btn-default" formaction="${pageContext.request.contextPath}/supplier/update">修改</button>
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
