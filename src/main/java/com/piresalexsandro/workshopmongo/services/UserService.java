package com.piresalexsandro.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piresalexsandro.workshopmongo.repository.UserRepository;
import com.piresalexsandro.workshopmongo.resource.User;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
}
