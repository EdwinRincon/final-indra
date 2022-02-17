package com.formacion.app.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacion.app.apirest.dao.ClienteDao;
import com.formacion.app.apirest.entity.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteDao clienteDao;

	@Transactional(readOnly=true)
	@Override
	public List<Cliente> getClientes() {
		return clienteDao.findAll();
	}

	@Transactional
	@Override
	public Cliente getCliente(Long id) {
		return clienteDao.findById(id).orElse(null);
	}
	
	@Transactional
	@Override
	public Cliente postCliente(Cliente cliente) {
		return clienteDao.save(cliente);
	}

	@Transactional
	@Override
	public Cliente putCliente(Cliente cliente, long id) {
		Cliente toUpdateCliente = getCliente(id);
		
		if (toUpdateCliente==null) return null;
		
		toUpdateCliente.setNombre(cliente.getNombre());
		toUpdateCliente.setApellidos(cliente.getApellidos());
		toUpdateCliente.setSexo(cliente.getSexo());
		toUpdateCliente.setTelefono(cliente.getTelefono());
		return this.clienteDao.save(toUpdateCliente);
	}

	@Transactional
	@Override
	public void deleteCliente(long id) {
		this.clienteDao.deleteById(id);
		
	}
	

	
}
