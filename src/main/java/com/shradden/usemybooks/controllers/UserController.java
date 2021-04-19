package com.shradden.usemybooks.controllers;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shradden.usemybooks.models.User;
import com.shradden.usemybooks.repo.UserRepo;

@RestController
public class UserController 
{
	@Autowired
	UserRepo repo;
	
	@GetMapping("usrs")
	public List<User> getUsers()
	{
		List<User> users = repo.findAll();
		return users;
	}
	
	@GetMapping("user/{userid}")
	public User getUser(@PathVariable("userid") int id)
	{
		User user = repo.findById(id).orElse(new User());;
		return user;
		
	}
	
	@PostMapping("register-user")
	public boolean register(@RequestBody User user)
	{
		if(repo.findByUsername(user.getUsername())==null)
			{
				repo.save(user);
				return true;
			}
		else
		{
			System.out.println("Username already exists");
			return false;
		}
				
	}
	
	@PostMapping(path="user-login")
	public boolean login(@RequestBody User u) 
	{
		User user = repo.findByUsername(u.getUsername());
		if(user==null)
		{
			System.out.println("Wrong credentials");
			return false;
		}
			
		else if(user.getPassword().equals(u.getPassword()))
			return true;
		else
		{
			System.out.println("Wrong credentials");
			return false;
		}
		
	}
	
	@PostMapping("users/{user-id}/update")
	public boolean userUpdate(@PathVariable("user-id") int id, @RequestBody User user)
	{
		User u = repo.findById(id).orElse(null);
		if(u==null)
		{
			System.out.println("User not found");
			return false;
		}
		if(user.getUsername().equals(u.getUsername())||repo.findByUsername(user.getUsername())==null)
		{
			u.setEmail(user.getEmail());
			u.setName(user.getName());
			u.setPassword(user.getPassword());
			u.setPhone(user.getPhone());
			u.setUsername(user.getUsername());
			repo.save(u);
			return true;
		}
		else
		{
			System.out.println("Failure");
			return false;
		}
	}
	
//	@PostMapping(path="user")
//	public boolean login(@RequestBody User u) 
//	{
//		User user = repo.selfDefinedFind(u.getUsername());
//		if(user.getPassword().equals(u.getPassword()))
//			return true;
//		else
//			return false;
//	}

}
