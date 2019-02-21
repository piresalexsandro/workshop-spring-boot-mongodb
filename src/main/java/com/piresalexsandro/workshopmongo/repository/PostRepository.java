package com.piresalexsandro.workshopmongo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.piresalexsandro.workshopmongo.resource.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

	Post save(Optional<Post> newObj);
	
	@Query("{ title: { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text);
}
