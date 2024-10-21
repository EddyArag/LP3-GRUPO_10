import java.io.FileNotFoundException; // Excepción si el archivo no se encuentra
import java.io.FileOutputStream; // Para escribir bytes en archivos
import java.io.IOException; // Excepciones de E/S
import java.io.DataOutputStream; // Para escribir datos primitivos en archivos
import java.util.Scanner; // Para leer la entrada del usuario

public class Binarios2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Crear un escáner para la entrada del usuario
        FileOutputStream fos = null; // Inicializar FileOutputStream
        DataOutputStream salida = null; // Inicializar DataOutputStream
        double[][] matriz; // Declarar la matriz
        int filas, columnas, i, j;

        // Pedir al usuario el número de filas y columnas
        do {
            System.out.print("Número de filas: ");
            filas = sc.nextInt();
        } while (filas <= 0);
        do {
            System.out.print("Número de columnas: ");
            columnas = sc.nextInt();
        } while (columnas <= 0);

        matriz = new double[filas][columnas]; // Crear la matriz

        // Leer los datos de la matriz
        for (i = 0; i < filas; i++) {
            for (j = 0; j < columnas; j++) {
                System.out.print("matriz[" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextDouble();
            }
        }

        try {
            fos = new FileOutputStream("/ficheros/matriz.dat"); // Crear el archivo de salida
            salida = new DataOutputStream(fos); // Crear DataOutputStream
            salida.writeInt(filas); // Escribir el número de filas
            salida.writeInt(columnas); // Escribir el número de columnas
            for (i = 0; i < filas; i++) {
                for (j = 0; j < columnas; j++) {
                    salida.writeDouble(matriz[i][j]); // Escribir los datos de la matriz
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage()); // Mostrar mensaje si el archivo no se encuentra
        } catch (IOException e) {
            System.out.println(e.getMessage()); // Mostrar mensaje de error de E/S
        } finally {
            try {
                if (fos != null) fos.close(); // Cerrar FileOutputStream
                if (salida != null) salida.close(); // Cerrar DataOutputStream
            } catch (IOException e) {
                System.out.println(e.getMessage()); // Mostrar mensaje de error al cerrar
            }
        }
    }
}
