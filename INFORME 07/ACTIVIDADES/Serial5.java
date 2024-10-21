import java.io.FileNotFoundException; // Excepción si el archivo no se encuentra
import java.io.FileOutputStream; // Para escribir bytes en archivos
import java.io.IOException; // Excepciones de E/S
import java.io.ObjectOutputStream; // Para escribir objetos en archivos

public class Serial5 {

    public static void main(String[] args) {

        FileOutputStream fos = null; // Inicializar FileOutputStream
        ObjectOutputStream salida = null; // Inicializar ObjectOutputStream
        Alumno a; // Declarar alumno
        Fecha f; // Declarar fecha

        try {
            fos = new FileOutputStream("/ficheros/alumnos.dat"); // Crear el archivo de salida
            salida = new ObjectOutputStream(fos); // Crear ObjectOutputStream
            f = new Fecha(5, 9, 2011); // Crear fecha
            a = new Alumno("12345678A", "Lucas González", 20, f); // Crear alumno
            salida.writeObject(a); // Escribir objeto alumno en archivo
            f = new Fecha(7, 9, 2011); // Crear otra fecha
            a = new Alumno("98765432B", "Anacleto Jiménez", 19, f); // Crear otro alumno
            salida.writeObject(a); // Escribir objeto alumno en archivo
            f = new Fecha(8, 9, 2011); // Crear otra fecha
            a = new Alumno("78234122R", "María Zapata", 21, f); // Crear otro alumno
            salida.writeObject(a); // Escribir objeto alumno en archivo
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage()); // Mostrar mensaje si el archivo no se encuentra
        } catch (IOException e) {
            System.out.println(e.getMessage()); // Mostrar mensaje de error de E/S
        } finally {
            try {
                if (fos != null) fos.close(); // Cerrar FileOutputStream
                if (salida != null) salida.close(); // Cerrar ObjectOutputStream
            } catch (IOException e) {
                System.out.println(e.getMessage()); // Mostrar mensaje de error al cerrar
            }
        }
    }
}