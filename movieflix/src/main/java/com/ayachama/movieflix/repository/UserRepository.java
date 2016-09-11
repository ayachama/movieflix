package com.ayachama.movieflix.repository;

import com.ayachama.movieflix.entity.User;

public interface UserRepository {
	
	public User signUpUser(User user);
	
	public User signInUser(User user);
	
	public User findByEmail(String email);
	
	public User signOutUser(User user);
	
}
