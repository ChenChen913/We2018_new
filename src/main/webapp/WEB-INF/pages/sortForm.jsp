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

    <title>医用耗材网上采购系统</title>
    
    <style type="text/css">
    	.suppplier_table{
    		width: 600px;
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
          <h1 class="page-header">分类管理</h1>
          <div class="row placeholders">
          	<form action="" method="post">
          		<table class="table table-bordered table-hover suppplier_table">
          			<tr>
          				<td>分类名称</td>
          				<td>
          					<input type="text" name="sort_name" value="${sort.sort_name}" required="required">
          					<input type="text" name="sort_id" value="${sort.sort_id}" hidden="hidden">
          				</td>
          			</tr>
          			<tr>
          				<td colspan="2">
          				<c:if test="${sort.sort_id == null}">
          					<button type="submit" class="btn btn-default" formaction="${pageContext.request.contextPath}/sort/add">添加</button>
          				</c:if>
          				<c:if test="${sort.sort_id != null}">
          					<button type="submit" class="btn btn-default" formaction="${pageContext.request.contextPath}/sort/update">修改</button>
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
  </body>
</html>
