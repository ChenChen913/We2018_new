<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>用户注册</title>
	<style type="text/css">
		.table,.table th,.table tr td{
			text-align: center;
			vertical-align: middle !important;
		}
		#container{
    		width: 400px;
    		margin:auto;
    	}
    	.user_table{
    		text-align: center;
    	}
	</style>
</head>
<body>
	<!-- 引入 -->
    <jsp:include page="../include/include.jsp"/>
	<form class="user-form" method="post" name="myform">
		<!-- 头部 -->

			<div id="container">
				<h1 class="page-header">用户注册</h1>
				<div class="row placeholders">
					<table class="table table-hover table-bordered user_table">
						<tr>
							<th>用户名</th>
							<td>
								<input type="text"  name="customer_login_name">
							</td>
						</tr>
						<tr>
							<th>真实姓名</th>
							<td><input type="text"  name="customer_real_name"></td>
						</tr>
						<tr>
							<th>密码</th>
							<td><input type="text"  name="customer_password"></td>	
						</tr>
						<tr>
							<th>邮箱</th>
							<td><input type="text"  name="customer_email"></td>	
						</tr>
						<tr>
							<th>推荐人</th>
							<td><input type="text"  name="seller_id"></td>	
						</tr>
						<tr>
							<td colspan="2">
		          					<button type="submit" class="btn btn-default" formaction="${pageContext.request.contextPath}/customer/add">注册</button>
		          					<button type="submit" class="btn btn-default" onClick="javascript:history.back(-1);">取消</button>	
							</td>
						</tr>	
						
					</table>
				</div>
			</div>
	</form>
</body>
</html>
