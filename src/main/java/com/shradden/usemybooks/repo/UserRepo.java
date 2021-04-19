package com.shradden.usemybooks.repo;

import javax.transaction.Transactional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shradden.usemybooks.models.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	

	User findByUsername(String username);
//	@Query("from User where username=:name")
//	User selfDefinedFind(@Param("name") String userName);
	
	
		
}
