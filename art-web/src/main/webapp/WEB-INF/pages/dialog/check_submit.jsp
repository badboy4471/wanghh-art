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
									<button type="button" data="${admin.id }" class="btn-allUser btn btn-default btn-lg">${admin.nickName }</button>
								</c:forEach>
							</div>
						</div>
						<div class="form-actions" style="margin-bottom:0px;">
							<button type="button" id="submitCheck" class="btn btn-primary">提交</button>
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
		
		$(".btn-allUser").click(function(){
			var text = $(this).html();
			var id = $(this).attr("data");
			var classes = $(this).attr("class");
			if (classes.indexOf("primary")>=0){
				$(this).removeClass("btn-primary");
				$(this).addClass("btn-default");
				$("#"+id).remove();
			}else{
				$(this).addClass("btn-primary");
				$(this).removeClass("btn-default");
				$("#selected").append("<span id='"+id+"'><button type='button' class='btn btn-default btn-lg'>"+text+"</button><input class='selectedUser' name='checkUser' type='hidden' value='"+id+"'></span>");
			}
		});
		
		$("#submitCheck").click(function() {
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