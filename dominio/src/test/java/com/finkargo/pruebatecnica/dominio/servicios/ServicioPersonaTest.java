package com.finkargo.pruebatecnica.dominio.servicios;

import com.finkargo.pruebatecnica.dominio.builders.EntidadPersonaBuilder;
import com.finkargo.pruebatecnica.dominio.excepciones.ExcepcionDeNegocio;
import com.finkargo.pruebatecnica.dominio.excepciones.ExcepcionObjetoExistente;
import com.finkargo.pruebatecnica.dominio.repositorios.RepositorioPersona;
import com.finkargo.pruebatecnica.dominio.repositorios.entidades.EntidadPersona;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

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
    void testBuscarPorIdentificacionBien() {
        // Arrange
        final String tipoIdentificacion = "CC";
        final String numeroIdentificacion = "1094956";
        final String identificacion = tipoIdentificacion + numeroIdentificacion;
        final EntidadPersona build = EntidadPersonaBuilder.getInstance().conIdentificacion(tipoIdentificacion, numeroIdentificacion).build();
        Mockito.when(this.repositorio.buscarPorIdentificacion(identificacion))
                .thenReturn(Optional.of(build));

        // Act
        EntidadPersona entidad = this.servicio.buscarPorIdentificacion(identificacion);

        // Assert
        Assertions.assertNotNull(entidad);
        Assertions.assertEquals(identificacion, entidad.getIdentificacion());
    }

    @Test
    void testBuscarPorIdentificacionDatosNulos() {
        // Arrange
        final String identificacion = null;

        try {
            // Act
            this.servicio.buscarPorIdentificacion(identificacion);

        } catch (ExcepcionDeNegocio exc) {
            // Assert
            Assertions.assertEquals("El campo identificacion es obligatorio.", exc.getMessage());
        }
    }

    @Test
    void testBuscarPorIdentificacionDatosVacios() {
        // Arrange
        final String identificacion = " ";

        try {
            // Act
            this.servicio.buscarPorIdentificacion(identificacion);

        } catch (ExcepcionDeNegocio exc) {
            // Assert
            Assertions.assertEquals("El campo identificacion es obligatorio.", exc.getMessage());
        }
    }

    @Test
    void testBuscarPorIdentificacionDatosNoValidos() {
        // Arrange
        final String identificacion = "12C125181";

        try {
            // Act
            this.servicio.buscarPorIdentificacion(identificacion);

        } catch (ExcepcionDeNegocio exc) {
            // Assert
            Assertions.assertEquals(String.format("El valor '%s' del campo identificacion no es valido.", identificacion),
                    exc.getMessage());
        }
    }


    @Test
    void testBuscarPorNombresBien() {
        // Arrange
        final String nombres = "Juan";
        Mockito.when(this.repositorio.buscarPorNombres(nombres))
                .thenReturn(List.of(EntidadPersonaBuilder.getInstance().conNombres(nombres).build()));

        // Act
        List<EntidadPersona> entidades = this.servicio.buscarPorNombres(nombres);

        // Assert
        Assertions.assertNotNull(entidades);
        Assertions.assertEquals(1, entidades.size());
        Assertions.assertEquals(nombres, entidades.get(0).getNombres());
    }

    @Test
    void testBuscarPorNombresDatosNulos() {
        // Arrange
        final String nombres = null;

        try {
            // Act
            this.servicio.buscarPorNombres(nombres);

        } catch (ExcepcionDeNegocio exc) {
            // Assert
            Assertions.assertEquals("El campo nombres es obligatorio.", exc.getMessage());
        }
    }

    @Test
    void testBuscarPorNombresDatosVacios() {
        // Arrange
        final String nombres = "";

        try {
            // Act
            this.servicio.buscarPorNombres(nombres);

        } catch (ExcepcionDeNegocio exc) {
            // Assert
            Assertions.assertEquals("El campo nombres es obligatorio.", exc.getMessage());
        }
    }

    @Test
    void testBuscarPorNombresDatosNoValidos() {
        // Arrange
        final String nombres = "Juli12C125181";

        try {
            // Act
            this.servicio.buscarPorNombres(nombres);

        } catch (ExcepcionDeNegocio exc) {
            // Assert
            Assertions.assertEquals(String.format("El valor '%s' del campo nombres no es valido.", nombres),
                    exc.getMessage());
        }
    }


    @Test
    void testBuscarPorEmailBien() {
        // Arrange
        final String email = "email@finkargo.co";
        Mockito.when(this.repositorio.buscarPorEmail(email))
                .thenReturn(EntidadPersonaBuilder.getInstance().build());

        // Act
        EntidadPersona entidad = this.servicio.buscarPorEmail(email);

        // Assert
        Assertions.assertNotNull(entidad);
        Assertions.assertEquals(email, entidad.getEmail());
    }

    @Test
    void testBuscarPorEmailDatosNulos() {
        // Arrange
        final String email = null;

        try {
            // Act
            this.servicio.buscarPorEmail(email);

        } catch (ExcepcionDeNegocio exc) {
            // Assert
            Assertions.assertEquals("El campo email es obligatorio.", exc.getMessage());
        }
    }

    @Test
    void testBuscarPorEmailDatosVacios() {
        // Arrange
        final String email = " ";

        try {
            // Act
            this.servicio.buscarPorEmail(email);

        } catch (ExcepcionDeNegocio exc) {
            // Assert
            Assertions.assertEquals("El campo email es obligatorio.", exc.getMessage());
        }
    }

    @Test
    void testBuscarPorEmailDatosNoValidos() {
        // Arrange
        final String email = "juan.olaya@finktech";

        try {
            // Act
            this.servicio.buscarPorEmail(email);

        } catch (ExcepcionDeNegocio exc) {
            // Assert
            Assertions.assertEquals(String.format("El valor '%s' del campo email no es valido.", email), exc.getMessage());
        }
    }


    @Test
    void testAgregarBien() {
        // Arrange
        final EntidadPersona entidad = EntidadPersonaBuilder.getInstance().build();
        Mockito.when(this.repositorio.insertar(entidad)).thenReturn(entidad);

        // Act
        EntidadPersona entidadResultado = this.servicio.agregar(entidad);

        // Assert
        Assertions.assertNotNull(entidadResultado);
        Assertions.assertEquals(entidad.getIdentificacion(), entidadResultado.getIdentificacion());
        Assertions.assertEquals(entidad.getEmail(), entidadResultado.getEmail());
    }

    @Test
    void testAgregarExistente() {
        // Arrange
        final EntidadPersona entidad = EntidadPersonaBuilder.getInstance().build();
        Mockito.when(this.repositorio.buscarPorIdentificacion(entidad.getIdentificacion()))
                .thenReturn(Optional.of(entidad));

        try {
            // Act
            this.servicio.agregar(entidad);

        } catch (ExcepcionObjetoExistente exc) {
            // Assert
            Assertions.assertEquals(
                    String.format("Ya se encuentra registrada una persona con identificacion '%s'.", entidad.getIdentificacion()),
                    exc.getMessage());
        }
    }
}