package com.niit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.niit.domain.User;
import com.niit.exception.UserNotFoundException;
import com.niit.repository.UserRepository;

@Component
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User registerUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) throws UserNotFoundException {
		User user=userRepository.findByUsernameAndPassword(username, password);
		if(user==null) {
			throw new UserNotFoundException();
		}
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

}
