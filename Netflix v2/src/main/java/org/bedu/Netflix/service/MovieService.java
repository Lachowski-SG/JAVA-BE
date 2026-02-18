package org.bedu.Netflix.service;
import java.util.List;
import java.util.Optional;

import org.bedu.Netflix.dto.CreateMovieDTO;
import org.bedu.Netflix.dto.MovieDTO;
import org.bedu.Netflix.entity.Movie;
import org.bedu.Netflix.mapper.MovieMapper;
import org.bedu.Netflix.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;
    @Autowired
    private MovieMapper mapper;

    public List<Movie> getMovies(){
        return repository.findAll();
    }

    public Optional<Movie> getMovieById(Long id){
        return repository.findById(id);
    }

    public MovieDTO createMovie(CreateMovieDTO movie) {
        Movie entity = mapper.toModel(movie);
        return mapper.toDTO(repository.save(entity));
    }

    public void deleteMovie (long id){
        repository.deleteById(id);
    }

    public void updateMovie (long id, Movie movie){
        // 1. Busco en BD el objeto a actualizar
        Optional<Movie> dbMovie = repository.findById(id);

        // 2. Verificamos que el objeto no sea nulo
        //isEmpty() --> true su esta vacio o nulo,
        //isPresent() --> true si tiene un objeto.movieController
        if (dbMovie.isPresent()){

            // 3. Sacar el objeto de su caja

            Movie updateMovie = dbMovie.get();

            if (movie.getTitle() != null){
                //Sustituyendo el valor viejo por el nuevo.
                updateMovie.setTitle(movie.getTitle());
            }

            repository.save(updateMovie);
        }
    }
}