package com.application.communalTrustPortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.application.communalTrustPortal.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	@Query("SELECT user FROM User as user where user.username = :username and user.password = :password") 
    public User findUserExists(@Param("username") String username, @Param("password") String password);
	
	@Query("SELECT user FROM User as user") 
	public List<User> findAllUsers();
}
