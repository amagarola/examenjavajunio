package com.mycompany.viernes;

import java.io.Serializable;

class Persona implements Serializable {

    protected String nombre, apellidos, dni;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Persona(String nombre, String apellidos, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
    }

    @Override
    public String toString() {
        String contenido = "nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni;
        return contenido;
    }

}
