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

import com.example.demo.model.AddAnggota;
import com.example.demo.service.IAnggotaService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/anggota")
public class AnggotaController {
	@Autowired
	IAnggotaService AddAnggotaService;
	
	
	@PostMapping("/insert")
	public AddAnggota insertAddAnggota(@RequestBody AddAnggota AddAnggota){
		return AddAnggotaService.insertAddAnggota(AddAnggota);
	}
	
	@GetMapping("/getAll")
	public List<AddAnggota> getAllAddAnggota(){
		return AddAnggotaService.getAllAddAnggota();
	}
	
	@PutMapping("/update/{id}")
	public AddAnggota updateAddAnggota(@PathVariable int id, @RequestBody AddAnggota AddAnggota) {
		return AddAnggotaService.updateAddAnggota(id, AddAnggota);
	}
	
	@DeleteMapping("/delete/{id}")
	public AddAnggota deleteAddAnggota(@PathVariable int id) {
		return AddAnggotaService.deleteAddAnggota(id);
	}
	
//	@GetMapping("/student/{id}")
//	public AddAnggota getAddAnggota(@PathVariable int id) {
//		return AddAnggotaService.getStudent(id);
//	}
}
