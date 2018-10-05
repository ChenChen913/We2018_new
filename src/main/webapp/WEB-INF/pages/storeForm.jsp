<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>信息管理 - 店员信息管理</title>
    
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
          <h1 class="page-header">店铺信息管理</h1>
          <div class="row placeholders">
          	<form action="" method="post">
          		<table class="table table-bordered table-hover suppplier_table">
          			<c:if test="${store.store_id != null && store.store_id != ''}">
          				<tr>
	          				<td>图片</td>
	          				<td>
	          					<img alt="" src="${pageContext.request.contextPath}/we_file/${store.store_img}" class="photo">
								<input type="text" value="${store.store_id}"  hidden="true">
								<button type="button" class="btn btn-primary"  data-toggle="modal" data-target="#avatar-modal" style="margin: 10px;">修改图片</button>
	          				</td>
	          			</tr>
          			</c:if>
          			
          			<tr>
          				<td>店铺名称</td>
          				<td>
          					<input type="text" name="store_name" value="${store.store_name}">
          					<input type="text" name="store_id" value="${store.store_id}" hidden="hidden" id="store_id">
          				</td>
          			</tr>
          			<tr>
          				<td>店铺简介</td>
          				<td><input type="text" name="store_content" value="${store.store_content}"></td>
          			</tr>
          			
          			<tr>
          				<td colspan="2">
          				<c:if test="${store.store_id != null}">
          					<button type="submit" class="btn btn-default" formaction="${pageContext.request.contextPath}/store/update">修改</button>
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
    
    
    
    		<!-- 上传头像开始 -->

<div class="user_pic" style="margin: 10px;">
	<img src="">
</div>

<div class="modal fade" id="avatar-modal" aria-hidden="true" aria-labelledby="avatar-modal-label" role="dialog" tabindex="-1">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			
			 <form class="avatar-form"> 
				<div class="modal-header">
					<button class="close" data-dismiss="modal" type="button">&times;</button>
					<h4 class="modal-title" id="avatar-modal-label">上传图片</h4>
				</div>
				<div class="modal-body">
					<div class="avatar-body">
						<div class="avatar-upload">
							<input class="avatar-src" name="avatar_src" type="hidden">
							<input class="avatar-data" name="avatar_data" type="hidden">
							<label for="avatarInput" style="line-height: 35px;">图片上传</label>
							<button class="btn btn-danger"  type="button" style="height: 35px;" onClick="$('input[id=avatarInput]').click();">请选择图片</button>
							<span id="avatar-name"></span>
							<input class="avatar-input hide" id="avatarInput" name="avatar_file" type="file"></div>
						<div class="row">
							<div class="col-md-9">
								<div class="avatar-wrapper"></div>
							</div>
							<div class="col-md-3">
								<div class="avatar-preview preview-lg" id="imageHead"></div>
								<!--<div class="avatar-preview preview-md"></div>
						<div class="avatar-preview preview-sm"></div>-->
							</div>
						</div>
						<div class="row avatar-btns">
							<div class="col-md-4">
								<div class="btn-group">
									<button class="btn btn-danger fa fa-undo" data-method="rotate" data-option="-90" type="button" title="Rotate -90 degrees"> 向左旋转</button>
								</div>
								<div class="btn-group">
									<button class="btn  btn-danger fa fa-repeat" data-method="rotate" data-option="90" type="button" title="Rotate 90 degrees"> 向右旋转</button>
								</div>
							</div>
							<div class="col-md-5" style="text-align: right;">								
								<button class="btn btn-danger fa fa-arrows" data-method="setDragMode" data-option="move" type="button" title="移动">
								<span class="docs-tooltip" data-toggle="tooltip" title="" data-original-title="$().cropper(&quot;setDragMode&quot;, &quot;move&quot;)">
								</span>
							  </button>
							  <button type="button" class="btn btn-danger fa fa-search-plus" data-method="zoom" data-option="0.1" title="放大图片">
								<span class="docs-tooltip" data-toggle="tooltip" title="" data-original-title="$().cropper(&quot;zoom&quot;, 0.1)">
								  <!--<span class="fa fa-search-plus"></span>-->
								</span>
							  </button>
							  <button type="button" class="btn btn-danger fa fa-search-minus" data-method="zoom" data-option="-0.1" title="缩小图片">
								<span class="docs-tooltip" data-toggle="tooltip" title="" data-original-title="$().cropper(&quot;zoom&quot;, -0.1)">
								  <!--<span class="fa fa-search-minus"></span>-->
								</span>
							  </button>
							  <button type="button" class="btn btn-danger fa fa-refresh" data-method="reset" title="重置图片">
									<span class="docs-tooltip" data-toggle="tooltip" title="" data-original-title="$().cropper(&quot;reset&quot;)" aria-describedby="tooltip866214"></span>
							   </button>
							</div>
							<div class="col-md-3">
								<button class="btn btn-danger btn-block avatar-save fa fa-save" type="button" data-dismiss="modal"> 保存修改</button>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>


<div class="loading" aria-label="Loading" role="img" tabindex="-1"></div>
<script src="${pageContext.request.contextPath}/static/logo/head/html2canvas.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
//做个下简易的验证  大小 格式 
	$('#avatarInput').on('change', function(e) {
		var filemaxsize = 1024 * 5;//5M
		var target = $(e.target);
		var Size = target[0].files[0].size / 1024;
		if(Size > filemaxsize) {
			alert('图片过大，请重新选择!');
			$(".avatar-wrapper").childre().remove;
			return false;
		}
		if(!this.files[0].type.match(/image.*/)) {
			alert('请选择正确的图片!')
		} else {
			var filename = document.querySelector("#avatar-name");
			var texts = document.querySelector("#avatarInput").value;
			var teststr = texts; //你这里的路径写错了
			testend = teststr.match(/[^\\]+\.[^\(]+/i); //直接完整文件名的
			filename.innerHTML = testend;
		}
	
	});

	$(".avatar-save").on("click", function() {
		var img_lg = document.getElementById('imageHead');
		// 截图小的显示框内的内容
		html2canvas(img_lg, {
			allowTaint: true,
			taintTest: false,
			onrendered: function(canvas) {
				canvas.id = "mycanvas";
				//生成base64图片数据
				var dataUrl = canvas.toDataURL("image/jpeg");
				var newImg = document.createElement("img");
				newImg.src = dataUrl;
				imagesAjax(dataUrl)
			}
		});
	})
	
	function imagesAjax(src) {
		var data = {};
		data.img = src;
		data.seller_id=$('#store_id').val();
		//data.jid = $('#jid').val(); 
		//alert($('#jid').val());
		//alert(JSON.stringify(data));
		$.ajax({
			url: "logoUpload",
			data: data,
			type: "POST",
			dataType: 'json',
			success: function(re) {
				/* if(re.status == '1') {
					$('.user_pic img').attr('src',src );
				} */
				if(re.flag==true){
					alert("修改头像成功！");
					$(".photo").attr("src","${pageContext.request.contextPath}/we_file/"+re.logoName)
				}
				if(re.flag==false){
					alert("修改头像失败！");
				}
			}
		});
	}
</script>
		
		<!-- 上传头像结束 -->
  </body>
</html>
