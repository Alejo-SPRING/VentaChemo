package com.ventasChamo.backend.app.services;

import java.util.List;

import com.ventasChamo.backend.app.model.entity.UsuarioHasRol;

public interface IUsuarioHasRolService {

	public void create(UsuarioHasRol usuarioHasRol);

	public void update(UsuarioHasRol usuarioHasRol);

	public UsuarioHasRol findForId(Integer id);

	public List<UsuarioHasRol> findAll();

	public void delete(Integer id);
	
}
