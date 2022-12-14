package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.AddAnggota;

public interface IAnggotaRepository {

	public AddAnggota insertAddAnggota(AddAnggota addanggota);
	public List<AddAnggota> getAllAddAnggota();
	public AddAnggota updateAddAnggota(int id, AddAnggota addanggota);
	public AddAnggota deleteAddAnggota(int id);
//	public AddAnggota getStudent(int id);
	public AddAnggota getAnggota(int id);
}
