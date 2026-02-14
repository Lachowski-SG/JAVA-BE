package org.bedu.Netflix.service;

import java.util.LinkedList;
import java.util.List;

import org.bedu.Netflix.model.Movie;
import org.springframework.stereotype.Service;

/**
 * Nota: Las capas Spring las conoce como "Componentes".
 * Existen varios Componentes.
 * Ejemplo: Controller, Service
 * 
 * La capa de servicio se encarga de aplicar algoritmos, 
 * validaciones y logica del negocio (reglas).
 * 
 * El sevicio no tiene acceso a nada de HTTP, se asume que cada metodo
 * recibe informacion que necesita de la capa de arriba (Controller).
 */

@Service
public class MovieService {
    

    private int currentId =1;

    private List<Movie> movies = new LinkedList<>();

    public MovieService(){
        List<Integer> actors1= new LinkedList<>();
        actors1.add(1); //Leonardo DiCaprio
        actors1.add(2); //Kate Winslet
        
        Movie m1=new Movie();
        m1.setId(currentId++);
        m1.setTitle("Titanic");
        m1.setYear(1997);
        m1.setActors(actors1);

        movies.add(m1);
    }

    public List<Movie> getMovies(){
        return movies;
    }


    public Movie getMovieById(int id) {
        for (Movie movie : movies) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

    public Movie createMovie(Movie movie) {
        movie.setId(currentId++);
        movies.add(movie);
        return movie;
    }
}