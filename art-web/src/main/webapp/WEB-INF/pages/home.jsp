<%@ page language="java"  isELIgnored="false" pageEncoding="UTF-8"%>
<%@ include file="inc/head.jsp" %>
<!DOCTYPE html>
<html class="no-js">
    
    <head>
        <title>Admin Home Page</title>
        <!-- Bootstrap -->
        <link href="${ctx }/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="${ctx }/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
        <link href="${ctx }/vendors/easypiechart/jquery.easy-pie-chart.css" rel="stylesheet" media="screen">
        <link href="${ctx }/assets/styles.css" rel="stylesheet" media="screen">
        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        <script src="${ctx }/vendors/jquery-1.9.1.js"></script>
        <script src="${ctx }/vendors/modernizr-2.6.2-respond-1.1.0.min.js"></script>
         <c:set var="local" value="home"></c:set>
    </head>
    
    <body>
        <%@ include file="inc/navbar.jsp" %>
        <div class="container-fluid">
            <div class="row-fluid">
                <%@ include file="inc/menu.jsp" %>
                
                <!--/span-->
                <div class="span9" id="content">
                    <div class="row-fluid">
                        <div class="alert alert-success">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
                            <h4>提示</h4>
                        	艺术馆管理系统</div>
                        	<!-- 
                        	<div class="navbar">
                            	<div class="navbar-inner">
	                                <ul class="breadcrumb">
	                                    <i class="icon-chevron-left hide-sidebar"><a href='#' title="Hide Sidebar" rel='tooltip'>&nbsp;</a></i>
	                                    <i class="icon-chevron-right show-sidebar" style="display:none;"><a href='#' title="Show Sidebar" rel='tooltip'>&nbsp;</a></i>
	                                    <li>
	                                        <a href="#">Dashboard</a> <span class="divider">/</span>	
	                                    </li>
	                                    <li>
	                                        <a href="#">Settings</a> <span class="divider">/</span>	
	                                    </li>
	                                    <li class="active">Tools</li>
	                                </ul>
                            	</div>
                        	</div>
                        	 -->
                    	</div>
                    <div class="row-fluid">
                        <!-- block -->
                        <!-- /block -->
                    </div>
                    <div class="row-fluid">
                    	<div class="span6">
                            <!-- block 我发起的审核单-->
                            <div class="block">
                                <div class="navbar navbar-inner block-header">
                                    <div class="muted pull-left"><a href="${ctx }/admin/receipt/list/view.form">我发起的审核单</a></div>
                                    <div class="pull-right"><span class="badge badge-info">0</span>

                                    </div>
                                </div>
                                <div class="block-content collapse in">
                                    <table class="table table-striped">
                                        <thead>
                                            <tr>
                                                <th>编号</th>
                                                <th>描述</th>
                                                <th>状态</th>
                                                <th>操作</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<c:forEach items="${receipts }" var="receipt">
                                            <tr>
                                                <td>${receipt.id }</td>
                                                <td>${receipt.memo }</td>
                                                <td>${receipt.status }</td>
                                                <td><a href="###" onClick="show_check(${receipt.id })">查看详情</a></td>
                                            </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <!-- /block -->
                        </div>
                        
                        <div class="span6">
                            <!-- block 我审核的审核单-->
                            <div class="block">
                                <div class="navbar navbar-inner block-header">
                                    <div class="muted pull-left"><a href="${ctx }/admin/receipt/list/view.form">我审核的审核单</a></div>
                                    <div class="pull-right"><span class="badge badge-info">0</span>

                                    </div>
                                </div>
                                <div class="block-content collapse in">
                                    <table class="table table-striped">
                                        <thead>
                                            <tr>
                                                <th>编号</th>
                                                <th>描述</th>
                                                <th>状态</th>
                                                <th>操作</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<c:forEach items="${myReceipts }" var="receipt">
                                            <tr>
                                                <td>${receipt.id }</td>
                                                <td>${receipt.memo }</td>
                                                <td>${receipt.status }</td>
                                                <td><a href="###" onClick="check(${receipt.id })">审核</a></td>
                                            </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <!-- /block -->
                        </div>
                    </div>
                </div>
            </div>
            <hr>
            <%@ include file="inc/footer.jsp" %>
        </div>
        <!--/.fluid-container-->
        <link href="${ctx }/vendors/artdialog/ui-dialog.css" rel="stylesheet" media="screen">
        <script src="${ctx }/bootstrap/js/bootstrap.min.js"></script>
        <script src="${ctx }/vendors/easypiechart/jquery.easy-pie-chart.js"></script>
        <script src="${ctx }/assets/scripts.js"></script>
        <script src="${ctx }/vendors/artdialog/dialog-min.js"></script>
        <script>
        $(function() {
            // Easy pie charts
            $('.chart').easyPieChart({animate: 1000});
        });
        
        show_check = function(id){
			var d = dialog({
			    title:"审核情况",
			    width:650
			});
			$.ajax({
			    url: "${ctx}/admin/check/process/view.form?receiptId="+id,
			    success: function (data) {
			        d.content(data);
			    },
			    cache: false
			});
			d.show();
		}
        
        check = function(id){
			var d = dialog({
			    title:"审核",
			    width:500
			});
			$.ajax({
			    url: "${ctx}/admin/check/view.form?receiptId="+id,
			    success: function (data) {
			        d.content(data);
			    },
			    cache: false
			});
			d.show();
		}
        
        $(document).ready(function(){
        	$("#addMuseum").click(function(){
        		var d = dialog({
        		    title:'添加艺术馆',
        		    width:550,
        			height:260
        		});
        		$.ajax({
        		    url: "${ctx}/admin/museum/add.form",
        		    success: function (data) {
        		        d.content(data);
        		    },
        		    cache: false
        		});
        		d.show();
        	});
        	
        	$(".museumRemove").click(function(){
        		if(confirm("删除艺术馆吗？")){
        			var museumId = $(this).attr("data");
        			$.ajax({
        				url:"${ctx}/admin/museum/delete.form",
        				dataType:"json",
        				data:{museumId:museumId},
        				method:"POST",
        				success:function(data){
        					alert(data.message);
        					if (data.code == 200){
        						window.location.reload();
        					}
        				}
        				
        			})
        		}
        	});
        });
        </script>
    </body>

</html>