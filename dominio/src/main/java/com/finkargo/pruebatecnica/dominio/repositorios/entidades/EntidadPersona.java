package com.finkargo.pruebatecnica.dominio.repositorios.entidades;

import com.finkargo.pruebatecnica.dominio.entidades.Persona;

import java.time.LocalDateTime;

public class EntidadPersona extends Persona {

    private String id;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
    private LocalDateTime fechaEliminacion;

    public EntidadPersona() {
        super();
        // Constructor por defecto
    }

    public EntidadPersona(String tipoIdentificacion, String numeroIdentificacion, String nombres, String apellidos,
                          String email, String id, LocalDateTime fechaCreacion, LocalDateTime fechaActualizacion,
                          LocalDateTime fechaEliminacion) {
        super(tipoIdentificacion, numeroIdentificacion, nombres, apellidos, email);

        this.setId(id);
        this.setFechaCreacion(fechaCreacion);
        this.setFechaActualizacion(fechaActualizacion);
        this.setFechaEliminacion(fechaEliminacion);
    }

    public EntidadPersona(String tipoIdentificacion, String numeroIdentificacion, String nombres, String apellidos,
                          String email, String id, LocalDateTime fechaCreacion) {
        super(tipoIdentificacion, numeroIdentificacion, nombres, apellidos, email);
        this.setId(id);
        this.setFechaCreacion(fechaCreacion);
    }

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    private void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    private void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public LocalDateTime getFechaEliminacion() {
        return fechaEliminacion;
    }

    public void setFechaEliminacion(LocalDateTime fechaEliminacion) {
        this.fechaEliminacion = fechaEliminacion;
    }
}
