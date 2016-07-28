<%@ page language="java"  isELIgnored="false" pageEncoding="UTF-8"%>
<%@ include file="../inc/head.jsp" %>
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
        <script src="${ctx }/vendors/jquery-1.9.1.js"></script>
        <script src="${ctx }/vendors/modernizr-2.6.2-respond-1.1.0.min.js"></script>
        <c:set var="local" value="check.list"></c:set>
    </head>
    
    <body>
        <%@ include file="../inc/navbar.jsp" %>
        <div class="container-fluid">
            <div class="row-fluid">
                <%@include file="../inc/menu.jsp" %>
                <!--/span-->
                <div class="span9" id="content">
                      <!-- morris stacked chart -->
                     <!-- validation -->
                    <div class="row-fluid">
                         <!-- block -->
                        <div class="block">
                            <div class="navbar navbar-inner block-header">
                                <div class="muted pull-left">审核单列表</div>
                            </div>
                            
                            <div class="block-content collapse in">
                                <div class="span12">
                                 
                                   <div class="table-toolbar">
                                      <div class="btn-group">
                                         <a href="${ctx }/admin/art/add.form"><button class="btn btn-success">Add New <i class="icon-plus icon-white"></i></button></a>
                                      </div>
                                      <div class="btn-group pull-right">
										<p>
										<!-- 
										<select style="width: 150px;margin-bottom:0px;margin-right: 5px;" id="museumId" name="museumId">
                                              <option value="0">请选择艺术馆</option>
                                        </select>
                                         -->
										<input style="width: 150px;margin-bottom:0px;margin-right: 5px;" placeholder="编号" id="artNumber" type="text" >
										<input style="width: 150px;margin-bottom:0px;margin-right: 5px;" placeholder="内部编号" id="artInnerNumber" type="text" >
										<input style="width: 150px;margin-bottom:0px;margin-right: 5px;" placeholder="名称" id="artName" type="text" > <button class="btn" id="searchBtn"><i class="icon-search"></i>搜索</button>
										</p>
                                      </div>
                                   </div>
                                   <!-- private int id;
	private String memo;
	private Date createTime;
	private int createUid;
	private int status;
	private int type;
	private Date lastUpdateTime; -->
                                    <table cellspacing="0" class="table table-striped table-bordered" id="artList">
                                        <thead>
                                            <tr>
                                                <th>编号</th>
                                                <th>描述</th>
                                                <th>提交时间</th>
                                                <th>类型</th>
                                                <th>状态</th>
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
            <%@ include file="../inc/footer.jsp" %>
        </div>
        <!--/.fluid-container-->
        <link href="${ctx }/vendors/datepicker.css" rel="stylesheet" media="screen">
        <link href="${ctx }/vendors/uniform.default.css" rel="stylesheet" media="screen">
        <link href="${ctx }/vendors/artdialog/ui-dialog.css" rel="stylesheet" media="screen">
        <script src="${ctx }/bootstrap/js/bootstrap.min.js"></script>
        <script src="${ctx }/vendors/jquery.uniform.min.js"></script>
        <script src="${ctx }/vendors/chosen.jquery.min.js"></script>
        <script src="${ctx }/vendors/datatables/js/jquery.dataTables.min.js"></script>
		<script src="${ctx }/assets/scripts.js"></script>
		<script src="${ctx }/assets/DT_bootstrap.js"></script>
		<script src="${ctx }/vendors/artdialog/dialog-min.js"></script>
		<script src="${ctx }/vendors/bootstrap-datepicker.js"></script>
		<script>
		var oTable = null; 
		function retrieveData( sSource, aoData, fnCallback ) {  
		    //将客户名称加入参数数组  
		    var name = $("#key").val();
			var status = $("#status").val();
			aoData.push({ "name": "name", "value": name});
			aoData.push({ "name": "status", "value": status});
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
					"sDom": "<'row'l f<'search'> r>t<'row'<'span6'i><'span6'p>>",
					"bProcessing": true,
				    "sAjaxSource":"${ctx}/admin/receipt/search.form",
				    "bServerSide":true,
				    "aoColumns": [
						{ "mData": 'id'},
						{ "mData": 'memo'},
						{ "mData": 'createTime'，
						  "mRender" : function(data,type,row){
							  return Date(parseInt(data)).toLocaleString().replace(/:\d{1,2}$/,' ');
						  }
						},
						{ "mData": 'type',
						  "mRender" : function(data,type,row){
								return data == 1?'出库':'入库';
						   }	
						},
						{ "mData": 'status',
						  "mRender":function(data,type,row){
							  	if (data == 0)
							  		return "待提交审核";
								if (data == 1)
									return "审核中";
								if (data == 2)
									return "审核通过";
								if (data == 3)
									return "审核不通过";
								
								return "未知状态";
							}
						},
						{ "mData": 'id'}
					],
					"fnServerData": retrieveData,           //获取数据的处理函数  
		            "bFilter": false,                       //不使用过滤功能  
		            "bLengthChange": false,                 //用户不可改变每页显示数量  
		            "iDisplayLength": 10,                    //每页显示10条数据  
		            "sPaginationType": "bootstrap",
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
		            },
		            
			    });
			}else{
				oTable.fnDraw();
			}
		}
		
		
		detail=function(title,id){
			var d = dialog({
			    title:title,
			    width:500,
			    height:500
			});
			$.ajax({
			    url: "${ctx}/admin/art/detail.form?id="+id,
			    success: function (data) {
			        d.content(data);
			    },
			    cache: false
			});
			d.show();
		}
		
	    
	    
		del=function(id){
			if(confirm("删除艺术品？")){
				$.ajax({
				    url: "${ctx}/admin/art/del.form?id="+id,
				    success: function (data) {
				        if (data.code == 200){
				        	alert(data.message);
				        }
				    },
				    cache: false
				});
			}
		};
		
		initSelect = function(){
			var optionSize = $("#museumId option").size();
			if (optionSize == 1){
				$.ajax({
					url:"${ctx}/admin/museum/all.form",
					dataType:"json",
					method:"POST",
					success:function(data){
						$.each(data.data, function(i, item) {
				            $("#museumId").append(
				                    "<option value="+item.id+">" + item.name + "</option>");
				                   
				        });
					}
				})
			}
		}
		
		$(document).ready(function(){
			search();
			
			$("body").on("click", '#searchBtn', function(){
				search();
			});
			
			$("body").on("click",'.archive',function(){
				var artId = $(this).attr("data");
				var d = dialog({
				    title:"归档",
					width:500,
					height:240
				});
				$.ajax({
					url: "${ctx}/admin/museum/list.form?artId="+artId,
					success: function (data) {
						d.content(data);
					},
					cache: false
				});
				d.show();
			});
			
			$("body").on("click",'.goout',function(){
				var artId = $(this).attr("data");
				var d = dialog({
				    title:"归档",
					width:500,
					height:500
				});
				$.ajax({
					url: "${ctx}/admin/art/out.form?artId="+artId,
					success: function (data) {
						d.content(data);
					},
					cache: false
				});
				d.show();
			});
			
			initSelect();
			$("body").on("click","#museumId",function(){
				initSelect();
			})
		}) 
		</script>
    </body>
</html>