package com.mytaxi.MytaxiServerApplicantTestApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mytaxi.MytaxiServerApplicantTestApplication.entity.Driver;

public interface DriverRepository extends JpaRepository<Driver, Long>{
	

}
