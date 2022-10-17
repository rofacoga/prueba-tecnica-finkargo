package com.finkargo.pruebatecnica.aplicacion.casosdeuso.personas;

import com.finkargo.pruebatecnica.dominio.repositorios.entidades.EntidadPersona;
import com.finkargo.pruebatecnica.dominio.servicios.ServicioPersona;

import java.util.List;

public class CasoDeUsoBuscarPersonaPorNombres {
    private final ServicioPersona servicio;

    public CasoDeUsoBuscarPersonaPorNombres(ServicioPersona servicio) {
        this.servicio = servicio;
    }

    public List<EntidadPersona> ejecutar(String nombres) {
        return this.servicio.buscarPorNombres(nombres);
    }
}
