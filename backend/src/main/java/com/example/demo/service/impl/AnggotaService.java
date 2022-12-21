package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.AnggotaModel;
import com.example.demo.repository.IAnggotaRepository;
import com.example.demo.service.IAnggotaService;

@Service
public class AnggotaService implements IAnggotaService {

	@Autowired
	IAnggotaRepository anggotaRepository;

	@Override
	public AnggotaModel insertAddAnggota(AnggotaModel AddAnggota) {
		return anggotaRepository.insertAddAnggota(AddAnggota);
	}

	@Override
	public List<AnggotaModel> getAllAddAnggota() {
		return anggotaRepository.getAllAddAnggota();
	}

	@Override
	public AnggotaModel updateAddAnggota(int id, AnggotaModel AddAnggota) {
		return anggotaRepository.updateAddAnggota(id, AddAnggota);
	}

	@Override
	public AnggotaModel deleteAddAnggota(int id) {
		return anggotaRepository.deleteAddAnggota(id);
	}

	@Override
	public List<AnggotaModel> getAnggotaByIdKk(String id_kk) {
		return anggotaRepository.getAnggotaByIdKk(id_kk);
	}

	@Override
	public AnggotaModel updateAnggotaByIdKk(String id_kk, AnggotaModel AddAnggota) {
		return anggotaRepository.updateAnggotaByIdKk(id_kk, AddAnggota);
	}

	@Override
	public AnggotaModel getAnggota(int id) {
		return anggotaRepository.getAnggota(id);
	}

	@Override
	public List<AnggotaModel> deleteAllAnggota(String id_kk) {
		return anggotaRepository.deleteAllAnggota(id_kk);
	}

}
