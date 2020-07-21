package com.ventasChamo.backend.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ventasChamo.backend.app.model.entity.UsuarioHasRol;
import com.ventasChamo.backend.app.model.services.IUsuarioHasRolServiceDao;

@Service
public class UsuarioHasRolServiceImpl implements IUsuarioHasRolService {

	@Autowired
	private IUsuarioHasRolServiceDao usuarioHasRolServiceDao;

	@Override
	public void create(UsuarioHasRol usuarioHasRol) {
		usuarioHasRol.getUsuarioLogin()
				.setPass(new BCryptPasswordEncoder().encode(usuarioHasRol.getUsuarioLogin().getPass()));
		usuarioHasRolServiceDao.save(usuarioHasRol);
	}

	@Override
	public void update(UsuarioHasRol usuarioHasRol) {
		usuarioHasRolServiceDao.save(usuarioHasRol);
	}

	@Override
	public UsuarioHasRol findForId(Integer id) {
		return usuarioHasRolServiceDao.findById(id).orElse(new UsuarioHasRol());
	}

	@Override
	public List<UsuarioHasRol> findAll() {
		return (List<UsuarioHasRol>) usuarioHasRolServiceDao.findAll();
	}

	@Override
	public void delete(Integer id) {
		usuarioHasRolServiceDao.deleteById(id);
	}

}
