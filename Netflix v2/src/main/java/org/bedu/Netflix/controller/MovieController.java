package org.bedu.Netflix.controller;

import java.util.List;
import java.util.Optional;

import org.bedu.Netflix.dto.CreateMovieDTO;
import org.bedu.Netflix.dto.MovieDTO;
import org.bedu.Netflix.entity.Movie;
import org.bedu.Netflix.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/** 
 * IoC (Inversion of Control): mecanismo de Spring para crear automaticamente
 * las instancias/objetos de sus componentes.
 * 
 * API REST: Son APIs aplicando buenas practicas
 * 1 - No existe un estado, es decir, la peticion contiene toda la informacion
 * necesaria para funcionar.
 * 
 * 2 - Transmitir XML o JSON (ya XML no se usa).
 * 
 * 3 - Al nombrar endpoints no usar verbos, voy a utilizar los sustativos (en plural).
 * 
 * 4 - Utilizar verbos/metodos de HTTP correctamente:
 *      a) GET = Leer informacion.
 *      b) POST = Crear informacion.
 *      c) PUT = Actualizar info de manera parcial.
 *      d) DELETE = Eliminar informacion.
 * 
 * NOTA; PATCH tecnicamente se usa paea actualizar info de manera parcial
 * y PUT originalmente era para reemplazar toda la info.
 * 
 * Lo que hizo fue dejar de usar PATCH y usar PUT como si fuera PATCH.
 * 
 * GET /movies --> Obtener las peliculas.
 * POST /movies --> Crear una nueva pelicula.
 * 
 * NOTA: RequestMapping por defecto es "GET".
 * 
 * 5 - Reflejar la jerarquia de los datos en las urls.
 * 
 *  GET /escuelas --- > Obtener las escuelas.
 *  GET /alumnos --- > Obtener los alumnos.
 *  GET /escuelas/100/alumnos/20/calificaciones --- > De la escuela 100,
 *  del alumno 20, obtener sus calificaciones.
 * 
*/
@RestController
@RequestMapping ("movies")  //Le agrega el prefijo /movies a todos los endpoints.

public class MovieController {

    @Autowired // Inyecta una instancia a un componente.
    private MovieService service;

/**
 * Iniciamos nuestro CRUD
*/

// Crear una pelicula.  (C = Create)
    @PostMapping
    public MovieDTO createMovie (@RequestBody CreateMovieDTO movie){
        return service.createMovie(movie);
    }

// Obtener todas las peliculas. (R = Read)
    @GetMapping //Damos un nombre a nuestro Endpoint
    public List<Movie> getMovies(){
        return service.getMovies();
    }
// Obtener una pelicula por ID. (R = Read)
    @GetMapping ("{id}")
    public Optional <Movie> getMovieById (@PathVariable Long id){
        return service.getMovieById(id);
    }


// Actualizar una pelicula. (U = Update)
    @RequestMapping("{id}")
    public void updateMovie (@PathVariable Long id, @RequestBody Movie movie){
        service.updateMovie (id, movie);
    }

// Eliminar una pelicula. (D = Delete)
    @DeleteMapping ("{id}")
    public void deleteMovie (@PathVariable Long id){
        service.deleteMovie(id);
    }


}
