package com.example.demo.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserModel;
import com.example.demo.repository.IUserRepository;

@Repository
public class UserRepository implements IUserRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public UserModel insertAddUser(UserModel adduser) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO tb_user(email, nama, password) "
				+ "VALUES(?, ?, ?)";
		jdbcTemplate.update(query, new Object[] { adduser.getEmail(), adduser.getNama(), adduser.getPassword() });
		return adduser;
	}

	@Override
	public UserModel getUser(String email, String password) {
		String query = "SELECT * FROM tb_user WHERE email = ? AND password = ?";
		return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(UserModel.class), email, password);
	}

	@Override
	public List<UserModel> getAllAddUser() {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_user";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(UserModel.class));
	}

	@Override
	public UserModel updateUser(int id, UserModel adduser) {
		// TODO Auto-generated method stub
		String query = "UPDATE tb_user SET email = ?, nama = ?, password = ? WHERE id = ?";

		jdbcTemplate.update(query, new Object[] { adduser.getEmail(), adduser.getNama(), adduser.getPassword(), id });

		return adduser;
	}

	@Override
	public UserModel deleteAddUser(int id) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_user WHERE id = ?";
		var result = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(UserModel.class), id);

		query = "DELETE FROM tb_user WHERE id = ?";
		jdbcTemplate.update(query, id);

		return result;
	}

	@Override
	public UserModel getEmail(String email) {
		UserModel result = new UserModel();
		String query = "SELECT * FROM tb_user WHERE email = ?";
		try {
			result = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(UserModel.class), email);
		} catch (Exception e) {
			result = new UserModel();
		}
		return result;
	}

	@Override
	public UserModel getUserById(int id) {
		String query = "SELECT * FROM tb_user WHERE id = ?";
		return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(UserModel.class), id);
	}

}
