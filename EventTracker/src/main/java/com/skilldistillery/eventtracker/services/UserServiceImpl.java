package com.skilldistillery.eventtracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.eventtracker.entities.User;
import com.skilldistillery.eventtracker.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository uRepo;

	@Override
	public List<User> findAll() {
		return uRepo.findAll();
	}

	@Override
	public User createUser(User newUser) {
		return uRepo.saveAndFlush(newUser);
	}

}
