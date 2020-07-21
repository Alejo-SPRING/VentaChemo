package com.ventasChamo.backend.app.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ventas")
public class Venta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "venta_id")
	private Integer id;
	@Column(name = "fecha_vena")
	@Temporal(TemporalType.DATE)
	private Date fecha;
	@Column(name = "venta_pago")
	private String pago;
	@Column(name = "venta_total")
	private BigDecimal total;
	@OneToMany(mappedBy = "venta")
	private List<VentaHasProducto> ventaHasProductoList;
	@OneToMany(mappedBy = "venta")
	private List<UsuarioHasVenta> usuarioHasVentaList;

	public List<UsuarioHasVenta> getUsuarioHasVentaList() {
		return usuarioHasVentaList;
	}

	public void setUsuarioHasVentaList(List<UsuarioHasVenta> usuarioHasVentaList) {
		this.usuarioHasVentaList = usuarioHasVentaList;
	}

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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getPago() {
		return pago;
	}

	public void setPago(String pago) {
		this.pago = pago;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

}
