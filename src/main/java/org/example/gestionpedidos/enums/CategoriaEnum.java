package org.example.gestionpedidos.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public enum CategoriaEnum {
    COMIDA("Comida"), BEBIDA("Bebida"), OTRO ("Otro");

    private final String categoria;

    private CategoriaEnum(String categoria) {
        this.categoria = categoria;
    }
}
