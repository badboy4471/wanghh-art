package com.whh.art.web.controller;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.whh.art.dao.model.AdminModel;
import com.whh.art.service.IOptLogService;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	@Resource
	IOptLogService optLogService;

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
//				builder.append(request.getContextPath());
				builder.append("/login.html\";</script>");
				out.print(builder.toString());
				out.close();
				return false;
			}
			admin = (AdminModel)obj;
			
			optLogService.insert(admin.getId(), uri);
		}
		return super.preHandle(request, response, handler);
	}

}
