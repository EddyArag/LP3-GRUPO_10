import java.io.IOException; // Excepciones de E/S
import javax.swing.JFrame; // Para crear una ventana

public class PruebaJFileChooser {
    public static void main(String[] args) throws IOException { // Lanzar excepciones de E/S
        DemoJFileChooser aplicacion = new DemoJFileChooser(); // Crear instancia de DemoJFileChooser
        aplicacion.setSize(400, 400); // Configurar tamaño de la ventana
        aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configurar operación de cierre
        aplicacion.setVisible(true); // Hacer visible la ventana
    }
}