package com.finkargo.pruebatecnica.dominio.servicios;

import com.finkargo.pruebatecnica.dominio.entidades.Persona;
import com.finkargo.pruebatecnica.dominio.repositorios.RepositorioPersona;
import com.finkargo.pruebatecnica.dominio.repositorios.entidades.EntidadPersona;

import java.util.List;

public final class ServicioPersona {
    private final RepositorioPersona repositorio;

    public ServicioPersona(RepositorioPersona repositorio) {
        this.repositorio = repositorio;
    }

    public EntidadPersona buscarPorIdentificacion(String identificacion) {
        ValidadorDatos.validarCampo(identificacion, "identificacion");

        return this.repositorio.buscarPorIdentificacion(identificacion);
    }

    public List<EntidadPersona> buscarPorNombres(String nombres) {
        ValidadorDatos.validarCampo(nombres, "nombres");

        return this.repositorio.buscarPorNombres(nombres);
    }

    public EntidadPersona buscarPorEmail(String email) {
        ValidadorDatos.validarCampo(email, "email");
        ValidadorDatos.validarEmail(email);

        return this.repositorio.buscarPorEmail(email);
    }

    public EntidadPersona insertar(Persona persona) {
        return this.repositorio.insertar(persona);
    }
}
