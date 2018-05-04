package com.lilian.useraccount.controllers;

//import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lilian.useraccount.entities.User;
import com.lilian.useraccount.services.UserService;

@RestController
public class UserController {
	
		@Autowired
		private UserService userService;
	
		@RequestMapping("/users")
		public List<User> getAllUsers() {
			return userService.getAllUsers();
				
		}
		
		@RequestMapping("/users/{id}")
		public Optional<User> getUser(@PathVariable Long id) {
			return userService.getUser(id);
		}
		
		@RequestMapping(method=RequestMethod.POST, value="/users")
		public void addUser(@RequestBody User user) {
				userService.addUser(user);
		}
		
		@RequestMapping(method=RequestMethod.PUT, value="/users/{id}")
		public void updateUser(@RequestBody User user, @PathVariable Long id) {
				userService.updateUser(id, user);
		}
		
		@RequestMapping(method=RequestMethod.DELETE, value="/users/{id}")
		public void deleteUser(@PathVariable Long id) { 
			userService.deleteUser(id);
		}
		
//		@RequestMapping("users/byFirstname/{firstname}")
//		public List<User>byFirstname(@PathVariable(value="firstname") String firstname) {
//			return userService.byFirstname(firstname);
//		}
//		
//		
//		@RequestMapping("users/name/{firstname}/{lastname}")
//		public List<User>byFirstnameOrLastname(@PathVariable(value="firstname") String firstname, @PathVariable(value="lastname") String lastname) {
//			return userService.byFirstnameOrLastname(firstname, lastname);
//		}
		
		
		
		
		
		@GetMapping(value="/users/search")
		public List<User> getAllUsers(@RequestParam(value="firstname", required=false) String firstname,
											@RequestParam(value="lastname", required=false) String lastname,
											@RequestParam(value="middlename", required=false) String middlename,
											@RequestParam(value="query", required=false) String query){
			
			
			if(query!=null) 
			{
				if(query.length()<3) 
				{
					throw new NullPointerException("Query must at least be 3 characters.");
				}
				else 
				{
					return userService.getUserByAll(query);
				}
			}
			else if(firstname!=null)
			{
				if(firstname.length()<3) 
				{
					
					throw new RuntimeException("Search characters should be at least 3 characters.");
				}else 
				{
					return userService.getUserByFirstname(firstname);
				}
			}
			else if(middlename!=null) 
			{
				if(middlename.length()<3) 
				{
					throw new RuntimeException("Search characters should be at least 3 characters.");
				}else 
				{
					return userService.getUserByMiddlename(middlename);
				}
				
			}
			else if(lastname!=null) 
			{
				if(lastname.length()<3) 
				{
					throw new RuntimeException("Search characters should be at least 3 characters.");
				}else 
				{
					return userService.getUserByLastname(lastname);
				}		
				
			}
			else 
			{
				return userService.getAllUsers();
			}
		}
}