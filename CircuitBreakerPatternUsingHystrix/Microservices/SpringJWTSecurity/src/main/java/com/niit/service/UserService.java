package com.niit.service;

import java.util.List;

import com.niit.domain.User;
import com.niit.exception.UserNotFoundException;

public interface UserService {
	public User registerUser(User user);
	public User findByUsernameAndPassword(String username,String password)throws UserNotFoundException;
	public List<User> getAllUsers();
}
