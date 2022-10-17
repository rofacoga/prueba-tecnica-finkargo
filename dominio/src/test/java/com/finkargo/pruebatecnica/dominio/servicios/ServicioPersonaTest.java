package com.finkargo.pruebatecnica.dominio.servicios;

import com.finkargo.pruebatecnica.dominio.builders.EntidadPersonaBuilder;
import com.finkargo.pruebatecnica.dominio.repositorios.RepositorioPersona;
import com.finkargo.pruebatecnica.dominio.repositorios.entidades.EntidadPersona;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

class ServicioPersonaTest {
  
    @Mock
    private RepositorioPersona repositorio;

    private ServicioPersona servicio;

    @BeforeEach
    void setUp() {
        this.repositorio = Mockito.mock(RepositorioPersona.class);
        this.servicio = new ServicioPersona(this.repositorio);
    }

    @Test
    void buscarPorIdentificacion() {
        // Arrange
        final String tipoIdentificacion = "CC";
        final String numeroIdentificacion = "1094956";
        final String identificacion = tipoIdentificacion + numeroIdentificacion;
        Mockito.when(this.repositorio.buscarPorIdentificacion(identificacion))
                .thenReturn(EntidadPersonaBuilder.getInstance().conIdentificacion(tipoIdentificacion, numeroIdentificacion).build());

        // Act
        EntidadPersona entidad = this.servicio.buscarPorIdentificacion(identificacion);

        // Assert
        Assertions.assertEquals(identificacion, entidad.getIdentificacion());
    }
}