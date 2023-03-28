package com.viniciusmartins.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	
}