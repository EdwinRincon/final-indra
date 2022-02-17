package com.formacion.app.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacion.app.apirest.dao.VentaDao;
import com.formacion.app.apirest.entity.Venta;;


@Service
public class VentaServiceImpl implements VentaService{

	@Autowired
	private VentaDao ventaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Venta> findAll() {
		return (List<Venta>) ventaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Venta findById(Long id) {
		return ventaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Venta save(Venta venta) {
		return ventaDao.save(venta);
	}

	@Override
	public void delete(Long id) {
		ventaDao.deleteById(id);
		
	}

}
