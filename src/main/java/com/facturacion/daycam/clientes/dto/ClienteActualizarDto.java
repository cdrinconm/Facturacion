package com.facturacion.daycam.clientes.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteActualizarDto{
    private Long id;
    private String nombre;
    private String nit;
    private String direccion;
    private String telefono;
    private String celular;
    private String correo;
    private String estado;
    private String desvincular;
    private Double valorCredito;
    private String fechaCredito;
    private String remitente;
    private String cedularemitente;
    private String telefonoremitente;
}
