package com.cgi.NPS.repo;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cgi.NPS.model.Park;

@Repository
@Transactional
public interface ParksRepo extends JpaRepository<Park, String>{

//	@Query
//	( "SELECT p FROM Park p WHERE UPPER(p.fullName LIKE UPPER(:searchTerm) ")
//	List<Park> getBySearch(@Param("searchTerm") String searchTerm);
}
