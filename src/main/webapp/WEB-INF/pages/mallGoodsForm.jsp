<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	
    
    <title>助微力</title>
	<style type="text/css">
		.photo{
			width: 300px;
			height:300px;
		}
		
		.goods{
			width:1000px;
			min-height:600px;
			border:1px solid #333333;
			border-top:0 solid red;
			margin:auto;
			padding:100px;
		}
		
		.div1{
			display: inline-block !important;
			padding-right:50px;
		}
		
		.div2{
			display: inline-block !important;
		}
		.price_now{
			color: red;
			
		}
		.price_0{
			text-decoration:line-through;
			
			
		}
		
		.goods_search{
			width: 200px !important;
			display: inline-block !important;
		}
		.myform{
			display: inline-block !important;
		}
		
		.i-num{
			width:50px;
			
		}
		.att{
			border:1px dashed #888888;
			margin:5px;
			padding:5px;
			display: inline-block !important;
		}
		#price{
			font-size: 2em;
			color: red;
		}
		.name{
			font-size: 1.5em;
			
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
         
          		<form method="post" >
	       			<!-- 提交字段 -->
	       			<input type="text" name="store_id" value="${store_id}" hidden>
	       				
	       			<%-- <input type="text" name="goods_price" value="${goods.goods_price_now}" hidden> --%>
	       			<input type="text" name="goods_state" value="1" hidden>
	       			<!-- 提交字段结束 -->
	       			<input name="goods_id" value="${goods.goods_id}" hidden>
	       			<div class="goods">
	       				<div class="div1">
	       					<img alt="" src="${pageContext.request.contextPath}/we_file/${goods.goods_img1}" class="photo">
	       				</div>
	       				
	       				<div class="div2">
	       					<div>
		       					<font class="name">${goods.goods_name}</font>
		       				</div>
	       					<div>
		       					<font id="price"> </font>
		       					<input id="price_input" name="goods_price"  hidden="hidden" required="required">
		       				</div>
		       				
		       				<c:forEach items="${listAttribute}" var="attribute">
		       					<div class="att" id="attr${attribute.attribute_id}" >
		       						<font>${attribute.attribute_name}</font>
		       						<c:if test="${grade_type==1}">
		       							<input  value="${attribute.attribute_price}" id="p" hidden>
		       						</c:if>
		       						<c:if test="${grade_type==2}">
		       							<input  value="${attribute.attribute_price_agent}" hidden>
		       						</c:if>
		       						<c:if test="${grade_type==3}">
		       							<input value="${attribute.attribute_price_vip}" hidden>
		       						</c:if>
		       						
		       					</div>
		       				</c:forEach>
		       				
		       				
							
							<div>
								<input type="number" name="goods_num"  value="1" class="i-num">
								<input type="submit" value="添加到购物车" class="btn btn-danger" formaction="${pageContext.request.contextPath}/order/addOrderGoods"> 
								<input type="text" id="attribute" name="attribute" hidden="hidden" required="required">
								<%-- <shiro:hasAnyRoles name="master,clerk">
									<br><br>店主店员才能看到以下这一部分
									<select id="s">
										<option value="1">普通客户</option>
										<option value="2">代理商</option>
										<option value="3">VIP</option>
									</select>
									<c:forEach items="${listAttribute}" var="attribute">
				       					<div class="att" id="attr${attribute.attribute_id}" >
				       						<font>${attribute.attribute_name}</font>
				       							<input  value="${attribute.attribute_price}" class="attr attribute_price" hidden>
				       							<input  value="${attribute.attribute_price_agent}" class="attr attribute_price_agent" hidden>
				       							<input value="${attribute.attribute_price_vip}" class="attr attribute_price_vip" hidden>
				       					</div>
				       				</c:forEach>
								</shiro:hasAnyRoles> --%>
							</div>
	       				</div>     				
	       			</div>
          		</form>
          </div>
         </div>          
       </div>
     </div>
  	<script type="text/javascript">
	  	$(document).ready(function(){
	  	  $(".att").click(function(){
	  	    /* $(this).attr("border","1px solid red"); */
	  	    $(".att").css("border","1px dashed #888888")
	  	    $(this).css("border","2px solid red")
	  	    $("#attribute").val($(this).find("font").html())
	  	  	$("#price_input").val($(this).find("input").val())
	  	  	$("#price").html('￥'+$(this).find("input").val())
	  	  });
	  	});
  		
	  	$("#s").change(function(){
	  		text = $(this).val();
	  		alert(text);
	  		if(text==1){
	  			
	  		}
	  		if(text==2){
	  			
	  		}
	  		if(text==3){
	  			
	  		}
	  		
	  	});
  	</script>
  

  </body>
</html>
