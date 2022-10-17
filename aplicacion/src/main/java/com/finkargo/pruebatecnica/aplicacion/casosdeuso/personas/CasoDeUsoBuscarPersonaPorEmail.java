package com.finkargo.pruebatecnica.aplicacion.casosdeuso.personas;

import com.finkargo.pruebatecnica.dominio.repositorios.entidades.EntidadPersona;
import com.finkargo.pruebatecnica.dominio.servicios.ServicioPersona;
import org.springframework.stereotype.Service;

@Service
public class CasoDeUsoBuscarPersonaPorEmail {
    private final ServicioPersona servicio;

    public CasoDeUsoBuscarPersonaPorEmail(ServicioPersona servicio) {
        this.servicio = servicio;
    }

    public EntidadPersona ejecutar(String email) {
        return this.servicio.buscarPorEmail(email);
    }
}
