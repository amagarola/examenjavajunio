/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.proyectobase;

import java.io.Serializable;
import java.util.Arrays;


/**
 *
 * @author 
 */
// Clase que hereda de Persona y añade el atributo curso y las notas
public class Estudiante extends Persona implements Serializable {

    private String curso;
    // matriz 3x3 que almacena 9 notas de exámenes
    float[][] notas = new float[3][3];
    

    // Constructor
    public Estudiante(String nombre, String apellidos, String dni, String curso, float[][] notas) {
        super(nombre, apellidos, dni);
        this.curso = curso;
        this.notas = notas;
    }

    // Método getter para el curso
    public String getCurso() {
        return curso;
    }

    // Método setter para el curso
    public void setCurso(String curso) {
        this.curso = curso;
    }

    public float[][] getNotas() {
        return notas;
    }

    public void setNotas(float[][] notas) {
        this.notas = notas;
    } 
    
    
    @Override
    public String toString() {
        
        String contenido = "Nombre: " + nombre + "\nApellidos: " + apellidos + " "
                + "\nDNI: " + dni + "\nCurso: " + curso ;
        return contenido;
    }
    
    public String toString2() {
        String contenido = "Nombre: " + nombre + "\nApellidos: " + apellidos + " "
                + "\nDNI: " + dni + "\nCurso: " + curso + "\n";
        for(int i=0;i<notas.length; i++)
        {
            contenido += "Evaluación " + (i+1) + ":\n";
            for(int j=0; j<notas[i].length; j++)
            {
                contenido += String.format("%.2f", notas[i][j]) + "\t";
            }
            contenido += "\n";
        }
                    
        return contenido;
    }
}
