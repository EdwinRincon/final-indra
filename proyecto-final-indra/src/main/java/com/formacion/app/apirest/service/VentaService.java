package com.formacion.app.apirest.service;

import java.util.List;

import com.formacion.app.apirest.entity.Venta;


public interface VentaService {

	public List<Venta> findAll();
	
	public Venta findById(Long id);
	
	public Venta save(Venta cliente);
	
	public void delete(Long id);
}
