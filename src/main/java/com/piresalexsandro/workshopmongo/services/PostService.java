package com.piresalexsandro.workshopmongo.services;

import java.util.Date;
import java.util.List;
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
	
	/*
	 * public List<Post> findPostByTitle(String text){ return
	 * repo.findByTitleContainingIgnoreCase(text); }
	 */	
	public List<Post> searchTitle(String text){
		return repo.searchTitle(text);
	}

	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 *60 * 60 * 1000);
		return repo.fullSearch(text, minDate, maxDate);
	}
}
