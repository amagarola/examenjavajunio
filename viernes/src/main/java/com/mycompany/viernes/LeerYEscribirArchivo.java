import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class LeerYEscribirArchivo {
    public static void main(String[] args) {
        String archivoEntrada = "archivoEntrada.txt";  // Archivo de entrada
        String archivoSalida = "archivoSalida.txt";    // Archivo de salida

        try (FileInputStream fis = new FileInputStream(archivoEntrada);
             FileOutputStream fos = new FileOutputStream(archivoSalida)) {

            int byteLeido;
            while ((byteLeido = fis.read()) != -1) {
                fos.write(byteLeido);  // Leer del archivo de entrada y escribir en el archivo de salida
            }

            System.out.println("Lectura y escritura completadas.");
        } catch (IOException e) {
            e.printStackTrace();  // Manejo de excepciones
        }
    }
}
