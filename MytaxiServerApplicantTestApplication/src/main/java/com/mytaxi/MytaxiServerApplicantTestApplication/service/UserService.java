package com.mytaxi.MytaxiServerApplicantTestApplication.service;

import java.util.List;

import com.mytaxi.MytaxiServerApplicantTestApplication.dto.UserDTO;
import com.mytaxi.MytaxiServerApplicantTestApplication.entity.User;

public interface UserService {
	
	public List<UserDTO> getAllUsers();
	
	public User addUser(User user);

}
