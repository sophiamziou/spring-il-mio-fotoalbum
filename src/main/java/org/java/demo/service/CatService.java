package org.java.demo.service;

import java.util.List;
import java.util.Optional;

import org.java.demo.pojo.Categoria;
import org.java.demo.repo.CatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatService {

	@Autowired
	private CatRepo catRepo;
	
	public List<Categoria> findAll() {
		
		return catRepo.findAll();
	}
	public Categoria save(Categoria categoria) {
		
		return catRepo.save(categoria);
	}
	public Optional<Categoria> findById(int id) {
		
		return catRepo.findById(id);
	}
	
	public void deleteCat(Categoria categoria) {
		
		catRepo.delete(categoria);
	}
	
}