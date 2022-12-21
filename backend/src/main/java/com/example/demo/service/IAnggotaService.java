package com.example.demo.service;

import java.util.List;

import com.example.demo.model.AnggotaModel;

public interface IAnggotaService {
	public AnggotaModel insertAddAnggota(AnggotaModel addanggota);

	public List<AnggotaModel> getAllAddAnggota();

	public AnggotaModel updateAddAnggota(int id, AnggotaModel addanggota);

	public AnggotaModel deleteAddAnggota(int id);

	public List<AnggotaModel> deleteAllAnggota(String id_kk);

	public AnggotaModel getAnggota(int id);

	public List<AnggotaModel> getAnggotaByIdKk(String id_kk);

	public AnggotaModel updateAnggotaByIdKk(String id_kk, AnggotaModel AddAnggota);

}
