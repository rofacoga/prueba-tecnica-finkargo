package com.finkargo.pruebatecnica.aplicacion.casosdeuso.personas;

import com.finkargo.pruebatecnica.dominio.entidades.Persona;
import com.finkargo.pruebatecnica.dominio.repositorios.entidades.EntidadPersona;
import com.finkargo.pruebatecnica.dominio.servicios.ServicioPersona;
import org.springframework.stereotype.Service;

@Service
public class CasoDeUsoAgregarPersona {
    private final ServicioPersona servicio;

    public CasoDeUsoAgregarPersona(ServicioPersona servicio) {
        this.servicio = servicio;
    }

    public EntidadPersona ejecutar(Persona persona) {
        return this.servicio.agregar(persona);
    }
}
