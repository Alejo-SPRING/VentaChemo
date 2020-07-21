package com.ventasChamo.backend.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventasChamo.backend.app.model.entity.UsuarioDato;
import com.ventasChamo.backend.app.model.services.IUsuarioDatoServiceDao;

@Service
public class UsuarioDatoServiceImpl implements IUsuarioDatoService{

	@Autowired
	private IUsuarioDatoServiceDao usuarioServiceDao;
	
	@Override
	public void create(UsuarioDato usuarioDato) {
		usuarioServiceDao.save(usuarioDato);
	}

	@Override
	public void update(UsuarioDato usuarioDato) {
		usuarioServiceDao.save(usuarioDato);
	}

	@Override
	public UsuarioDato findForId(Integer id) {
		return usuarioServiceDao.findById(id).orElse(new UsuarioDato());
	}

	@Override
	public List<UsuarioDato> findAll() {
		return (List<UsuarioDato>) usuarioServiceDao.findAll();
	}

	@Override
	public void delete(UsuarioDato usuarioDato) {
		usuarioServiceDao.delete(usuarioDato);
	}
	
}
