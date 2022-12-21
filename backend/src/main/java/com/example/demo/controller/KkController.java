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

import com.example.demo.model.KkModel;
import com.example.demo.service.IKkService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/kk")
public class KkController {

	@Autowired
	IKkService AddKkService;

	@PostMapping("/insert")
	public KkModel insertAddKk(@RequestBody KkModel AddKk) {
		return AddKkService.insertAddKk(AddKk);
	}

	@GetMapping("/getAll")
	public List<KkModel> getAllAddKk() {
		return AddKkService.getAllAddKk();
	}

	@PutMapping("/update/{id}")
	public KkModel updateAddKk(@PathVariable int id, @RequestBody KkModel AddKk) {
		return AddKkService.updateAddKk(id, AddKk);
	}

	@DeleteMapping("/delete/{id}")
	public KkModel deleteAddKk(@PathVariable int id) {
		return AddKkService.deleteAddKk(id);
	}

	@GetMapping("/getData/{id}")
	public KkModel getKkById(@PathVariable int id) {
		return AddKkService.getKkById(id);
	}

}
