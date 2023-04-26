package com.ayushi.crudoperation.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayushi.crudoperation.Entity.User;
import com.ayushi.crudoperation.Repository.UserRepo;

@RestController
@RequestMapping("/api/users")
public class UserControler {

	//Controller Class
	
	@Autowired
	private UserRepo userRepo;
	
	@PostMapping
	public User addUser(@RequestBody User user) {
		return userRepo.save(user);
	}
	
	@GetMapping
	public List<User> getAllUser(){
		return userRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id){
		
		Optional<User> optionalUser = userRepo.findById(id);
		if(optionalUser.isPresent()) {
			return ResponseEntity.ok(optionalUser.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){
		
		Optional<User> optionalUser = userRepo.findById(id);
		if(optionalUser.isPresent()) {
			User existingUser = optionalUser.get();
			existingUser.setName(user.getName());
			existingUser.setBalance(user.getBalance());
			userRepo.save(existingUser);
			return ResponseEntity.ok(existingUser);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteById(@PathVariable Long id){
		
		Optional<User> optionalUser = userRepo.findById(id);
		if(optionalUser.isPresent()) {
			userRepo.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
}
