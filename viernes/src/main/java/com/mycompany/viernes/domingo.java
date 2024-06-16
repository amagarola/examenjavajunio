package com.mycompany.viernes;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class domingo {

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        List<Estudiante> listadoEstudiantes = new LinkedList<>();
        boolean fin = false;
        int opcion;

        double[][] notas = {
            {7.5, 8.1, 6.9},
            {8.3, 7.6, 6.8},
            {8.9, 6.7, 7.2}
        };

        do {
            try {
                opcion = menu();
                switch (opcion) {
                    case 1:
                        System.out.println("Caso 1");
                        System.out.println("Generando datos de estudiantes....");
                        listadoEstudiantes = crearEstudiantes();
                        break;
                    case 2:
                        System.out.println("Caso 2");
                        int result = muestraInformacionEstudiante(listadoEstudiantes);
                        if (result == -1) {
                            System.out.println("El DNI no existe");
                        }
                        break;
                    case 3:
                        System.out.println("Caso 3");
                        System.out.println("Se va a calcular la nota media del curso");
                        double media = calculaNotaMedia(notas);
                        System.out.printf("\n La nota media es %.2f \n", media);
                        break;
                    case 4:
                        System.out.println("Caso 4");
                        System.out.println("Escritura de los estudiantes en fichero de salida");
                         {
                            try {
                                escrituraFichero(listadoEstudiantes);
                            } catch (FileNotFoundException ex) {
                            }
                        }
                        break;
                    case 5:
                        System.out.println("Caso 5");
                        System.out.println("Lectura de los estudiantes almacenados en fichero.");
                        lecturaFichero();
                        break;
                    case 6:
                        System.out.println("Caso 6");
                        fin = true;
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Introduce un numero vazlido, pero vamos que esto no funciona :)");
                teclado.nextLine();
                break;
            }
        } while (fin == false);

    }

    public static int menu() {
        int opcion = 0;

        do {
            System.out.println("Seleccionar una opción:");
            System.out.println("[1] Declara e instancia los estudiantes.");
            System.out.println("[2] Muestra información completa de un estudiante filtrando por DNI.");
            System.out.println("[3] Calcula la nota media del curso de la matriz ya generada.");
            System.out.println("[4] Escribir objetos serializados en fichero.");
            System.out.println("[5] Leer objetos serializados del fichero.");
            System.out.println("[6] Salir.");

            System.out.println("Escriba la selección: ");
            opcion = teclado.nextInt();
            teclado.nextLine(); // limpiamos el salto de línea del buffer
        } while (opcion < 1 || opcion > 6);

        return opcion;
    }

    public static List<Estudiante> crearEstudiantes() {
        List<Estudiante> estudiantes = new LinkedList<>();
        estudiantes.add(new Estudiante("Juan", "Perez", "12345678A", "Matemáticas"));
        estudiantes.add(new Estudiante("María", "Gómez", "23456789B", "Física"));
        estudiantes.add(new Estudiante("Carlos", "López", "34567890C", "Química"));
        estudiantes.add(new Estudiante("Laura", "Martínez", "45678901D", "Historia"));
        estudiantes.add(new Estudiante("Pedro", "Sánchez", "56789012E", "Biología"));
        estudiantes.add(new Estudiante("Adrian", "Magarola", "18061668K", "Daw"));
        return estudiantes;
    }

    public static int muestraInformacionEstudiante(List<Estudiante> listadoEstudiantes) {
        System.out.println("Indica el DNI del estudiante");
        String dni = teclado.nextLine();
        for (Estudiante estudiante : listadoEstudiantes) {
            if (dni.equals(estudiante.getDni())) {

                System.out.println(estudiante.toString());
                return 0;

            }

        }
        return -1;
    }

    public static double calculaNotaMedia(double[][] notas) {
        double sumaPrimeraFila = 0, sumaSegundaFila = 0, sumaTerceraFila = 0;

        for (int i = 0; i < notas.length; i++) {
            for (int j = 0; j < notas.length; j++) {
                switch (i) {
                    case 0 ->
                        sumaPrimeraFila += notas[i][j];
                    case 1 ->
                        sumaSegundaFila += notas[i][j];
                    case 2 ->
                        sumaTerceraFila += notas[i][j];

                }
            }
        }

        double notaMediaFinal = (sumaPrimeraFila / 3) * (1.0 / 3) + (sumaSegundaFila / 3) * (1.0 / 3) + (sumaTerceraFila / 3) * (1.0 / 3);

        return notaMediaFinal;
    }

    public static int escrituraFichero(List<Estudiante> listadoEstudiantes) throws FileNotFoundException {
        try {
            try (FileOutputStream fileOut = new FileOutputStream("personas.dat"); ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
                for (Estudiante estudiante : listadoEstudiantes) {
                    objectOut.writeObject(estudiante);
                }
            }
            System.out.println("Objetos almacenados correctamente");
        } catch (IOException e) {
        }
        return 0;
    }

    public static int lecturaFichero() {

        boolean finalFichero = false;
        try {
            try (FileInputStream fileIn = new FileInputStream("personas.dat"); ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
                System.out.println("Objetos almacenados en fichero");
                while (!finalFichero) {
                    try {
                        Estudiante estudiante = (Estudiante) objectIn.readObject();
                        System.out.println(estudiante.toString());
                    } catch (EOFException e) {
                        finalFichero = true;
                    }
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
