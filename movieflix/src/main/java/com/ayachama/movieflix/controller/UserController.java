package com.ayachama.movieflix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ayachama.movieflix.entity.User;
import com.ayachama.movieflix.service.UserService;

@RestController
@RequestMapping(value = "user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/signup", 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User signUpUser(@RequestBody User user) {
		return userService.signUpUser(user);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/signin", 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User signIn(@RequestBody User user) {
		return userService.signInUser(user);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/signout", 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User signOut(@RequestBody User user) {
		return userService.signOut(user);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public User getMoviesList() {
		User user = new User();
		user.setEmailId("email@gmail.com");
		return user;
	}
}