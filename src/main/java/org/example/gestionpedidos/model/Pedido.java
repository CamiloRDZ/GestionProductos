package org.example.gestionpedidos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    private String idPedido;
    private String idCliente;
    private List<Producto> productos;
}
