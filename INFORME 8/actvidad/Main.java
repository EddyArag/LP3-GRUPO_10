import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            // Inicializa la base de datos
            DBManager.initializeDatabase();

            // Muestra el menú interactivo
            mostrarMenu();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Método para mostrar el menú
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
                case 1:
                    agregarSobreviviente(scanner);
                    break;
                case 2:
                    agregarArma(scanner);
                    break;
                case 3:
                    agregarItem(scanner);
                    break;
                case 4:
                    mostrarSobrevivientes();
                    break;
                case 5:
                    mostrarArmas();
                    break;
                case 6:
                    mostrarItems();
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 7);
    }

    // Métodos para agregar datos a la base de datos
    private static void agregarSobreviviente(Scanner scanner) throws SQLException {
        System.out.print("Ingrese el nombre del sobreviviente: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el rol (Ejemplo: Líder, Médico): ");
        String rol = scanner.next();
        System.out.print("Ingrese la salud: ");
        int salud = scanner.nextInt();

        String sql = "INSERT INTO survivors (name, role, health) VALUES (?, ?, ?)";
        try (Connection conn = DBManager.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
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
        System.out.print("Ingrese el tipo (Ejemplo: Rifle, Escopeta): ");
        String tipo = scanner.next();
        System.out.print("Ingrese el daño: ");
        int dano = scanner.nextInt();

        String sql = "INSERT INTO weapons (name, type, damage) VALUES (?, ?, ?)";
        try (Connection conn = DBManager.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, tipo);
            pstmt.setInt(3, dano);
            pstmt.executeUpdate();
            System.out.println("Arma agregada correctamente.");
        }
    }

    private static void agregarItem(Scanner scanner) throws SQLException {
        System.out.print("Ingrese el nombre del ítem: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el efecto (Ejemplo: Cura, Aumenta Resistencia): ");
        String efecto = scanner.next();

        String sql = "INSERT INTO items (name, effect) VALUES (?, ?)";
        try (Connection conn = DBManager.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, efecto);
            pstmt.executeUpdate();
            System.out.println("Ítem agregado correctamente.");
        }
    }

    // Métodos para mostrar datos
    private static void mostrarSobrevivientes() throws SQLException {
        String sql = "SELECT * FROM survivors";
        try (Connection conn = DBManager.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n--- Sobrevivientes ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                                   ", Nombre: " + rs.getString("name") +
                                   ", Rol: " + rs.getString("role") +
                                   ", Salud: " + rs.getInt("health"));
            }
        }
    }

    private static void mostrarArmas() throws SQLException {
        String sql = "SELECT * FROM weapons";
        try (Connection conn = DBManager.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n--- Armas ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                                   ", Nombre: " + rs.getString("name") +
                                   ", Tipo: " + rs.getString("type") +
                                   ", Daño: " + rs.getInt("damage"));
            }
        }
    }

    private static void mostrarItems() throws SQLException {
        String sql = "SELECT * FROM items";
        try (Connection conn = DBManager.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n--- Ítems ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                                   ", Nombre: " + rs.getString("name") +
                                   ", Efecto: " + rs.getString("effect"));
            }
        }
    }
}
