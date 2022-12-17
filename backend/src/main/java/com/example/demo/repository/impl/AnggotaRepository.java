package com.example.demo.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AddAnggota;
import com.example.demo.repository.IAnggotaRepository;

@Repository
public class AnggotaRepository implements IAnggotaRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public AddAnggota insertAddAnggota(AddAnggota addanggota) {
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
	public List<AddAnggota> getAllAddAnggota() {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_anggota_keluarga";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(AddAnggota.class));
	}

	@Override
	public AddAnggota updateAddAnggota(int id, AddAnggota addanggota) {
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
	public AddAnggota deleteAddAnggota(int id) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_anggota_keluarga WHERE id = ?";
		var result = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(AddAnggota.class), id);

		query = "DELETE FROM tb_anggota_keluarga WHERE id = ?";
		jdbcTemplate.update(query, id);

		return result;
	}

	@Override
	public List<AddAnggota> deleteAllAnggota(String id_kk) {
		String query = "SELECT * FROM tb_anggota_keluarga WHERE id_kk = ?";
		var result = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(AddAnggota.class), id_kk);

		query = "DELETE FROM tb_anggota_keluarga WHERE id_kk = ?";
		jdbcTemplate.update(query, id_kk);

		return result;
	}

	@Override
	public AddAnggota getAnggota(int id) {
		String query = "SELECT * FROM tb_anggota_keluarga WHERE id = ?";
		return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(AddAnggota.class), id);
	}

	@Override
	public List<AddAnggota> getAnggotaByIdKk(String id_kk) {
		String query = "SELECT * FROM tb_anggota_keluarga WHERE id_kk = ?";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(AddAnggota.class), id_kk);
	}

	@Override
	public AddAnggota updateAnggotaByIdKk(String id_kk, AddAnggota AddAnggota) {
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
