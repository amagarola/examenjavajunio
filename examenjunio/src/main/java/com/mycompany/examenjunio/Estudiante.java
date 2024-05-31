package com.mycompany.examenjunio;

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
    public String toString(){
        String contenido
    }
}