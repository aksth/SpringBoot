package com.mytaxi.MytaxiServerApplicantTestApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mytaxi.MytaxiServerApplicantTestApplication.dto.UserDTO;
import com.mytaxi.MytaxiServerApplicantTestApplication.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	

}
