<%@ page language="java"  isELIgnored="false" pageEncoding="UTF-8"%>
<footer>
	<p>&copy; Vincent Gabriel 2013</p>
</footer>
<script>
	$(document).ready(function() {
		$("#toChangePassword").click(function() {
			var d = dialog({
				title : '修改密码',
				width : 400,
				height : 300
			});
			$.ajax({
				url : "/admin/to/change/password.form",
				success : function(data) {
					d.content(data);
				},
				cache : false
			});
			d.show();
		});
	});
</script>