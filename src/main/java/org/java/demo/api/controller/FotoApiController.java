package org.java.demo.api.controller;

import org.java.demo.pojo.Foto;
import org.java.demo.service.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FotoApiController {
	
    @Autowired
    private FotoService fotoService;

	@GetMapping("/foto")
	public ResponseEntity<List<Foto>> getFotoIndex(
			@RequestBody(required = false) String name
		) {
		
		List<Foto> foto = (name == null || name.isBlank())
				? fotoService.findAll()
				: fotoService.findByTitolo(name);
		
		return new ResponseEntity<>(foto, HttpStatus.OK);
	}

}
