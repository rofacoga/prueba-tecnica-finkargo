package com.finkargo.pruebatecnica.infraestructura.configuraciones;

import com.finkargo.pruebatecnica.aplicacion.casosdeuso.personas.CasoDeUsoAgregarPersona;
import com.finkargo.pruebatecnica.aplicacion.casosdeuso.personas.CasoDeUsoBuscarPersonaPorEmail;
import com.finkargo.pruebatecnica.aplicacion.casosdeuso.personas.CasoDeUsoBuscarPersonaPorIdentificacion;
import com.finkargo.pruebatecnica.aplicacion.casosdeuso.personas.CasoDeUsoBuscarPersonaPorNombres;
import com.finkargo.pruebatecnica.dominio.repositorios.RepositorioPersona;
import com.finkargo.pruebatecnica.dominio.servicios.ServicioPersona;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracionCasosDeUso {

    @Bean
    public ServicioPersona servicioPersona(RepositorioPersona repositorioPersona) {
        return new ServicioPersona(repositorioPersona);
    }

    @Bean
    public CasoDeUsoBuscarPersonaPorIdentificacion casoDeUsoBuscarPersonaPorIdentificacion(ServicioPersona servicioPersona) {
        return new CasoDeUsoBuscarPersonaPorIdentificacion(servicioPersona);
    }

    @Bean
    public CasoDeUsoBuscarPersonaPorEmail casoDeUsoBuscarPersonaPorEmail(ServicioPersona servicioPersona) {
        return new CasoDeUsoBuscarPersonaPorEmail(servicioPersona);
    }

    @Bean
    public CasoDeUsoBuscarPersonaPorNombres casoDeUsoBuscarPersonaPorNombres(ServicioPersona servicioPersona) {
        return new CasoDeUsoBuscarPersonaPorNombres(servicioPersona);
    }

    @Bean
    public CasoDeUsoAgregarPersona casoDeUsoAgregarPersona(ServicioPersona servicioPersona) {
        return new CasoDeUsoAgregarPersona(servicioPersona);
    }
}
