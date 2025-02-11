package com.sura.global_web.producto.service;

import com.sura.global_web.producto.entities.Producto;

import java.util.List;

public interface IProductoService {

    Producto createProducto(Producto producto);
    List<Producto> findAllProductos();
    Producto findByIdProducto(Long id);
    Producto updateProducto(Long id,Producto producto);
    String deleteByProducto(Long id);
}
