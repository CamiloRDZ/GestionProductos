package org.example.gestionpedidos.service.impl;

import org.example.gestionpedidos.enums.CategoriaEnum;
import org.example.gestionpedidos.model.Pedido;
import org.example.gestionpedidos.model.Producto;
import org.example.gestionpedidos.repository.PedidoRepository;
import org.example.gestionpedidos.service.PedidoService;
import org.example.gestionpedidos.strategy.CalcularDecuento;
import org.example.gestionpedidos.strategy.CalcularDescuentoBebida;
import org.example.gestionpedidos.strategy.CalcularDescuentoComida;
import org.example.gestionpedidos.strategy.SinDescuento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public void guardarPedido(Pedido pedido) {
        pedidoRepository.guardarPedido(pedido);
    }

    @Override
    public double calcularTotal(Pedido pedido) {
        return pedido.getProductos()
                .stream()
                .mapToDouble(producto -> {
                    if (producto.getCategoria().equalsIgnoreCase("Bebida")) {
                        CalcularDecuento calcularDescuento = new CalcularDescuentoBebida();
                        return calcularDescuento.calcularDescuento(producto.getPrecio());
                    } else if (producto.getCategoria().equalsIgnoreCase("Comida")) {
                        CalcularDecuento calcularDescuento = new CalcularDescuentoComida();
                        return calcularDescuento.calcularDescuento(producto.getPrecio());
                    } else {
                        CalcularDecuento calcularDescuento = new SinDescuento();
                        return calcularDescuento.calcularDescuento(producto.getPrecio());
                    }
                })
                .sum();
    }

    @Override
    public List<Pedido> listarPedidos() {
        return pedidoRepository.listarPedidos();
    }

    @Override
    public Pedido buscarPedido(String idPedido) {
        return pedidoRepository.bucarPedido(idPedido);
    }
}
