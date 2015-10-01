<%@ page language="java"  isELIgnored="false" pageEncoding="UTF-8"%>
<%@ include file="inc/head.jsp" %>
<!DOCTYPE html>
<html>
    
    <head>
        <title>艺术品添加</title>
        <!-- Bootstrap -->
        <link href="${ctx }/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="${ctx }/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
        <link href="${ctx }/assets/styles.css" rel="stylesheet" media="screen">
        <link href="${ctx }/assets/DT_bootstrap.css" rel="stylesheet" media="screen">
        <!--[if lte IE 8]><script language="javascript" type="text/javascript" src="vendors/flot/excanvas.min.js"></script><![endif]-->
        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        <script src="${ctx }/vendors/modernizr-2.6.2-respond-1.1.0.min.js"></script>
    </head>
    
    <body>
        <%@ include file="inc/navbar.jsp" %>
        <div class="container-fluid">
            <div class="row-fluid">
                <%@include file="inc/menu.jsp" %>
                <!--/span-->
                <div class="span9" id="content">
                      <!-- morris stacked chart -->

                     <!-- validation -->
                    <div class="row-fluid">
                         <!-- block -->
                        <div class="block">
                            <div class="navbar navbar-inner block-header">
                                <div class="muted pull-left">Bootstrap dataTables with Toolbar</div>
                            </div>
                            <div class="block-content collapse in">
                                <div class="span12">
                                   <div class="table-toolbar">
                                      <div class="btn-group">
                                         <a href="#"><button class="btn btn-success">Add New <i class="icon-plus icon-white"></i></button></a>
                                      </div>
                                      <div class="btn-group pull-right">
                                         <button data-toggle="dropdown" class="btn dropdown-toggle">Tools <span class="caret"></span></button>
                                         <ul class="dropdown-menu">
                                            <li><a href="#">Print</a></li>
                                            <li><a href="#">Save as PDF</a></li>
                                            <li><a href="#">Export to Excel</a></li>
                                         </ul>
                                      </div>
                                   </div>
                                    
                                    <table cellspacing="0" class="table table-striped table-bordered" id="artList">
                                        <thead>
                                            <tr>
                                                <th>缩略图</th>
                                                <th>名字</th>
                                                <th>介绍</th>
                                                <th>材料/尺寸</th>
                                                <th>操作</th>
                                            </tr>
                                        </thead>
                                        
                                    </table>
                                </div>
                            </div>
                        </div>
                     	<!-- /block -->
		    </div>
                     <!-- /validation -->


                </div>
            </div>
            <hr>
            <%@ include file="inc/footer.jsp" %>
        </div>
        <!--/.fluid-container-->
        <link href="${ctx }/vendors/uniform.default.css" rel="stylesheet" media="screen">
        <script src="${ctx }/vendors/jquery-1.9.1.js"></script>
        <script src="${ctx }/bootstrap/js/bootstrap.min.js"></script>
        <script src="${ctx }/vendors/jquery.uniform.min.js"></script>
        <script src="${ctx }/vendors/chosen.jquery.min.js"></script>
        <script src="${ctx }/vendors/datatables/js/jquery.dataTables.min.js"></script>
		<script src="${ctx }/assets/scripts.js"></script>
		
		<script>
		var oTable = null; 
		function retrieveData( sSource, aoData, fnCallback ) {  
		    //将客户名称加入参数数组  
		    //aoData.push( { "name": "customerName", "value": $("#customerName").val() } );  
		    $.ajax( {  
		        "type": "POST",   
		        "contentType": "application/json",  
		        "url": sSource,   
		        "dataType": "json",  
		        "data": JSON.stringify(aoData), //以json格式传递  
		        "success": function(resp) { 
		            fnCallback(resp); //服务器端返回的对象的returnObject部分是要求的格式  
		        }  
		    });  
		}
		function search() {
			if (oTable == null) { //仅第一次检索时初始化Datatable  
				oTable = $("#artList").dataTable({
					"bProcessing": true,
				    "sAjaxSource":"${ctx}/admin/art/search.form",
				    "bServerSide":true,
				    "aoColumns": [
						{ "mData": 'imageUrl' },
						{ "mData": 'artName' },
						{ "mData": 'artDesc' },
						{ "mData": 'artSize' },
						{ "mData": 'id' }
					],
					"fnServerData": retrieveData,           //获取数据的处理函数  
		            //"bFilter": false,                       //不使用过滤功能  
		            "bLengthChange": false,                 //用户不可改变每页显示数量  
		            "iDisplayLength": 10,                    //每页显示10条数据  
		            "oLanguage": {                          //汉化  
		                "sLengthMenu": "每页显示 _MENU_ 条记录",  
		                "sZeroRecords": "没有检索到数据",  
		                "sInfo": "当前数据为从第 _START_ 到第 _END_ 条数据；总共有 _TOTAL_ 条记录",  
		                "sInfoEmpty": "没有数据",  
		                "sProcessing": "正在加载数据...",  
		                "oPaginate": {  
		                    "sFirst": "首页",  
		                    "sPrevious": "前页",  
		                    "sNext": "后页",  
		                    "sLast": "尾页"  
		                }  
		            }  
			    });
			}
			oTable.fnDraw(); 
		}
		
		search();
		</script>
    </body>
</html>