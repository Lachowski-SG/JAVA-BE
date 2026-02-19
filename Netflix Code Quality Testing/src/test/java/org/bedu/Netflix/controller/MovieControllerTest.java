package org.bedu.Netflix.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.LinkedList;

import org.bedu.Netflix.service.MovieService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

//WebMvcTest me ayuda a realizar "peticiones" en un contexto de HTTP para pruebas unitarias.

@WebMvcTest(MovieController.class)
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;// simular las peticiones HTTP

    @MockitoBean
    private MovieService service;

    @Test
    @DisplayName("Si el servicio regresa vacio entonces el controlador regresa vacio.")
    public void empty()throws Exception{

        //Arrange
        when(service.getMovies()).thenReturn(new LinkedList<>());


        //Perform simula una peticion de HTTP
        

        //Act
        //Como en Postman o Bruno, tengo que describir mi peticion de HTTP
        mockMvc.perform(get("/movies"))


        //Assert
        //Empiezo a realizar los asserts pero a nivel del HTTP
        // 1. El status sea OK (200)
        .andExpect(status().isOk())
        // 2. El contenido en forma de texto sea "[]"
        //Si fuera un objeto, seria alfo como [{"title": "Harry Potter"}]
        .andExpect(content().string("[]"));


    }
    
}
