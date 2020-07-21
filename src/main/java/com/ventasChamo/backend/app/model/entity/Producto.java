package com.ventasChamo.backend.app.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "producto_id")
	private Integer id;
	@Column(name = "producto_img")
	private String img;
	@Column(name = "producto_nombre")
	private String nombre;
	@Column(name = "producto_valor")
	private BigDecimal valor;
	@OneToMany(mappedBy = "producto")
	private List<VentaHasProducto> ventaHasProductoList;

	public List<VentaHasProducto> getVentaHasProductoList() {
		return ventaHasProductoList;
	}

	public void setVentaHasProductoList(List<VentaHasProducto> ventaHasProductoList) {
		this.ventaHasProductoList = ventaHasProductoList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
