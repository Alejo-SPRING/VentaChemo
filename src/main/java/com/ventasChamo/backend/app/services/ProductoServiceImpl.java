package com.ventasChamo.backend.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventasChamo.backend.app.model.entity.Producto;
import com.ventasChamo.backend.app.model.services.IProductoServiceDao;

@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private IProductoServiceDao productoServiceDao;
	
	@Override
	public void create(Producto producto) {
		productoServiceDao.save(producto);
	}

	@Override
	public void update(Producto producto) {
		productoServiceDao.save(producto);
	}

	@Override
	public Producto findForId(Integer id) {
		return productoServiceDao.findById(id).orElse(new Producto());
	}

	@Override
	public List<Producto> findAll() {
		return (List<Producto>) productoServiceDao.findAll();
	}

	@Override
	public void delete(Producto producto) {
		productoServiceDao.delete(producto);
	}

}
