package com.facturacion.daycam.productos.entities;

import java.time.Instant;
import java.util.Date;

import com.facturacion.daycam.bodegas.entities.BodegaEntity;
import com.facturacion.daycam.lineas.entities.LineaEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "PRODUCTOS")
public class ProductoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "El código es obligatorio")
    private String codigo;
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    @NotBlank(message = "La cantidad es obligatoria")
    private String cantidad;
    private String fecharegistro;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "linea", nullable=true)
    private LineaEntity linea;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "bodega", nullable=true)
    private BodegaEntity bodega;
    private String estado;
    private String desvincular;
    private Double costo;
    private Double costoventa;
    @NotBlank(message = "El serial es obligatorio")
    private String serial;
    private Double costoventa2;
    private Double costoventa3;
    private int iva;
    private String observacion;

    @PrePersist
    public void prePersist() {
        this.estado = "activo";
        this.desvincular = "NO";
        this.fecharegistro = Date.from(Instant.now()).toString();
    }

}
