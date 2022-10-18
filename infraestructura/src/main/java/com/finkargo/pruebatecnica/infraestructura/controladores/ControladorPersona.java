package com.finkargo.pruebatecnica.infraestructura.controladores;

import com.finkargo.pruebatecnica.aplicacion.casosdeuso.personas.CasoDeUsoAgregarPersona;
import com.finkargo.pruebatecnica.aplicacion.casosdeuso.personas.CasoDeUsoBuscarPersonaPorEmail;
import com.finkargo.pruebatecnica.aplicacion.casosdeuso.personas.CasoDeUsoBuscarPersonaPorIdentificacion;
import com.finkargo.pruebatecnica.aplicacion.casosdeuso.personas.CasoDeUsoBuscarPersonaPorNombres;
import com.finkargo.pruebatecnica.dominio.entidades.Persona;
import com.finkargo.pruebatecnica.dominio.repositorios.entidades.EntidadPersona;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/personas")
public class ControladorPersona {

    private final CasoDeUsoAgregarPersona agregar;
    private final CasoDeUsoBuscarPersonaPorIdentificacion buscarPorIdentificacion;
    private final CasoDeUsoBuscarPersonaPorEmail buscarPorEmail;
    private final CasoDeUsoBuscarPersonaPorNombres buscarPorNombres;

    public ControladorPersona(CasoDeUsoAgregarPersona agregar,
                              CasoDeUsoBuscarPersonaPorIdentificacion buscarPorIdentificacion,
                              CasoDeUsoBuscarPersonaPorEmail buscarPorEmail,
                              CasoDeUsoBuscarPersonaPorNombres buscarPorNombres) {
        this.agregar = agregar;
        this.buscarPorIdentificacion = buscarPorIdentificacion;
        this.buscarPorEmail = buscarPorEmail;
        this.buscarPorNombres = buscarPorNombres;
    }

    @PostMapping()
    @Transactional
    public @ResponseBody EntidadPersona agregar(@Validated @RequestBody Persona persona) {
        return this.agregar.ejecutar(persona);
    }

    @GetMapping("/identificacion/{identificacion}")
    public @ResponseBody EntidadPersona buscarPorIdentificacion(@Validated @PathVariable(value = "identificacion") String identificacion) {
        return this.buscarPorIdentificacion.ejecutar(identificacion);
    }

    @GetMapping("/email/{email}")
    public @ResponseBody EntidadPersona buscarPorEmail(@Validated @PathVariable(value = "email") String email) {
        return this.buscarPorEmail.ejecutar(email);
    }

    @GetMapping("/nombres/{nombres}")
    public @ResponseBody List<EntidadPersona> buscarPorNombres(@Validated @PathVariable(value = "nombres") String nombres) {
        return this.buscarPorNombres.ejecutar(nombres);
    }
}
