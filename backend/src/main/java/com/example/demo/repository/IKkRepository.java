package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.KkModel;

public interface IKkRepository {
	public KkModel insertAddKk(KkModel addkk);

	public List<KkModel> getAllAddKk();

	public KkModel updateAddKk(int id, KkModel addkk);

	public KkModel deleteAddKk(int id);

	public KkModel getKkById(int id);
}
