package com.security.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.Service.UserService;
import com.security.entities.User;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	//all Users
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable String username) {
		return this.userService.getUser(username);
	}
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return this.userService.addUser(user);
	}
	
}
