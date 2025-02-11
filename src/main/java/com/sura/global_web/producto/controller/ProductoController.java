package com.sura.global_web.producto.controller;

import com.sura.global_web.producto.entities.Producto;
import com.sura.global_web.producto.service.imple.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/productos")
public class ProductoController {

    private final ProductService productService;

    public ProductoController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping
    public ResponseEntity<Producto> createProducto(@RequestBody Producto producto){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.productService.createProducto(producto));
    }

    @GetMapping
    public ResponseEntity<List<Producto>> getAllProductos(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.productService.findAllProductos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.productService.findByIdProducto(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable Long id,@RequestBody Producto producto){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.productService.updateProducto(id,producto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductos(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK).body(this.productService.deleteByProducto(id));
    }

}
