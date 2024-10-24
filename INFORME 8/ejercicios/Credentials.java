package database;
import java.util.Scanner;

public class Credentials {
    public static boolean validarClave() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la clave para confirmar: ");
        String clave = scanner.nextLine();
        return "admin123".equals(clave);
    }
}
