package com.application.communalTrustPortal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.application.communalTrustPortal.model.User;
import com.application.communalTrustPortal.service.UserService;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Controller
@RequestMapping("/users")
public class LoginAndRegistrationController {

	@Autowired
	UserService userService;
	
	@Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
	
	@PostMapping(value = "/register")
	public ResponseEntity<Void> processRegistrationForm(@RequestBody User user) {
		boolean status = false;
		
		if(null != user)
			status = userService.saveUser(user);
		
		if (status == false) {
		     return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/authenticate")
	public ResponseEntity<User> authenticateUser(@RequestBody User user){
		User result = null;
		
		if(null != user)
			result = userService.findUserExists(user);
		
		if(null != result)
			return new ResponseEntity<User>(result, HttpStatus.OK);
		else
			return new ResponseEntity<User>(result, HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value = "/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers(){
		
		List<User> users = userService.findAllUsers();
		
		if(null != users && users.size() > 0) 
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		else
			return new ResponseEntity<List<User>>(users, HttpStatus.NO_CONTENT);
	}
}
