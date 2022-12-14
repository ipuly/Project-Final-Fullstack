package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.AddUser;
import com.example.demo.repository.IUserRepository;
import com.example.demo.service.IUserService;

@Service
public class UserService implements IUserService {
	@Autowired
	IUserRepository userRepository;

	@Override
	public AddUser insertAddUser(AddUser AddUser) {
		// TODO Auto-generated method stub
		return userRepository.insertAddUser(AddUser);
	}

	@Override
	public List<AddUser> getAllAddUser() {
		// TODO Auto-generated method stub
		return userRepository.getAllAddUser();
	}

	@Override
	public AddUser updateAddUser(int id, AddUser AddUser) {
		// TODO Auto-generated method stub
		return userRepository.updateAddUser(id, AddUser);
	}

	@Override
	public AddUser deleteAddUser(int id) {
		// TODO Auto-generated method stub
		return userRepository.deleteAddUser(id);
	}
}
