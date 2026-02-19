package org.bedu.Netflix.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * La relacion ( Movie - Director
 * Es uno de muchos porque un director
 * dirige varias peliculas pero una pelicula es dirigida por
 * un unico director.
 */

@Entity
@Table(name="Directors")

public class Director {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String name;
    // Relacion Inversa (Opcional)
    @OneToMany
    @JoinColumn (name="id_director")
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
