package com.lilian.useraccount.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lilian.useraccount.entities.User;


public interface UserRepository extends JpaRepository<User, Long> {
	
	

}
