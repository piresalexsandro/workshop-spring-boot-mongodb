package com.piresalexsandro.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piresalexsandro.workshopmongo.repository.PostRepository;
import com.piresalexsandro.workshopmongo.resource.Post;
import com.piresalexsandro.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) throws ObjectNotFoundException { //retorna um objeto do tipo USUARIO User
		Optional<Post> optionalPost = repo.findById(id);
		optionalPost.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado"));
		return optionalPost.get();
	}	
}
