import java.io.IOException; // Importa las excepciones de E/S
import java.nio.file.DirectoryStream; // Para leer el contenido de directorios
import java.nio.file.Files; // Para operaciones de archivos
import java.nio.file.Path; // Para representar rutas en el sistema de archivos
import java.nio.file.Paths; // Para crear instancias de Path
import java.util.Scanner; // Para leer la entrada del usuario

public class TestFile {

    public static void main(String[] args) throws IOException { // Lanzar excepciones de E/S
        Scanner sc = new Scanner(System.in); // Crear un escáner para la entrada del usuario

        System.out.println("Escriba el nombre del archivo o directorio:"); // Pedir al usuario la ruta
        Path ruta = Paths.get(sc.nextLine()); // Obtener la ruta del usuario
        if (Files.exists(ruta)) { // Comprobar si la ruta existe
            System.out.printf("%s existe%n", ruta.getFileName()); // Mostrar el nombre del archivo/directorio
            System.out.printf("%s un directorio%n", Files.isDirectory(ruta) ? "Es" : "No es"); // Comprobar si es un directorio
            System.out.printf("%s una ruta absoluta%n", ruta.isAbsolute() ? "Es" : "No es"); // Comprobar si es una ruta absoluta
            System.out.printf("Fecha de ultima modificacion: %s%n", Files.getLastModifiedTime(ruta)); // Mostrar la última modificación
            System.out.printf("Tamaño: %s%n", Files.size(ruta)); // Mostrar el tamaño
            System.out.printf("Ruta: %s%n", ruta); // Mostrar la ruta
            System.out.printf("Ruta absoluta %s%n", ruta.toAbsolutePath()); // Mostrar la ruta absoluta
            if (Files.isDirectory(ruta)) { // Si es un directorio
                System.out.printf("%nContenido del directorio:%n");
                DirectoryStream<Path> flujoDirectorio = Files.newDirectoryStream(ruta); // Leer contenido del directorio
                for (Path p : flujoDirectorio)
                    System.out.println(p); // Imprimir cada archivo en el directorio
            }
        } else {
            System.out.printf("%s no existe%n", ruta); // Si la ruta no existe
        }
    }
}
