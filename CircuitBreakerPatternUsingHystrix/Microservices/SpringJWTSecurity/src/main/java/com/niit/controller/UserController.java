package com.niit.controller;

import java.util.List;
import java.util.Map;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.niit.domain.User;
import com.niit.service.SecurityTokenGenerator;
import com.niit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.niit.exception.UserNotFoundException;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
    UserService userService;
	
	@Autowired
    SecurityTokenGenerator securityTokenGenerator;
	
	@PostMapping("/login")
	@HystrixCommand(fallbackMethod = "fallbackmethod",commandKey = "loginkey",groupKey = "login")
	@HystrixProperty(name ="execution.isolation.thread.timeoutInMilliseconds",value ="1000")
	public ResponseEntity<?> loginUser(@RequestBody User user)throws UserNotFoundException
	{
		ResponseEntity responseEntity;
		try
		{
			User userObj=userService.findByUsernameAndPassword(user.getUsername(),user.getPassword());
			System.out.println(userObj);
			if(userObj.getUsername().equals(user.getUsername()))
			{
				Map<String,String> tokenMap=securityTokenGenerator.generateToken(userObj);
				responseEntity=new ResponseEntity<>(tokenMap,HttpStatus.OK);
			}
			else
			{
			responseEntity=new ResponseEntity<>("Invalid User",HttpStatus.OK);
			}
		}
		catch(UserNotFoundException ue)
		{
			throw new UserNotFoundException();
		}
		catch(Exception e)
		{
			responseEntity=new ResponseEntity<>("Some other Error Occured!!!",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

	public ResponseEntity<?> fallbackmethod(@RequestBody User user) throws UserNotFoundException
	{
		String message ="Service not available, please try again later";
		return  new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody User user)
	{
		User newUser=userService.registerUser(user);
		return new ResponseEntity<>("User Created",HttpStatus.CREATED);
	}
	
	@GetMapping("/userdetails/users")
	public ResponseEntity<?> getAllUsers()
	{
		List<User> userList=userService.getAllUsers();
		return new ResponseEntity<>(userList,HttpStatus.OK);
	}
}
