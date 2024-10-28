package com.facturacion.daycam.lineas.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LineaModel {
    private Long id;
    private String nombre;
    private String estado;
    private String desvincular;
}
