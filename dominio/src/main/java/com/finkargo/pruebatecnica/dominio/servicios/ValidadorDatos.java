package com.finkargo.pruebatecnica.dominio.servicios;

import com.finkargo.pruebatecnica.dominio.excepciones.ExcepcionDeNegocio;

import java.util.regex.Pattern;

public final class ValidadorDatos {
    private ValidadorDatos() {
        // Clase utilitaria para validar datos
    }


    public static void validarCampo(String campo, String nombreCampo) {
        if (campo == null || campo.isBlank()) {
            throw new ExcepcionDeNegocio(String.format("El campo %s es obligatorio.", nombreCampo));
        }
    }

    public static void validarSoloLetras(String campo, String nombreCampo) {
        var regexPattern = "^[a-zA-Z]+$";
        validarRegex(regexPattern, campo, nombreCampo);
    }

    public static void validarSoloNumerosYLetras(String campo, String nombreCampo) {
        var regexPattern = "^[a-zA-Z0-9]+$";
        validarRegex(regexPattern, campo, nombreCampo);
    }

    public static void validarSoloLetrasConEspacios(String campo, String nombreCampo) {
        var regexPattern = "^[a-zA-Z]+(?:[ ][a-zA-Z]+)*$";
        validarRegex(regexPattern, campo, nombreCampo);
    }

    public static void validarIdentificacion(String identificacion) {
        var regexPattern = "^[a-zA-Z]{1,10}[a-zA-Z0-9]{1,20}$";
        validarRegex(regexPattern, identificacion, "identificacion");
    }

    public static void validarEmail(String email) {
        var regexPattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        validarRegex(regexPattern, email, "email");
    }

    private static void validarRegex( String regexPattern, String campo, String nombreCampo) {
        var isMatches = Pattern.compile(regexPattern).matcher(campo).matches();

        if (!isMatches) {
            throw new ExcepcionDeNegocio(String.format("El valor '%s' del campo %s no es valido.", campo, nombreCampo));
        }
    }
}
