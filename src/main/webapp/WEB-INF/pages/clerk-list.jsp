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

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/static/css/layout.css" rel="stylesheet">
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
          	<div>
                <button type="button" class="btn btn-warning delete-query" data-toggle="modal" data-target="#delete-confirm-dialog">删除所选</button>
                <!--  删除所选对话框 -->
                <div class="modal fade " id="delete-confirm-dialog" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
                  <div class="modal-dialog modal-sm" role="document">
                    <div class="modal-content">
                      <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" >警告</h4>
                      </div>
                      <div class="modal-body">
                        	确认删除所选用户吗
                      </div>
                      <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        <button type="submit" class="btn btn-primary delete-selected-confirm" formaction="${pageContext.request.contextPath}/">确认</button>
                      </div>
                    </div>
                  </div>
                </div>
                <button type="button" class="btn btn-primary show-user-form" data-toggle="modal" data-target="#add-user-form">添加新员工</button>
                
                
                
                <!--start 添加新用户表单-->
                <div class="modal fade " id="add-user-form" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
                  <div class="modal-dialog modal-sm" role="document">
                    <div class="modal-content">
                      <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" >添加新员工</h4>
                      </div>
                      <div class="modal-body">
                          <div class="form-group">
                            <label for="userNameInput">用户名</label>
                            <input type="text" name="seller_login_name" class="form-control" id="userNameInput" placeholder="用户名" required onchange="validate()">
                          </div>
                          <div class="form-group">
                            <label for="passwordInput">密码</label>
                            <input type="password" name="seller_password" class="form-control" id="passwordInput" placeholder="密码" required>
                          </div>
                      </div>
                      <div class="modal-footer">
                      	<font id="validName"></font>
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        <button type="submit" class="btn btn-primary add-user-submit" formaction="${pageContext.request.contextPath}/clerk/add" id="addClerk">添加 </button>
                      </div>
                    </div>
                  </div>
                </div>
            	<!--END 添加新用户表单-->
            	
            
            
            
            </div>
            <div class="space-div"></div>
            
            
            
            <!-- start 这是list主列表 -->
            <table class="table table-hover table-bordered user-list">
            	<tr>
                	<td><input type="checkbox" class="select-all-btn"/></td>
                    
                    <td>用户名</td>
                    
                    <td>操作</td>
                </tr>
                
                <c:forEach items="${clerkList }" var="clerk">
                	<tr>
                		<td><input type="checkbox" name="clerk_id" value="${clerk.seller_id }"/></td>
                		
                		<td class="username">${clerk.seller_login_name }</td>
                		
	                    <%-- <td>
	                    	<a class="glyphicon glyphicon-wrench show-userrole-form" aria-hidden="true" title="修改店员权限" href="javascript:void(0);" data-toggle="modal" data-target="#update-userrole-dialog" ></a>
	                    	<a class="glyphicon glyphicon-remove delete-this-user" aria-hidden="true" title="删除用户" href="javascript:void(0);" onclick="onDel(${clerk.seller_id })"></a>
	                    </td> --%>
	                    <td>
	                    	<a class="glyphicon glyphicon-wrench show-userrole-form" aria-hidden="true" title="修改店员权限" href="${pageContext.request.contextPath}/clerk/queryClerkPermission?clerk_id=${clerk.seller_id}" ></a>
	                    	&nbsp;&nbsp;<a class="glyphicon glyphicon-remove delete-this-user" aria-hidden="true" title="删除用户" href="javascript:void(0);" onclick="onDel(${clerk.seller_id })"></a>
	                    </td>
	                    
                	</tr>
                </c:forEach>
            </table>
            <!-- END 这是list主列表 -->
            
            
            
            <!--start 修改用户角色表单-->
            <div class="modal fade " id="update-userrole-dialog" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
                  <div class="modal-dialog modal-sm" role="document">
                    <div class="modal-content">
                      <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" >修改店员权限</h4>
                      </div>
                      <div class="modal-body">
                      	<!-- <form class="update-userrole-form"> -->
                        	<input name="seller_id" type="hidden" id="seller_id"/>
                        	<div class="roles-div">
                        		<c:forEach  var="p" items="${permissionList }">
                        			${p.permission_name}</br>
                        				<c:forEach items="${p.childNavigations}" var="p2">
                        					&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="permission_id" value="${p2.permission_id}" >${p2.permission_name}</br>
                        				</c:forEach>
                        		</c:forEach>
                        	</div>
                        <!-- </form> -->
                      </div>
                      <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        <button type="submit" class="btn btn-primary update-userrole-submit" formaction="${pageContext.request.contextPath}/clerk/authorizeClerkByBatch">提交 </button>
                      </div>
                    </div>
                  </div>
            </div>
          	<!-- end 这是修改用户角色表单 -->
          
          
          
          
          </div>          
        </div>
    </div>
    <!-- 提示框 -->
	<div class="modal fade" id="op-tips-dialog" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" >
      <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">
        	<div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" >提示信息</h4>
          </div>
          <div class="modal-body" id="op-tips-content">
          </div>
        </div>
      </div>
    </div>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
    <script>
    	
       	
		function onDel(obj){
			with(document.forms['myform']){
				
				action = "${pageContext.request.contextPath}/clerk/deleteClerkById_physics?seller_id="+obj;
				submit();
				//alert(obj);
			}
		}
		
		//添加店员时，校验用户名是否重复
		function validate(name){
			$(document).ready(function(){
				//alert($("#userNameInput").val());
				var seller_login_name = $("#userNameInput").val();
				//异步请求服务器，校验该用户名是否已经使用
				$.post("${pageContext.request.contextPath}/clerk/validate",
						{
							seller_login_name:seller_login_name
						},
						function(data,status){
							
							if(data=='true'){
								$("#addClerk").attr({
									"disabled":false
								}); 
								$("#validName").text("可以使用")
								
							}
							if(data=='false'){
								$("#addClerk").attr({
									"disabled":true
								}); 
								$("#validName").text("该用户名已经存在！")
								
							}
							
							
						}
				)
				
				
			});
		}
		
		
		/* $(document).ready(function(){
			$(".show-userrole-form").clerk{
				
			}
		}); */
		
		
    </script>
    </form>
  </body>
</html>
