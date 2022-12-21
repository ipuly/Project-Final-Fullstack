package com.example.demo.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.KkModel;
import com.example.demo.repository.IKkRepository;

@Repository
public class KkRepository implements IKkRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public KkModel insertAddKk(KkModel addkk) {
		String query = "INSERT INTO tb_kartu_keluarga(alamat, desa_kelurahan, kabupaten_kota, kecamatan, kode_pos, nomor_kk, provinsi, rt, rw) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(query,
				new Object[] { addkk.getAlamat(), addkk.getDesa_kelurahan(), addkk.getKabupaten_kota(),
						addkk.getKecamatan(), addkk.getKode_pos(), addkk.getNomor_kk(), addkk.getProvinsi(),
						addkk.getRt(), addkk.getRw() });
		return addkk;
	}

	@Override
	public List<KkModel> getAllAddKk() {
		String query = "SELECT * FROM tb_kartu_keluarga";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(KkModel.class));
	}

	@Override
	public KkModel updateAddKk(int id, KkModel addkk) {
		String query = "UPDATE tb_kartu_keluarga SET alamat = ?, desa_kelurahan = ?, kabupaten_kota = ?, kecamatan = ?, "
				+ "kode_pos = ?, nomor_kk = ?, provinsi = ?, rt = ?, rw = ? WHERE id = ?";

		jdbcTemplate.update(query,
				new Object[] { addkk.getAlamat(), addkk.getDesa_kelurahan(), addkk.getKabupaten_kota(),
						addkk.getKecamatan(), addkk.getKode_pos(), addkk.getNomor_kk(), addkk.getProvinsi(),
						addkk.getRt(), addkk.getRw(), id });

		return addkk;
	}

	@Override
	public KkModel deleteAddKk(int id) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_kartu_keluarga WHERE id = ?";
		var result = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(KkModel.class), id);

		query = "DELETE FROM tb_kartu_keluarga WHERE id = ?";
		jdbcTemplate.update(query, id);

		return result;
	}

	@Override
	public KkModel getKkById(int id) {
		String query = "SELECT * FROM tb_kartu_keluarga WHERE id = ?";
		return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(KkModel.class), id);
	}
}
