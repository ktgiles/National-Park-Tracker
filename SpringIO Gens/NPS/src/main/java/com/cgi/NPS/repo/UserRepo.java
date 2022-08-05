package com.cgi.NPS.repo;

import java.util.Optional;


import javax.transaction.Transactional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cgi.NPS.model.User;

@Repository
@Transactional
public
interface UserRepo extends JpaRepository<User, String>{

	@Query
	( "SELECT u FROM User u WHERE UPPER(u.username) = UPPER(:searchTerm) ")
	Optional<User> getByUsername(@Param("searchTerm") String searchTerm);
	
	@Query
	( "SELECT u FROM User u WHERE UPPER(u.username) = UPPER(:searchTerm) ")
	User getUserByUsername(@Param("searchTerm") String searchTerm);
	
}
