package com.lilian.useraccount.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lilian.useraccount.entities.User;


public interface UserRepository extends JpaRepository<User, Long> {
	
//	List<User> findAllByFirstnameIgnoreCase(String firstname);
//	List<User> findAllByFirstnameIgnoreCaseOrLastnameIgnoreCase(String firstname, String lastname);
	
	
	//queries
	
//	User findUserByFirstname(String firstname);
//	
//	@Query("Select u from User u where u.firstname=:firstname")
//	User findUserByFirstNamedParam(@Param("firstname") String firstname);
	
	
	List<User> findByFirstnameContainingIgnoreCaseOrLastnameContainingIgnoreCaseOrMiddlenameContainingIgnoreCase(String search, String search2, String search3);
	List<User> findByFirstnameContainingIgnoreCase(String firstName);
	List<User> findByMiddlenameContainingIgnoreCase(String middleName);
	List<User> findByLastnameContainingIgnoreCase(String lastName);

}
