package com.GreenStitch.service;

import com.GreenStitch.model.UserData;
import com.GreenStitch.exceptions.UserException;

public interface UserService {
	UserData signInUser()  throws UserException;
	UserData CreateUser(UserData userData) throws UserException;
}
