package com.mytaxi.MytaxiServerApplicantTestApplication.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mytaxi.MytaxiServerApplicantTestApplication.entity.User;
import com.mytaxi.MytaxiServerApplicantTestApplication.repository.UserRepository;

@Component
public class UserDAOImpl implements UserDAO {
	
	private UserRepository userRepository;
	
	@Autowired
	UserDAOImpl(UserRepository userRepository){
		this.userRepository = userRepository;
	}
	
	@Override
	public List<User> getAllUsers(){
		List<User> userList = userRepository.findAll();
		return userList;
	}
	
	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}
	
}
