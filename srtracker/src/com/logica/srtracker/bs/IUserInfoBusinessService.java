package com.logica.srtracker.bs;

import com.logica.srtracker.request.UserInfoRequest;
import com.logica.srtracker.response.UserInfoResponse;

public interface IUserInfoBusinessService {

	public abstract UserInfoResponse validate(UserInfoRequest request);

	public abstract UserInfoResponse register(UserInfoRequest request);
	
	public abstract UserInfoResponse changePassword(UserInfoRequest request);

}