package com.example.demo.service;

import java.util.List;

import com.example.demo.model.UserModel;

public interface IUserService {
	public UserModel insertAddUser(UserModel adduser);

	public UserModel getUser(String email, String password);

	public UserModel getEmail(String email);

	public List<UserModel> getAllAddUser();

	public UserModel updateUser(int id, UserModel adduser);

	public UserModel deleteAddUser(int id);

	public UserModel getUserById(int id);
}
