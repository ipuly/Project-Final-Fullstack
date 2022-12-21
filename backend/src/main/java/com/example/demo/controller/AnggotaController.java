package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AnggotaModel;
import com.example.demo.service.IAnggotaService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/anggota")
public class AnggotaController {
	@Autowired
	IAnggotaService AddAnggotaService;

	@PostMapping("/insert")
	public AnggotaModel insertAddAnggota(@RequestBody AnggotaModel AddAnggota) {
		return AddAnggotaService.insertAddAnggota(AddAnggota);
	}

	@GetMapping("/getAll")
	public List<AnggotaModel> getAllAddAnggota() {
		return AddAnggotaService.getAllAddAnggota();
	}

	@PutMapping("/update/{id}")
	public AnggotaModel updateAddAnggota(@PathVariable int id, @RequestBody AnggotaModel AddAnggota) {
		return AddAnggotaService.updateAddAnggota(id, AddAnggota);
	}

	@DeleteMapping("/delete/{id}")
	public AnggotaModel deleteAddAnggota(@PathVariable int id) {
		return AddAnggotaService.deleteAddAnggota(id);
	}

	@DeleteMapping("/deleteAllAnggota/{id_kk}")
	public List<AnggotaModel> deleteAllAnggota(@PathVariable String id_kk) {
		return AddAnggotaService.deleteAllAnggota(id_kk);
	}

	@GetMapping("/getAnggota/{id}")
	public AnggotaModel getAnggotaById(@PathVariable int id) {
		return AddAnggotaService.getAnggota(id);
	}

	@GetMapping("/getIdKk/{id_kk}")
	public List<AnggotaModel> getAnggotaByIdKk(@PathVariable String id_kk) {
		return AddAnggotaService.getAnggotaByIdKk(id_kk);
	}

	@PutMapping("/updateKK/{id_kk}")
	public AnggotaModel updateAnggotaByIdKk(@PathVariable String id_kk,
			@RequestBody AnggotaModel AddAnggota) {
		return AddAnggotaService.updateAnggotaByIdKk(id_kk, AddAnggota);
	}
}
