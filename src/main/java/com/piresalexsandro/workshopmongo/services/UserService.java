package com.piresalexsandro.workshopmongo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.piresalexsandro.workshopmongo.dto.UserDTO;
import com.piresalexsandro.workshopmongo.repository.UserRepository;
import com.piresalexsandro.workshopmongo.resource.User;
import com.piresalexsandro.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) throws ObjectNotFoundException { //retorna um objeto do tipo USUARIO User
		Optional<User> optionalUser = repo.findById(id);
		optionalUser.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado"));
		return optionalUser.get();
	}
	
	public User insert(User obj) {
		
		return repo.insert(obj);
	}
	
	public User fromDTO(UserDTO objDTO) {
		
		return new User(objDTO.getId(), objDTO.getEmail(), objDTO.getName());
	}
	
}
