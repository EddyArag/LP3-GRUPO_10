import java.util.Scanner;

public class IgualGenerico {
    // Método genérico para comparar dos elementos
    public static <T> boolean esIgualA(T obj1, T obj2) {
        if (obj1 == null || obj2 == null) {
            return false;
        }
        return obj1.equals(obj2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ingresar enteros
        System.out.print("Ingresa el primer entero: ");
        Integer a = scanner.nextInt();

        System.out.print("Ingresa el segundo entero: ");
        Integer b = scanner.nextInt();

        // Comparar enteros
        System.out.println("Comparando enteros: " + esIgualA(a, b));

        // Ingresar cadenas
        scanner.nextLine();
        System.out.print("Ingresa la primera cadena: ");
        String s1 = scanner.nextLine();

        System.out.print("Ingresa la segunda cadena: ");
        String s2 = scanner.nextLine();

        // Comparar cadenas
        System.out.println("Comparando cadenas: " + esIgualA(s1, s2));

        // Comparar null
        System.out.println("Comparando null con la segunda cadena: " + esIgualA(null, null));
    }
}
