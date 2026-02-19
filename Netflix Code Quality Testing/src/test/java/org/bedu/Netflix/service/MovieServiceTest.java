package org.bedu.Netflix.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.bedu.Netflix.dto.MovieDTO;
import org.bedu.Netflix.repository.MovieRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

/**
 * SpringBootTest es una combinacion del IoC (Inmersion de Control). 
 * Es un elemento de spring que se encarga de administrar los objetos que se van 
 * creando dentro de Spring. (Administracion de instancias).
 * y Mockito (Nos ayuda a simular/falsificar metodos u objetos).
 * 
 */
@SpringBootTest
public class MovieServiceTest {

    //sustituye en el IoC el objeto y pone nuestra implementacion.
    //En esre caso NO se van a realizar consultas a BD.

    @MockitoBean
    private MovieRepository repository;

    @Autowired
    private MovieService service;

    @Test
    @DisplayName("Si el repositorio esta vacio, el servicio regresa vacio")
    public void empty(){
        //Arrange
        //La precondicion es que el repositorio este vacio al invocar "findAll"
        //Cuando se invoque "findAll()" regresa []
        when(repository.findAll()).thenReturn(new LinkedList<>());

        //Act
        List<MovieDTO>movies=service.getMovies();
        //Assert
        assertEquals(0, movies.size());
    }

    
}
