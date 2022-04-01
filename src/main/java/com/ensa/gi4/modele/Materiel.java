package com.ensa.gi4.modele;

public abstract class Materiel {
    private static int count = 0;
    private int id;
    private String name;


public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public void setId() {
      id=count++;
    }
    public void setName(String name) {
        this.name = name;
    }

}
