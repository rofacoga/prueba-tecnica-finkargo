package com.finkargo.pruebatecnica.infraestructura.builders;

import com.finkargo.pruebatecnica.dominio.repositorios.entidades.EntidadPersona;

import java.time.LocalDateTime;

public class EntidadPersonaBuilder {

    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private String nombres;
    private String apellidos;
    private String email;
    private String id;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
    private LocalDateTime fechaEliminacion;

    private EntidadPersonaBuilder() {
        this.tipoIdentificacion = "CC";
        this.numeroIdentificacion = "123654";
        this.nombres = "Julio";
        this.apellidos = "Andrade";
        this.email = "email@finkargo.co";
        this.id = "uuid-1234-4569875-asdasd";
        this.fechaCreacion = LocalDateTime.now();
        this.fechaActualizacion = null;
        this.fechaEliminacion = null;
    }

    public static EntidadPersonaBuilder getInstance() {
        return new EntidadPersonaBuilder();
    }

    public EntidadPersona build() {
        return new EntidadPersona(tipoIdentificacion, numeroIdentificacion, nombres, apellidos, email, id, fechaCreacion);
    }

    public EntidadPersonaBuilder conNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
        return this;
    }
}
