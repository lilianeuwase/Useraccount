package com.lilian.useraccount.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lilian.useraccount.entities.Name;


public interface NameRepository extends JpaRepository<Name, Long> {
	
	public List<Name> findByUserId(Long userId);

}
