package com.GreenStitch.repository;

import com.GreenStitch.model.UserData;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository  extends JpaRepository<UserData, Integer>{
	UserData findByEmail(String userName);
}
