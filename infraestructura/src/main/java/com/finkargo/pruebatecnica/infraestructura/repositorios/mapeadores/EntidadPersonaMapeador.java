package com.finkargo.pruebatecnica.infraestructura.repositorios.mapeadores;

import com.finkargo.pruebatecnica.dominio.entidades.Persona;
import com.finkargo.pruebatecnica.dominio.repositorios.entidades.EntidadPersona;
import com.finkargo.pruebatecnica.infraestructura.repositorios.entidades.EntidadPersonaJPA;

public class EntidadPersonaMapeador {

    private EntidadPersonaMapeador() {
        // clase utilitaria
    }

    public static EntidadPersona mapear(EntidadPersonaJPA entidadJpa) {
        return new EntidadPersona(entidadJpa.getTipoIdentificacion(), entidadJpa.getNumeroIdentificacion(),
                entidadJpa.getNombres(), entidadJpa.getApellidos(), entidadJpa.getEmail(),
                entidadJpa.getId().toString(), entidadJpa.getFechaCreacion());
    }

    public static EntidadPersonaJPA mapear(Persona persona) {
        return new EntidadPersonaJPA(persona.getTipoIdentificacion(), persona.getNumeroIdentificacion(),
                persona.getNombres(), persona.getApellidos(), persona.getEmail());
    }
}
