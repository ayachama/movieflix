package com.ayachama.movieflix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayachama.movieflix.entity.User;
import com.ayachama.movieflix.exception.UserAlreadyExistException;
import com.ayachama.movieflix.exception.UserNameAndPasswordNoMatchException;
import com.ayachama.movieflix.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User signUpUser(User user) {
		User registeredUser = userRepository.findByEmail(user.getEmailId());
		if(registeredUser != null)
		{
			throw new UserAlreadyExistException("This email id is already registered, Please login!");
		}
		return userRepository.signUpUser(user);
	}

	@Override
	public User signInUser(User user) {
		User registeredUser = userRepository.findByEmail(user.getEmailId());
		if(registeredUser == null)
		{
			throw new UserAlreadyExistException("This email id is not registered, Please Sign up!");
		} else if ((registeredUser.getEmailId() == user.getEmailId()) &&
								(registeredUser.getPassword() == user.getPassword())) {
			System.out.println("User Authenticated!");
			return user;	
		} else{
			throw new UserNameAndPasswordNoMatchException("User name and Password you have entered is not matching with our records.");
		}
	}

	@Override
	public User signOut(User user) {
		User registeredUser = userRepository.findByEmail(user.getEmailId());
		if(registeredUser == null)
		{
			
		}
		return user;
	}
	
}
