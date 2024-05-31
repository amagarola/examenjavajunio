/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package prog.proyectobase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
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

        // case 1
        String dni;

        // case 1,2,3, donde recibiré si ha ido bien el método
        int caso;

        //
        // A continuación se instancian 10 estudiantes con sus datos a través del metodo crearEstudiantes()
        //
        ArrayList<Estudiante> listadoEstudiantes = (ArrayList<Estudiante>) crearEstudiantes();

        // Se muestra el menú mientras fin no sea igual a true
        // Se ejecuta el código correspondiente a la opción elegida por el usuario/a
        do {
            try {
                opcion = menu();
                switch (opcion) {
                    case 1:
                        System.out.println("Opción 1.");
                        System.out.println("Introduzca el DNI del estudiante:");
                        dni = teclado.nextLine();
                        caso = calculaAsignaturasAprobadas(listadoEstudiantes, dni);
                        if (caso > 0) {
                            float media = caso * 100 / 9;
                            System.out.printf("El numero de materias aprobadas es %d, un %.2f por ciento del total \n", caso, media);
                        } else if (caso == 0) {
                            System.out.println("No ha aprobado ninguna");
                        } else {
                            System.out.println("El estudiante no existe");
                        }
                        break;
                        
                    case 2:
                        System.out.println("Opción 2.");
                        System.out.println("Escritura de los estudiantes en fichero de salida.");
                        caso = escrituraFichero(listadoEstudiantes);
                        if (caso == 0) {
                            System.out.println("Inserción realizada");
                        } else {
                            System.out.println("ocurrió un error");
                        }
                        break;

                    case 3:
                        System.out.println("Opción 3.");
                        System.out.println("Lectura de los estudiantes almacenados en fichero.");
                        caso = lecturaFichero();
                        if (caso == 0) {
                            System.out.println("Lectura  realizada con éxito");
                        } else {
                            System.out.println("ocurrió un error");
                        }
                        break;
                        
                    case 4:
                        System.out.println("Opción 4.");
                        System.out.println("Información del listado de estudiantes:");
                        muestraInformacionEstudiantes(listadoEstudiantes);
                        break;
                        
                    case 5:
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
     * Método que muestra un menú por pantalla y devuelve la opción elegida por
     * el usuario/a
     *
     * @return option con la opción del menú escogida
     */
    public static int menu() {
        int opcion = 0;

        do {
            System.out.println("Seleccionar una opción:");
            System.out.println("[1] Calcula el número de asignaturas aprobadas por un estudiante filtrando por DNI.");
            System.out.println("[2] Escribir objetos serializados en fichero.");
            System.out.println("[3] Leer objetos serializados del fichero.");
            System.out.println("[4] Mostrar información de todos los estudiantes.");
            System.out.println("[5] Salir.");

            System.out.println("Escriba la selección: ");
            opcion = teclado.nextInt();
            teclado.nextLine(); // limpiamos el salto de línea del buffer
        } while (opcion < 1 || opcion > 5);

        return opcion;
    }

    /**
     * Método que instancia 10 objetos de tipo Estudiante con unos datos ya
     * establecidos
     *
     * @return listadoEstudiantes
     */
    public static ArrayList<Estudiante> crearEstudiantes() {
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(new Estudiante("Juan", "Pérez", "12345678A", "Matemáticas", crearNotas()));
        estudiantes.add(new Estudiante("María", "Gómez", "23456789B", "Física", crearNotas()));
        estudiantes.add(new Estudiante("Carlos", "López", "34567890C", "Química", crearNotas()));
        estudiantes.add(new Estudiante("Laura", "Martínez", "45678901D", "Historia", crearNotas()));
        estudiantes.add(new Estudiante("Pedro", "Sánchez", "56789012E", "Biología", crearNotas()));
        estudiantes.add(new Estudiante("María", "García", "12345678A", "Física", crearNotas()));
        estudiantes.add(new Estudiante("Juan", "López", "98765432B", "Matemáticas", crearNotas()));
        estudiantes.add(new Estudiante("Ana", "Martínez", "54321678C", "Química", crearNotas()));
        estudiantes.add(new Estudiante("Ibai", "Rodríguez", "87654321D", "Tecnología", crearNotas()));
        estudiantes.add(new Estudiante("Nuria", "Fernández", "13579246F", "Educación Física", crearNotas()));
        return estudiantes;
    }

    /**
     * Método que genera las 9 notas en una matriz de 3x3 para cada uno de los
     * 10 estudiantes
     *
     * @return matriz 3x3 con notas
     */
    public static float[][] crearNotas() {
        int i, j;
        float[][] notas = new float[3][3];
        Random notaAleatoria = new Random();
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                // Generamos nota aleatoria entre 0 y 10
                notas[i][j] = 10 * notaAleatoria.nextFloat();
                //System.out.println(notas[i][j]);
            }
        }
        return notas;
    }

    //-------------------------------------------------
    /**
     * OPCIÓN 1 MÉTODO A IMPLEMENTAR: 1) Pedir DNI por teclado al usuario/a 2)
     * Buscar si existe el estudiante en el ArrayList 3) Si el estudiante existe
     * se calcula el número de asignaturas que ha aprobado, así como el % del
     * total 4) Si el estudiante no existe se muestra un mensaje indicándolo.
     *
     * @param listadoEstudiantes
     * @param dni
     * @return 0 si encuentra estudiante, -1 si no lo encuentra.
     */
    //------------------------------------------------------
    public static int calculaAsignaturasAprobadas(ArrayList<Estudiante> listadoEstudiantes, String dni) {
        float[][] notasObtenidas; // array donde guardamos las notas que se generan
        int contador = 0; //contador para saber las aprobadas

        for (Estudiante listadoEstudiante : listadoEstudiantes) {
            if (listadoEstudiante.getDni().equals(dni)) {
                System.out.println("El estudiante existe");
                notasObtenidas = listadoEstudiante.getNotas();
                for (int i = 0; i < notasObtenidas.length; i++) {
                    for (int j = 0; j < notasObtenidas[i].length; j++) {
                        if (notasObtenidas[i][j] >= 5) {
                            contador++;
                        }
                    }

                }
                return contador;
            }

        }

        return -1;
    }

    //-------------------------------------------------
    /**
     * OPCIÓN 2 MÉTODO A IMPLEMENTAR: Método que ESCRIBA en un fichero de
     * objetos todos los estudiantes del ArrayList.
     *
     * @param listadoEstudiantes
     * @return 0
     */
    //------------------------------------------------------
    public static int escrituraFichero(ArrayList<Estudiante> listadoEstudiantes) {
        try {
            FileOutputStream fileOut = new FileOutputStream("estudiantes.dat");
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            Estudiante wrtObj;

            // recorremos el arraylist y lo insertamos objeto a objeto
            for (Estudiante listadoEstudiante : listadoEstudiantes) {
                wrtObj = listadoEstudiante;
                objOut.writeObject(wrtObj);
            }
            objOut.close();
            fileOut.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error al crear el fichero");
            return -1;
        } catch (IOException e1) {
            System.out.println("Ocurrió un error");
            return -1;

        }

        return 0;
    }

    //-------------------------------------------------
    /**
     * OPCIÓN 3 MÉTODO A IMPLEMENTAR: Método que LEA en un fichero de objetos
     * todos los estudiantes del ArrayList.
     *
     * @return 0
     */
    //------------------------------------------------------
    public static int lecturaFichero() {
        try {
            FileInputStream fileIn = new FileInputStream("estudiantes.dat");
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            Estudiante lectura;
            int contador = 1; //Variable para dejar mas bonito el print
            boolean lecturaBool = true; // lectura de estudiantes hasta error

            while (lecturaBool) { // mientras existan Estudiantes, no sale del bucle
                try {
                    lectura = (Estudiante) objIn.readObject();
                    System.out.println("Estudiante nº " + contador);
                    System.out.println(lectura.toString() + "\n");
                    contador++;
                } catch (ClassNotFoundException e) {
                    lecturaBool = false; // cuando deja de haber Estudiantes, sale del bucle
                }

            }

            objIn.close();
            fileIn.close();

        } catch (IOException e1) {
            return 0;

        }
        return -1;
    }

    //-------------------------------------------------
    /**
     * OPCIÓN 4 MÉTODO A IMPLEMENTAR: Método que muestra por pantalla la
     * información de todos los estudiantes atendiendo al formato especificado
     *
     * @param listadoEstudiantes
     */
    //------------------------------------------------------
    public static void muestraInformacionEstudiantes(ArrayList<Estudiante> listadoEstudiantes) {
        for (Estudiante listadoEstudiante : listadoEstudiantes) {// recorremos estudiantes
            System.out.println(listadoEstudiante.toString());
            System.out.print("Notas: ");
            listadoEstudiante.toString2(); // Llamo a .toString2. Lo he hecho void para no crear variable
            System.out.println("\n");

        }

    }

}
