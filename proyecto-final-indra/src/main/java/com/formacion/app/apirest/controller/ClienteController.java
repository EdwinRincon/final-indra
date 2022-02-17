package com.formacion.app.apirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.formacion.app.apirest.entity.Cliente;
import com.formacion.app.apirest.service.ClienteService;


@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	
	// Mostrar clientes
	@GetMapping("")
	public String getEmpleados(Model model) {
		model.addAttribute("clientes",clienteService.getClientes());
		return "clientes/clientes";
	}

	// Crear nuevo cliente VISTA
	@GetMapping("/nuevo")
	public String formularioNuevoCliente(Model modelo) {
		Cliente nuevoCliente= new Cliente();
		modelo.addAttribute("clienteKey", nuevoCliente);
		return "clientes/nuevo_cliente";
	}
	
	// Crear nuevo cliente MODELO
	@PostMapping("")
	public String postCliente(@ModelAttribute("cliente") Cliente cliente) {
		clienteService.postCliente(cliente);
		return "redirect:/clientes";
	}
	
	
	//Editar cliente VISTA 
	@GetMapping("/editar/{id}")
	public String formularioEditCliente(@PathVariable long id,Model modelo) {
		modelo.addAttribute("clienteKey", clienteService.getCliente(id));
		return "clientes/editar_cliente";
	}
	
	
	// Editar cliente  MODELO
	@PostMapping("/editar/{id}")
	public String putCliente(@PathVariable Long id, @ModelAttribute("clienteKey") Cliente cliente) {
		clienteService.putCliente(cliente, id);
		return "redirect:/clientes";
	}
	
	
	//Eliminar cliente
	@GetMapping("/eliminar/{id}")
	public String deleteCliente(@PathVariable Long id) {
		clienteService.deleteCliente(id);
		return "redirect:/clientes";
	}
	
}
