package org.java.demo.service;

import java.util.List;
import java.util.Optional;

import org.java.demo.pojo.Foto;
import org.java.demo.repo.FotoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FotoService {

	@Autowired
	private FotoRepo fotoRepo;
	
	public List<Foto> findAll() {
		
		return fotoRepo.findAll();
	}
	public Foto save(Foto foto) {
		
		return fotoRepo.save(foto);
	}
	public Optional<Foto> findById(int id) {
		
		return fotoRepo.findById(id);
	}
	
	public void deleteFoto(Foto foto) {
		
		fotoRepo.delete(foto);
	}
	
}
