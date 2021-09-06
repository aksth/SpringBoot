package com.mytaxi.MytaxiServerApplicantTestApplication.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mytaxi.MytaxiServerApplicantTestApplication.dao.UserDAO;
import com.mytaxi.MytaxiServerApplicantTestApplication.dto.UserDTO;
import com.mytaxi.MytaxiServerApplicantTestApplication.entity.User;
import com.mytaxi.MytaxiServerApplicantTestApplication.utility.UserUtils;

@Component
public class UserServiceImpl implements UserService {
	
	private UserDAO userDAO;
	private final ModelMapper modelMapper;
	
	@Autowired
	UserServiceImpl(UserDAO userDAO, ModelMapper modelMapper){
		this.userDAO = userDAO;
		this.modelMapper = modelMapper;
	}
	
	@Override
	public List<UserDTO> getAllUsers(){
		List<UserDTO> userDTOList = new ArrayList<>();
		List<User> userList = userDAO.getAllUsers();
		//Type type = new TypeToken<List<UserDTO>>(){}.getType();
		//userDTOList = modelMapper.map(userList, type);
		return UserUtils.convertToDTOList(userList);
	}
	
	@Override
	public User addUser(User user) {
		return userDAO.addUser(user);
	}
	
}
