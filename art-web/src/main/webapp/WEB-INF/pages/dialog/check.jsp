<%@ page language="java" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ include file="../inc/head.jsp" %>
<div class="row-fluid">
	<div class="block" style="border-top-style:solid; border-top-color: rgb(204,204,204);border-top-width: 1px">
		<div class="block-content collapse in">
			<div class="span12">
				<form action="" id="check_submit_form" class="form-horizontal"
					method="post">
					<input type="hidden" name="receiptId" value="${receiptId }">
					<fieldset>
						<div class="control-group">
							<label class="control-label">审核理由<span class="required">*</span></label>
							<div class="controls">
								<textarea rows="3" cols="120" id="memo" name="memo" placeholder="请输入审核意见"></textarea>
							</div>
						</div>
						<div class="form-actions" style="margin-bottom:0px;">
							<button type="button" class="btn btn-primary">提交</button>
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
		
		$(".btn").click(function() {
			$.ajax({
				method : "POST",
				url : "${ctx }/admin/check/submit.form",
				data : $('#check_submit_form').serialize(),
                success: function(data){
                	alert("["+data.code+"]:"+data.message);
                }
			});
		});
	});
</script>