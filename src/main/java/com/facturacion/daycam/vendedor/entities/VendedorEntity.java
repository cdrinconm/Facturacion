package com.facturacion.daycam.vendedor.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "VENDEDOR")
public class VendedorEntity {
    @Id
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

    @PrePersist
    public void prePersist() {
        this.estado = "activo";
        this.desvincular = "NO";
    }
}
