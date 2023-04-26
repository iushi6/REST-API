package com.ayushi.crudoperation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayushi.crudoperation.Entity.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

	
	
}
