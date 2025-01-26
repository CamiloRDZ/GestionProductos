package org.example.gestionpedidos.controller;

import org.example.gestionpedidos.model.Pedido;
import org.example.gestionpedidos.model.Producto;
import org.example.gestionpedidos.service.PedidoService;
import org.example.gestionpedidos.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ProductoService productoService;

    @PostMapping(path = "calcularTotal", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> calcularTotal(@RequestParam String idPedido){

        Pedido pedido = pedidoService.buscarPedido(idPedido);
        if(pedido == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El pedido no esta creado.");
        }

        double precioTotal = pedidoService.calcularTotal(pedido);
        return ResponseEntity.status(HttpStatus.OK).body("Total: " + precioTotal);

    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> crearPedido(@RequestBody Pedido pedido){

        List<Producto> productos = productoService.buscarProductos();
        if(productos.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se ha creado aun los productos.");
        }
        boolean rsp = pedido.getProductos()
                .stream()
                .allMatch(p -> productos.contains(p));

        if (rsp){
            try {
                pedidoService.guardarPedido(pedido);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Error al crear pedido.");
            }
            return ResponseEntity.ok("Pedido creado.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El pedido contiene productos que no se han creado");

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Pedido>> listarPedidos(){
        List<Pedido> pedidos = pedidoService.listarPedidos();
        return ResponseEntity.ok().body(pedidos);
    }

    @GetMapping(path = "/buscarPedido", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pedido> buscarPedido(@RequestParam String idPedido){
        Pedido pedido = pedidoService.buscarPedido(idPedido);
        if(pedido == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(pedido);
    }
}
