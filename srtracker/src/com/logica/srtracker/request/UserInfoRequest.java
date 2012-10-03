package com.logica.srtracker.request;

public class UserInfoRequest extends Request {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3812200893907060091L;
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
