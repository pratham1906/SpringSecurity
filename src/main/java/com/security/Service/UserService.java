package com.security.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.security.entities.User;

@Service
public class UserService {

	
	List<User> list=new ArrayList<>();

	public UserService() {
		list.add(new User("abc","abc","abc@gmail.com"));
		list.add(new User("xyz","xyz","xyz@gmail.com"));
		list.add(new User("lca","lca","lca@gmail.com"));
		list.add(new User("apa","apa","apa@gmail.com"));
	}
	
	//get All Users
	public List<User> getAllUsers(){
		return this.list;
	}
	
	//get single user
	public User getUser(String username) {
		return this.list.stream().filter((user)->user.getUsername().equals(username)).findAny().orElse(null);
	}
	
	//add User
	public User addUser(User user) {
		this.list.add(user);
		return user;
	}
}
