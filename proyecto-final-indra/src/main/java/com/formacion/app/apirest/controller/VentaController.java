package com.formacion.app.apirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.formacion.app.apirest.service.VentaService;

@Controller
public class VentaController {
	
	@Autowired
	private VentaService servicio;
	
	@GetMapping( {"/ventas","/"} )
	public String listarVentas(Model model) {
		model.addAttribute("ventas",servicio.findAll());
		return "ventas";
	}

}
