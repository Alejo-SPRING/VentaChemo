package com.ventasChamo.backend.app.services;

import java.util.List;

import com.ventasChamo.backend.app.model.entity.VentaHasProducto;

public interface IVentaHasProductoService {

	public void create(VentaHasProducto ventaHasProducto);

	public void update(VentaHasProducto ventaHasProducto);

	public VentaHasProducto findForId(Integer id);

	public List<VentaHasProducto> findAll();

	public void delete(VentaHasProducto ventaHasProducto);

}
