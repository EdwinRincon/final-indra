package com.formacion.app.apirest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formacion.app.apirest.entity.Venta;
import com.formacion.app.apirest.service.VentaService;


@RestController
public class VentasControllerRest {

	@Autowired
	private VentaService servicio;
	
	@GetMapping ("/ventas")
	public List<Venta> venta(){
		
		return servicio.findAll();
	}

	
	@GetMapping("/ventas/{id}")
	public ResponseEntity<?> ventaShow(@PathVariable Long id){
		Venta venta = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			
			venta = servicio.findById(id);
		} catch(DataAccessException e) {
			
			response.put("mensaje", "Error al realizar la consulta a la base de datos");
			response.put("error", e.getMessage().concat("_").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (venta == null) {
			
			response.put("mensaje", "El venta ID: ".concat(id.toString().concat("no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<Venta>(venta, HttpStatus.OK);
	}
	
	
	@PostMapping("/ventas")
	public ResponseEntity<?> saveVenta(@RequestBody Venta venta) {
		Venta ventaNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			
			ventaNew = servicio.save(venta);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat("_").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El venta ha sido creado con éxito!");
		response.put("venta", ventaNew);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/ventas/{id}")
	public ResponseEntity<?> updateVenta(@RequestBody Venta venta, @PathVariable Long id) {
		
		Venta ventaActual = servicio.findById(id);
		Map<String, Object> response = new HashMap<>();
		try {
			
			ventaActual.setCantidad(venta.getCantidad());
			ventaActual.setSubtotal(venta.getSubtotal());
			ventaActual.setIva(venta.getIva());
			ventaActual.setTotal(venta.getTotal());
			ventaActual.setCliente(venta.getCliente());
			ventaActual.setProducto(venta.getProducto());
			
			servicio.save(ventaActual);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat("_").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El venta ha sido actualizado con éxito!");
		response.put("venta", ventaActual);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	

	
	@DeleteMapping("/ventas/{id}")
	public ResponseEntity<?> deleteVenta(@PathVariable Long id) {
		
		Venta ventaBorrado = servicio.findById(id);
		Map<String, Object> response = new HashMap<>();
		
			if (ventaBorrado == null) {
				
				response.put("mensaje", "El venta ID: ".concat(id.toString().concat("no existe en la base de datos")));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}else {
				try {
					
					servicio.delete(id);
				}catch (DataAccessException e) {
					response.put("mensaje", "Error al borrar el registro de la base de datos");
					response.put("error", e.getMessage().concat("_").concat(e.getMostSpecificCause().getMessage()));
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
				}
				
			}
			
			
		
		response.put("mensaje", "El registro ha sido eliminado con éxito!");
		response.put("venta", ventaBorrado);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	
}
