<%@ page language="java" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ include file="../inc/head.jsp" %>
<div class="row-fluid">
	<div class="block" style="border-top-style:solid; border-top-color: rgb(204,204,204);border-top-width: 1px">
		<div class="block-content collapse in">
			<div class="span12">
				<form action="" id="form_sample_1" class="form-horizontal"
					method="post">
						<div class="control-group">
							<label class="control-label">原密码<span class="required">*</span></label>
							<div class="controls">
								<input type="text" name="oldPassword" id="oldPassword" data-required="1"
									class=" m-wrap" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">新密码<span class="required">*</span></label>
							<div class="controls">
								<input name="newPassword" id="newPassword" type="text" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">新密码确认<span class="required">*</span></label>
							<div class="controls">
								<input name="newPassword2" id="newPassword2" type="text" />
							</div>
						</div>
						<div class="form-actions" style="margin-bottom:0px;">
							<button type="button" id="changePassword" class="btn btn-primary">提交</button>
							<button type="button" class="btn">重置</button>
						</div>
				</form>
			</div>
		</div>
	</div>
</div>
<script>
	$(document).ready(function() {
		$("#changePassword").click(function() {
			var oldPassword = $("#oldPassword").val();
			var newPassword = $("#newPassword").val();
			var newPassword2 = $("#newPassword2").val();
			$.ajax({
				method : "POST",
				url : "${ctx }/admin/change/password.form",
				dataType : "json",
				data : {
					oldPassword : oldPassword,
					newPassword : newPassword,
					newPassword2 : newPassword2
				},
				success : function(data) {
					alert(data.message);
					if (data.code == 200){
						alert(data.message);
						dialog.getCurrent().close().remove();
					}else{
						alert(data.message);
					}
				}
			});
		});
	});
</script>