package org.example.gestionpedidos.service;

import org.example.gestionpedidos.model.Pedido;

import java.util.List;

public interface PedidoService {

    void guardarPedido(Pedido pedido);

    double calcularTotal(Pedido pedido);

    List<Pedido> listarPedidos();

    Pedido buscarPedido(String idPedido);
}
