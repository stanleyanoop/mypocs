package com.self.myworklist.business.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.self.myworklist.business.UserProcessor;
import com.self.myworklist.data.UserData;
import com.self.myworklist.dataaccess.impl.UserDaoImpl;

public class UserProcessorImpl implements UserProcessor {

	@Autowired
	UserDaoImpl userDao;
	
	@Override
	public UserData createUser(UserData user) {
		// TODO Auto-generated method stub
		return userDao.createUser(user);
	}

	@Override
	public UserData getUser(Long userId) {
		// TODO Auto-generated method stub
		return userDao.getUser(userId);
	}

}
