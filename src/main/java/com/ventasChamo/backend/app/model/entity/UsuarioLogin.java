package com.ventasChamo.backend.app.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "usuario_login")
public class UsuarioLogin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idusuario_login_id")
	private Integer id;
	@Column(name = "usuario_login_correo", nullable = false)
	private String correo;
	@Column(name = "usuario_login_pass")
	private String pass;
	@JoinColumn(name = "usuario_datos_id", referencedColumnName = "usuariodatos_id")
	@OneToOne(cascade = CascadeType.ALL)
	private UsuarioDato usuarioDato;
	@OneToMany(mappedBy = "usuarioLogin")
	@JsonManagedReference
	private List<UsuarioHasRol> usuarioHasRolList;

	public List<UsuarioHasRol> getUsuarioHasRolList() {
		return usuarioHasRolList;
	}

	public void setUsuarioHasRolList(List<UsuarioHasRol> usuarioHasRolList) {
		this.usuarioHasRolList = usuarioHasRolList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public UsuarioDato getUsuarioDato() {
		return usuarioDato;
	}

	public void setUsuarioDato(UsuarioDato usuarioDato) {
		this.usuarioDato = usuarioDato;
	}

}
