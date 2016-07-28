<%@ page language="java" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ include file="../inc/head.jsp" %>
<div class="row-fluid">
	<div class="block" style="border-top-style:solid; border-top-color: rgb(204,204,204);border-top-width: 1px">
		<div class="block-content collapse in">
			<div class="span12">
				<form action="" id="form_sample_1" class="form-horizontal"
					method="post">
					<fieldset>
  						<div class="control-group">
  							<label class="control-label">类型</label>
  							<div class="controls">
  								<select id="type" name="type">
  									<option value="1">入库</option>
  									<option value="2">出库</option>
  								</select>
  							</div>
  						</div>
  						<div class="control-group">
  							<label class="control-label">描述</label>
  							<div class="controls">
  								<textarea rows="3" cols="120" id="memo" name="memo">${receipt.memo }</textarea>
  							</div>
  						</div>
  						<div class="form-actions">
  							<button type="button" id="saveReceipt" class=" submit btn btn-primary">提交</button>
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
		$("#saveReceipt").click(function() {
			var memo = $("#memo").val();
			var type = $("#type").val();
			$.ajax({
				method : "POST",
				url : "${ctx }/admin/receipt/save.form",
				dataType : "json",
				data : {
					memo : memo,
					type : type
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