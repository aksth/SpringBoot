package com.mytaxi.MytaxiServerApplicantTestApplication.utility;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.mytaxi.MytaxiServerApplicantTestApplication.dto.UserDTO;
import com.mytaxi.MytaxiServerApplicantTestApplication.entity.Driver;
import com.mytaxi.MytaxiServerApplicantTestApplication.entity.User;

public class UserUtils {
	
	public static User converToEntity(UserDTO userDTO, Driver driver) {
		ZonedDateTime nowTime = ZonedDateTime.now();
		User user = new User.Builder()
				.name(userDTO.getName())
				.email(userDTO.getEmail())
				.password(BCrypt.hashpw(userDTO.getPassword(), BCrypt.gensalt()))
				.isDriver(userDTO.getIsDriver())
				.driver(driver)
				.status('Y')
				.createdDate(nowTime).build();
		
		return user;
	}
	
	public static User converToEntity(UserDTO userDTO) {
		ZonedDateTime nowTime = ZonedDateTime.now();
		User user = new User.Builder()
				.name(userDTO.getName())
				.email(userDTO.getEmail())
				.password(BCrypt.hashpw(userDTO.getPassword(), BCrypt.gensalt()))
				.isDriver(userDTO.getIsDriver())
				.status('Y')
				.createdDate(nowTime).build();
		
		return user;
	}
	
	public static List<UserDTO> convertToDTOList(List<User> userList){
	
		List<UserDTO> userDTOList = new ArrayList<>();
		
		for(User user : userList) {
			UserDTO userDTO = new UserDTO.Builder()
					.id(user.getId())
					.name(user.getName())
					.email(user.getEmail())
					.isDriver(user.isDriver())
					.status(user.getStatus())
					.createdDate(user.getCreatedDate()).build();
			userDTOList.add(userDTO);
			if(user.isDriver()) {
				userDTO.setLicenseNumber(user.getDriver().getLicenseNumber());
			}
		}
		return userDTOList;
	
	}

}
