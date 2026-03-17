import java.io.File;
import java.text.DateFormat;
import java.util.Locale;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        File directorioActual = File.listRoots()[0];
        
        DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, Locale.getDefault());

        while (true) {
            System.out.println("Directorio actual: " + directorioActual.getAbsolutePath());
            System.out.println("0.- \tDirectorio Padre");

            File[] listado = directorioActual.listFiles();

            if (listado == null) {
                System.out.println("No se puede acceder al directorio");
                return;
            }
            
            for (int i = 0; i < listado.length; i++) {
                File e = listado[i];
                int cont = i + 1;
                
                String flags = (e.isDirectory() ? "d" : "-") +
                               (e.canRead() ? "r" : "-") +
                               (e.canWrite() ? "w" : "-") +
                               (e.canExecute() ? "x" : "-");

                System.out.println(cont + ".- \t" + flags + "\t" + String.format("%-15d", e.length()) + formatter.format(e.lastModified()) + "\t" + e.getName());
            }
            
            System.out.print("Introduce un numero (-1 para salir): ");
            int numero = teclado.nextInt();
            
            if (numero == -1) {
                break;
            }
            
            if (numero == 0) {
                File padre = directorioActual.getParentFile();
                if (padre != null) {
                    directorioActual = padre;
                } else {
                    System.out.println("No hay directorio padre");
                }
            } else if (numero > 0 && numero <= listado.length) {
                File seleccionado = listado[numero - 1];
                if (seleccionado.isDirectory()) {
                    directorioActual = seleccionado;
                } else {
                    System.out.println("No es un directorio");
                }
            } else {
                System.out.println("Número no válido");
            }
        }
    }
}
