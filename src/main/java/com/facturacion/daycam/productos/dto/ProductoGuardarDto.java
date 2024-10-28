package com.facturacion.daycam.productos.dto;

import com.facturacion.daycam.bodegas.model.BodegaModel;
import com.facturacion.daycam.lineas.model.LineaModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoGuardarDto {
    private String codigo;
    private String nombre;
    private String cantidad;
    private String fecharegistro;
    private LineaModel linea;
    private BodegaModel bodega;
    private String estado;
    private String desvincular;
    private Double costo;
    private Double costoventa;
    private String serial;
    private Double costoventa2;
    private Double costoventa3;
    private int iva;
    private String observacion;
}