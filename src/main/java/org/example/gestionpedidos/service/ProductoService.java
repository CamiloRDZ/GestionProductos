package org.example.gestionpedidos.service;

import org.example.gestionpedidos.model.Producto;

import java.util.List;

public interface ProductoService {

    List<Producto> buscarProductos();

    void  guardarProducto(Producto producto);
}
