package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.AddAnggota;

public interface IAnggotaRepository {

	public AddAnggota insertAddAnggota(AddAnggota addanggota);

	public List<AddAnggota> getAllAddAnggota();

	public AddAnggota updateAddAnggota(int id, AddAnggota addanggota);

	public AddAnggota deleteAddAnggota(int id);

	public AddAnggota getAnggota(int id);

	public List<AddAnggota> getAnggotaByIdKk(String id_kk);

	public AddAnggota updateAnggotaByIdKk(String id_kk, AddAnggota AddAnggota);

	public List<AddAnggota> deleteAllAnggota(String id_kk);
}
