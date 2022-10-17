package com.finkargo.pruebatecnica.dominio.entidades;

import com.finkargo.pruebatecnica.dominio.excepciones.ExcepcionDeNegocio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PersonaTest {

    @Test
    void testConstruirPersonaConTipoIdentificacionNulo() {
        // Arrange
        String tipoIdentificacion = null;
        String numeroIdentificacion = null;
        String nombres = null;
        String apellidos = null;
        String email = null;

        try {
            // Act
            new Persona(tipoIdentificacion, numeroIdentificacion, nombres, apellidos, email);

        } catch (ExcepcionDeNegocio exc) {
            // Assert
            Assertions.assertEquals("El campo tipo identificacion es obligatorio.", exc.getMessage());
        }
    }

    @Test
    void testConstruirPersonaConTipoIdentificacionVacio() {
        // Arrange
        String tipoIdentificacion = " ";
        String numeroIdentificacion = null;
        String nombres = null;
        String apellidos = null;
        String email = null;

        try {
            // Act
            new Persona(tipoIdentificacion, numeroIdentificacion, nombres, apellidos, email);

        } catch (ExcepcionDeNegocio exc) {
            // Assert
            Assertions.assertEquals("El campo tipo identificacion es obligatorio.", exc.getMessage());
        }
    }

    @Test
    void testConstruirPersonaConTipoIdentificacionNoValido() {
        // Arrange
        String tipoIdentificacion = "123";
        String numeroIdentificacion = null;
        String nombres = null;
        String apellidos = null;
        String email = null;

        try {
            // Act
            new Persona(tipoIdentificacion, numeroIdentificacion, nombres, apellidos, email);

        } catch (ExcepcionDeNegocio exc) {
            // Assert
            Assertions.assertEquals(String.format("El valor '%s' del campo tipo identificacion no es valido.", tipoIdentificacion),
                    exc.getMessage());
        }
    }


    @Test
    void testConstruirPersonaConNumeroIdentificacionNulo() {
        // Arrange
        String tipoIdentificacion = "CC";
        String numeroIdentificacion = null;
        String nombres = null;
        String apellidos = null;
        String email = null;

        try {
            // Act
            new Persona(tipoIdentificacion, numeroIdentificacion, nombres, apellidos, email);

        } catch (ExcepcionDeNegocio exc) {
            // Assert
            Assertions.assertEquals("El campo numero identificacion es obligatorio.", exc.getMessage());
        }
    }

    @Test
    void testConstruirPersonaConNumeroIdentificacionVacio() {
        // Arrange
        String tipoIdentificacion = "CC";
        String numeroIdentificacion = "";
        String nombres = null;
        String apellidos = null;
        String email = null;

        try {
            // Act
            new Persona(tipoIdentificacion, numeroIdentificacion, nombres, apellidos, email);

        } catch (ExcepcionDeNegocio exc) {
            // Assert
            Assertions.assertEquals("El campo numero identificacion es obligatorio.", exc.getMessage());
        }
    }

    @Test
    void testConstruirPersonaConNumeroIdentificacionNoValido() {
        // Arrange
        String tipoIdentificacion = "CC";
        String numeroIdentificacion = "a123sd+-/";
        String nombres = null;
        String apellidos = null;
        String email = null;

        try {
            // Act
            new Persona(tipoIdentificacion, numeroIdentificacion, nombres, apellidos, email);

        } catch (ExcepcionDeNegocio exc) {
            // Assert
            Assertions.assertEquals(String.format("El valor '%s' del campo numero identificacion no es valido.", numeroIdentificacion),
                    exc.getMessage());
        }
    }


    @Test
    void testConstruirPersonaConNombresNulo() {
        // Arrange
        String tipoIdentificacion = "CC";
        String numeroIdentificacion = "123987564";
        String nombres = null;
        String apellidos = null;
        String email = null;

        try {
            // Act
            new Persona(tipoIdentificacion, numeroIdentificacion, nombres, apellidos, email);

        } catch (ExcepcionDeNegocio exc) {
            // Assert
            Assertions.assertEquals("El campo nombres es obligatorio.", exc.getMessage());
        }
    }

    @Test
    void testConstruirPersonaConNombresVacio() {
        // Arrange
        String tipoIdentificacion = "TI";
        String numeroIdentificacion = "698532484";
        String nombres = "  ";
        String apellidos = null;
        String email = null;

        try {
            // Act
            new Persona(tipoIdentificacion, numeroIdentificacion, nombres, apellidos, email);

        } catch (ExcepcionDeNegocio exc) {
            // Assert
            Assertions.assertEquals("El campo nombres es obligatorio.", exc.getMessage());
        }
    }

    @Test
    void testConstruirPersonaConNombresNoValidos() {
        // Arrange
        String tipoIdentificacion = "CE";
        String numeroIdentificacion = "a142689";
        String nombres = "Hassan 896548 ";
        String apellidos = null;
        String email = null;

        try {
            // Act
            new Persona(tipoIdentificacion, numeroIdentificacion, nombres, apellidos, email);

        } catch (ExcepcionDeNegocio exc) {
            // Assert
            Assertions.assertEquals(String.format("El valor '%s' del campo nombres no es valido.", nombres),
                    exc.getMessage());
        }
    }


    @Test
    void testConstruirPersonaConApellidosNulo() {
        // Arrange
        String tipoIdentificacion = "CC";
        String numeroIdentificacion = "123987564";
        String nombres = "Mario";
        String apellidos = null;
        String email = null;

        try {
            // Act
            new Persona(tipoIdentificacion, numeroIdentificacion, nombres, apellidos, email);

        } catch (ExcepcionDeNegocio exc) {
            // Assert
            Assertions.assertEquals("El campo apellidos es obligatorio.", exc.getMessage());
        }
    }

    @Test
    void testConstruirPersonaConApellidosVacio() {
        // Arrange
        String tipoIdentificacion = "TI";
        String numeroIdentificacion = "698532484";
        String nombres = "Jorge";
        String apellidos = "";
        String email = null;

        try {
            // Act
            new Persona(tipoIdentificacion, numeroIdentificacion, nombres, apellidos, email);

        } catch (ExcepcionDeNegocio exc) {
            // Assert
            Assertions.assertEquals("El campo apellidos es obligatorio.", exc.getMessage());
        }
    }

    @Test
    void testConstruirPersonaConApellidosNoValidos() {
        // Arrange
        String tipoIdentificacion = "CE";
        String numeroIdentificacion = "a142689";
        String nombres = "Hassan de Jesus";
        String apellidos = "Vargas12 Cobre";
        String email = null;

        try {
            // Act
            new Persona(tipoIdentificacion, numeroIdentificacion, nombres, apellidos, email);

        } catch (ExcepcionDeNegocio exc) {
            // Assert
            Assertions.assertEquals(String.format("El valor '%s' del campo apellidos no es valido.", apellidos),
                    exc.getMessage());
        }
    }


    @Test
    void testConstruirPersonaConEmailNulo() {
        // Arrange
        String tipoIdentificacion = "CC";
        String numeroIdentificacion = "123987564";
        String nombres = "Mario";
        String apellidos = "Duque Duarte";
        String email = null;

        try {
            // Act
            new Persona(tipoIdentificacion, numeroIdentificacion, nombres, apellidos, email);

        } catch (ExcepcionDeNegocio exc) {
            // Assert
            Assertions.assertEquals("El campo email es obligatorio.", exc.getMessage());
        }
    }

    @Test
    void testConstruirPersonaConEmailVacio() {
        // Arrange
        String tipoIdentificacion = "TI";
        String numeroIdentificacion = "698532484";
        String nombres = "Jorge";
        String apellidos = "Cortazar";
        String email = "";

        try {
            // Act
            new Persona(tipoIdentificacion, numeroIdentificacion, nombres, apellidos, email);

        } catch (ExcepcionDeNegocio exc) {
            // Assert
            Assertions.assertEquals("El campo email es obligatorio.", exc.getMessage());
        }
    }

    @Test
    void testConstruirPersonaConEmailNoValidos() {
        // Arrange
        String tipoIdentificacion = "CE";
        String numeroIdentificacion = "a142689";
        String nombres = "Hassan de Jesus";
        String apellidos = "Vargas Cobre";
        String email = "correo@null";

        try {
            // Act
            new Persona(tipoIdentificacion, numeroIdentificacion, nombres, apellidos, email);

        } catch (ExcepcionDeNegocio exc) {
            // Assert
            Assertions.assertEquals(String.format("El valor '%s' del campo email no es valido.", email),
                    exc.getMessage());
        }
    }
}