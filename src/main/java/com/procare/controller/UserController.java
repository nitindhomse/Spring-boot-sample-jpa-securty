package com.procare.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.procare.model.Employee;
import com.procare.repository.UserRepo;
@Component
@RestController()
@RequestMapping(path = "/user")

public class UserController {
	@Autowired
	UserRepo userRepo;
	
	@GetMapping("/")
	public String hello() {
		return "Hello";
	}
	
	
	// Get All Users
	@Secured("ROLE_USER")
	@GetMapping("/getAll")
	public List<Employee> getAllUsers() {
	    return userRepo.findAll();
	}
	
	@Secured("ROLE_USER")
	@PostMapping("/add")
	public Employee createUser(@Valid @RequestBody Employee user) {
	    return userRepo.save(user);
	}
	
	// Get a Single User
	@Secured("ROLE_USER")
	@GetMapping("/get/{id}")
	public Optional<Employee> getUserById(@PathVariable(value = "id") Long id) {
	    return userRepo.findById(id);
	            //.orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
	}
	
	
	// Update an User
	@Secured("ROLE_USER")
	@PutMapping("/updateUser/{id}")
	public Employee updateUser(@PathVariable(value = "id") Long id,
	                                        @Valid @RequestBody Employee userDetails) {

	    Employee user =  userRepo.findById(id).orElse(null);
	          //  .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

	    user.setCity(userDetails.getCity());
	    user.setName(userDetails.getName());

	    Employee updatedUser = userRepo.save(user);
	    return updatedUser;
	}
	
	
	@Secured("ROLE_USER")
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
	    Employee note = userRepo.findById(noteId).orElse(null);
	            //.orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
	    userRepo.delete(note);
	    return ResponseEntity.ok().build();
	}
	
	
	// Get a Single Note
		@GetMapping("/find/{name}")
		public List<Employee> getUserById(@PathVariable(value = "name") String name) {
			Sort sort = new Sort(Direction.ASC, "name");
			List<Employee> authors = userRepo.findByName(name, sort);

			return authors;
		            //.orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		}
}
