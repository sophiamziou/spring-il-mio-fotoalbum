package org.java.demo.controller;

import java.util.List;
import java.util.Optional;

import org.java.demo.pojo.Foto;
import org.java.demo.service.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
public class FotoController {

	@Autowired
	private FotoService fotoService;

	@GetMapping("/")
	public String getFotoIndex(Model model) {

		List<Foto> fotos = fotoService.findAll();
		model.addAttribute("fotos", fotos);

		return "foto-index";
	}
	
	@GetMapping("/foto/{id}")
	public String getFotoShow(
			Model model,
			@PathVariable int id
		) {

		Optional<Foto> fotoOpt = fotoService.findById(id);
		Foto foto = fotoOpt.get();
		
		model.addAttribute("foto", foto);

		return "foto-show";
	}
	
	@GetMapping("/admin/foto/create")
	public String createFoto(Model model) {
		model.addAttribute("foto", new Foto());
		return "foto-create";
	}
	
	@PostMapping("/admin/foto/save")
	public String saveFoto(Model model, @Valid @ModelAttribute Foto foto, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			
			for (ObjectError err : bindingResult.getAllErrors()) 
				System.err.println("error: " + err.getDefaultMessage());
			
			model.addAttribute("errors", bindingResult);
			model.addAttribute("foto", foto);
			
			return "foto-create";
		}
		
		fotoService.save(foto);
		return "redirect:/";
	}
	
	@GetMapping("/admin/foto/delete/{id}")
	public String deleteFoto(Model model, @PathVariable("id") int id) {
		
		Optional<Foto> fotoOpt = fotoService.findById(id);
		Foto foto = fotoOpt.get();
		fotoService.deleteFoto(foto); 
		
	    return "redirect:/";
		
	}
	
	@GetMapping("/admin/foto/edit/{id}")
	public String editFoto(Model model, @PathVariable("id") int id) {
		
		Optional<Foto> fotoOpt = fotoService.findById(id);
		Foto foto = fotoOpt.get();
		model.addAttribute("foto", foto);
		
		return "foto-edit";
	}
	
	@PostMapping("/admin/foto/update/{id}")
	public String updateFoto(Model model, @PathVariable("id") int id, @Valid @ModelAttribute Foto foto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			
			for (ObjectError err : bindingResult.getAllErrors()) 
				System.err.println("error: " + err.getDefaultMessage());
			
			model.addAttribute("errors", bindingResult);
			model.addAttribute("foto", foto);
			
			return "foto-create";
		}
		
		fotoService.save(foto);
		return "redirect:/";
	}
	
	@PostMapping("/foto/search")
	public String searchFoto(Model model, @RequestParam(required = false) String titolo) {
		List<Foto> foto = fotoService.findByTitolo(titolo);
		model.addAttribute("titolo", titolo);
		model.addAttribute("fotos", foto);
		
		return "foto-index";
	}
	
}
