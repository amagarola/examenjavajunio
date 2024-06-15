package com.mycompany.viernes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Viernes {

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        boolean fin = false;

        //Se muestra el menu mientras fin no sea igual a true
        // Se ejcuta el codigo correspondiente a la opcion elegida por el usuario
        do {
            try {
                opcion = menu();
                switch (opcion) {   
                    case 1:
                        System.out.println("Opcion 1.");
                        break;
                    case 2:
                        System.out.println("Opcion 2.");
                        break;
                    case 3:
                        System.out.println("Opcion 3.");
                        break;
                    case 4:
                        System.out.println("Opcion 4.");
                        break;
                    case 5:
                        System.out.println("Opcion 5.");
                        fin = true;
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Se debe introducir un numero entero");
                teclado.nextLine();
            }
        } while (fin == false);
    }

    public static int menu() {
        int opcion = 0;
        do {
            System.out.println("Seleccionar una opcion");
            System.out.println("[1]Calcula el numero de asignaturas aprobadas por un estudiante filtrando por DNI");
            System.out.println("[2]Escribir los objetos serializados en fichero");
            System.out.println("[3]Leer objetos serializados del fichero");
            System.out.println("[4]Mostrar informacion de todos los estudiantes");
            System.out.println("[5]Salir");

            System.out.println("Escriba la seleccion");
            opcion = teclado.nextInt();
            teclado.nextLine();
        } while (opcion < 1 || opcion > 5);
        return opcion;
    }

}
