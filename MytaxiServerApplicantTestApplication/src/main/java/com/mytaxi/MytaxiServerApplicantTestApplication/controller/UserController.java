package com.mytaxi.MytaxiServerApplicantTestApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mytaxi.MytaxiServerApplicantTestApplication.constants.WebResourceKeyConstant;
import com.mytaxi.MytaxiServerApplicantTestApplication.dto.UserDTO;
import com.mytaxi.MytaxiServerApplicantTestApplication.entity.Driver;
import com.mytaxi.MytaxiServerApplicantTestApplication.entity.User;
import com.mytaxi.MytaxiServerApplicantTestApplication.service.DriverService;
import com.mytaxi.MytaxiServerApplicantTestApplication.service.UserService;
import com.mytaxi.MytaxiServerApplicantTestApplication.utility.DriverUtils;
import com.mytaxi.MytaxiServerApplicantTestApplication.utility.UserUtils;

@RestController
@RequestMapping(value = WebResourceKeyConstant.BASE_API + WebResourceKeyConstant.UserConstants.USER_BASE)
public class UserController {
	
	private UserService userService;
	private DriverService driverService;
	
	@Autowired
	UserController(UserService userService, DriverService driverService){
		this.userService = userService;
		this.driverService = driverService;
	}

	@GetMapping
	public ResponseEntity<List<UserDTO>> getAllUsers(){
		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> addUser(@RequestBody UserDTO userDTO){
		
		try {
			User user;
			if(userDTO.getIsDriver()) {
				Driver driver = driverService.addDriver(DriverUtils.converToEntity(userDTO));
				user = UserUtils.converToEntity(userDTO, driver);
			}else {
				user = UserUtils.converToEntity(userDTO);
			}
			
			userService.addUser(user);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}catch(Exception e) {
			throw e;
		}
	}
	
}
