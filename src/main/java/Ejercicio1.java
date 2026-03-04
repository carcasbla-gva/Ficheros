import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        File directorioActual = File.listRoots()[0];

        while (true){
            System.out.println("Directorio actual: " + directorioActual.getAbsolutePath());
            System.out.println("0. - Directorio Padre");

            File[] listado = directorioActual.listFiles();

            if (listado == null){
                System.out.println("No se puede acceder al directorio");
                return;
            }
            for (int i = 0; i < listado.length ; i++) {
                System.out.print(i + ". - " + listado[i].getName() +" ");

                if (listado[i].isDirectory()){
                    System.out.println("<Directorio>");
                }
                else {
                    System.out.println(listado[i].length() + " bytes");
                }
            }
            System.out.println("Introduce un numero (-1 para salir): ");
            int numero = teclado.nextInt();
            if (numero == -1){
                break;
            }
            if (numero == 0){
                File padre = directorioActual.getParentFile();
                if (padre != null){
                    directorioActual = padre;
                }
                else {
                    System.out.println("No hay directorio padre");
                }

            } else if (numero > 0 && numero < listado.length){
                File seleccionado = listado[numero - 1];
                if (seleccionado.isDirectory()){
                    directorioActual = seleccionado;
                }
                else {
                    System.out.println("No es un directorio");
                }
            }
        }
    }
}
