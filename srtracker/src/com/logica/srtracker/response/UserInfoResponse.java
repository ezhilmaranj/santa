package com.logica.srtracker.response;

import com.logica.srtracker.data.UserInfo;

public class UserInfoResponse extends Response {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserInfoResponse() {
		super();
	}
	
	private UserInfo userInfo;

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
}
