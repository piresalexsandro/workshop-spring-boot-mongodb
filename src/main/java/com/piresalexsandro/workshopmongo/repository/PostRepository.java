package com.piresalexsandro.workshopmongo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.piresalexsandro.workshopmongo.resource.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

	Post save(Optional<Post> newObj);
	
	List<Post> findByTitleContainingIgnoreCase(String text);
}
