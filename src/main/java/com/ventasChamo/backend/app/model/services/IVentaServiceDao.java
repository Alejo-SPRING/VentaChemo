package com.ventasChamo.backend.app.model.services;

import org.springframework.data.repository.CrudRepository;

import com.ventasChamo.backend.app.model.entity.Venta;

public interface IVentaServiceDao extends CrudRepository<Venta, Integer>{

}
