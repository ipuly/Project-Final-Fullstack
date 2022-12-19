package com.example.demo.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AddUser;
import com.example.demo.repository.IUserRepository;

@Repository
public class UserRepository implements IUserRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public AddUser insertAddUser(AddUser adduser) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO tb_user(email, nama, password) "
				+ "VALUES(?, ?, ?)";
		jdbcTemplate.update(query, new Object[] { adduser.getEmail(), adduser.getNama(), adduser.getPassword(), });
		return adduser;
	}

	@Override
	public AddUser getUser(String email, String password) {
		String query = "SELECT * FROM tb_user WHERE email = ? AND password = ?";
		return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(AddUser.class), email, password);
	}

	@Override
	public List<AddUser> getAllAddUser() {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_user";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(AddUser.class));
	}

	@Override
	public AddUser updateAddUser(int id, AddUser adduser) {
		// TODO Auto-generated method stub
		String query = "UPDATE tb_user SET email = ?, nama = ?, password = ?";

		jdbcTemplate.update(query, new Object[] { adduser.getEmail(), adduser.getNama(), adduser.getPassword(), id });

		return adduser;
	}

	@Override
	public AddUser deleteAddUser(int id) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_user WHERE id = ?";
		var result = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(AddUser.class), id);

		query = "DELETE FROM tb_user WHERE id = ?";
		jdbcTemplate.update(query, id);

		return result;
	}

}
