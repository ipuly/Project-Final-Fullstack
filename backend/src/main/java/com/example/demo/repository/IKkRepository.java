package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.AddKk;

public interface IKkRepository {
	public AddKk insertAddKk(AddKk addkk);

	public List<AddKk> getAllAddKk();

	public AddKk updateAddKk(int id, AddKk addkk);

	public AddKk deleteAddKk(int id);

	public AddKk getKkById(int id);
}
