package app;

import database.DatabaseManager;
import database.Credentials;
import model.Registro;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DatabaseManager db = new DatabaseManager();
        try {
            db.conectar();
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nMenú de Opciones:");
                System.out.println("1. Insertar Registro");
                System.out.println("2. Salir");
                System.out.print("Seleccione una opción: ");
                int opcion = scanner.nextInt();

                if (opcion == 1) {
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Nombre: ");
                    String nombre = scanner.next();
                    System.out.print("Edad: ");
                    int edad = scanner.nextInt();
                    System.out.print("Ciudad: ");
                    String ciudad = scanner.next();

                    if (Credentials.validarClave()) {
                        db.insertarRegistro(id, nombre, edad, ciudad);
                    } else {
                        System.out.println("Clave incorrecta. Operación cancelada.");
                    }
                } else if (opcion == 2) {
                    break;
                } else {
                    System.out.println("Opción no válida.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                db.cerrar();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
