package com.application.communalTrustPortal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.communalTrustPortal.model.User;
import com.application.communalTrustPortal.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
    private UserRepository userRepository;
	
	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}

}
