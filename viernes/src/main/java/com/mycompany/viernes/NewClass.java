package com.mycompany.viernes;

import java.io.EOFException;
import java.io.FileInputStream;
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
        double[][] notas = {
            {7.5, 8.1, 6.9},
            {8.3, 7.6, 6.8},
            {8.9, 6.7, 7.2}
        };

        while (!fin) {
            try {
                switch (menu()) {
                    case 1 -> {
                        System.out.println("Caso 1: Generando datos de estudiantes...");
                        listadoEstudiantes = crearEstudiantes();
                    }
                    case 2 -> {
                        System.out.println("Caso 2: Muestra información de un estudiante por DNI");
                        if (muestraInformacionEstudiante(listadoEstudiantes) == -1) {
                            System.out.println("El DNI no existe");
                        }
                    }
                    case 3 -> {
                        System.out.println("Caso 3: Calculando la nota media del curso");
                        System.out.printf("La nota media es %.2f%n", calculaNotaMedia(notas));
                    }
                    case 4 -> {
                        System.out.println("Caso 4: Escritura de los estudiantes en fichero de salida");
                        escrituraFichero(listadoEstudiantes);
                    }
                    case 5 -> {
                        System.out.println("Caso 5: Lectura de los estudiantes almacenados en fichero");
                        lecturaFichero();
                    }
                    case 6 -> fin = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Introduce un numero valido");
                teclado.nextLine();
            }
        }
    }

    public static int menu() {
        int opcion;
        do {
            System.out.println("Seleccionar una opción:");
            System.out.println("[1] Declara e instancia los estudiantes.");
            System.out.println("[2] Muestra información completa de un estudiante filtrando por DNI.");
            System.out.println("[3] Calcula la nota media del curso de la matriz ya generada.");
            System.out.println("[4] Escribir objetos serializados en fichero.");
            System.out.println("[5] Leer objetos serializados del fichero.");
            System.out.println("[6] Salir.");
            System.out.print("Escriba la selección: ");
            opcion = teclado.nextInt();
            teclado.nextLine(); // limpiar el buffer
        } while (opcion < 1 || opcion > 6);
        return opcion;
    }

    public static List<Estudiante> crearEstudiantes() {
        return List.of(
            new Estudiante("Juan", "Perez", "12345678A", "Matemáticas"),
            new Estudiante("María", "Gómez", "23456789B", "Física"),
            new Estudiante("Carlos", "López", "34567890C", "Química"),
            new Estudiante("Laura", "Martínez", "45678901D", "Historia"),
            new Estudiante("Pedro", "Sánchez", "56789012E", "Biología"),
            new Estudiante("Adrian", "Magarola", "18061668K", "Daw")
        );
    }

    public static int muestraInformacionEstudiante(List<Estudiante> listadoEstudiantes) {
        System.out.print("Indica el DNI del estudiante: ");
        String dni = teclado.nextLine();
        return listadoEstudiantes.stream()
                .filter(estudiante -> dni.equals(estudiante.getDni()))
                .peek(estudiante -> System.out.println(estudiante))
                .findFirst()
                .map(e -> 0)
                .orElse(-1);
    }

    public static double calculaNotaMedia(double[][] notas) {
        double sumaTotal = 0;
        for (double[] fila : notas) {
            for (double nota : fila) {
                sumaTotal += nota;
            }
        }
        return sumaTotal / (notas.length * notas[0].length);
    }

    public static void escrituraFichero(List<Estudiante> listadoEstudiantes) {
        try (FileOutputStream fileOut = new FileOutputStream("personas.dat");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            for (Estudiante estudiante : listadoEstudiantes) {
                objectOut.writeObject(estudiante);
            }
            System.out.println("Objetos almacenados correctamente");
        } catch (IOException e) {
            System.err.println("Error al escribir en el fichero: " + e.getMessage());
        }
    }

    public static void lecturaFichero() {
        try (FileInputStream fileIn = new FileInputStream("personas.dat");
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            System.out.println("Objetos almacenados en fichero:");
            while (true) {
                try {
                    Estudiante estudiante = (Estudiante) objectIn.readObject();
                    System.out.println(estudiante);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al leer del fichero: " + e.getMessage());
        }
    }
}
