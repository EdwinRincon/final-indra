package com.formacion.app.apirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.formacion.app.apirest.entity.Venta;
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
	
	
	@GetMapping("/venta/nuevo")
	public String formularioVenta(Model modelo) {
		Venta newVenta= new Venta();
		modelo.addAttribute("ventaKey",newVenta);
		return "nuevo_venta";
	}
	
	@PostMapping("/venta")
	public String guardarVenta(@ModelAttribute("ventaKey") Venta venta) {
		servicio.save(venta);
		return "redirect:/ventas";
	}
	
	@GetMapping("/venta/editar/{id}")
	public String formularioEdicionVenta(@PathVariable Long id,Model modelo) {
		modelo.addAttribute("ventaKey",servicio.findById(id));
		return "editar_venta";
	}
	
	@PostMapping("/venta/editar/{id}")
	public String editarVenta(@PathVariable Long id,@ModelAttribute("ventaKey") Venta venta){
		
		Venta ventaEdit = servicio.findById(id);
		ventaEdit.setCantidad(venta.getCantidad());
		ventaEdit.setSubtotal(venta.getSubtotal());
		ventaEdit.setIva(venta.getIva());
		ventaEdit.setTotal(venta.getTotal());
		
		servicio.save(ventaEdit);
		
		return "redirect:/ventas";
	}
	
	@GetMapping("/venta/borrar/{id}")
	public String eliminarVenta(@PathVariable Long id) {
		servicio.delete(id);
		return "redirect:/ventas";
	}
	

}
