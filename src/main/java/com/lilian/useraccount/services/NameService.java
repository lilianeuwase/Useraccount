package com.lilian.useraccount.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lilian.useraccount.entities.Name;
import com.lilian.useraccount.repositories.NameRepository;

@Service
public class NameService {
	
	
	@Autowired
	private NameRepository nameRepository;
	

	public List<Name> getAllNames(Long userId){
		List<Name> names = new ArrayList<>();
		nameRepository.findByUserId(userId)
		.forEach(names::add);
		if(names!=null && !names.isEmpty())
		{
		return names;
		}
		else
		{
			throw new NullPointerException("No names recorded");
		}
	}
	
	public Optional<Name> getName(Long id) {
		if(nameRepository.existsById(id))
		{
		return nameRepository.findById(id);
		}
		else
		{
			throw new NullPointerException("id "+id+" not found");
		}
		
	}
		
		public void addName(Name name) {
			nameRepository.save(name); 
		}

		public void updateName(Name name) {
			nameRepository.save(name);
			
			
		}

		public void deleteName(Long id) {
			if(nameRepository.existsById(id))
			{
			nameRepository.deleteById(id);
			}
			else
			{
			throw new NullPointerException("unable to delete the user, id "+id+" not found");
			}
		}
		
}
