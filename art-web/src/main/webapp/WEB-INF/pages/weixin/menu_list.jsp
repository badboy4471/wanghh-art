<%@ page language="java"  isELIgnored="false" pageEncoding="UTF-8"%>
<%@ include file="../inc/head.jsp" %>
<!DOCTYPE html>
<html class="no-js">
    
    <head>
        <title>791艺术街区-自定义菜单</title>
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
         <c:set var="local" value="weixin.menu"></c:set>
    </head>
    
    <body>
        <%@ include file="../inc/navbar.jsp" %>
        <div class="container-fluid">
            <div class="row-fluid">
                <%@ include file="../inc/menu.jsp" %>
                
                <!--/span-->
                <div class="span9" id="content">
                    <div class="row-fluid">
                        <div class="alert alert-success">
                            <button type="button" id="flushtowx" data-dismiss="alert">同步到微信</button>
                            <h4>本地JSON</h4>
                            ${localJson }</div>
                        <div class="alert alert-success">
                            <button type="button" id="clearwxmenu" data-dismiss="alert">删除微信菜单</button>
                            <h4>远端JSON</h4>
                            ${remoteJson }</div>
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
                        <c:forEach var="menu" items="${menus }" varStatus="midx">
                        <c:if test="${ not empty menu.name }">
                        <div class="span6">
                            <!-- block -->
                            <div class="block">
                                <div class="navbar navbar-inner block-header">
                                    <div class="muted pull-left"><a href="###" class="museumRemove" data="${menu }"><i class="icon-remove"></i></a> ${menu.name }/${menu.type }/${menu.key }${menu.url }</div>
                                    <div class="pull-right"><span class="badge badge-info addSubMenu" pid="${menu.id }">添加子菜单</span>

                                    </div>
                                </div>
                                <div class="block-content collapse in">
                                    <table class="table table-striped">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>菜单名</th>
                                                <th>菜单类型</th>
                                                <th>KEY</th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${menu.sub_menu }" var="sub_menu" varStatus="idx">
                                            <tr>
                                                <td>${idx.count }</td>
                                                <td>${sub_menu.name }</td>
                                                <td>${sub_menu.type }</td>
                                                <td>${sub_menu.key }${sub_menu.url }</td>
                                                <td><a class="delSubMenu" id="${sub_menu.id }" href="###">删除</a></td>
                                            </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <!-- /block -->
                        </div>
                        </c:if>
                        <c:if test="${empty menu.name}">
                            <div class="span6">
                            <!-- block -->
                            <div class="block">
                                <div class="navbar navbar-inner block-header">
                                    <div class="muted pull-left">添加</div>
                                </div>
                                <div class="block-content collapse in">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td style="border-top: none;text-align: center;">
                                                    <a href="###" id="addMuseum"><img alt="add" src="${ctx }/images/big-add.png"></a>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <!-- /block -->
                        </div>
                        </c:if>
                        <c:if test="${midx.count%2 == 0 }">
                            </div>
                            <div class="row-fluid">
                        </c:if>
                        
                        
                        </c:forEach>
                    </div>
                    
                    
                </div>
            </div>
            <hr>
            <%@ include file="../inc/footer.jsp" %>
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
        $(document).ready(function(){
        	$(".addSubMenu").click(function(){
        		var d = dialog({
        		    title:'添加子菜单',
        		    width:550,
        			height:260
        		});
        		$.ajax({
        		    url: "${ctx}/admin/weixin/submenu/add.form",
        		    success: function (data) {
        		        d.content(data);
        		    },
        		    cache: false
        		});
        		d.show();
        	});
        	
        	$(".delSubMenu").click(function(){
        		if(confirm("删除微信菜单？")){
        			var museumId = $(this).attr("data");
        			$.ajax({
        				url:"${ctx}/admin/weixin/menu/delete.form",
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
        	
        	$(".flushtowx").click(function(){
        		if(confirm("确定更新菜单到微信？")){
        			$.ajax({
        				url:"${ctx}/admin/weixin/menu/flush.form",
        				dataType:"json",
        				data:{museumId:museumId},
        				method:"GET",
        				success:function(data){
        					alert(data.message);
        					if (data.code == 200){
        						window.location.reload();
        					}
        				}
        			})
        		}
        	});
        	
        	$(".clearwxmenu").click(function(){
        		if(confirm("确定清空微信菜单？")){
        			var museumId = $(this).attr("data");
        			$.ajax({
        				url:"${ctx}/admin/weixin/menu/clear.form",
        				dataType:"json",
        				data:{museumId:museumId},
        				method:"GET",
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