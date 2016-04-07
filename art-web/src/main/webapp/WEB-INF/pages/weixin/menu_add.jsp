<%@ page language="java" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ include file="../inc/head.jsp" %>
<div class="row-fluid">
	<div class="block" style="border-top-style:solid; border-top-color: rgb(204,204,204);border-top-width: 1px">
		<div class="block-content collapse in">
			<div class="span12">
				<form action="" id="form_sample_1" class="form-horizontal"
					method="post">
					<input type="hidden" id="pid" name="pid" value="${pid }"/>
					<fieldset>
						<div class="control-group">
							<label class="control-label">菜单名称：<span class="required">*</span></label>
							<div class="controls">
								<input type="text" name="name" id="name" data-required="1"
									class=" m-wrap" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">类型：<span class="required">*</span></label>
							<div class="controls">
								<input name="type" id="type" value="view" readonly="readonly" type="text" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">参数：<span class="required">*</span></label>
							<div class="controls">
								<input name="param" id="param" type="text" />
							</div>
						</div>
						<div class="form-actions" style="margin-bottom:0px;">
							<button type="button" id="saveMenu" class="btn btn-primary">提交</button>
							<button type="button" class="btn">重置</button>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</div>
<script>
	$(document).ready(function() {
		$("#saveMenu").click(function() {
			var name = $("#name").val();
			var param = $("#param").val();
			var pid = $("#pid").val();
			$.ajax({
				method : "POST",
				url : "${ctx }/admin/weixin/menu/save.form",
				dataType : "json",
				data : {
					pid : pid,
					name : name,
					type : 'view',
					param : param
				},
				success : function(data) {
					alert(data.message);
					if (data.code == 200){
						dialog.getCurrent().close().remove();
					}
				}
			});
		});
	});
</script>