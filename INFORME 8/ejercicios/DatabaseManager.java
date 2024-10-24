package database;
import java.sql.*;

public class DatabaseManager {
    private Connection conn;

    public void conectar() throws SQLException {
        conn = DriverManager.getConnection("jdbc:sqlite:miBase.db");
        System.out.println("Conexión exitosa.");
    }

    public void insertarRegistro(int id, String nombre, int edad, String ciudad) throws SQLException {
        String query = "INSERT INTO clientes (id, nombre, edad, ciudad) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.setString(2, nombre);
            stmt.setInt(3, edad);
            stmt.setString(4, ciudad);
            stmt.executeUpdate();
            System.out.println("Registro insertado correctamente.");
        }
    }

    public void cerrar() throws SQLException {
        if (conn != null) conn.close();
    }
}
