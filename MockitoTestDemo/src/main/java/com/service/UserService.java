package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.User;
import com.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repo;
	
	public String getUserNameById(int userid) {
		return repo.findById(userid)
				.map(User::getUsername)
				.orElse("Unknown");
	}
}
