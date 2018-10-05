<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>顾客等级管理</title>
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
		.grade_search{
			display: inline-block !important;
			width: 200px !important;
			
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
				<h1 class="page-header">顾客等级管理</h1>
				<div class="row placeholders">
					<button class="btn btn-success"><a class="glyphicon glyphicon-plus" href="${pageContext.request.contextPath}/grade/open">添加顾客等级</a></button>
					<!-- 搜索 -->
	       			<input type="search" placeholder="顾客用户名"  name="customer_login_name" class="form-control grade_search" >
	       			<input type="submit" value="搜索" class="btn btn-default" formaction="${pageContext.request.contextPath}/grade/list">
					<br>
					<br>
					<table class="table table-hover table-bordered">
						<tr>
							<th>顾客账号</th>
							<th>等级</th>
							<th>操作</th>
						</tr>	
						<c:forEach	items="${list}" var="grade">
							<tr>
								<td>${grade.customer_login_name}</td>					
								<td>
										<c:if test="${grade.grade_type==1}">普通顾客</c:if>
										<c:if test="${grade.grade_type==2}">代理商</c:if>
										<c:if test="${grade.grade_type==3}">VIP</c:if>
								</td>					
								<td>
									<button class="btn btn-warning"><a class="glyphicon glyphicon-remove" href="${pageContext.request.contextPath}/grade/delete?grade_id=${grade.grade_id}">删除</a></button>
									<button class="btn btn-info"><a class="glyphicon glyphicon-pencil" href="${pageContext.request.contextPath}/grade/query?grade_id=${grade.grade_id}">修改</a></button>
								</td>					
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</form>
</body>
</html>
