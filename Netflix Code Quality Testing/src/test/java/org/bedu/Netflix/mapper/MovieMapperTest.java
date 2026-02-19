package org.bedu.Netflix.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.bedu.Netflix.dto.CreateMovieDTO;
import org.bedu.Netflix.entity.Movie;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest //Invoca el IoC de Spring
public class MovieMapperTest {

    @Autowired

    private MovieMapper mapper;

    @Test
    @DisplayName ("El mapper se esta inyectando a traves de Spring")
    public void smoke(){
        assertNotNull(mapper);
    }

    @Test
    @DisplayName("Si DTO es nulo, entonces el modelo es nulo")
    public void isNull(){
        Movie model = mapper.toModel(null);

        //Verifica que el valor sea nulo.
        assertNull(model);
    }
    
    @Test
    @DisplayName("Convierte de DTO a Model")
    public void toModel(){
        //Arrange
        CreateMovieDTO dto =new CreateMovieDTO();

        dto.setTitle("Demon Hunters");
        dto.setGenre("Animation");
        dto.setYear(2025);

        //Act
        Movie movie = mapper.toModel(dto);

        //Assert

        assertNotNull(movie); //La pelicula no deberia ser nula.
        
        //Todas las propiedades deben de coincidir.
        assertEquals(dto.getTitle(), movie.getTitle());
        assertEquals(dto.getGenre(), movie.getGenre());
        assertEquals(dto.getYear(), movie.getYear());


    }

}
