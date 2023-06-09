package com.viniciusmartins.workshopmongo.services;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viniciusmartins.workshopmongo.repository.PostRepository;
import com.viniciusmartins.workshopmongo.services.exception.ObjectNotFoundException;

import domain.Post;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	
	
	public Optional<Post> findById(String id) {
		
		Optional<Post> post = repository.findById(id);
		
		if(!post.isPresent()) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		
		return post;
	}
	
	public List<Post> findByTitle(String text){
		//return repository.findByTitleContainingIgnoreCase(text);
		return repository.searchTitle(text);	
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000 );
		
		return repository.fullSearch(text, minDate, maxDate);
	}
}
