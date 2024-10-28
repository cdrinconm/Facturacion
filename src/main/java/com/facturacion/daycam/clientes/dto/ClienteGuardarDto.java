package com.facturacion.daycam.clientes.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteGuardarDto implements Serializable{
    
    private String nombre;
    private String nit;
    private String direccion;
    private String telefono;
    private String celular;
    private String correo;
    private Double valorCredito;
    private String fechaCredito;
    private String remitente;
    private String cedularemitente;
    private String telefonoremitente;
}
