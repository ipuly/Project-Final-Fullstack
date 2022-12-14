package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.AddUser;
import com.example.demo.service.IUserService;


@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	IUserService userService;
	
	
	@PostMapping("/insert")
	public AddUser insertAddUser(@RequestBody AddUser adduser){
		return userService.insertAddUser(adduser);
	}
	
	@GetMapping("/getAll")
	public List<AddUser> getAllAddKk(){
		return userService.getAllAddUser();
	}
	
//	@PutMapping("/update/{id}")
//	public AddUser updateAddUser(@PathVariable int id, @RequestBody AddUser adduser) {
//		return userService.updateAddUser(id, adduser);
//	}
	
//	@DeleteMapping("/delete/{id}")
//	public AddUser deleteAddUser(@PathVariable int id) {
//		return userService.deleteAddUser(id);
//	}
	

}
