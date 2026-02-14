package org.bedu.Netflix.model;

public class Actor {

    private int id;
    private String name;
    private boolean hasWonOscar;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHasWonOscar() {
        return hasWonOscar;
    }
    
    public void setHasWonOscar(boolean hasWonOscar) {
        this.hasWonOscar = hasWonOscar;
    }


    
}
