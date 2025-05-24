package com.self.myworklist.dataaccess.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
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

	public List<UserData> getUser(String userName) {
		try {
			UserData userQuery = new UserData();
			userQuery.setUserName(userName);
			ExampleMatcher matcher = ExampleMatcher.matching().withIgnorePaths("userId");
			Example<UserData> example = Example.of(userQuery, matcher);
			List<UserData> queryUsers = userRepo.findAll(example);
			System.out.println("out from hibernate for the username : " + queryUsers);
			return queryUsers;
		} catch (Exception e) {
			System.out.println("No response found!");
		}
		return null;
	}
	
	

}
