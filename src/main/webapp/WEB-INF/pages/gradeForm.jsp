<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>助微力</title>
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
				<h1 class="page-header">客户等级管理</h1>
				<div class="row placeholders">
					<table class="table table-hover table-bordered">
						<tr>
							<th>客户名称</th>
							<td>
								<input type="text"  name="grade_id" value="${grade.grade_id}" hidden>
								<c:if test="${grade.grade_id != null}">
									<input type="text"  name="customer_id" value="${grade.customer_id}" hidden>
								</c:if>
								<input type="text" name="customer_id" value="${grade.customer_login_name}"  list="aaa" id="grade">
								<datalist id="aaa">
								</datalist>
							</td>
						</tr>
						<tr>
							<th>等级</th>
							<td>
								<select name="grade_type">
									<option value="1" <c:if test="${grade.grade_type==1}">selected</c:if>>普通顾客</option>
									<option value="2" <c:if test="${grade.grade_type==2}">selected</c:if>>代理商</option>
									<option value="3" <c:if test="${grade.grade_type==3}">selected</c:if>>VIP</option>
								</select>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<c:if test="${grade.grade_id == null}">
		          					<button type="submit" class="btn btn-default" formaction="${pageContext.request.contextPath}/grade/saveOrUpdate">添加</button>
		          				</c:if>
		          				<c:if test="${grade.grade_id != null}">
		          					<button type="submit" class="btn btn-default" formaction="${pageContext.request.contextPath}/grade/saveOrUpdate">修改</button>
		          				</c:if>
		          					<button type="submit" class="btn btn-default" onClick="javascript:history.back(-1);">取消</button>	
							</td>
						</tr>	
						
					</table>
				</div>
			</div>
		</div>
	</form>
	
	<script type="text/javascript">
		$('#grade').change(function(){
			text = $(this).val();
			//alert(text)
			$.post("queryCustomerByName",
		    {
				customer_login_name:text,
		    },
		        function(data,status){
		        //alert("数据: \n" + data + "\n状态: " + status);
		        //alert(data)
		        $("#aaa").html(data);
		    });
		});
	</script>
</body>
</html>
