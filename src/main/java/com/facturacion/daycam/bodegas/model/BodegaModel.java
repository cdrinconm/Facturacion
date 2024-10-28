package com.facturacion.daycam.bodegas.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BodegaModel {
    private Long id;
    private String nombre;
    private String contacto;
    private String telefono;
    private String direccion;
    private String estado;
    private String desvincular;
}
