package com.application.communalTrustPortal.service;

import java.util.List;

import com.application.communalTrustPortal.model.User;

public interface UserService {

	public boolean saveUser(User user);
	public User findUserExists(User user);
	public List<User> findAllUsers();
}
