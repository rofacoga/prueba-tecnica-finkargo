package com.finkargo.pruebatecnica.dominio.repositorios;

import com.finkargo.pruebatecnica.dominio.entidades.Persona;
import com.finkargo.pruebatecnica.dominio.repositorios.entidades.EntidadPersona;

import java.util.List;
import java.util.Optional;

public interface RepositorioPersona {

    Optional<EntidadPersona> buscarPorIdentificacion(String identificacion);

    List<EntidadPersona> buscarPorNombres(String nombres);

    EntidadPersona buscarPorEmail(String email);


    EntidadPersona insertar(Persona persona);
}
