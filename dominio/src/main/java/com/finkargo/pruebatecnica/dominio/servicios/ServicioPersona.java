package com.finkargo.pruebatecnica.dominio.servicios;

import com.finkargo.pruebatecnica.dominio.entidades.Persona;
import com.finkargo.pruebatecnica.dominio.excepciones.ExcepcionDeNegocio;
import com.finkargo.pruebatecnica.dominio.excepciones.ExcepcionObjetoNoEncontrado;
import com.finkargo.pruebatecnica.dominio.repositorios.RepositorioPersona;
import com.finkargo.pruebatecnica.dominio.repositorios.entidades.EntidadPersona;

import java.util.List;

public final class ServicioPersona {
    private static final String CAMPO_IDENTIFICACION = "identificacion";
    private static final String ERROR_SE_HA_ENCONTRADO_UNA_PERSONA_CON = "Se ha encontrado una persona con %s '%s'.";
    private static final String ERROR_NO_SE_HA_ENCONTRADO_NINGUNA_PERSONA_CON = "No se ha encontrado ninguna persona con %s '%s'.";

    private final RepositorioPersona repositorio;

    public ServicioPersona(RepositorioPersona repositorio) {
        this.repositorio = repositorio;
    }

    public EntidadPersona buscarPorIdentificacion(String identificacion) {
        ValidadorDatos.validarCampo(identificacion, CAMPO_IDENTIFICACION);
        ValidadorDatos.validarIdentificacion(identificacion);

        return this.repositorio.buscarPorIdentificacion(identificacion)
                .orElseThrow(() -> new ExcepcionObjetoNoEncontrado(
                        String.format(ERROR_NO_SE_HA_ENCONTRADO_NINGUNA_PERSONA_CON, CAMPO_IDENTIFICACION, identificacion)));
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

    public EntidadPersona agregar(Persona persona) {
        this.repositorio.buscarPorIdentificacion(persona.getIdentificacion()).ifPresent(entidadPersona -> {
            throw new ExcepcionDeNegocio(
                    String.format(ERROR_SE_HA_ENCONTRADO_UNA_PERSONA_CON, CAMPO_IDENTIFICACION, entidadPersona.getIdentificacion()));
        });

        return this.repositorio.insertar(persona);
    }
}
