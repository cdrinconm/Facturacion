package com.facturacion.daycam.clientes.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "CLIENTE")
public class ClienteEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    @NotBlank(message = "El nit es obligatorio")
    private String nit;
    @NotBlank(message = "La dirección es obligatoria")
    private String direccion;
    private String telefono;
    @NotBlank(message = "El celular es obligatorio")
    private String celular;
    @NotBlank(message = "El correo es obligatorio")
    private String correo;
    private String estado;
    private String desvincular;
    @Column(name = "valor_credito")
    private Double valorCredito;
    @Column(name = "fecha_credito")
    private String fechaCredito;
    private String remitente;
    private String cedularemitente;
    private String telefonoremitente;

    @PrePersist
    public void prePersist() {
        this.estado = "activo";
        this.desvincular = "NO";
    }
}