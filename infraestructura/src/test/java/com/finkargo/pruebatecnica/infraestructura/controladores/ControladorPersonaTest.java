package com.finkargo.pruebatecnica.infraestructura.controladores;

import com.finkargo.pruebatecnica.infraestructura.configuraciones.ConfiguracionCasosDeUso;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        ConfiguracionCasosDeUso.class
})
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@WebMvcTest(ControladorPersona.class)
class ControladorPersonaTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
    }

    @Test
    @Ignore
    void buscarPorIdentificacion() {
    }

    @Test
    @Ignore
    void buscarPorEmail() {
    }

    @Test
    @Ignore
    void buscarPorNombres() {
    }
}