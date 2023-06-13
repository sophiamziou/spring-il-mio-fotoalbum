package org.java.demo.repo;

import org.java.demo.pojo.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRepo extends JpaRepository<Categoria, Integer> {

}
