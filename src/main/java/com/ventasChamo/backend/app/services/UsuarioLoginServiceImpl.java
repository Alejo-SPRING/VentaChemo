package com.ventasChamo.backend.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ventasChamo.backend.app.model.entity.UsuarioLogin;
import com.ventasChamo.backend.app.model.services.IUsuarioLoginServiceDao;

@Service
public class UsuarioLoginServiceImpl implements IUsuarioLoginService {

	@Autowired
	private IUsuarioLoginServiceDao usuarioLoginService;

	@Override
	public UsuarioLogin findForUsername(String username) {
		return usuarioLoginService.findForUsername(username);
	}

	@Override
	public void create(UsuarioLogin usuarioLogin) {
		usuarioLoginService.save(usuarioLogin);
	}

	@Override
	public void update(UsuarioLogin usuarioLogin) {
		usuarioLogin.setPass(new BCryptPasswordEncoder().encode(usuarioLogin.getPass()));
		usuarioLoginService.save(usuarioLogin);
	}

	@Override
	public UsuarioLogin findForId(Integer id) {
		return usuarioLoginService.findById(id).orElse(new UsuarioLogin());
	}

	@Override
	public List<UsuarioLogin> findAll() {
		return (List<UsuarioLogin>) usuarioLoginService.findAll();
	}

	@Override
	public void delete(UsuarioLogin usuarioLogin) {
		usuarioLoginService.delete(usuarioLogin);
	}

}
