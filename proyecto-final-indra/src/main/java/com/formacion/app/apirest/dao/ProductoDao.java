package com.formacion.app.apirest.dao;

import org.springframework.data.repository.CrudRepository;

import com.formacion.app.apirest.entity.Producto;



public interface ProductoDao extends CrudRepository<Producto, Long>{

}
