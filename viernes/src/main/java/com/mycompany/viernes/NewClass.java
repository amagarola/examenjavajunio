/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.viernes;


import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author BFK
 */
public class NewClass {

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        boolean fin = false;

        do {
            try {
                opcion = menu();
                switch (opcion) {
                    case 1:
                        System.out.println("Case 1");
                        break;
                    case 2:
                        System.out.println("Case 2");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Pon bien el numero");
                teclado.nextLine();
            }
        } while (fin == false);
    }
    
    public static int menu(){
        int opcion = 0;
        do{
            System.out.println("Selecciona algo");
            System.out.println("Opcion 1");
            System.out.println("Opcion 2");
            
            System.out.println("Escriba la seleccion");
            opcion = teclado.nextInt();
            teclado.nextLine();
        } while (opcion < 1 || opcion > 2);
        return opcion;
   }

}
