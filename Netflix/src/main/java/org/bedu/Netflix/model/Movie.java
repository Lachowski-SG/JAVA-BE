package org.bedu.Netflix.model;

import java.util.List;

/**
 * POJO: Plain Old Java Object
 * Es una clase con atributos getters y setters. 
 */
public class Movie {

    private int id;
    private String title;
    private String genre;
    private int year;
    private List<Integer> actors;

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Integer> getActors() {
        return actors;
    }
    
    public void setActors(List<Integer> actors) {
        this.actors = actors;
    }

    
    
}
