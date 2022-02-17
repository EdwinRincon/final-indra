package com.formacion.app.apirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.formacion.app.apirest.entity.Producto;
import com.formacion.app.apirest.service.ProductoService;

@Controller
public class ProductoController {

	@Autowired
	private ProductoService servicio;
	
	@GetMapping({"/productos", "/"})
	public String listarProductos(Model model) {
		
		model.addAttribute("productos", servicio.findAll());
		return "productos/productos";
	}
	
	@GetMapping("/productos/nuevo")
	public String formularioProductos(Model modelo) {
		
		Producto newProducto = new Producto();
		modelo.addAttribute("empleadoKey", newProducto);
		return "productos/nuevo_producto";
	}
	
	@PostMapping("/productos")
	public String guardarProducto(@ModelAttribute("productoKey") Producto producto) {
		
		servicio.save(producto);
		return "redirect:/productos";
	}
	
	@GetMapping("/productos/editar/{id}")
	public String formularioEdicionProducto(@PathVariable Long id, Model modelo) {
		
		modelo.addAttribute("productoKey", servicio.findById(id));
		return "productos/editar_producto";		
	}
	
	@PostMapping("/productos/editar/{id}")
	public String editarProducto(@PathVariable Long id, @ModelAttribute("productoKey") Producto producto, Model modelo) {
		
		Producto productoEdit = servicio.findById(id);
		productoEdit.setNombre(producto.getNombre());
		productoEdit.setDescripcion(producto.getDescripcion());
		productoEdit.setP_unitario(producto.getP_unitario());
		productoEdit.setExistencias(producto.getExistencias());
		servicio.save(productoEdit);
		return "redirect:/productos";	
	}
	
	@GetMapping("/productos/borrar/{id}")
	public String eliminarProducto(@PathVariable Long id) {
		
		servicio.delete(id);
		return "redirect:/productos";
	}

}
