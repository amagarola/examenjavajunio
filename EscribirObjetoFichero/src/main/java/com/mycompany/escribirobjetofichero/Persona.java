package com.mycompany.escribirobjetofichero;

import java.io.Serializable;

public class Persona implements Serializable{
    
    private String nombre, lugar;
    private int edad;

    public Persona(String nombre, String lugar, int edad) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.edad = edad;
    }

}
