package org.example.gestionpedidos.service.impl;

import org.example.gestionpedidos.factory.FabricaProducto;
import org.example.gestionpedidos.model.Producto;
import org.example.gestionpedidos.repository.ProductoRespository;
import org.example.gestionpedidos.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    ProductoRespository productoRespository;

    @Override
    public List<Producto> buscarProductos() {
        return productoRespository.buscarProductos();
    }

    @Override
    public void guardarProducto(Producto producto) {
        Producto productoFabricado = FabricaProducto.crearProducto(producto.getIdProducto(), producto.getNombre(), producto.getCategoria(), producto.getPrecio());
        productoRespository.guardarProducto(productoFabricado);
    }
}
