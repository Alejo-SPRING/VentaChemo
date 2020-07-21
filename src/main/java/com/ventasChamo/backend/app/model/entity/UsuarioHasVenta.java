package com.ventasChamo.backend.app.model.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "venta_has_producto")
public class UsuarioHasVenta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idventa_has_producto")
	private Integer id;
	@JoinColumn(name = "usuario_id", referencedColumnName = "usuariodatos_id")
	@ManyToOne(cascade = CascadeType.ALL)
	private UsuarioDato usuarioDato;
	@JoinColumn(name = "venta_id", referencedColumnName = "venta_id")
	@ManyToOne(cascade = CascadeType.ALL)
	private Venta venta;
	
	
}
