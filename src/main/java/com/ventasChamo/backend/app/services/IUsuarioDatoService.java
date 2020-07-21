package com.ventasChamo.backend.app.services;

import java.util.List;

import com.ventasChamo.backend.app.model.entity.UsuarioDato;

public interface IUsuarioDatoService {

	public void create(UsuarioDato usuarioDato);

	public void update(UsuarioDato usuarioDato);

	public UsuarioDato findForId(Integer id);

	public List<UsuarioDato> findAll();

	public void delete(UsuarioDato usuarioDato);

}
