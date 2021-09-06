package com.mytaxi.MytaxiServerApplicantTestApplication.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mytaxi.MytaxiServerApplicantTestApplication.entity.Driver;
import com.mytaxi.MytaxiServerApplicantTestApplication.repository.DriverRepository;

@Component
public class DriverDAOImpl implements DriverDAO {
	
	private DriverRepository driverRepository;
	
	@Autowired
	DriverDAOImpl(DriverRepository driverRepository){
		this.driverRepository = driverRepository;
	}
	
	@Override
	public Driver addDriver(Driver driver) {
		return driverRepository.save(driver);
	}
	
}
