package com.mycompany.escribirobjetofichero;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class EscribirObjetoFichero {

    public static void main(String[] args) {
        Persona personaParaGuardar = new Persona("Josefina", "Pontevedra", 30);
        FileOutputStream fichero = null;

        try {
            fichero = new FileOutputStream("datos.txt");
            ObjectOutputStream tuberia = new ObjectOutputStream(fichero);
            tuberia.writeObject(personaParaGuardar);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fichero.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
