package com.logica.srtracker.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.logica.srtracker.bs.IUserInfoBusinessService;
import com.logica.srtracker.request.UserInfoRequest;
import com.logica.srtracker.response.UserInfoResponse;
import com.logica.srtracker.util.LogicaUtils;
import com.logica.srtracker.util.PasswordService;
import com.opensymphony.xwork2.ActionSupport;

public class UserInfoAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<String, Object> session;

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	IUserInfoBusinessService userInfoBusinessService = (IUserInfoBusinessService) LogicaUtils
			.getSpringContext().getBean("userInfoBusinessService");

	PasswordService ps = PasswordService.getInstance();

	public String registerlink() {
		return "register";
	}

	public String changePassword() {
		String ret = "";
		UserInfoRequest request = new UserInfoRequest();
		request.setUserName((String) session.get("user"));
		request.setPassword(ps.encrypt(password));
		UserInfoResponse response = userInfoBusinessService
				.changePassword(request);
		if (response.getStatus()) {
			addActionMessage("Password Changed Successfully..!");
			session.clear();
			ret = "home";
		} else {
			addActionError(response.getErrors().getErrDesc());
		}

		return ret;
	}

	public String check() {
		String ret = "";
		UserInfoRequest request = new UserInfoRequest();
		request.setUserName(userName);
		PasswordService ps = PasswordService.getInstance();
		request.setPassword(ps.encrypt(password));
		UserInfoResponse response = userInfoBusinessService.validate(request);
		if (response.getStatus()) {
			ret = "home";
			session.put("role", response.getUserInfo().getRole());
			session.put("user", userName);
		} else {
			ret = "login";
			addActionError(response.getErrors().getErrDesc());
		}
		return ret;
	}

	public String register() {
		String ret = "";
		UserInfoRequest request = new UserInfoRequest();
		request.setUserName(userName);
		request.setPassword(ps.encrypt(password));
		request.setEmail(email);
		request.setRole("user");
		UserInfoResponse response = userInfoBusinessService.register(request);
		if (response.getStatus()) {
			addActionMessage("User Registered Successfully..!");
			ret = "register";
		} else {
			addActionError(response.getErrors().getErrDesc());
			ret = "register";
		}
		return ret;
	}

	public String logout() {
		session.clear();
		return "home";
	}

	private String userName;
	private String password;
	private String email;
	private String role;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
