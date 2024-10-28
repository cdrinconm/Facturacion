package com.facturacion.daycam.vendedor.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendedorActualizarDto{
    private Long id;
    private String nombre;
    private String nit;
    private String direccion;
    private String telefono;
    private String celular;
    private String correo;
    private String estado;
    private String desvincular;
}
