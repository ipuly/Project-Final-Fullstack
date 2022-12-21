package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.KkModel;
import com.example.demo.repository.IKkRepository;
import com.example.demo.service.IKkService;

@Service
public class KkService implements IKkService {

	@Autowired
	IKkRepository kkRepository;

	@Override
	public KkModel insertAddKk(KkModel AddKk) {
		// TODO Auto-generated method stub
		return kkRepository.insertAddKk(AddKk);
	}

	@Override
	public List<KkModel> getAllAddKk() {
		// TODO Auto-generated method stub
		return kkRepository.getAllAddKk();
	}

	@Override
	public KkModel updateAddKk(int id, KkModel AddKk) {
		// TODO Auto-generated method stub
		return kkRepository.updateAddKk(id, AddKk);
	}

	@Override
	public KkModel deleteAddKk(int id) {
		// TODO Auto-generated method stub
		return kkRepository.deleteAddKk(id);
	}

	@Override
	public KkModel getKkById(int id) {
		// TODO Auto-generated method stub
		return kkRepository.getKkById(id);
	}

}
