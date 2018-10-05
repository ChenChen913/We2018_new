<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>代客下单</title>
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
		.check{
			width: 1.2em !important;
			height: 1.2em !important;
		}
		.num{
			width: 30px;
		}
	</style>
</head>
<body>
	<form class="user-form" method="post" name="myform" id="myform">
		<!-- 头部 -->
		<jsp:include page="header.jsp" />

		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-3 col-md-2 sidebar">
					<jsp:include page="navibar.jsp" />
				</div>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">代客下单</h1>
				<div class="row placeholders">
					<select id="s">
						<option value="1" selected="selected">普通客户</option>
						<option value="2">代理商</option>
						<option value="3">VIP</option>
					</select>
					<br><br>
					<table class="table table-hover table-bordered">
						<tr>
							<th>商品名称</th>
							<th colspan="4">商品属性</th>
						</tr>
						<c:forEach	items="${list}" var="goods">
							<c:forEach items="${goods.attributeList}" var="attribute" varStatus="i">
							<tr>
								<c:if test="${i.index==0}">
									<td rowspan="${goods.attributeListSize}">
										${goods.goods_name}
									</td>
								</c:if>
								<td><input type="checkbox" class="check" value="${goods.goods_id}" name="goods_id"></td>
								<td>
									${attribute.attribute_name}
									<input type="text" value="${attribute.attribute_name}" name="attribute" hidden="hidden">
								</td>
								<td>￥
									<input value="${attribute.attribute_price}" class="p p1" name="goods_price">
									<input value="${attribute.attribute_price_agent}" class="p p2" disabled="disabled" hidden="hidden" name="goods_price">
									<input value="${attribute.attribute_price_vip}" class="p p3" disabled="disabled" hidden="hidden" name="goods_price">
								</td>
								<td>
									<input type="number" name="goods_num" class="num" value="1">
								</td>
							</tr>
							</c:forEach>
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
	          				<input type="text" name="wx" placeholder="微信" required>
	          				<br>
	          				
	          				<font>已经选好了<font id="ggg"> 0 </font>件商品，总计 <font id="ppp">0</font> 元</font>
     						<input  type="submit" value="立即购买" class="btn" formaction="${pageContext.request.contextPath}/sellerOrder/add">
	     				</div>
					
				</div>
			</div>
		</div>
	</form>
	
	<script type="text/javascript">
		$("#s").change(function(){
			$(".p").attr("disabled",true)
			if($(this).val()==1){
				$(".p1").attr("disabled",false)
				$(".p2").attr("disabled",true)
				$(".p3").attr("disabled",true)
				
				$(".p1").attr("hidden",false)
				$(".p2").attr("hidden",true)
				$(".p3").attr("hidden",true)
			}
			if($(this).val()==2){
				$(".p1").attr("disabled",true)
				$(".p2").attr("disabled",false)
				$(".p3").attr("disabled",true)
				
				$(".p1").attr("hidden",true)
				$(".p2").attr("hidden",false)
				$(".p3").attr("hidden",true)
			}
			if($(this).val()==3){
				$(".p1").attr("disabled",true)
				$(".p2").attr("disabled",true)
				$(".p3").attr("disabled",false)
				
				$(".p1").attr("hidden",true)
				$(".p2").attr("hidden",true)
				$(".p3").attr("hidden",false)
			}
		})
		
		var sum =0;
		var count=0;
		
		$(".check").change(function(){
			if($(this).is(':checked') ){
				$("#ggg").html(++count);
				//计算使用那一个等级
				grade = 'p'+$('#s').val();
				price = $(this).parent().next().next().find("."+grade).val();
				i = $(this).parent().next().next().next().find(".num").val();
				//alert(i)
				sum+=Number(price)*Number(i);
				$("#ppp").html(sum);
			}
			if(!$(this).is(':checked') ){
				$("#ggg").html(--count);
				//计算使用那一个等级
				grade = 'p'+$('#s').val();
				price = $(this).parent().next().next().find("."+grade).val();
				i = $(this).parent().next().next().next().find(".num").val();
			
				sum-=Number(price)*Number(i);
				$("#ppp").html(sum);
			}
		})
		
		/* 表单提交 */
		$("#myform").submit(function(){
			/* var list = $(this).find(".check");
			for(int i=0;i<list.length;i++){
				alert(list[i]);
			} 
			alert(list);  */
			var str = "";    
            $("input[name='goods_id']").each(function(){    
                if($(this).is(":checked"))    
                {    
                     str = "yes";    
                }
                else{
                     str = "no";
                     /* 父级的子级input全部禁用 */
                     $(this).parent().parent().find("input").attr("disabled",true)
                     
               	}
                 //alert(str);
            }); 
				
		})
		
	</script>
</body>
</html>
