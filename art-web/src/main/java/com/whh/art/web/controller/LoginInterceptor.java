package com.whh.art.web.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.whh.art.dao.model.AdminModel;
import com.whh.art.dao.model.SystemActionModel;
import com.whh.art.service.IAdminService;
import com.whh.art.service.IOptLogService;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	@Resource
	IOptLogService optLogService;
	@Resource
	IAdminService adminService;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		AdminModel admin = null;
		// System.out.println("[ServerName="+request.getServerName()+",LocalAddr="+request.getLocalAddr()+",LocalName="+request.getLocalName()+",LocalPort="+request.getLocalPort()+"]");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String[] noFilters = new String[] { "login.jsp", "login.do",
				"weixin.do" };// 不需要过滤的页面
		String uri = request.getRequestURI();
		boolean beFilter = true;
		for (String s : noFilters) {
			if (uri.indexOf(s) != -1) {
				beFilter = false;
				break;
			}
		}
		if (beFilter) {
			Object obj = request.getSession().getAttribute(LoginController.SESSION_KEY);
			if (obj == null) {
				PrintWriter out = response.getWriter();
				StringBuilder builder = new StringBuilder();
				builder.append("<script type=\"text/javascript\" charset=\"UTF-8\">");
				builder.append("alert(\"页面过期，请重新登录\");");
				builder.append("window.top.location.href=\"");
				builder.append(request.getContextPath());
				builder.append("/login.html\";</script>");
				out.print(builder.toString());
				out.close();
				return false;
			}
			admin = (AdminModel)obj;
			
			Object rights = request.getSession().getAttribute(LoginController.USER_RIGHT_KEY);
			
			if (rights != null){
				uri = uri.replaceAll(".form", "");
				Set<SystemActionModel> actions = (Set)rights;
				boolean hasRight = this.hasRight(admin, uri, actions);
				if (!hasRight){
					/*PrintWriter out = response.getWriter();
					StringBuilder builder = new StringBuilder();
					builder.append("<script type=\"text/javascript\" charset=\"UTF-8\">");
					builder.append("alert(\"你没有权限访问该功能,请更换有更高权限的账号进行登录！\");");
					//builder.append("window.top.location.href=\"");
					//builder.append(request.getContextPath());
					//builder.append("/login.html\";");
					builder.append("</script>");
					out.print(builder.toString());
					out.close();*/
					response.sendRedirect(request.getContextPath()+"/403.html");
					return false;
				}
			}
			
			optLogService.insert(admin.getId(), uri);
		}
		return super.preHandle(request, response, handler);
	}
	
	
	private boolean hasRight(AdminModel admin, String action,Set<SystemActionModel> actions) {
		if (admin.getId() == 1){
			return true;
		}
		Map<String, String> rights = this.change2Map(actions);
		return StringUtils.isNotEmpty(rights.get(action));
	}


	private Map<String, String> change2Map(Set<SystemActionModel> actions) {
		Map<String, String> map = new HashMap<String, String>();
		for (SystemActionModel action : actions) {
			map.put(action.getAction(), action.getAction_key());
		}
		return map;
	}
}
