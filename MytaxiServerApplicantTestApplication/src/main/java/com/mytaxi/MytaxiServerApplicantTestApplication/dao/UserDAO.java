package com.mytaxi.MytaxiServerApplicantTestApplication.dao;

import java.util.List;

import com.mytaxi.MytaxiServerApplicantTestApplication.entity.User;

public interface UserDAO {
	
	public List<User> getAllUsers();
	
	public User addUser(User user);
	
}
