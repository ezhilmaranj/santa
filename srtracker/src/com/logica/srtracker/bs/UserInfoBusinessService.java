package com.logica.srtracker.bs;

import com.logica.srtracker.dao.IUserInfoDAO;
import com.logica.srtracker.request.UserInfoRequest;
import com.logica.srtracker.response.UserInfoResponse;

public class UserInfoBusinessService implements IUserInfoBusinessService {

	private IUserInfoDAO userInfoDAO;

	public void setUserInfoDAO(IUserInfoDAO userInfoDAO) {
		this.userInfoDAO = userInfoDAO;
	}

	@Override
	public UserInfoResponse changePassword(UserInfoRequest request) {
		UserInfoResponse response = userInfoDAO.changePassword(request);
		return response;
	}

	@Override
	public UserInfoResponse register(UserInfoRequest request) {
		UserInfoResponse response = userInfoDAO.register(request);
		return response;
	}

	@Override
	public UserInfoResponse validate(UserInfoRequest request) {
		UserInfoResponse response = userInfoDAO.validate(request);
		return response;
	}

}
