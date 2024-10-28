package com.facturacion.daycam.proveedores.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProveedorGuardarDto implements Serializable{
    
    private String nombre;
    private String nit;
    private String direccion;
    private String telefono;
    private String celular;
    private String correo;
}
