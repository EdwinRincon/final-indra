package com.formacion.app.apirest.service;

import java.util.List;

import com.formacion.app.apirest.entity.Producto;


public interface ProductoService {

	public List<Producto> findAll();
	
	public Producto findById(Long id);
	
	public Producto save(Producto producto);
	
	public void delete(Long id);
}
