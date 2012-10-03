package com.logica.srtracker.dao;

import java.util.List;

import com.logica.srtracker.data.UserInfo;
import com.logica.srtracker.request.UserInfoRequest;
import com.logica.srtracker.response.UserInfoResponse;

public interface IUserInfoDAO {

	public abstract void save(UserInfo transientInstance);

	public abstract void delete(UserInfo persistentInstance);

	public abstract UserInfo findById(java.lang.String id);

	public abstract List findByExample(UserInfo instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByPassword(Object password);

	public abstract List findByEmail(Object email);

	public abstract List findByRole(Object role);

	public abstract List findAll();

	public abstract UserInfo merge(UserInfo detachedInstance);

	public abstract void attachDirty(UserInfo instance);

	public abstract void attachClean(UserInfo instance);
	
	public abstract UserInfoResponse validate(UserInfoRequest request);
	
	public abstract UserInfoResponse register(UserInfoRequest request);
	
	public abstract UserInfoResponse changePassword(UserInfoRequest request);

}