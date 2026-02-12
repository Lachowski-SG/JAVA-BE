package org.bedu.Games.model;
/**
 * POJO (Plain old Java Object)
 * es una clase que no utiliza herencia especial, ni implementa
 * interfaces, en resumen no tiene metodos, mas que los get y set.
 * 
 */
public class Game {
    
    private Integer id;
    private String title;
    private Integer year;
    private String genre;



    public Game(Integer id, String title, Integer year, String genre) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
