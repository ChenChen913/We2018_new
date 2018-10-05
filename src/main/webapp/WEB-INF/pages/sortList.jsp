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

    <title>分类管理|医用耗材网上采购系统</title>
	<style type="text/css">
		.sort2{
			margin-left: 40px;
		}
		.sort3{
			margin-left: 80px;
		}
		#mytree{
			width:500px;
			text-align:left;
		}
		.glyphicon-wrench{
			margin-right: 20px;
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
          		<a class="btn btn-default " aria-hidden="true" title="添加分类" href="${pageContext.request.contextPath}/sort/open?sort_grade=1">添加分类</a>
            	<table class="table " id="mytree">
          			
          			<c:forEach items="${sortList}" var="sort">
          				<tr>
	            			<td>
	            				<input type="text" value="${sort.sort_name}">
	            			</td>
	            			<td>
								<a class="glyphicon glyphicon-wrench" aria-hidden="true" title="修改分类名称" href="${pageContext.request.contextPath}/sort/query?sort_id=${sort.sort_id}"></a>
	                    		<a class="glyphicon glyphicon-remove " aria-hidden="true" title="删除分类" href="${pageContext.request.contextPath}/sort/delete?sort_id=${sort.sort_id}"></a>
							</td>
          				</tr>
          			</c:forEach>
          		</table>
          		
          		
          </div>          
        </div>
      </div>
    </div>

  </body>
</html>
