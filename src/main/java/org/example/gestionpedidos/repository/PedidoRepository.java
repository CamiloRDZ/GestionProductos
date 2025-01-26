package org.example.gestionpedidos.repository;

import org.example.gestionpedidos.model.Pedido;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PedidoRepository {

    List<Pedido> pedidos = new ArrayList<>();

    public List<Pedido> listarPedidos() {
        return this.pedidos;
    }
    public Pedido bucarPedido(String idPedido) {
        return pedidos.stream()
                .filter(p -> p.getIdPedido().equals(idPedido))
                .findFirst()
                .orElse(null);
    }

    public void guardarPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }
}
