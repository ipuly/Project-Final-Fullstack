package com.example.demo.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AnggotaModel;
import com.example.demo.repository.IAnggotaRepository;

@Repository
public class AnggotaRepository implements IAnggotaRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public AnggotaModel insertAddAnggota(AnggotaModel addanggota) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO tb_anggota_keluarga(agama, id_kk, jenis_kelamin, kepala_keluarga, nama, nik, pendidikan, tanggal_lahir, tempat_lahir) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(query,
				new Object[] { addanggota.getAgama(), addanggota.getId_kk(), addanggota.getJenis_kelamin(),
						addanggota.getKepala_keluarga(), addanggota.getNama(), addanggota.getNik(),
						addanggota.getPendidikan(), addanggota.getTanggal_lahir(), addanggota.getTempat_lahir() });
		return addanggota;
	}

	@Override
	public List<AnggotaModel> getAllAddAnggota() {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_anggota_keluarga";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(AnggotaModel.class));
	}

	@Override
	public AnggotaModel updateAddAnggota(int id, AnggotaModel addanggota) {
		// TODO Auto-generated method stub
		String query = "UPDATE tb_anggota_keluarga SET agama = ?, id_kk = ?, jenis_kelamin = ?, kepala_keluarga = ?, "
				+ "nama = ?, nik = ?, pendidikan = ?, tanggal_lahir = ?, tempat_lahir = ? WHERE id = ?";

		jdbcTemplate.update(query,
				new Object[] { addanggota.getAgama(), addanggota.getId_kk(), addanggota.getJenis_kelamin(),
						addanggota.getKepala_keluarga(), addanggota.getNama(), addanggota.getNik(),
						addanggota.getPendidikan(), addanggota.getTanggal_lahir(), addanggota.getTempat_lahir(), id });

		return addanggota;
	}

	@Override
	public AnggotaModel deleteAddAnggota(int id) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_anggota_keluarga WHERE id = ?";
		var result = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(AnggotaModel.class), id);

		query = "DELETE FROM tb_anggota_keluarga WHERE id = ?";
		jdbcTemplate.update(query, id);

		return result;
	}

	@Override
	public List<AnggotaModel> deleteAllAnggota(String id_kk) {
		String query = "SELECT * FROM tb_anggota_keluarga WHERE id_kk = ?";
		var result = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(AnggotaModel.class), id_kk);

		query = "DELETE FROM tb_anggota_keluarga WHERE id_kk = ?";
		jdbcTemplate.update(query, id_kk);

		return result;
	}

	@Override
	public AnggotaModel getAnggota(int id) {
		String query = "SELECT * FROM tb_anggota_keluarga WHERE id = ?";
		return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(AnggotaModel.class), id);
	}

	@Override
	public List<AnggotaModel> getAnggotaByIdKk(String id_kk) {
		String query = "SELECT * FROM tb_anggota_keluarga WHERE id_kk = ?";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(AnggotaModel.class), id_kk);
	}

	@Override
	public AnggotaModel updateAnggotaByIdKk(String id_kk, AnggotaModel AddAnggota) {
		String query = "UPDATE tb_anggota_keluarga SET agama = ?, id_kk = ?, jenis_kelamin = ?, kepala_keluarga = ?, "
				+ "nama = ?, nik = ?, pendidikan = ?, tanggal_lahir = ?, tempat_lahir = ? WHERE id = ?";

		jdbcTemplate.update(query,
				new Object[] { AddAnggota.getAgama(), AddAnggota.getId_kk(), AddAnggota.getJenis_kelamin(),
						AddAnggota.getKepala_keluarga(), AddAnggota.getNama(), AddAnggota.getNik(),
						AddAnggota.getPendidikan(), AddAnggota.getTanggal_lahir(), AddAnggota.getTempat_lahir(),
						id_kk });

		return AddAnggota;
	}
}
