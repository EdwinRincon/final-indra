package com.formacion.app.apirest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formacion.app.apirest.entity.Cliente;


@Repository
public interface ClienteDao extends JpaRepository<Cliente, Long>{

	
}
