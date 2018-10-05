<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>修改密码 - 店员信息管理</title>
    
    <script src="${pageContext.request.contextPath}/static/logo/head/jquery.min.js"></script>

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/logo/css/bootstrap.min.css">
	<link href="${pageContext.request.contextPath}/static/logo/head/cropper.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/static/logo/head/sitelogo.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/logo/css/font-awesome.min.css">
	
	<script src="${pageContext.request.contextPath}/static/logo/head/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/logo/head/cropper.js"></script>
	<script src="${pageContext.request.contextPath}/static/logo/head/sitelogo.js"></script>
    
	<style type="text/css">
		.table{
    		width: 500px !important;
    		text-align: center;
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
          <h1 class="page-header">修改密码</h1>
          <div class="row placeholders">
          	<form action="${pageContext.request.contextPath}/user/password" method="post">
          		<table class="table table-bordered table-hover suppplier_table">
          			<tr>
          				<td>用户名</td>
          				<td>
          					<input type="text" name="seller_login_name" value="${seller.seller_login_name}" disabled="disabled">
          					
          				</td>
          			</tr>
          			<tr>
          				<td>原密码</td>
          				<td><input type="password" id="seller_password0" >
          				<input type="text" name="seller_id" value="${seller.seller_id}" hidden="hidden" id="seller_id">
          					<input type="text" value="${seller.seller_password}" hidden="hidden" id="p0">
          				</td>
          				
          			</tr>
          			<tr>
          				<td>要修改的密码</td>
          				<td><input type="password" name="seller_password" ></td>
          			</tr>
          			
          			<tr>
          				<td colspan="2">
          				<c:if test="${seller.seller_id != null}">
          					<button type="submit" class="btn btn-default" formaction="${pageContext.request.contextPath}/user/updateSellerPassword" disabled="disabled" id="bt">修改密码</button>
          				</c:if>
          					<button type="submit" class="btn btn-default" onClick="javascript:history.back(-1);">取消</button>	
          				</td>
          			</tr>
          		</table>
          	</form>
          </div>          
        </div>
      </div>
    </div>
    
    <script type="text/javascript">
    	$("#seller_password0").change(function(){
    		text = $(this).val();
    		seller_id = $(this).next().val();
    		 $.post("ajax_password",
		    {
		        seller_password:text,
		        seller_id :seller_id
		    },
		        function(data,status){
		      /*   alert("数据: \n" + data + "\n状态: " + status);  */
		        if(data == 'true'){
		        	$("#bt").attr("disabled",false);
		        }
		        if(data == 'false'){
		        	$("#bt").attr("disabled",true);
		        }
		    });
    	})
    </script>
  
  </body>
</html>
