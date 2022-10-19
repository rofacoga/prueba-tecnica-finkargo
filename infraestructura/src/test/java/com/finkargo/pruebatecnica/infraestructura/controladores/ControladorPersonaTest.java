package com.finkargo.pruebatecnica.infraestructura.controladores;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.finkargo.pruebatecnica.dominio.entidades.Persona;
import com.finkargo.pruebatecnica.infraestructura.builders.EntidadPersonaBuilder;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ControladorPersonaTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @BeforeEach
    void setUp() {
    }

    @Test
    @Transactional
    void testAgregarBien() {
        Persona persona = EntidadPersonaBuilder.getInstance().build();

        try {
            MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/personas")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(mapper.writeValueAsString(persona));

            mockMvc.perform(requestBuilder)
                    .andExpect(MockMvcResultMatchers.status().isCreated())
                    .andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.id", CoreMatchers.notNullValue()))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.tipoIdentificacion", CoreMatchers.is(persona.getTipoIdentificacion())))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.identificacion", CoreMatchers.is(persona.getIdentificacion())))
                    .andReturn();

        } catch (JsonProcessingException exc) {
            System.out.println("Fallo al mapear los datos...");
            exc.printStackTrace();
            Assertions.fail();

        } catch (Exception exc) {
            exc.printStackTrace();
            Assertions.fail();
        }
    }

    @Test
    @Sql("/datos-repositorios/personas.sql")
    void testAgregarFallaRegistroDuplicado() {
        Persona persona = EntidadPersonaBuilder.getInstance().conNumeroIdentificacion("123456").build();

        try {
            MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/personas")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(mapper.writeValueAsString(persona));

            mockMvc.perform(requestBuilder)
                    .andExpect(MockMvcResultMatchers.status().isConflict())
                    .andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty())
                    .andExpect(MockMvcResultMatchers.jsonPath("$", CoreMatchers.notNullValue()))
                    .andExpect(MockMvcResultMatchers.jsonPath("$", CoreMatchers.is(
                            String.format("Ya se encuentra registrada una persona con identificacion '%s'.", persona.getIdentificacion())
                    ))).andReturn();

        } catch (JsonProcessingException exc) {
            System.out.println("Fallo al mapear los datos...");
            exc.printStackTrace();
            Assertions.fail();

        } catch (Exception exc) {
            exc.printStackTrace();
            Assertions.fail();
        }
    }

    @Test
    @Disabled
    void buscarPorEmail() {
    }

    @Test
    @Sql("/datos-repositorios/personas.sql")
    void buscarPorNombres() {
        try {
            MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                    .get("/personas/nombres/" + "juan");

            mockMvc.perform(requestBuilder)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty())
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", CoreMatchers.notNullValue(String.class)))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].tipoIdentificacion", CoreMatchers.is("CC")))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].identificacion", CoreMatchers.notNullValue()))
                    .andReturn();

        } catch (Exception exc) {
            exc.printStackTrace();
            Assertions.fail();
        }
    }
}