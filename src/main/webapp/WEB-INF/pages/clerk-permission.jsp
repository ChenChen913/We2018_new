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

    <title>信息管理 - 店员信息管理</title>

  </head>

  <body>
	<form class="user-form" method="post" name="myform">
    <!-- 头部 -->
    <jsp:include page="header.jsp"/>

    <div class="container-fluid">
      	<div class="row">
        	<div class="col-sm-3 col-md-2 sidebar">
         		 <jsp:include page="navibar.jsp"/>
         	</div>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          	<h1 class="page-header">店员列表</h1>
          	<div class="row placeholders">
          		
          		您正在给${clerk_login_name}店员授权
          		<input value="${clerk_id}" type="text" hidden name="clerk_id"><br>
          		<c:forEach	items="${list }" var="p">
          			<input type="checkbox" <c:if test="${p.flag==true}">checked="checked"</c:if> value="${p.permission_id}" name="permission_id">${p.permission_name}</br>
          		</c:forEach>	
          		
          		<input type="submit" class="btn btn-default" value="确认授权" formaction="${pageContext.request.contextPath}/clerk/authorizeClerkByBatch">
          		<button type="button" class="btn btn-default" onClick="javascript:history.back(-1);">取消</button>	
          	</div>
         </div>
      </div>
    </form>
  </body>
</html>
