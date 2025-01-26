package org.example.gestionpedidos.strategy;

public class CalcularDescuentoBebida implements CalcularDecuento {

    @Override
    public double calcularDescuento(double precio){
        return precio - (precio * 0.05);
    }
}
