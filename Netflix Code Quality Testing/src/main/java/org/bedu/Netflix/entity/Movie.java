package org.bedu.Netflix.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


//@Entity --> Indica que esta clase es una tabla de base de datos
//@Table --> Cambia unicamente el nombre de la table en la base de datos.
//@GeneratedValue --> Indica que el valor del ID se genere automaticamente.
@Entity
@Table(name="movies")
public class Movie {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    //Atributos --> Columnas de la tabla
    //nullable = false --. Hace obligatoria una columna.
    @Column(nullable = false)
    private String title;

    // ColumnDefinition --> Permite alterar la definicion de la columna SQL.
    @Column //(columnDefinition = "INT CHECK(year >= 1888")
    private int year;
    //El genero lo dejamos por defecto puede ser nulo (opcional).
    private String genre;

    //Uno a Muchos
    @ManyToOne //Es Obligatorio
    @JoinColumn(name="id_director")
    private Director director;
    
    //Muchos a Muchos
    @ManyToMany //(OBLIGATORIO pero el programador decide donde ponerlo)
    @JoinTable(
        name="movie_actors", //Creamos una table intermedia
        joinColumns = @JoinColumn(name="id_movie"), //El id del Movie se llamara asi en la nueva tabla.
        inverseJoinColumns = @JoinColumn(name="id_actor") // El id del Actor se va llamar asi en la nueva tabla.
    )
    
    private List<Actor> actors;

    public Director getDirector() {
        return director;
    }
    public void setDirector(Director director) {
        this.director = director;
    }
    public List<Actor> getActors() {
        return actors;
    }
    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    

}
