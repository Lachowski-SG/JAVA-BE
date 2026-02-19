package org.bedu.Netflix.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
/**
 * Tenemos que analizar de que manera interactuan las entidades:
 * 
 * Uno a uno (One to one)
 * 
 *      Vehiculos - Matriculas (1 - 1)
 * 
 *      La relacion es uno a uno porque un vehiculo tiene una
 *      unica matricula y viceserva.
 * 
 * Uno a muchos / Muchos a uno (One To Many / Many to One)
 *      
 *      Usuarios/Cuenta - Canales (1 - N)
 * 
 *      La relacion es uno a muchos porque el usuario puede
 *      tener varios canales de youtube, pero un canal solo
 *      pertenece a un usuario.
 *      
 *      Usuarios - Tweets
 * 
 *      La relacion es uno a muchos por que el usuario puede
 *      escribir varios tweets pero un tweet solo es
 *      escrito por un unico usuario.
 * 
 * Muchos a muchos (Many to Many)
 * 
 *      Una relacion es muchos a muchos cuando es uno a
 *      muchos y muchos a muchos a uno al mismo tiempo.
 * 
 *      Cliente - Productos (N - M)
 *      
 *      La relacion es muchos a muchos porque:
 *      
 *      1 . Un cliente puede comprar varios productos.
 *      2 . Un producto puede ser comprado por varios clientes.
 * 
 *  ------------------------------------------------------------
 * 
 *      Movie -  Actor
 * 
 *  La relacion es "Muchos a muchos" porque:
 * 
 *      1. En una pelicula actuan varios actores.
 *      2. Un actor puede participar en varias peliculas.
 * 
 */

@Entity
@Table(name="Actors")

public class Actor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "actors")// La relacion principal esta definida en "movie" (OPCIONAL)
    private List<Movie> movies;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    
}
