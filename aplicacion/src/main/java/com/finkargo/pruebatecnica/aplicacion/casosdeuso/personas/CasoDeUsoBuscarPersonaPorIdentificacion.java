package com.finkargo.pruebatecnica.aplicacion.casosdeuso.personas;

import com.finkargo.pruebatecnica.dominio.repositorios.entidades.EntidadPersona;
import com.finkargo.pruebatecnica.dominio.servicios.ServicioPersona;

public class CasoDeUsoBuscarPersonaPorIdentificacion {
    private final ServicioPersona servicio;

    public CasoDeUsoBuscarPersonaPorIdentificacion(ServicioPersona servicio) {
        this.servicio = servicio;
    }

    public EntidadPersona ejecutar(String identificacion) {
        return this.servicio.buscarPorIdentificacion(identificacion);
    }
}
