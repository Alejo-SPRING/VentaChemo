package com.ventasChamo.backend.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventasChamo.backend.app.model.entity.Venta;
import com.ventasChamo.backend.app.model.services.IVentaServiceDao;

@Service
public class VentaServiceImpl implements IVentaService{

	@Autowired
	private IVentaServiceDao ventaServiceDao;
	
	@Override
	public void create(Venta venta) {
		ventaServiceDao.save(venta);
	}

	@Override
	public void update(Venta venta) {
		ventaServiceDao.save(venta);
	}

	@Override
	public Venta findForId(Integer id) {
		return ventaServiceDao.findById(id).orElse(new Venta());
	}

	@Override
	public List<Venta> findAll() {
		return (List<Venta>) ventaServiceDao.findAll();
	}

	@Override
	public void delete(Venta venta) {
		ventaServiceDao.delete(venta);
	}

}
