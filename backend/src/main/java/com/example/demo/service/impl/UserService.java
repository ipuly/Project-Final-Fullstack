package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserModel;
import com.example.demo.repository.IUserRepository;
import com.example.demo.service.IUserService;

@Service
public class UserService implements IUserService {
	@Autowired
	IUserRepository userRepository;

	@Override
	public UserModel insertAddUser(UserModel AddUser) {
		return userRepository.insertAddUser(AddUser);
	}

	@Override
	public UserModel getUser(String email, String password) {
		return userRepository.getUser(email, password);
	}

	@Override
	public UserModel getEmail(String email) {
		return userRepository.getEmail(email);
	}

	@Override
	public List<UserModel> getAllAddUser() {
		// TODO Auto-generated method stub
		return userRepository.getAllAddUser();
	}

	@Override
	public UserModel updateUser(int id, UserModel AddUser) {
		// TODO Auto-generated method stub
		return userRepository.updateUser(id, AddUser);
	}

	@Override
	public UserModel deleteAddUser(int id) {
		// TODO Auto-generated method stub
		return userRepository.deleteAddUser(id);
	}

	@Override
	public UserModel getUserById(int id) {
		// TODO Auto-generated method stub
		return userRepository.getUserById(id);
	}

}
