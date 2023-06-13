package org.java.demo.repo;

import java.util.List;

import org.java.demo.pojo.Foto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FotoRepo extends JpaRepository<Foto, Integer> {

	public List<Foto> findByTitoloContaining(String titolo);
}
