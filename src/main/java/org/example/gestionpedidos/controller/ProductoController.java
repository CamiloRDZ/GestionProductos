package org.example.gestionpedidos.controller;

import org.example.gestionpedidos.factory.FabricaProducto;
import org.example.gestionpedidos.model.Producto;
import org.example.gestionpedidos.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Producto>> buscarProductos(){

        List<Producto> response = productoService.buscarProductos();

        return ResponseEntity.ok().body(response);
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> crearProducto(@RequestBody List<Producto> productos){

        try {
            productos.forEach(producto -> productoService.guardarProducto(producto));
            return ResponseEntity.ok().body("Producto creado");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al crear producto");

        }
    }
}
