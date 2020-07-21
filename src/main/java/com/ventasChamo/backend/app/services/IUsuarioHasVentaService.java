package com.ventasChamo.backend.app.services;

import java.util.List;

import com.ventasChamo.backend.app.model.entity.UsuarioHasVenta;

public interface IUsuarioHasVentaService {

	public void create(UsuarioHasVenta usuarioHasVenta);

	public void update(UsuarioHasVenta usuarioHasVenta);

	public UsuarioHasVenta findForId(Integer id);

	public List<UsuarioHasVenta> findAll();

	public void delete(UsuarioHasVenta usuarioHasVenta);
	
}
