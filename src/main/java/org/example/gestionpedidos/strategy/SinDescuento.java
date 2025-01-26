package org.example.gestionpedidos.strategy;

public class SinDescuento implements CalcularDecuento {

    @Override
    public double calcularDescuento(double precio) {
        return precio;
    }
}
