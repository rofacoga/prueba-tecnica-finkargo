package com.finkargo.pruebatecnica.infraestructura.repositorios;

import com.finkargo.pruebatecnica.dominio.entidades.Persona;
import com.finkargo.pruebatecnica.dominio.excepciones.ExcepcionObjetoNoEncontrado;
import com.finkargo.pruebatecnica.dominio.repositorios.RepositorioPersona;
import com.finkargo.pruebatecnica.dominio.repositorios.entidades.EntidadPersona;
import com.finkargo.pruebatecnica.infraestructura.repositorios.entidades.EntidadPersonaJPA;
import com.finkargo.pruebatecnica.infraestructura.repositorios.mapeadores.EntidadPersonaMapeador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public interface RepositorioPersonaJPA extends RepositorioPersona, JpaRepository<EntidadPersonaJPA, String> {

    String ERROR_NO_SE_HA_ENCONTRADO_NINGUNA_PERSONA_CON = "No se ha encontrado ninguna persona con %s '%s'";
    String ERROR_NO_SE_HA_LOGRADO_AGREGAR_PERSONA_CON = "No se ha logrado insertar persona con identificacion '%s%s'";
    LocalDateTime fechaNula = null;

    @Query(nativeQuery = true,
            value = "SELECT *  FROM personas " +
                    "WHERE 1 = 1 AND (tipo_identificacion || numero_identificacion) = :identificacion " +
                    "AND fecha_eliminacion IS NULL")
    Optional<EntidadPersonaJPA> findByTipoIdentificacionConcatNumeroIdentificacion(String identificacion);

    List<EntidadPersonaJPA> findByNombresContainingIgnoreCaseAndFechaEliminacion(String nombres, LocalDateTime fechaEliminacion);

    Optional<EntidadPersonaJPA> findByEmailIgnoreCaseAndFechaEliminacion(String email, LocalDateTime fechaEliminacion);


    default Optional<EntidadPersona> buscarPorIdentificacion(String identificacion) {
        return findByTipoIdentificacionConcatNumeroIdentificacion(identificacion)
                .map(EntidadPersonaMapeador::mapear);
    }

    default List<EntidadPersona> buscarPorNombres(String nombres) {
        return findByNombresContainingIgnoreCaseAndFechaEliminacion(nombres, fechaNula).stream()
                .map(EntidadPersonaMapeador::mapear)
                .collect(Collectors.toList());
    }

    default EntidadPersona buscarPorEmail(String email) {
        return findByEmailIgnoreCaseAndFechaEliminacion(email, fechaNula)
                .map(EntidadPersonaMapeador::mapear)
                .orElseThrow(() -> new ExcepcionObjetoNoEncontrado(
                        String.format(ERROR_NO_SE_HA_ENCONTRADO_NINGUNA_PERSONA_CON, "email", email)));
    }


    default EntidadPersona insertar(Persona persona) {
        return Optional.of(save(EntidadPersonaMapeador.mapear(persona)))
                .map(EntidadPersonaMapeador::mapear)
                .orElseThrow(() -> new ExcepcionObjetoNoEncontrado(
                        String.format(ERROR_NO_SE_HA_LOGRADO_AGREGAR_PERSONA_CON,
                                persona.getTipoIdentificacion(), persona.getNumeroIdentificacion())));
    }
}
