import java.io.FileNotFoundException; // Excepción si el archivo no se encuentra
import java.io.PrintWriter; // Para escribir en archivos
import java.util.Scanner; // Para leer la entrada del usuario

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Crear un escáner para la entrada del usuario
        String cadena;

        try (PrintWriter salida = new PrintWriter("c:/ficheros/datos.txt")) { // Crear PrintWriter con el archivo de destino
            System.out.println("Introduce texto. Para acabar introduce la cadena FIN:"); // Pedir al usuario el texto
            cadena = sc.nextLine(); // Leer la entrada del usuario
            while (!cadena.equalsIgnoreCase("FIN")) { // Continuar hasta que el usuario introduzca "FIN"
                salida.println(cadena); // Escribir la línea en el archivo
                cadena = sc.nextLine(); // Leer la siguiente línea
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage()); // Mostrar mensaje de error si el archivo no se encuentra
        }
    }
}
