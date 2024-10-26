import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            // Inicializa la base de datos
            GestorBD.inicializarBaseDeDatos();

            // Muestra el menú interactivo
            mostrarMenu();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void mostrarMenu() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Agregar sobreviviente");
            System.out.println("2. Agregar arma");
            System.out.println("3. Agregar ítem");
            System.out.println("4. Mostrar sobrevivientes");
            System.out.println("5. Mostrar armas");
            System.out.println("6. Mostrar ítems");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> agregarSobreviviente(scanner);
                case 2 -> agregarArma(scanner);
                case 3 -> agregarItem(scanner);
                case 4 -> mostrarSobrevivientes();
                case 5 -> mostrarArmas();
                case 6 -> mostrarItems();
                case 7 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 7);
    }

    private static void agregarSobreviviente(Scanner scanner) throws SQLException {
        System.out.print("Ingrese el nombre del sobreviviente: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el rol (Ejemplo: Líder, Médico): ");
        String rol = scanner.next();
        System.out.print("Ingrese la salud: ");
        int salud = scanner.nextInt();

        String sql = "INSERT INTO sobrevivientes (nombre, rol, salud) VALUES (?, ?, ?)";
        try (Connection conn = GestorBD.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, rol);
            pstmt.setInt(3, salud);
            pstmt.executeUpdate();
            System.out.println("Sobreviviente agregado correctamente.");
        }
    }

    private static void agregarArma(Scanner scanner) throws SQLException {
        System.out.print("Ingrese el nombre del arma: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el tipo: ");
        String tipo = scanner.next();
        System.out.print("Ingrese el daño: ");
        int daño = scanner.nextInt();

        String sql = "INSERT INTO armas (nombre, tipo, daño) VALUES (?, ?, ?)";
        try (Connection conn = GestorBD.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, tipo);
            pstmt.setInt(3, daño);
            pstmt.executeUpdate();
            System.out.println("Arma agregada correctamente.");
        }
    }

    private static void agregarItem(Scanner scanner) throws SQLException {
        System.out.print("Ingrese el nombre del ítem: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el efecto: ");
        String efecto = scanner.next();

        String sql = "INSERT INTO items (nombre, efecto) VALUES (?, ?)";
        try (Connection conn = GestorBD.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, efecto);
            pstmt.executeUpdate();
            System.out.println("Ítem agregado correctamente.");
        }
    }

    private static void mostrarSobrevivientes() throws SQLException {
        String sql = "SELECT * FROM sobrevivientes";
        try (Connection conn = GestorBD.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n--- Sobrevivientes ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                                   ", Nombre: " + rs.getString("nombre") +
                                   ", Rol: " + rs.getString("rol") +
                                   ", Salud: " + rs.getInt("salud"));
            }
        }
    }

    private static void mostrarArmas() throws SQLException {
        String sql = "SELECT * FROM armas";
        try (Connection conn = GestorBD.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n--- Armas ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                                   ", Nombre: " + rs.getString("nombre") +
                                   ", Tipo: " + rs.getString("tipo") +
                                   ", Daño: " + rs.getInt("daño"));
            }
        }
    }

    private static void mostrarItems() throws SQLException {
        String sql = "SELECT * FROM items";
        try (Connection conn = GestorBD.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n--- Ítems ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                                   ", Nombre: " + rs.getString("nombre") +
                                   ", Efecto: " + rs.getString("efecto"));
            }
        }
    }
}
