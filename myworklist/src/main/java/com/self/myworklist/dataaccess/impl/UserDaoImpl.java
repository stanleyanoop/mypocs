package com.self.myworklist.dataaccess.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.self.myworklist.data.UserData;
import com.self.myworklist.dataaccessrepo.UserDaoRepo;

@Service
public class UserDaoImpl {
	@Autowired
	UserDaoRepo userRepo;

	public UserData createUser(UserData user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	public UserData getUser(Long userId) {
		// TODO Auto-generated method stub
		UserData user = null;
		try {
			Optional<UserData> optUser = userRepo.findById(userId);
			user = optUser.get();
		} catch (Exception e) {
			System.out.println("No response found!");
		}
		return user;
	}
	
	

}
