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
							<label class="control-label">已经选中的审核人员<span class="required">*</span></label>
							<div id="selected" class="controls">
								
							</div>
						</div>
					</fieldset>
					<fieldset>
						<div class="control-group">
							<label class="control-label">所有员工<span class="required">*</span></label>
							<div class="controls">
								<c:forEach items="${admins }" var="admin">
									<input class="allUser" checked="false" type="checkbox" data="${admin.nickName }" value="${admin.id }">${admin.nickName }
								</c:forEach>
							</div>
						</div>
						<div class="form-actions" style="margin-bottom:0px;">
							<button type="button" id="saveMuseum" class="btn btn-primary">提交</button>
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
		
		$(".allUser").click(function(){
			var value = $(this).val();
			var text = $(this).attr("data");
			alert(value + text);
			var isSelected = $(this).attr("checked");
			alert(isSelected);
			if (isSelected){
				$("#selected").append("<input class='selectedUser' name='checkUser' id='"+value+"' type='checkbox' value='"+value+"'>"+text);
			}else{
				$("#"+value).remove();
			}
		})
		
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
					if (data.code == 200){
						dialog.getCurrent().close().remove();
					}
				}
			});
		});
	});
</script>