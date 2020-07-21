package com.ventasChamo.backend.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.ventasChamo.backend.app.model.entity.UsuarioHasRol;
import com.ventasChamo.backend.app.model.entity.UsuarioLogin;
import com.ventasChamo.backend.app.services.IUsuarioHasRolService;
import com.ventasChamo.backend.app.services.IUsuarioLoginService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/cliente")
@RequestScope
public class ClienteRestController {

	@Autowired
	private IUsuarioLoginService usuarioLoginService;
	@Autowired
	private IUsuarioHasRolService usuarioHasRolService;
	private Map<String, Object> body = new HashMap<>();
	private UsuarioLogin usuarioLogin;
	private UsuarioHasRol usuarioHasRol;

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		try {
			usuarioHasRol = usuarioHasRolService.findForId(id);
			if (usuarioHasRol.getId() != null) {
				usuarioHasRolService.delete(id);
				body.put("mensaje", "¡Usuario " + usuarioHasRol.getUsuarioLogin().getUsuarioDato().getNombre() + " "
						+ usuarioHasRol.getUsuarioLogin().getUsuarioDato().getApellido() + " eliminado!");
			} else {
				body.put("mensaje", "¡El ID: " + id + " no esta registrado en la DB!");
				return new ResponseEntity<Map<String, Object>>(body, HttpStatus.NOT_FOUND);
			}
		} catch (DataAccessException e) {
			body.put("mensaje", "¡Error al ejecutar el delete en la DB!");
			body.put("error", e.getStackTrace() + " : " + e.getMostSpecificCause());
			return new ResponseEntity<Map<String, Object>>(body, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Map<String, Object>>(body, HttpStatus.OK);
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Integer id) {
		try {			
			usuarioLogin = usuarioLoginService.findForId(id);
		} catch (DataAccessException e) {
			body.put("mensaje", "Error al ejecutar la consulta en la DB");
			body.put("error", e.getMostSpecificCause());
			return new ResponseEntity<Map<String, Object>>(body, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (usuarioLogin.getId() == null || usuarioLogin.getId() == 0) {
			body.put("mensaje", "¡El usuario con el ID:" + id + " no fue encontrado!");
			return new ResponseEntity<Map<String, Object>>(body, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UsuarioLogin>(usuarioLogin, HttpStatus.OK);
	}

	@GetMapping("/findAll")
	public ResponseEntity<?> findAll() {
		try {
			return new ResponseEntity<List<UsuarioLogin>>(usuarioLoginService.findAll(), HttpStatus.OK);
		} catch (DataAccessException e) {
			body.put("mensaje", "Error al consultar todos los usuarios en la DB");
			body.put("error", e.getStackTrace() + " : " + e.getMostSpecificCause());
			return new ResponseEntity<Map<String, Object>>(body, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody UsuarioHasRol usuarioHasRol) {
		try {
			if (usuarioLoginService.findForUsername(usuarioHasRol.getUsuarioLogin().getCorreo()) != null) {
				body.put("mensaje", "Error en usuario ya existe");
				return new ResponseEntity<Map<String, Object>>(body, HttpStatus.NOT_FOUND);
			}
			usuarioHasRolService.create(usuarioHasRol);
			body.put("mensaje", "¡Usuario " + usuarioHasRol.getUsuarioLogin().getUsuarioDato().getNombre() + " "
					+ usuarioHasRol.getUsuarioLogin().getUsuarioDato().getApellido() + " creado!");
		} catch (DataAccessException e) {
			body.put("mensaje", "Error al hacer el insert en la DB");
			body.put("error", e.getStackTrace() + ":" + e.getMostSpecificCause());
			return new ResponseEntity<Map<String, Object>>(body, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Map<String, Object>>(body, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody UsuarioLogin usuarioLogin) {
		try {
			if (usuarioLoginService.findForId(usuarioLogin.getId()).getId() != null) {
				usuarioLoginService.update(usuarioLogin);
				body.put("mensaje", "Usuario " + usuarioLogin.getUsuarioDato().getNombre() + " "
						+ usuarioLogin.getUsuarioDato().getApellido() + " actualizado!");
			} else {
				body.put("mensaje", "¡El usuario " + usuarioLogin.getUsuarioDato().getNombre() + " "
						+ usuarioLogin.getUsuarioDato().getApellido() + " no existe!");
				return new ResponseEntity<Map<String, Object>>(body, HttpStatus.NOT_FOUND);
			}
		} catch (DataAccessException e) {
			body.put("mensaje", "¡Error al hacer update en la DB!");
			body.put("error", e.getStackTrace() + " : " + e.getMostSpecificCause());
			return new ResponseEntity<Map<String, Object>>(body, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Map<String, Object>>(body, HttpStatus.CREATED);
	}

}
