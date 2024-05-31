/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package prog.proyectobase;

import java.io.*;
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
    static ArrayList<Estudiante> listadoEstudiantes = (ArrayList<Estudiante>) crearEstudiantes();
    
    
    public static void main(String[] args) {

        int opcion;
        boolean fin = false;
        //
        // A continuación se instancian 10 estudiantes con sus datos a través del metodo crearEstudiantes()
        //
        //ArrayList<Estudiante> listadoEstudiantes = (ArrayList<Estudiante>) crearEstudiantes();

        // Se muestra el menú mientras fin no sea igual a true
        // Se ejecuta el código correspondiente a la opción elegida por el usuario/a
        do {
            try {
                opcion = menu();
                switch (opcion) {
                    case 1:
                        System.out.println("Opción 1.");
                        System.out.println("Introduzca el DNI del estudiante: ");
                        if(calculaAsignaturasAprobadas(teclado.nextLine())==-1)
                            System.out.println("El estudiante no exite.");
                        //--------------------------------
                        // CÓDIGO A IMPLEMENTAR
                        //--------------------------------
                        break;
                    case 2:
                        System.out.println("Opción 2.");
                        System.out.println("Escritura de los estudiantes en fichero de salida.");
                        System.out.println(escrituraFichero()==0?"Fin de escritura de la base de datos.":"Sentimos el error.");;
                        //--------------------------------
                        // CÓDIGO A IMPLEMENTAR
                        //--------------------------------
                        break;

                    case 3:
                        System.out.println("Opción 3.");
                        System.out.println("Lectura de los estudiantes almacenados en fichero.");
                        System.out.println(lecturaFichero()==0?"Fin de lectura de la base de datos.":"Sentimos el error.");;
                        //--------------------------------
                        // CÓDIGO A IMPLEMENTAR
                        //--------------------------------
                        break;
                    case 4:
                        System.out.println("Opción 4.");
                        System.out.println("Información del listado de estudiantes:");
                        //--------------------------------
                        // CÓDIGO A IMPLEMENTAR
                        //--------------------------------
                        muestraInformacionEstudiantes();
                        break;
                    case 5:
                        System.out.println("Has seleccionado terminar el programa. Hasta luego.");
                        fin = true;
                        break;
                }
                // Se captura la excepción de que el dato introducido no sea un número 
            } catch (InputMismatchException e)
            {
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
        estudiantes.add(new Estudiante("María", "García", "12345679A", "Física", crearNotas()));
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
     * OPCIÓN 1 MÉTODO A IMPLEMENTAR: 
     * 1) Pedir DNI por teclado al usuario/a 
     * 2) Buscar si existe el estudiante en el ArrayList 
     * 3) Si el estudiante existe se calcula el número de asignaturas que ha aprobado, así como el % del total
     * 4) Si el estudiante no existe se muestra un mensaje indicándolo.
     *
     * @param dni
     * @return 0 si encuentra estudiante, -1 si no lo encuentra.
     */
    //------------------------------------------------------
    public static int calculaAsignaturasAprobadas(String dni)
    {
        int i=0, j=0, passedNumber=0;
        
        for(Estudiante student: listadoEstudiantes)
        {
            if(student.dni.equals(dni))
            {
                for(i=0;i<student.notas.length; i++)
                    for(j=0; j<student.notas[i].length; j++)
                    {
                        if(student.notas[i][j]>=5.0)
                            passedNumber++;
                    }
                System.out.println("El estudienta existe");
                System.out.printf("El número de materias aprobadas es %d un %.2f por ciento del total.\n", passedNumber, ((float)passedNumber*100/(i*j)));
                return 0;
            }
        }
        return -1;
    }

    //-------------------------------------------------
    /**
     * OPCIÓN 2 MÉTODO A IMPLEMENTAR: Método que ESCRIBA en un fichero de
     * objetos todos los estudiantes del ArrayList.
     *
     * @return 0
     */
    //------------------------------------------------------
    public static int escrituraFichero() {
        try(ObjectOutputStream data=new ObjectOutputStream(new FileOutputStream("estudiantes.dat")))
        {
            data.writeObject(listadoEstudiantes);
        } catch (FileNotFoundException ex) {
            System.out.println("Error en la escritura de la base de datos. Compruebe los permisos de escritura en la capreta");
            return -1;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
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
    public static int lecturaFichero()
    {
        
        try(ObjectInputStream data=new ObjectInputStream(new FileInputStream("estudiantes.dat")))
        {
            ArrayList<Estudiante> studentList = (ArrayList<Estudiante>) data.readObject();
            for(Estudiante student: studentList)
            {
                System.out.println(student.toString());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("No existe la base de datos o no tiene permisos de lectura en la misma.");
            return -1;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return -1;
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }

    

    //-------------------------------------------------
    /**
     * OPCIÓN 4 MÉTODO A IMPLEMENTAR: Método que muestra por pantalla la
     * información de todos los estudiantes atendiendo al formato especificado
     *
     * @param listadoEstudiantes
     */
    //------------------------------------------------------
    public static void muestraInformacionEstudiantes()
    {
        for(Estudiante student: listadoEstudiantes)
            System.out.println(student.toString2());
    }

}
