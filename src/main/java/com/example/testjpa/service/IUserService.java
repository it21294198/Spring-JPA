package com.example.testjpa.service;

import java.util.List;

import com.example.testjpa.exception.UserNotFoundException;
import com.example.testjpa.model.User;

public interface IUserService {
	
	User addUser(User user);
	User updateUserName(int id,String name);
	void deleteUser(int id);
	User getUserById(int id)throws UserNotFoundException;
	
	List<User> getAllUser()throws UserNotFoundException;
	List<User> getUserEqualName(String name)throws UserNotFoundException;

}
