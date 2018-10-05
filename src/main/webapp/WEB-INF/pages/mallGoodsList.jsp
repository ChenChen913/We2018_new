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
		.goods{
			display: inline-block !important;
			-moz-box-shadow:1px 2px 11px #666666;
			-webkit-box-shadow:1px 2px 11px #666666;
			box-shadow:1px 2px 11px #666666;
			padding: 20px;
		}
		.goods:hover{
			-moz-box-shadow:1px 2px 11px #333333;
			-webkit-box-shadow:1px 2px 11px #333333;
			box-shadow:1px 2px 11px #333333;
		}
		img {
			display: block !important;
		}
		
	</style>
</head>
<body>
	<!-- 头部 -->
    <jsp:include page="header.jsp"/>

    <div class="container-fluid">
     <div class="row">
         <div class="col-sm-3 col-md-2 sidebar">
			<jsp:include page="../include/sortNavibar.jsp"/>       
        </div> 
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <div class="row placeholders" >
          	<!-- 检索 -->
       		<form action="${pageContext.request.contextPath}/mall/list" method="post" class="myform">
       			<!-- 搜索 -->
       			<input type="search" placeholder="名称/品牌/分类"  name="q_goods_name" class="form-control goods_search" >
       			<input type="submit" value="搜索" class="btn btn-default">
       			<a href="${pageContext.request.contextPath}/order/shoppingCart?store_id=${store_id}">去购物车结算</a>
         	</form>
         	<br><br>
       		<c:forEach items="${goodslist}" var="goods">
       			
	       			<div class="goods">
	       				<div>
	       					<a href="${pageContext.request.contextPath}/mall/query?goods_id=${goods.goods_id}&store_id=${goods.store_id}">
	       						<img alt="" src="${pageContext.request.contextPath}/we_file/${goods.goods_img1}">
	       					</a>
	       				</div>
	       				<div>
	       					<font>${goods.goods_name}</font>
	       				</div>
	       				<%-- <div>
	       					<font>${goods.goods_describe}</font>
	       				</div>
						<div>
							<font class="price_now">￥${goods.goods_price_now}</font> 
							<font class="price_0">￥${goods.goods_price}</font>
						</div> --%>       				
	       			</div>'
       		</c:forEach>
       		
       	
          		
          </div>          
        </div>
      </div>
    </div>
	


</body>
</html>
