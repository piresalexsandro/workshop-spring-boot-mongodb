package com.piresalexsandro.workshopmongo.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.piresalexsandro.workshopmongo.resource.User;
import com.piresalexsandro.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
				/*List<User> list = new ArrayList<>();
				 * User maria = new User("1001", "Maria Brown", "maria@gmail.com"); User alex =
				 * new User("1002", "Alex Green", "alex@gmail.com");
				 * list.addAll(Arrays.asList(maria, alex));
				 */		
	}
}