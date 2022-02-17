package com.formacion.app.apirest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formacion.app.apirest.entity.Producto;



public interface ProductoDao extends JpaRepository<Producto, Long>{

}
