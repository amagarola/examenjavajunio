/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package prog.proyectobase;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author larapresa
 */
public class Principal {

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;
        boolean fin = false;
        List<Estudiante> listadoEstudiantes = null;
        // Matriz de ejemplo donde se almacen notas
        // 1º fila: notas de 3 exámenes del 1º trimestre
        // 2º fila: notas de 3 exámenes del 2º trimestre
        // 3º fila: notas de 3 exámenes del 3º trimestre
        double[][] notas = {
            {7.5, 8.1, 6.9},
            {8.3, 7.6, 6.8},
            {8.9, 6.7, 7.2}
        };

        // Se muestra el menú mientras fin no sea igual a true
        // Se ejecuta el código correspondiente a la opción elegida por el usuario/a
        do {
            try {
                opcion = menu();
                switch (opcion) {
                    case 1:
                        System.out.println("Opción 1.");
                        System.out.println("Generando datos estudiantes.....");
                        listadoEstudiantes = crearEstudiantes();
                        System.out.println("Se han creado 5 estudiantes.");
                        break;
                    case 2:
                        System.out.println("Opción 2.");
                        // A COMPLETAR: Código a ejecutar 
                        int result = muestraInformacionEstudiante(listadoEstudiantes);
                        if (result == -1) {
                            System.out.println("El DNI no existe en nuestra base de datos.");
                        }

                        break;
                    case 3:
                        System.out.println("Opción 3.");
                        System.out.println("Se va a calcular la nota media del curso.");

                        double sumaPrimeraFila = 0;
                        double sumaSegundaFila = 0;
                        double sumaTerceraFila = 0;

                        // Sumar las notas de cada fila
                        for (int i = 0; i < notas.length; i++) {
                            for (int j = 0; j < notas[i].length; j++) {
                                if (i == 0) {
                                    sumaPrimeraFila += notas[i][j];
                                } else if (i == 1) {
                                    sumaSegundaFila += notas[i][j];
                                } else if (i == 2) {
                                    sumaTerceraFila += notas[i][j];
                                }
                            }
                        }

                        // Calcular la nota media final
                        double notaMediaFinal = (sumaPrimeraFila / 3) * (1.0 / 3)
                                + (sumaSegundaFila / 3) * (1.0 / 3)
                                + (sumaTerceraFila / 3) * (1.0 / 3);

                        return notaMediaFinal;_

                        System.out.printf("\n La nota media es %.2f \n", media);
                        break;

                    case 4:
                        System.out.println("Opción 4.");
                        System.out.println("Escritura de los estudiantes en fichero de salida.");
                        try {
                            FileOutputStream fileOut = new FileOutputStream("personas.dat");
                            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
                            for (Estudiante estudiante : listadoEstudiantes) {

                                objectOut.writeObject(estudiante);
                            }
                            objectOut.close();
                            fileOut.close();
                            System.out.println("Objetos alamacenados correctamente.");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        return 0;

                        break;

                    case 5:
                        System.out.println("Opción 5.");
                        System.out.println("Lectura de los estudiantes almacenados en fichero.");

                        boolean finalFichero = false;
                        // Deserializar el objeto Persona desde el archivo
                        try {
                            FileInputStream fileIn = new FileInputStream("personas.dat");
                            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
                            System.out.println("Objetos almacenados en fichero:");
                            // mientras no sea final de fichero leemos objetos
                            while (!finalFichero) {
                                try {
                                    Estudiante estudiante = (Estudiante) objectIn.readObject();
                                    System.out.println(estudiante.toString());

                                } catch (EOFException e) {
                                    finalFichero = true;
                                }
                            }
                            // cerramos las instancias en orden inverso a como las hemos abierto
                            objectIn.close();
                            fileIn.close();

                        } catch (IOException | ClassNotFoundException e) {

                            e.printStackTrace();
                        }

                        return 0;

                        break;

                    case 6:
                        System.out.println("Has seleccionado terminar el programa. Hasta luego.");
                        fin = true;
                        break;
                }
                // Se captura la excepción de que el dato introducido no sea un número 
            } catch (InputMismatchException e) {
                System.out.println("Se debe introducir un número entero.");
                teclado.nextLine();
            }
        } while (fin == false);
    }

    /**
     * Método que muestra un menú por pantalla y devuelve la opción elegida por el usuario/a
     *
     * @return <code>option</code> con la opción del menú escogida
     */
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
        List<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(new Estudiante("Juan", "Pérez", "12345678A", "Matemáticas"));
        estudiantes.add(new Estudiante("María", "Gómez", "23456789B", "Física"));
        estudiantes.add(new Estudiante("Carlos", "López", "34567890C", "Química"));
        estudiantes.add(new Estudiante("Laura", "Martínez", "45678901D", "Historia"));
        estudiantes.add(new Estudiante("Pedro", "Sánchez", "56789012E", "Biología"));
        return estudiantes;
    }

}
