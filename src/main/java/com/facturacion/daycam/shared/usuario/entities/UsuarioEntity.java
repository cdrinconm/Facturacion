package com.facturacion.daycam.shared.usuario.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "USUARIO")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombres;
    private String apellidos;
    private String tipoDocumento;
    private String numeroDocumento;
    private String usuarioNombre;
    private String pass;
    private String estado;
    private String rol;
    private String desvincular;
    private String token;

    @PrePersist
    public void prePersist() {
        this.estado = "activo";
        this.desvincular = "NO";
    }
}
