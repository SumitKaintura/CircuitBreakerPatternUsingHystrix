package com.niit.service;

import java.util.Map;

import com.niit.domain.User;

public interface SecurityTokenGenerator {
	 Map<String,String> generateToken(User user);
}
