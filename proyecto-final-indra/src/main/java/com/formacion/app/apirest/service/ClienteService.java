package com.formacion.app.apirest.service;

import java.util.List;

import com.formacion.app.apirest.entity.Cliente;


public interface ClienteService {

	List<Cliente> getClientes();
	
	Cliente getCliente(Long id);
	
	Cliente postCliente(Cliente cliente);
	
	Cliente putCliente(Cliente cliente, long id);
	
	void deleteCliente(long id);
	
}
