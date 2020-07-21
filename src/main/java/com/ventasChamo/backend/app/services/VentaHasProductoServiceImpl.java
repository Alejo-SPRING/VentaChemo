package com.ventasChamo.backend.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventasChamo.backend.app.model.entity.VentaHasProducto;
import com.ventasChamo.backend.app.model.services.IVentaHasProductoServiceDao;

@Service
public class VentaHasProductoServiceImpl implements IVentaHasProductoService{

	@Autowired
	private IVentaHasProductoServiceDao ventaHasProductoServiceDao;
	
	@Override
	public void create(VentaHasProducto ventaHasProducto) {
		ventaHasProductoServiceDao.save(ventaHasProducto);
	}

	@Override
	public void update(VentaHasProducto ventaHasProducto) {
		ventaHasProductoServiceDao.save(ventaHasProducto);
	}

	@Override
	public VentaHasProducto findForId(Integer id) {
		return ventaHasProductoServiceDao.findById(id).orElse(new VentaHasProducto());
	}

	@Override
	public List<VentaHasProducto> findAll() {
		return (List<VentaHasProducto>) ventaHasProductoServiceDao.findAll();
	}

	@Override
	public void delete(VentaHasProducto ventaHasProducto) {
		ventaHasProductoServiceDao.delete(ventaHasProducto);
	}

}
