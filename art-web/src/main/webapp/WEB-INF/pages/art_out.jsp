<%@ page language="java" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ include file="inc/head.jsp"%>
<!DOCTYPE html>
<html>

<head>
<title>艺术品添加</title>
<!-- Bootstrap -->
<link href="${ctx }/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	media="screen">
<link href="${ctx }/bootstrap/css/bootstrap-responsive.min.css"
	rel="stylesheet" media="screen">
<link href="${ctx }/assets/styles.css" rel="stylesheet" media="screen">
<link href="${ctx }/assets/DT_bootstrap.css" rel="stylesheet"
	media="screen">
<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="vendors/flot/excanvas.min.js"></script><![endif]-->
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
<script src="${ctx }/vendors/modernizr-2.6.2-respond-1.1.0.min.js"></script>
<c:set var="local" value="art.out"></c:set>
</head>

<body>
	<%@ include file="inc/navbar.jsp"%>
	<div class="container-fluid">
		<div class="row-fluid">
			<%@include file="inc/menu.jsp"%>
			<!--/span-->
			<div class="span9" id="content">
				<div class="row-fluid">
					<div class="block">
						<div class="navbar navbar-inner block-header">
							<div class="muted pull-left">作品出库</div>
						</div>
						
							<div class="block-content collapse in">
								<div class="span12">
									<form action="" id="artOutForm" class="form-horizontal"
										method="post">
										<fieldset>
											<div class="control-group">
												<label class="control-label">备注<span
													class="required">*</span></label>
												<div class="controls">
													<textarea rows="3" cols="120" name="memo"
														placeholder="借给了谁，联系电话，其他备注信息"></textarea>
												</div>
											</div>
											<div class="control-group">
												<label class="control-label">归还时间<span
													class="required">*</span></label>
												<div class="controls">
													<input name="backDate" id="backDate" type="text" />
												</div>
											</div>
											<div class="form-actions" style="margin-bottom: 0px;">
												<button type="button" id="saveMuseum"
													class="btn btn-primary">提交</button>
												<button type="button" class="btn">重置</button>
											</div>
										</fieldset>
									</form>
								</div>
							</div>
						
						<div class="block-content collapse in">
							<div class="span12">
								<table class="table table-bordered" class="detail-table">
									<tbody>
										<tr>
											<td colspan="4"><img src="${ctx }/${art.artImage }"
												style="width: 120px" /></td>
										</tr>
										<tr>
											<td>编号</td>
											<td>${art.artNumber }</td>
											<td>名称</td>
											<td>${art.artName }</td>
										</tr>
										<tr>
											<td>尺寸</td>
											<td>${art.artSize }</td>
											<td>材质</td>
											<td>${art.artMaterial }</td>
										</tr>
										<tr>
											<td>作者</td>
											<td>${art.artAuthor }</td>
											<td>证书：</td>
											<td>${art.artCert }</td>
										</tr>
										<tr>
											<td>年份：</td>
											<td>${art.artYear }</td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td colspan="4">描述</td>
										</tr>
										<tr>
											<td colspan="4">${art.artDesc }</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						
					</div>
				</div>
			</div>
		</div>
		<hr>
		<%@ include file="inc/footer.jsp"%>
	</div>
	<!--/.fluid-container-->
	<link href="${ctx }/vendors/datepicker.css" rel="stylesheet"
		media="screen">
	<link href="${ctx }/vendors/uniform.default.css" rel="stylesheet"
		media="screen">
	<link href="${ctx }/vendors/artdialog/ui-dialog.css" rel="stylesheet"
		media="screen">
	<script src="${ctx }/vendors/jquery-1.9.1.js"></script>
	<script src="${ctx }/bootstrap/js/bootstrap.min.js"></script>
	<script src="${ctx }/vendors/jquery.uniform.min.js"></script>
	<script src="${ctx }/vendors/chosen.jquery.min.js"></script>
	<script src="${ctx }/vendors/datatables/js/jquery.dataTables.min.js"></script>
	<script src="${ctx }/assets/scripts.js"></script>
	<script src="${ctx }/assets/DT_bootstrap.js"></script>
	<script src="${ctx }/vendors/artdialog/dialog-min.js"></script>
	<script src="${ctx }/vendors/bootstrap-datepicker.js"></script>
	<script>
		$(function() {
			$("#backDate").datepicker();
		});
		$(document).ready(function() {
			$("#saveMuseum").click(function() {
				var name = $("#name").val();
				var location = $("#location").val();
				$.ajax({
					method : "POST",
					url : "${ctx }/admin/museum/save.form",
					dataType : "json",
					data : {
						name : name,
						location : location
					},
					success : function(data) {
						alert(data.message);
						if (data.code == 200) {
							dialog.getCurrent().close().remove();
						}
					}
				});
			});
		});
	</script>
</body>
</html>