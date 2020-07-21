package com.ventasChamo.backend.app.services;

import java.util.List;

import com.ventasChamo.backend.app.model.entity.Producto;

public interface IProductoService {

	public void create(Producto producto);

	public void update(Producto producto);

	public Producto findForId(Integer id);

	public List<Producto> findAll();

	public void delete(Producto producto);
	
}
