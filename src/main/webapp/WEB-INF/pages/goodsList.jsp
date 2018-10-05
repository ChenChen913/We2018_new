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
					<button class="btn btn-success"><a class="glyphicon glyphicon-plus" href="${pageContext.request.contextPath}/goods/open">添加商品</a></button>
					<br>
					<br>
					<table class="table table-hover table-bordered">
						<tr>
							<th>商品图片</th>
							<th>商品名称</th>
							<th>商品参数</th>
							<th>状态</th>
							<th>上线时间</th>
							<th>供应商</th>
							<th>所属分类</th>
							<th>操作</th>
						</tr>	
						<c:forEach	items="${page.list}" var="goods">
							<tr>
								<td>
									<img alt="" src="${pageContext.request.contextPath}/we_file/${goods.goods_img1}"> 
									<%-- <img alt="" src="${pageContext.request.contextPath}/we_file/${goods.goods_img2}"> 
									<img alt="" src="${pageContext.request.contextPath}/we_file/${goods.goods_img3}">  --%>
								</td>					
								<td>${goods.goods_name}</td>					
								<td>${goods.goods_content}</td>					
								<td>
									<!-- 0下架，1在售，2预售 -->
									<c:if test="${goods.goods_state ==0}">下架</c:if>
									<c:if test="${goods.goods_state ==1}">在售</c:if>
									<c:if test="${goods.goods_state ==2}">预售</c:if>
								</td>					
								<td>${goods.goods_start_time}</td>					
								<td>${goods.supplier_name}</td>					
								<td>${goods.sort_name}</td>					
								<td>
									<button class="btn btn-warning"><a class="glyphicon glyphicon-remove" href="${pageContext.request.contextPath}/goods/delete?goods_id=${goods.goods_id}">删除</a></button>
									<button class="btn btn-info"><a class="glyphicon glyphicon-pencil" href="${pageContext.request.contextPath}/goods/query?goods_id=${goods.goods_id}">修改</a></button>
									<button class="btn btn-info"><a class="	glyphicon glyphicon-th-list" href="${pageContext.request.contextPath}/goods/attributelist?goods_id=${goods.goods_id}">查看属性</a></button>
								</td>					
							</tr>
						</c:forEach>
					</table>
					<!-- 分页开始 -->
		          		<div class="fenye">
		          		<ul class="pagination">
							<li><a href="${pageContext.request.contextPath}/goods/list?page=1">&laquo;</a></li>
								
							<c:forEach var="i" begin="1" end="${page.pages}">
							   <li <c:if test="${page.pageNum==i}">class='active'</c:if>>
							   		<a href="${pageContext.request.contextPath}/goods/list?page=${i}">${i}</a>
							   	</li>
							</c:forEach>
							<li><a href="${pageContext.request.contextPath}/goods/list?page=${page.pages}">&raquo;</a></li>
						</ul>
						</div>
					<!-- 分页结束 -->
				</div>
			</div>
		</div>
	</form>
</body>
</html>
