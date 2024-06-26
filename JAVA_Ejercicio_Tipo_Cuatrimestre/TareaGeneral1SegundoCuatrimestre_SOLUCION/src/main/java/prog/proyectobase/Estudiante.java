package prog.proyectobase;

import java.io.Serializable;

public class Estudiante extends Persona implements Serializable {

    private String curso;

    // Constructor
    public Estudiante(String nombre, String apellidos, String dni, String curso) {
        super(nombre, apellidos, dni);
        this.curso = curso;
    }

    // Método getter para el curso
    public String getCurso() {
        return curso;
    }

    // Método setter para el curso
    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        String contenido = "Nombre: " + nombre + " Apellidos: " + apellidos + " DNI: " + dni + " Curso: " + curso;
        return contenido;
    }
}
