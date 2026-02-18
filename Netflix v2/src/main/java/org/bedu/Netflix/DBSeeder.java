package org.bedu.Netflix;

import org.bedu.Netflix.entity.Actor;
import org.bedu.Netflix.entity.Movie;
import org.bedu.Netflix.repository.ActorRepository;
import org.bedu.Netflix.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * El objetivo es precargar datos en la base de datos al iniciar el código
*/

@Component
public class DBSeeder implements ApplicationRunner {
    
    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void run(ApplicationArguments args) {

        // Insertamos un actor si no hay actores
        if (actorRepository.count() == 0) {

            Actor actor = new Actor();
            actor.setName("Leonardo DiCaprio");

            actorRepository.save(actor);
        }

        // Insertamos una pelicula si no hay peliculas
        if (movieRepository.count() == 0) {
            Movie movie = new Movie();

            movie.setTitle("Titanic");
            movie.setYear(1996);
            movie.setGenre("Drama");

            movieRepository.save(movie);
        }

        // Relacionar la pelicula con el actor
    }
}