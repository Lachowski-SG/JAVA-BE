package org.bedu.Netflix.repository;
import java.util.Optional;

import org.bedu.Netflix.dto.MovieDTO;
import org.bedu.Netflix.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**Un Repositorio es un objeto que permite acceder o manipular datos
 * de una base de datos a traves de metodos
 * 
 * JpaRepository provee de las operaciones basicas del CRUD.
 * 
 * - Obtener todo (findAll)
 * - Obtener por ID (findById)
 * - Guardar/Actualizar (save)
 * - Eliminar (deleteByID)
 * 
 * Recibe 2 Parametros:
 * 
 * - El tipo de la entidad.
 * - El tipo de la llave o 
 * 
 * Los tipos de datos con letras minisculas son tipos de datos
 * PRIMITIVOS (nacieron con el lenguaje)
 * Ejemplo: int, boolean, long...
 * 
 * Existe su version de objetos (Wrapper Classes)
 * Ejemplo: Integer, Boolean, Long...
 * 
*/

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{

    Optional<MovieDTO> findByIdWithDetails(long id);
}    
