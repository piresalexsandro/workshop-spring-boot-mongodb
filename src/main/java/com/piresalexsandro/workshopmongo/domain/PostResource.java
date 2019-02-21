// CRIAR ENDPOINTS

package com.piresalexsandro.workshopmongo.domain;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.piresalexsandro.workshopmongo.resource.Post;
import com.piresalexsandro.workshopmongo.resource.util.URL;
import com.piresalexsandro.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	private PostService service;
	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id) { //@PathVariable para firmar a amarraçao entre o id da url com o argumento
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}	
	
	@RequestMapping(value = "/titlesearch", method=RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitle(@RequestParam (value ="text", defaultValue = "") String text) { 
		text = URL.decodeParam(text);
		//List <Post> posts = service.findPostByTitle(text);
		List <Post> posts = service.searchTitle(text);
		return ResponseEntity.ok().body(posts);
	}	
	
	@RequestMapping(value = "/fullsearch", method=RequestMethod.GET)
	public ResponseEntity<List<Post>> 
		fullSearch(@RequestParam (value ="text", defaultValue = "") String text,
				   @RequestParam (value ="minDate", defaultValue = "") String minDate,
				   @RequestParam (value ="maxDate", defaultValue = "") String maxDate) { 
		text = URL.decodeParam(text);
		Date min = URL.convertDate(minDate, new Date(0L));
		Date max = URL.convertDate(maxDate, new Date());
		//List <Post> posts = service.findPostByTitle(text);
		List <Post> posts = service.fullSearch(text, min, max);
		return ResponseEntity.ok().body(posts);
	}	
}