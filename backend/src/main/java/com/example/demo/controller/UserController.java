package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserModel;
import com.example.demo.service.IUserService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	IUserService userService;

	@PostMapping("/insert")
	public UserModel insertAddUser(@RequestBody UserModel adduser) {
		return userService.insertAddUser(adduser);
	}

	@PostMapping("/getUser")
	public UserModel getUser(@RequestBody UserModel adduser) {
		return userService.getUser(adduser.getEmail(), adduser.getPassword());
	}

	@PostMapping("/getEmail")
	public UserModel getEmail(@RequestBody String email) {
		return userService.getEmail(email);
	}

	@GetMapping("/getAllUser")
	public List<UserModel> getAllAddUser() {
		return userService.getAllAddUser();
	}

	@DeleteMapping("/delete/{id}")
	public UserModel deleteUser(@PathVariable int id) {
		return userService.deleteAddUser(id);
	}

	@PutMapping("/updateUser/{id}")
	public UserModel updateUser(@PathVariable int id, @RequestBody UserModel adduser) {
		return userService.updateUser(id, adduser);
	}

	@GetMapping("/getUserById/{id}")
	public UserModel getKkById(@PathVariable int id) {
		return userService.getUserById(id);
	}
}
