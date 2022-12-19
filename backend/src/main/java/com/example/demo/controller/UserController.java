package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public AddUser insertAddUser(@RequestBody AddUser adduser) {
		return userService.insertAddUser(adduser);
	}

	@PostMapping("/getUser")
	public AddUser getUser(@RequestBody AddUser adduser) {
		return userService.getUser(adduser.getEmail(), adduser.getPassword());
	}

	@GetMapping("/getAllUser")
	public List<AddUser> getAllAddUser() {
		return userService.getAllAddUser();
	}
}
