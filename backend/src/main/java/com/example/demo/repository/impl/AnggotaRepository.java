package com.example.demo.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AddAnggota;
import com.example.demo.repository.IAnggotaRepository;

@Repository
public class AnggotaRepository implements IAnggotaRepository{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public AddAnggota insertAddAnggota(AddAnggota addanggota) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO tb_anggota_keluarga(agama, id_kk, jenis_kelamin, kepala_keluarga, nama, nik, pendidikan, tanggal_lahir, tempat_lahir) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(query, new Object[] {addanggota.getAgama(), addanggota.getId_kk(), addanggota.getJenis_kelamin(),
				addanggota.getKepala_keluarga(), addanggota.getNama(), addanggota.getNik(), addanggota.getPendidikan(), addanggota.getTanggal_lahir(), addanggota.getTempat_lahir(),});
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
		
		jdbcTemplate.update(query, new Object[] {addanggota.getAgama(), addanggota.getId_kk(), addanggota.getJenis_kelamin(),
				addanggota.getKepala_keluarga(), addanggota.getNama(), addanggota.getNik(), addanggota.getPendidikan(), addanggota.getTanggal_lahir(),addanggota.getTempat_lahir(), id});
		
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

//	@Override
//	public AddAnggota getStudent(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public AddAnggota getAnggota(int id) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_anggota_keluarga WHERE id = ?";
		return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(AddAnggota.class), id);
	}

}
