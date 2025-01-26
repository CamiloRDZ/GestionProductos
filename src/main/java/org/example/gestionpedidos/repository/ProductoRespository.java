package org.example.gestionpedidos.repository;

import org.example.gestionpedidos.model.Producto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductoRespository {

    private final List<Producto> productos = new ArrayList<Producto>();

    public List<Producto> buscarProductos() {
        return this.productos;
    }

    public void guardarProducto(Producto producto) {
        this.productos.add(producto);
    }
}
