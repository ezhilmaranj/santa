package com.logica.srtracker.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor extends ActionSupport implements Interceptor,
		ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HttpServletRequest request;

	private static final Logger log = Logger.getLogger(LoginInterceptor.class);

	@Override
	public void destroy() {
	}

	@Override
	public void init() {

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String result = null;
		String className = invocation.getAction().getClass().getName();
		request = ServletActionContext.getRequest();
		HttpSession session = request.getSession(true);
		String user = (String) session.getAttribute("user");
		user = (user == null) ? "" : user;
		if (className == "com.logica.srtracker.action.UserInfoAction") {
			return invocation.invoke();
		}
		if ("".equals(user)) {
			log.error("Yet To Be Logged In.. Forworded to Login Page..!");
			addActionMessage("You Need To Login!");
			result = "login";
			return result;
		} else {
			return invocation.invoke();
		}
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}
}
