package com.divya.RestAPI.controller;

																																																																																																																																																																																																																													
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.divya.RestAPI.model.User;
import com.divya.RestAPI.service.UserService;

@RestController // This means that this class is a Controller
@RequestMapping(path="/users") // This means URL's start with /demo (after Application path)
public class UserController {
 
	  UserService userService;
	  
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	//build create user REST API
	@PostMapping()
	public ResponseEntity<User> saveUser(@RequestBody User user){
		return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);		
	}
	
	//get all employees REST API
	  @GetMapping(path="/all") 
	  public @ResponseBody Iterable<User> getAllUsers() {
	  // This returns a JSON or XML with the users 
		  return userService.getAllUsers();
	  }
	  
	//get employee by ID REST API
	  @GetMapping("{id}")
	  public @ResponseBody  ResponseEntity<User> findByID(@PathVariable("id") Integer id) {
		  return new ResponseEntity<User>(userService.getUserById(id),HttpStatus.OK);
	  }

	 // build update User REST API
	  @PutMapping("{id}")
	  public ResponseEntity<User> updateUser(@PathVariable("id") Integer id, @RequestBody User us){
  		  return new ResponseEntity<User>(userService.UpdateUser(us,id),HttpStatus.ACCEPTED);
	  }
  

  
}