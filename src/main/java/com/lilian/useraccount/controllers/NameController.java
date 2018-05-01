package com.lilian.useraccount.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lilian.useraccount.entities.Name;
import com.lilian.useraccount.entities.User;
import com.lilian.useraccount.services.NameService;



@RestController
public class NameController {
	
		@Autowired
		private NameService nameService;
	
		@RequestMapping("/users/{id}/names")
		public List<Name> getAllNames(@PathVariable Long id) {
			return nameService.getAllNames(id);
				
		}
		
		@RequestMapping("/users/{userId}/names/{id}")
		public Optional<Name> getName(@PathVariable Long id) {
			return nameService.getName(id);
		}
		
		@RequestMapping(method=RequestMethod.POST, value="/users/{userId}/names")
		public void addName(@RequestBody Name name, @PathVariable Long userId) {
				name.setUser(new User(userId, "", "","","","",""));
				nameService.addName(name);
		}
		
		@RequestMapping(method=RequestMethod.PUT, value="/users/{userId}/names/{id}")
		public void updateName(@RequestBody Name name, @PathVariable Long userId,@PathVariable Long id) {
				name.setUser(new User(userId, "", "","","","",""));
				nameService.updateName(name);
		}
		
		@RequestMapping(method=RequestMethod.DELETE, value="/users/{userId}/names/{id}")
		public void deleteUser(@PathVariable Long id) {
			nameService.deleteName(id);
		}

}