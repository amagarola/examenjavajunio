package com.mycompany.viernes;

import java.io.Serializable;

public class Estudiante extends Persona implements Serializable {

    private String curso;

    public Estudiante(String nombre, String apellidos, String dni, String curso) {
        super(nombre, apellidos, dni);
        this.curso = curso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        String contenido = "nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", curso=" + curso;
        return contenido;
    }

}
