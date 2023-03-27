package com.viniciusmartins.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viniciusmartins.workshopmongo.dto.UserDTO;
import com.viniciusmartins.workshopmongo.repository.UserRepository;
import com.viniciusmartins.workshopmongo.services.exception.ObjectNotFoundException;

import domain.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		
		return repository.findAll();
	}
	
	public Optional<User> findById(String id) {
		
		Optional<User> user = repository.findById(id);
		
		if(!user.isPresent()) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		
		return user;
	}
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
