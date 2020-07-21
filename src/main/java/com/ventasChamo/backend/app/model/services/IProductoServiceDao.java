package com.ventasChamo.backend.app.model.services;

import org.springframework.data.repository.CrudRepository;

import com.ventasChamo.backend.app.model.entity.Producto;

public interface IProductoServiceDao extends CrudRepository<Producto, Integer>{

}
