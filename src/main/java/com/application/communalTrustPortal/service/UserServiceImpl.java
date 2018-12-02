package com.application.communalTrustPortal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.communalTrustPortal.model.User;
import com.application.communalTrustPortal.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
    private UserRepository userRepository;
	
	@Override
	public boolean saveUser(User user) {
		User returnedUser = userRepository.save(user);
		if(null != returnedUser.getId())
			return true;
		else
			return false;
	}

	@Override
	public User findUserExists(User user) {
		if(null != user.getUsername() && null != user.getPassword())
			return userRepository.findUserExists(user.getUsername(),user.getPassword());
		else
			return null;
	}

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAllUsers();
	}

}
