package com.ventasChamo.backend.app.services;

import java.util.List;

import com.ventasChamo.backend.app.model.entity.UsuarioLogin;

public interface IUsuarioLoginService {

	public void create(UsuarioLogin usuarioLogin);
	
	public void update(UsuarioLogin usuarioLogin);
	
	public UsuarioLogin findForId(Integer id);
	
	public List<UsuarioLogin> findAll();
	
	public void delete(UsuarioLogin usuarioLogin);

	public UsuarioLogin findForUsername(String username);
	
}
