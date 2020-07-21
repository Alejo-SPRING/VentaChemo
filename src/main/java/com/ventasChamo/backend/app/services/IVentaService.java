package com.ventasChamo.backend.app.services;

import java.util.List;

import com.ventasChamo.backend.app.model.entity.Venta;

public interface IVentaService {

	public void create(Venta venta);

	public void update(Venta venta);

	public Venta findForId(Integer id);

	public List<Venta> findAll();

	public void delete(Venta venta);
	
}
