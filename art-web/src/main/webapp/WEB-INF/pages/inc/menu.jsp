<%@ page language="java" isELIgnored="false" pageEncoding="UTF-8"%>
<div class="span3" id="sidebar">
	<ul class="nav nav-list bs-docs-sidenav nav-collapse collapse">
		<li <c:if test="${local == 'home' }">class="active"</c:if>><a href="${ctx }/admin/index.form"><i
				class="icon-chevron-right"></i> 首页</a></li>
		<li <c:if test="${local == 'art.list' }">class="active"</c:if>><a href="${ctx }/admin/art/list.form"><i class="icon-chevron-right"></i>
				作品列表</a></li>
		<li <c:if test="${local == 'art.add' }">class="active"</c:if>><a href="${ctx }/admin/art/add.form"><i class="icon-chevron-right"></i>
				添加作品</a></li>
		
		<li <c:if test="${local == 'receipt.add' }">class="active"</c:if>><a href="${ctx }/admin/receipt/add.form"><i class="icon-chevron-right"></i>
				创建审核单</a></li>
		
		<li <c:if test="${local == 'user.list' }">class="active"</c:if>><a href="${ctx }/admin/wx/user/list.form"><i class="icon-chevron-right"></i>
				用户列表</a></li>
				
		<li <c:if test="${local == 'weixin.menu' }">class="active"</c:if>><a href="${ctx }/admin/weixin/menu/view.form"><i class="icon-chevron-right"></i>
				自定义菜单</a></li>
		<!-- 
		<li><a href="tables.html"><i class="icon-chevron-right"></i>
				Tables</a></li>
		<li><a href="buttons.html"><i class="icon-chevron-right"></i>
				Buttons & Icons</a></li>
		<li><a href="editors.html"><i class="icon-chevron-right"></i>
				WYSIWYG Editors</a></li>
		<li><a href="interface.html"><i class="icon-chevron-right"></i>
				UI & Interface</a></li>
		<li><a href="#"><span class="badge badge-success pull-right">731</span>
				Orders</a></li>
		<li><a href="#"><span class="badge badge-success pull-right">812</span>
				Invoices</a></li>
		<li><a href="#"><span class="badge badge-info pull-right">27</span>
				Clients</a></li>
		<li><a href="#"><span class="badge badge-info pull-right">1,234</span>
				Users</a></li>
		<li><a href="#"><span class="badge badge-info pull-right">2,221</span>
				Messages</a></li>
		<li><a href="#"><span class="badge badge-info pull-right">11</span>
				Reports</a></li>
		<li><a href="#"><span
				class="badge badge-important pull-right">83</span> Errors</a></li>
		<li><a href="#"><span class="badge badge-warning pull-right">4,231</span>
				Logs</a></li>
		 -->
	</ul>
</div>