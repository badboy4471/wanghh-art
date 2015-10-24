<%@ page language="java" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ include file="../inc/head.jsp"%>
<div class="row-fluid">
	<div class="block-content collapse in">

		<div class="span12">
			<form id="museumForm" action="" method="post">
				<input type="hidden" name="artId" value="${artId }" id="artId" />
				<table class="table table-bordered" class="detail-table">
					<tbody>
						<tr>
							<c:forEach items="${museums }" var="museum" varStatus="i">
								<td>
								<c:if test="${museum.id > 0 }">
								<input style="margin-top: 0px" type="checkbox" name="museumId"
									value="${museum.id }" /> ${museum.name }
								</c:if>
								</td>
								<c:if test="${i.count % 3 == 0 }">
						</tr>
						<tr>
							</c:if>
							</c:forEach>
						</tr>
					</tbody>
				</table>
				<div class="form-actions" style="margin-bottom: 0px;">
					<button type="button" id="saveArchive" class="btn btn-primary">保存</button>
					<button type="button" class="btn">重置</button>
				</div>
			</form>
		</div>


	</div>
</div>

<script>
	$('.detail-table').dataTable({});

	$(document).ready(function() {
		$("#saveArchive").click(function() {
			$.ajax({
				method : "POST",
				url : "${ctx }/admin/art/museum/save.form",
				dataType : "json",
				data : $("#museumForm").serialize(),
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