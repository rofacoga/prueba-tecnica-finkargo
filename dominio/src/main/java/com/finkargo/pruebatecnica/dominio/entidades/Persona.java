package com.finkargo.pruebatecnica.dominio.entidades;

import com.finkargo.pruebatecnica.dominio.servicios.ValidadorDatos;

public class Persona {
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private String nombres;
    private String apellidos;
    private String email;

    protected Persona() {
        // Constructor por defecto
    }

    public Persona(String tipoIdentificacion, String numeroIdentificacion, String nombres, String apellidos, String email) {
        this.setTipoIdentificacion(tipoIdentificacion);
        this.setNumeroIdentificacion(numeroIdentificacion);
        this.setNombres(nombres);
        this.setApellidos(apellidos);
        this.setEmail(email);
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    private void setTipoIdentificacion(String tipoIdentificacion) {
        ValidadorDatos.validarCampo(tipoIdentificacion, "tipo identificacion");
        ValidadorDatos.validarSoloLetras(tipoIdentificacion, "tipo identificacion");

        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    private void setNumeroIdentificacion(String numeroIdentificacion) {
        ValidadorDatos.validarCampo(numeroIdentificacion, "numero identificacion");
        ValidadorDatos.validarSoloNumerosYLetras(numeroIdentificacion, "numero identificacion");

        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getIdentificacion() {
        return this.tipoIdentificacion + this.numeroIdentificacion;
    }

    public String getNombres() {
        return nombres;
    }

    private void setNombres(String nombres) {
        ValidadorDatos.validarCampo(nombres, "nombres");
        ValidadorDatos.validarSoloLetrasConEspacios(nombres, "nombres");

        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    private void setApellidos(String apellidos) {
        ValidadorDatos.validarCampo(apellidos, "apellidos");
        ValidadorDatos.validarSoloLetrasConEspacios(apellidos, "apellidos");

        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        ValidadorDatos.validarCampo(email, "email");
        ValidadorDatos.validarEmail(email);

        this.email = email;
    }
}
