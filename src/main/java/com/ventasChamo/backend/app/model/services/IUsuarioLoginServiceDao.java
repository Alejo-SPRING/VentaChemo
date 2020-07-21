package com.ventasChamo.backend.app.model.services;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ventasChamo.backend.app.model.entity.UsuarioLogin;

public interface IUsuarioLoginServiceDao extends CrudRepository<UsuarioLogin, Integer>{

	@Query("SELECT u FROM UsuarioLogin u WHERE u.correo = :username OR u.usuarioDato.nombre = :username")
	UsuarioLogin findForUsername(@Param("username") String username);
	
}
