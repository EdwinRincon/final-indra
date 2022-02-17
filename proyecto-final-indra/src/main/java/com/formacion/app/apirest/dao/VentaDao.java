package com.formacion.app.apirest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formacion.app.apirest.entity.Venta;


public interface VentaDao extends JpaRepository<Venta, Long>{

}
