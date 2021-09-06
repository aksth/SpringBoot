package com.mytaxi.MytaxiServerApplicantTestApplication.service;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mytaxi.MytaxiServerApplicantTestApplication.dao.DriverDAO;
import com.mytaxi.MytaxiServerApplicantTestApplication.dao.UserDAO;
import com.mytaxi.MytaxiServerApplicantTestApplication.entity.Driver;

@Component
public class DriverServiceImpl implements DriverService {
	
	private DriverDAO driverDAO;
	
	@Autowired
	DriverServiceImpl(DriverDAO driverDAO){
		this.driverDAO = driverDAO;
	}
	
	@Override
	public Driver addDriver(Driver driver) {
		return driverDAO.addDriver(driver);
	}
	
}
