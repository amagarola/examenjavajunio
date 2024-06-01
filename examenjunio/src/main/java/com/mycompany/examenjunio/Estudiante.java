package com.mycompany.examenjunio;

import java.io.Serializable;
import java.util.Arrays;

public class Estudiante{
    private String curso;
    float[][] notas = new float[3][3];
    
    public Estudiante(String nombre, String apellidos, String dni, String curso, float[][] notas){
        super(nombre, apellidos, dni);
        this.curso = curso;
        this.notas = notas;
    }
    public String getCurso(){
        return curso;
    }
    public void setCurso(String curso){
        this.curso = curso;
    }
    public float[][] getNotas(){
        return notas;
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