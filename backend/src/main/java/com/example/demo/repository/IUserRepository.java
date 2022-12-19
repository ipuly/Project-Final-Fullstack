package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.AddUser;

public interface IUserRepository {
	public AddUser insertAddUser(AddUser adduser);

	public AddUser getUser(String email, String password);

	public List<AddUser> getAllAddUser();

	public AddUser updateAddUser(int id, AddUser adduser);

	public AddUser deleteAddUser(int id);

}
