package com.lilian.useraccount.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lilian.useraccount.entities.User;
import com.lilian.useraccount.repositories.UserRepository;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepository userRepository;
	

	public List<User> getAllUsers(){
		List<User> users = new ArrayList<>();
		userRepository.findAll()
		.forEach(users::add);
		if(users!=null && !users.isEmpty())
		{
		return users;
		}
		else
		{
			throw new NullPointerException("No user recorded");
		}
	}
	
	public Optional<User> getUser(Long id) {
		if(userRepository.existsById(id))
		{
		return userRepository.findById(id);
		}
		else
		{
			throw new NullPointerException("id "+id+" not found");
		}
		
	}
		
		public void addUser(User user) {
			userRepository.save(user); 
		}

		public void updateUser(Long id, User user) {
			if(userRepository.existsById(id))
			{
			userRepository.save(user);
			}
			else
			{
				throw new NullPointerException("unable to update the user, id "+id+" not found");
			}
			
		}

		public void deleteUser(Long id) {
			if(userRepository.existsById(id))
			{
			userRepository.deleteById(id);
			}
			else
			{
			throw new NullPointerException("unable to delete the user, id "+id+" not found");
			}
		}
		
		//QUERIES
//			public List<User> byFirstname(String firstname){
//				return userRepository.findAllByFirstnameIgnoreCase(firstname);
//			}
//			
//			public List<User> byFirstnameOrLastname(String firstname, String lastname){
//				return userRepository.findAllByFirstnameIgnoreCaseOrLastnameIgnoreCase(firstname, lastname);
//			}
		
			
			
			
			public List<User> getUserByFirstname(String firstname) {
				return userRepository.findByFirstnameContainingIgnoreCase(firstname);
			}
			
			public List<User> getUserByLastname(String lastname) {
				return userRepository.findByLastnameContainingIgnoreCase(lastname);
			}
			
			public List<User> getUserByMiddlename(String middlename) {
				return userRepository.findByMiddlenameContainingIgnoreCase(middlename);
			}
			
			public List<User> getUserByAll(String query){
				return userRepository.findByFirstnameContainingIgnoreCaseOrLastnameContainingIgnoreCaseOrMiddlenameContainingIgnoreCase(query, query, query);
			}
			
}
