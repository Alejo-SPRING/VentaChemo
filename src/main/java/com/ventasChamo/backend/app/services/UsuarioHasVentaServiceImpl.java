package com.ventasChamo.backend.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventasChamo.backend.app.model.entity.UsuarioHasVenta;
import com.ventasChamo.backend.app.model.services.IUsuarioHasVentaServiceDao;

@Service
public class UsuarioHasVentaServiceImpl implements IUsuarioHasVentaService{

	@Autowired
	private IUsuarioHasVentaServiceDao usuarioHasVentaServiceDao;
	
	@Override
	public void create(UsuarioHasVenta usuarioHasVenta) {
		usuarioHasVentaServiceDao.save(usuarioHasVenta);
	}

	@Override
	public void update(UsuarioHasVenta usuarioHasVenta) {
		usuarioHasVentaServiceDao.save(usuarioHasVenta);
	}

	@Override
	public UsuarioHasVenta findForId(Integer id) {
		return usuarioHasVentaServiceDao.findById(id).orElse(new UsuarioHasVenta());
	}

	@Override
	public List<UsuarioHasVenta> findAll() {
		return (List<UsuarioHasVenta>) usuarioHasVentaServiceDao.findAll();
	}

	@Override
	public void delete(UsuarioHasVenta usuarioHasVenta) {
		usuarioHasVentaServiceDao.delete(usuarioHasVenta);
	}

}
