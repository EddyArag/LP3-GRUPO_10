import javax.swing.JFrame; // Para crear una ventana
import javax.swing.JTextArea; // Para crear un área de texto

public class ViewFile extends JFrame { // Extender JFrame para crear una ventana
    private JTextArea areaTexto; // Crear un área de texto

    public ViewFile(String s) { // Constructor que recibe el contenido del archivo
        super("Mostrando el contenido de un archivo"); // Título de la ventana
        areaTexto = new JTextArea(s, 5, 40); // Crear el área de texto con contenido
        add(areaTexto); // Añadir el área de texto a la ventana
    }
}