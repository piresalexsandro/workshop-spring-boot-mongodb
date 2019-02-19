package com.piresalexsandro.workshopmongo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User newUserData) {
		Optional<User> foundUser = repo.findById(newUserData.getId());
		return updateData(foundUser, newUserData).orElse(new User());
	}
	
	private Optional<User> updateData(Optional<User> foundUser, User newUserData) {
		
		/*
		 * List<String> listOfStrings = new ArrayList<String>(); for (int i = 0; i <
		 * listOfStrings.size(); i ++) { } listOfStrings.stream() .skip(1) .findFirst()
		 * .ifPresent(consumer);
		 */		
		foundUser.ifPresent((User user) -> {
			
			user.setEmail(newUserData.getName());
			user.setName(newUserData.getName());
			
			repo.save(user);
			
		});
		
		return foundUser;
		
	}

	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
	
}
