import java.io.FileInputStream; // Para leer archivos como secuencia de bytes
import java.io.FileNotFoundException; // Excepción si el archivo no se encuentra
import java.io.IOException; // Excepciones de E/S
import javax.swing.JFrame; // Para crear una ventana

public class TestFilePrueba {
    public static void main(String[] args) throws IOException { // Lanzar excepciones de E/S
        FileInputStream file; // Inicializar FileInputStream
        byte b[] = new byte[1024]; // Crear un buffer de bytes
        try {
            file = new FileInputStream("src/archivos/TestFile.java"); // Abrir el archivo
            file.read(b); // Leer el archivo en el buffer
            String s = new String(b); // Convertir los bytes a String
            ViewFile view = new ViewFile(s); // Crear la vista del archivo
            view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configurar operación de cierre
            view.setSize(400, 150); // Configurar tamaño de la ventana
            view.setVisible(true); // Hacer visible la ventana
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage()); // Mostrar mensaje si el archivo no se encuentra
        } catch (IOException e) {
            System.out.println(e.getMessage()); // Mostrar mensaje de error de E/S
        }
    }
}
