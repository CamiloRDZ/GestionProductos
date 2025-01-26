package org.example.gestionpedidos.model;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Producto {

    private String idProducto;
    private String nombre;
    private String categoria;
    private Double precio;

}
