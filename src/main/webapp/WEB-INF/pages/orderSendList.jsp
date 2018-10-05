<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <title>订单管理</title>
    
    <style type="text/css">
    	.supplier_search{
			width: 200px !important;
			display: inline-block !important;
		}
		.myform{
			display: inline-block !important;
		}
		.photo{
			width:30px;
			width:30px;
		}
		tr{
		 height: 30px;
		}
		.font_t{
			margin-left:30px; 
		}
		.ok{
			font-size:1.2em;
		}
    </style>

  </head>

  <body>

	<!-- 头部 -->
    <jsp:include page="header.jsp"/>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
         <jsp:include page="navibar.jsp"/>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">发货管理</h1>
			
          <div class="row placeholders">
          	<%-- 	<!-- 检索 -->
          		<form action="${pageContext.request.contextPath}/supplier/list" method="post" class="myform">
          			<!-- 搜索 -->
          			<input type="search" placeholder="厂商/地址"  name="q_supplier_name" class="form-control supplier_search" >
          			<input type="submit" value="搜索" class="btn btn-default">
            	</form> --%>
          		<h2>未发货的订单</h2>
            	<table class="table table-bordered table-hover">
          			<tr>
          				<th>订单号</th>
          				<th>总额</th>
          				<th>订单账号</th>
          				<th>订单状态</th>
          				<th>订单时间</th>
          				<th>操作</th>
          			</tr>
          			<c:forEach items="${page.list}" var="order">
          				<tr>
	            			<td>${order.order_number}</td>
	            			<td>${order.order_money}</td>
	            			<td>${order.customer}</td>
	            			<td>
	            				<c:if test="${order.order_state==1}">已审核</c:if>
	            				<c:if test="${order.order_state==0}">未审核</c:if>
	            			</td>
	            			<td>${order.order_time}</td>
	            			<td>
	            				<c:if test="${order.order_state==0}">
									<a class="glyphicon glyphicon-ok " aria-hidden="true" title="审核通过" href="${pageContext.request.contextPath}/order/update?order_id=${order.order_id}&order_state=1"></a>
									<a class="glyphicon glyphicon-remove " aria-hidden="true" title="错误订单" href="${pageContext.request.contextPath}/order/update?order_id=${order.order_id}&order_state=2"></a>
								</c:if>
								
								<c:if test="${order.order_state==1}">
									<font class="ok">已经审核</font>
								</c:if>
							</td>
          				</tr>
          				<c:forEach items="${order.orderGoodsList}" var="orderGoods">
	          				<tr>
	          					<td colspan="6">
	          						<%-- <img alt="" src="${pageContext.request.contextPath}/medical_FileUpload/${orderGoods.goods_photo}" class="photo"> --%>
	          						<font class="font_t">商品名称：${orderGoods.goods_name}</font>
	          						<font class="font_t">商品属性：${orderGoods.attribute}</font>
	          						<font class="font_t">商品成交价格${orderGoods.goods_price}</font>
	          						<%-- <input type="number" value="${orderGoods.goods_num}" name="goods_num"> --%>
	          						<font class="font_t">商品数量：${orderGoods.goods_num}</font>
	          					</td>
	          				</tr>
          				</c:forEach>
          			</c:forEach>
          		</table>
          		
          		<!-- 分页开始 -->
          		<div class="fenye">
          		<ul class="pagination">
					<li><a href="${pageContext.request.contextPath}/order/list?page=1">&laquo;</a></li>
						
					<c:forEach var="i" begin="1" end="${page.pages}">
					   <li <c:if test="${page.pageNum==i}">class='active'</c:if>>
					   		<a href="${pageContext.request.contextPath}/order/list?page=${i}">${i}</a>
					   	</li>
					</c:forEach>
					<li><a href="${pageContext.request.contextPath}/order/list?page=${page.pages}">&raquo;</a></li>
				</ul>
				</div>
				<!-- 分页结束 -->
          		
          		
          		
          		<!-- 已经审核的订单 -->
          		<h2>已经发货的订单</h2>
            	<table class="table table-bordered table-hover">
          			<tr>
          				<th>订单号</th>
          				<th>总额</th>
          				<th>订单账号</th>
          				<th>订单状态</th>
          				<th>订单时间</th>
          				<th>操作</th>
          			</tr>
          			<c:forEach items="${page2.list}" var="order">
          				<tr>
	            			<td>${order.order_number}</td>
	            			<td>${order.order_money}</td>
	            			<td>${order.customer}</td>
	            			<td>
	            				<c:if test="${order.order_state==1}">已审核</c:if>
	            				<c:if test="${order.order_state==2}">错误订单</c:if>
	            				<c:if test="${order.order_state==0}">未审核</c:if>
	            			</td>
	            			<td>${order.order_time}</td>
	            			<td>
	            				<c:if test="${order.order_state==0}">
									<a class="glyphicon glyphicon-ok " aria-hidden="true" title="审核通过" href="${pageContext.request.contextPath}/order/update?order_id=${order.order_id}"></a>
								</c:if>
								
								<c:if test="${order.order_state==1}">
									<font class="ok">已经审核</font>
								</c:if>
								<c:if test="${order.order_state==2}">
									<font class="ok">错误订单</font>
								</c:if>
							</td>
          				</tr>
          				<c:forEach items="${order.orderGoodsList}" var="orderGoods">
	          				<tr>
	          					<td colspan="6">
	          						<%-- <img alt="" src="${pageContext.request.contextPath}/medical_FileUpload/${orderGoods.goods_photo}" class="photo"> --%>
	          						<font class="font_t">商品名称：${orderGoods.goods_name}</font>
	          						<font class="font_t">商品属性：${orderGoods.attribute}</font>
	          						<font class="font_t">商品成交价格${orderGoods.goods_price}</font>
	          						<%-- <input type="number" value="${orderGoods.goods_num}" name="goods_num"> --%>
	          						<font class="font_t">商品数量：${orderGoods.goods_num}</font>
	          					</td>
	          				</tr>
          				</c:forEach>
          			</c:forEach>
          		</table>
          		
          		<!-- 分页开始 -->
          		<div class="fenye">
          		<ul class="pagination">
					<li><a href="${pageContext.request.contextPath}/send/list?page2=1">&laquo;</a></li>
						
					<c:forEach var="i" begin="1" end="${page2.pages}">
					   <li <c:if test="${page2.pageNum==i}">class='active'</c:if>>
					   		<a href="${pageContext.request.contextPath}/send/list?page2=${i}">${i}</a>
					   	</li>
					</c:forEach>
					<li><a href="${pageContext.request.contextPath}/send/list?page2=${page2.pages}">&raquo;</a></li>
				</ul>
				</div>
				<!-- 分页结束 -->
          </div>          
        </div>
      </div>
    </div>

  </body>
</html>
