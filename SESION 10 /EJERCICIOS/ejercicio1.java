import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductoApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Gestión de Producto");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(610, 200);

        // Modelo de datos
        Producto producto = new Producto("Sin Nombre", 0.0, 0, "Sin Categoría");

        // Componentes de la interfaz
        JTextField nombreField = new JTextField(producto.getNombre(), 20);
        JTextField precioField = new JTextField(String.valueOf(producto.getPrecio()), 20);
        JTextField cantidadField = new JTextField(String.valueOf(producto.getCantidadStock()), 20);
        JTextField categoriaField = new JTextField(producto.getCategoria(), 20);
        JButton actualizarButton = new JButton("Actualizar Producto");
        JLabel infoLabel = new JLabel("Información actualizada del producto aparecerá aquí.");

        // Listener para actualizar el modelo y mostrar la información
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    producto.setNombre(nombreField.getText());
                    producto.setPrecio(Double.parseDouble(precioField.getText()));
                    producto.setCantidadStock(Integer.parseInt(cantidadField.getText()));
                    producto.setCategoria(categoriaField.getText());

                    // Mostrar la información actualizada
                    infoLabel.setText("<html>Producto: " + producto.getNombre() +
                            "<br>Precio: " + producto.getPrecio() +
                            "<br>Cantidad en stock: " + producto.getCantidadStock() +
                            "<br>Categoría: " + producto.getCategoria() + "</html>");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingrese valores válidos.");
                }
            }
        });

        // Diseño de la interfaz
        frame.setLayout(new FlowLayout());
        frame.add(new JLabel("Nombre:"));
        frame.add(nombreField);
        frame.add(new JLabel("Precio:"));
        frame.add(precioField);
        frame.add(new JLabel("Cantidad:"));
        frame.add(cantidadField);
        frame.add(new JLabel("Categoría:"));
        frame.add(categoriaField);
        frame.add(actualizarButton);
        frame.add(infoLabel);

        frame.setVisible(true);
    }
}

// Clase modelo
class Producto {
    private String nombre;
    private double precio;
    private int cantidadStock;
    private String categoria;

    public Producto(String nombre, double precio, int cantidadStock, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
