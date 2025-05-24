package com.self.myworklist.business;

import java.util.List;

import com.self.myworklist.data.UserData;

public interface UserProcessor {
	
	/**
	 * This method creates the user with the information passed through the 
	 * Entity object user
	 * 
	 * @param user
	 * @return
	 */
	public UserData createUser(UserData user);

	/**
	 * This method fetches the user information for the given userId
	 * 
	 * @param userId
	 * @return
	 */
	public UserData getUser(Long userId);

	/**
	 * This method fetches the user information for the given userName
	 * @param userName
	 * @return
	 */
	public List<UserData> getUser(String userName);

}
