package org.bedu.Netflix.mapper;
import org.bedu.Netflix.dto.CreateMovieDTO;
import org.bedu.Netflix.dto.MovieDTO;
import org.bedu.Netflix.entity.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {
    
//Service --> Repository
    public Movie toModel(CreateMovieDTO dto){
        Movie entity = new Movie();

        entity.setTitle((dto.getTitle()));
        entity.setYear(dto.getYear());
        entity.setGenre(dto.getGenre());

        return entity;
    }

//Repository --> Service
    public MovieDTO toDTO(Movie entity){
        MovieDTO dto= new MovieDTO();

        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setGenre(entity.getGenre());
        dto.setYear(entity.getYear());

        return dto;
    }
    
}
