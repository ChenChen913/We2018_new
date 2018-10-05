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

    <title>医用耗材网上采购商城</title>
	<style type="text/css">
		.photo{
			width: 100px !important;
			height:100px !important;
		}
		.table th{
			text-align: center;
		}
		th,.mytd{
			text-align: center;
			vertical-align: middle !important;
		}
		.Mycheck{
			width:20px;
			height: 20px;
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
          		
          	<%-- <!-- 检索 -->
       		<form action="${pageContext.request.contextPath}/mall/list" method="post" class="myform">
       			<!-- 搜索 -->
       			<input type="search" placeholder="名称/品牌/分类"  name="q_goods_name" class="form-control goods_search" >
       			<input type="submit" value="搜索" class="btn btn-default">
         	</form>
         	<br><br> --%>
          	<form action="" name="myform">
          		<!-- 提交字段 -->
          		<input type="text" name="order_money"  id="order_money" hidden>
          		<input type="text" name="store_id"   hidden value="${store_id}">
          		
          		<table class="table table-bordered table-hover">
          			<tr>
						<td class="mytd"><!-- <input type="checkbox" onclick="All(this.checked)" name="selectAll" class="Mycheck2"> --></td>       					
						<td class="mytd">商品图片</td>       					
						<td class="mytd">商品名称</td>       					
						<td class="mytd">属性</td>       					
						<td class="mytd">商品单价</td>       					
						<td class="mytd">商品数量</td>  
						<td class="mytd">小计</td>  
						<td class="mytd">操作</td>   
						    					
      				</tr>
        		<c:forEach items="${orderGoodsList}" var="goods" varStatus="i">
     				<tr>
						<td class="mytd">
							<input type="checkbox" name="idlist" value="${goods.goods_id}" class="Mycheck">
							<!-- 隐藏提交字段 -->
							<input type="text" disabled="disabled"  name="order_goods_id" value="${goods.order_goods_id}" id="i_${goods.goods_id}" hidden>
						</td>       					
						<td class="mytd">
							<a href="${pageContext.request.contextPath}/mall/query?goods_id=${goods.goods_id}">
			 					<%-- <img alt="" src="${pageContext.request.contextPath}/medical_FileUpload/${goods.goods_photo}" class="photo"> --%>
			 				</a>
			 			</td>       					
						<td class="mytd">${goods.goods_id}</td>       					
						<td class="mytd">${goods.attribute}</td>       					
						<td class="mytd">
							${goods.goods_price}
							<!-- 商品购买时的价格 -->
						</td>       					
						<td class="mytd">${goods.goods_num}</td>       					
						<td class="mytd price" id="p_${goods.goods_id}">${goods.goods_price*goods.goods_num}</td>       					
						<td class="mytd">
							<a class="glyphicon glyphicon-remove " aria-hidden="true" title="删除商品" href="${pageContext.request.contextPath}/order/delete?goods_id=${goods.goods_id}"></a>
						</td>       					
     				</tr>
     			</c:forEach>
     				
     				
     				
          		</table>
          			<div style="text-align: right">
          				<select name="order_epay_type">
          					<option value="1">支付宝</option>
          					<option value="2">微信</option>
          				</select>
          				
          				<input type="text" name="address_contact" placeholder="收件人" required>
          				<input type="text" name="address_content" placeholder="收件地址" required>
          				<input type="text" name="address_phone" placeholder="手机号" required>
          				<input type="text" name="wx" placeholder="微信号" required>
          				<br>
          				
          				
          				<font>已经选好了<font id="ggg"> 0 </font>件商品，总计 <font id="ppp">0</font> 元</font>
     					<a class="btn" href="${pageContext.request.contextPath}/mall/list?store_id=${store_id}">返回继续购物</a>
     					<input  type="submit" value="立即购买" class="btn" formaction="${pageContext.request.contextPath}/order/add?store_id=${store_id}">
     				</div>
     				
     			</form>
     			
     			
     			
          		
     			
     			
     			
          </div>          
        </div>
      </div>
    </div>
	
	<script type="text/javascript">
		$(document).ready(function(){
			var sum =0;
			var count=0;
			$(".Mycheck").change(function(){
				if($(this).is(':checked') ){
					
					/* check_id = '#p_'+$(this).val(); */
					check_id = $(this).parent().next().next().next().next().next().next(); 
					sum+=Number($(check_id).text());
					$("#ppp").text(sum);
					$("#order_money").val(sum);
					
					$("#ggg").text(++count);
					
					/* input_id = '#i_'+$(this).val(); */
					input_id = $(this).next();
					$(input_id).attr("disabled",false);
					
					//alert(sum);
				} 
				if(!$(this).is(':checked') ){
					/* check_id = '#p_'+$(this).val(); */
					check_id = $(this).parent().next().next().next().next().next().next(); 
					sum-=Number($(check_id).text());
					$("#ppp").text(sum);
					$("#order_money").val(sum);
					$("#ggg").text(--count);
					
					
					/* input_id = '#i_'+$(this).val(); */
					input_id = $(this).next();
					$(input_id).attr("disabled",true);
					//alert(sum);
				} 
				/* alert("选中了"); */
				/* if(
						
				)
				//alert();
				alert($(".price").text()); */
			})
		});
	</script>
	
	
	<!-- 全选有bug -->
	<!-- <script type="text/javascript">
		var count = 0;
		function onSelect(obj)
	    {
	  	 var vidlist=document.getElementsByName("idlist");
	  	 var size=vidlist.length; 
	  	 with(document.forms['myform'])
	  	 {
	  		 obj?count++:count--;
	  		 //alert("count="+count+"  size="+size);
	  		 
	  		 next[2].disabled=(count==0);
	  		 selectAll.checked=(count==size)?true:false;
	  	 }
	    }
		function All(obj){
			var vidlist = document.getElementsByName("idlist");
			var size = vidlist.length;
			with(document.forms['myform']){
				for(var i = 0;i<size;i++){
					vidlist[i].checked=obj;
				}
				next[2].disabled=!obj;
	  		  	count=obj?size:0;
			}
		}
	
	</script> -->
  </body>
</html>
