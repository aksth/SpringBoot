package com.mytaxi.MytaxiServerApplicantTestApplication.utility;

import java.time.ZonedDateTime;

import com.mytaxi.MytaxiServerApplicantTestApplication.dto.UserDTO;
import com.mytaxi.MytaxiServerApplicantTestApplication.entity.Driver;

public class DriverUtils {
	public static Driver converToEntity(UserDTO userDTO) {
		Driver driver = null;
		if(userDTO.getIsDriver()) {
			ZonedDateTime nowTime = ZonedDateTime.now();
			driver = new Driver.Builder()
					.licenseNumber(userDTO.getLicenseNumber())
					.status('Y')
					.createdDate(nowTime).build();
		}
		
		return driver;
	}
}
