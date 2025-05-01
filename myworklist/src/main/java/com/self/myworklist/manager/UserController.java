package com.self.myworklist.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.self.myworklist.business.UserProcessor;
import com.self.myworklist.data.UserData;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	UserProcessor processor;
	
	@PostMapping("/user")
	public UserData createUser(@RequestBody UserData user) {
		System.out.println("Updating the data >>> " + user.toString());
		
		return processor.createUser(user);
	}

	@GetMapping("/user/{userId}")
	public UserData getUserById(@PathVariable Long userId) {
		System.out.println("Getting the user data for user ID >>> " + userId);
		return processor.getUser(userId);
	}

	@GetMapping("/validuser/{userName}")
	public List<UserData> getUserByName(@PathVariable String userName) {
		System.out.println("Getting the user data for user Name >>> " + userName);
		return processor.getUser(userName);
	}

}
