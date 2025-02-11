package com.sura.global_web.producto.service.imple;


import com.sura.global_web.producto.entities.Producto;
import com.sura.global_web.producto.repository.IProductoRepository;
import com.sura.global_web.producto.service.IProductoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductoService {

    private final IProductoRepository productoRepository;

    public ProductService(IProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public Producto createProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public List<Producto> findAllProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto findByIdProducto(Long id) {
        return this.productoRepository
                    .findById(id).orElseThrow(()-> new RuntimeException("not found"));
    }

    @Override
    public Producto updateProducto(Long id, Producto producto) {

        Optional<Producto>optionalProducto= this.productoRepository.findById(id);

        if (optionalProducto.isPresent()){
            Producto productoExiste = optionalProducto.get();


            productoExiste.setName(producto.getName());

            return this.productoRepository.save(productoExiste);
        }else {

            throw new RuntimeException(" producto no existe");
        }

    }

    @Override
    public String deleteByProducto(Long id) {
        findByIdProducto(id);
        this.productoRepository.deleteById(id);
        return"producto con"+ id +" fue eliminado exitosamente ";
    }

}
