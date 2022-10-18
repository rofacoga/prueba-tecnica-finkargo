package com.finkargo.pruebatecnica.infraestructura.controladores;

import com.finkargo.pruebatecnica.dominio.excepciones.ExcepcionDeNegocio;
import com.finkargo.pruebatecnica.dominio.excepciones.ExcepcionObjetoNoEncontrado;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ManejadorExcepciones {
    private static final Logger LOGGER = LogManager.getLogger(ManejadorExcepciones.class);
    private static final String MENSAJE_POR_DEFECTO = "Tenemos problemas con la acción que intentas realizar. Vuelve a intentarlo en unos minutos.";
    private static final String MENSAJE_PROBLEMAS_CON_LA_ACCION_A_REALIZAR = "Tenemos problemas con la acción que intentas realizar.";
    private static final String MENSAJE_ENTIDAD_NO_SERIALIZABLE = "Tenemos problemas con la entidad que intentas serilizar.";


    @ExceptionHandler(HttpMessageConversionException.class)
    public ResponseEntity<String> manejoHttpMessageConversionException(HttpMessageConversionException ex) {
        LOGGER.error(ex);
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(MENSAJE_ENTIDAD_NO_SERIALIZABLE);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<String> manejoHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
        LOGGER.error(ex);
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(MENSAJE_PROBLEMAS_CON_LA_ACCION_A_REALIZAR);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return errors;
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<String> manejoDataAccessException(DataAccessException ex) {
        LOGGER.error(ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(MENSAJE_PROBLEMAS_CON_LA_ACCION_A_REALIZAR);
    }


    @ExceptionHandler(ExcepcionObjetoNoEncontrado.class)
    public ResponseEntity<String> manejoExcepcionObjetoNoEncontrado(ExcepcionObjetoNoEncontrado ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(ExcepcionDeNegocio.class)
    public ResponseEntity<String> manejoExcepcionDeNegocio(ExcepcionDeNegocio ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> manejoExceptionGenerico(Exception ex) {
        LOGGER.error(ex);
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(MENSAJE_POR_DEFECTO);
    }
}
