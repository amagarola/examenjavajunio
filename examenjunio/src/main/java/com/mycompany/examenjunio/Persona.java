package com.mycompany.examenjunio;

public class Persona{
        protected String nombre;
        protected String apellidos;
        protected String dni;

        
        public Persona(String nombre, String apellidos, String dni) {
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.dni = dni;
        }


        protected String getNombre(){
            return nombre;
        }
        
        protected String getApellidos(){
            return apellidos;
        }
        protected String getDni(){
            return this.dni;
        }
        protected void setNombre(String nombre){
            this.nombre = nombre;
        }
        protected void setApellidos(String apellidos){
            this.apellidos = apellidos;
        }
        protected void setDni(String dni){
            this.dni = dni;
        }
        @Override
        public String toString(){
            String contenido = "Nombre: " + nombre + " Apellidos: " + apellidos + " Dni: " + dni;
            
            System.out.println("");
            return contenido;
        }
}