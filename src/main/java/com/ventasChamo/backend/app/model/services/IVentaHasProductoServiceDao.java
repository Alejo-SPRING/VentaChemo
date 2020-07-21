package com.ventasChamo.backend.app.model.services;

import org.springframework.data.repository.CrudRepository;

import com.ventasChamo.backend.app.model.entity.VentaHasProducto;

public interface IVentaHasProductoServiceDao extends CrudRepository<VentaHasProducto, Integer>{

}
