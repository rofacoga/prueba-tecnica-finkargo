package com.finkargo.pruebatecnica.dominio.excepciones;

public sealed class ExcepcionDeNegocio extends RuntimeException
        permits ExcepcionObjetoNoEncontrado {

    public ExcepcionDeNegocio(String message) {
        super(message);
    }
}
