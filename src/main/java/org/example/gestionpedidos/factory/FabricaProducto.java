package org.example.gestionpedidos.factory;

import org.example.gestionpedidos.enums.CategoriaEnum;
import org.example.gestionpedidos.model.Producto;

public class FabricaProducto {

    public static Producto crearProducto(String idProducto, String nombre, String categoria, Double precio) {
        try {
            CategoriaEnum categoriaEnum = CategoriaEnum.valueOf(categoria.toUpperCase());
            return new Producto(idProducto, nombre, categoria, precio);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("La categoria " + categoria + ", no es válida");
        }
    }

}
