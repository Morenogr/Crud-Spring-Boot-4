package com.luis.demo.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luis.demo.interfaceService.InterfaceVentasService;
import com.luis.demo.modelo.Comprador;

@Controller
@RequestMapping
public class Controlador {

	@Autowired
	private InterfaceVentasService service;
	
	@GetMapping("/home")
	public String home(Model model) {
		return "home";
	}

	@GetMapping("/listar")
	public String listar(Model model, @Param("palabraClave")String palabraClave) {
		
		List<Comprador> persona = service.listar(palabraClave);
		model.addAttribute("personas", persona);
		model.addAttribute("palabraClave", palabraClave);
		return "index";
	}

	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("persona", new Comprador());
		return "formulario";
	}

	@PostMapping("/save")
	public String save(@Valid Comprador c, Model model) {
		String opciones = c.getOpciones();
		c.setOpciones(opciones);
		service.save(c);
		return "redirect:/listar";

	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Comprador> persona = service.listarId(id);
		model.addAttribute("persona", persona);
		return "formulario";
	}

	@GetMapping("/eliminar/{id}")
	public String delete(Model model, @PathVariable int id) {
		service.delete(id);
		return "redirect:/listar";

	}

}
