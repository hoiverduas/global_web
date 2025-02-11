package com.sura.global_web.producto.repository;

import com.sura.global_web.producto.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepository extends JpaRepository<Producto,Long> {


}
