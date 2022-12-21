package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.AnggotaModel;

public interface IAnggotaRepository {

	public AnggotaModel insertAddAnggota(AnggotaModel addanggota);

	public List<AnggotaModel> getAllAddAnggota();

	public AnggotaModel updateAddAnggota(int id, AnggotaModel addanggota);

	public AnggotaModel deleteAddAnggota(int id);

	public AnggotaModel getAnggota(int id);

	public List<AnggotaModel> getAnggotaByIdKk(String id_kk);

	public AnggotaModel updateAnggotaByIdKk(String id_kk, AnggotaModel AddAnggota);

	public List<AnggotaModel> deleteAllAnggota(String id_kk);
}
