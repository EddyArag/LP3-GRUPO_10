import java.sql.*;

public class DBManager {
    private static final String URL = "jdbc:sqlite:left4dead2.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    // Método para crear las tablas iniciales (Survivors, Weapons, Items)
    public static void initializeDatabase() throws SQLException {
        String sqlSurvivors = "CREATE TABLE IF NOT EXISTS survivors ("
                            + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                            + "name TEXT NOT NULL, "
                            + "role TEXT, "
                            + "health INTEGER"
                            + ");";

        String sqlWeapons = "CREATE TABLE IF NOT EXISTS weapons ("
                          + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                          + "name TEXT NOT NULL, "
                          + "type TEXT, "
                          + "damage INTEGER"
                          + ");";

        String sqlItems = "CREATE TABLE IF NOT EXISTS items ("
                        + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + "name TEXT NOT NULL, "
                        + "effect TEXT"
                        + ");";

        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            stmt.execute(sqlSurvivors);
            stmt.execute(sqlWeapons);
            stmt.execute(sqlItems);
            System.out.println("Tablas creadas correctamente.");
        }
    }
}
