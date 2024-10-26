import java.sql.*;

public class GestorBD {
    private static final String URL = "jdbc:sqlite:left4dead2.db";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    // Método para crear las tablas iniciales (Sobrevivientes, Armas, Ítems)
    public static void inicializarBaseDeDatos() throws SQLException {
        String sqlSobrevivientes = "CREATE TABLE IF NOT EXISTS sobrevivientes ("
                                 + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                                 + "nombre TEXT NOT NULL, "
                                 + "rol TEXT, "
                                 + "salud INTEGER"
                                 + ");";

        String sqlArmas = "CREATE TABLE IF NOT EXISTS armas ("
                        + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + "nombre TEXT NOT NULL, "
                        + "tipo TEXT, "
                        + "daño INTEGER"
                        + ");";

        String sqlItems = "CREATE TABLE IF NOT EXISTS items ("
                        + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + "nombre TEXT NOT NULL, "
                        + "efecto TEXT"
                        + ");";

        try (Connection conn = conectar(); Statement stmt = conn.createStatement()) {
            stmt.execute(sqlSobrevivientes);
            stmt.execute(sqlArmas);
            stmt.execute(sqlItems);
            System.out.println("Tablas creadas correctamente.");
        }
    }
}
