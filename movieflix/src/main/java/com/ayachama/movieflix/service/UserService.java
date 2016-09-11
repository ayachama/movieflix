package com.ayachama.movieflix.service;

import com.ayachama.movieflix.entity.User;

public interface UserService {
	
	public User signUpUser(User user);
	
	public User signInUser(User user);
	
	public User signOut(User user);
	
}
