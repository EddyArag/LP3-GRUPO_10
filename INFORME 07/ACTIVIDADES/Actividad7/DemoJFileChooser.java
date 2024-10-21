import javax.swing.JFrame; // Para crear una ventana
import javax.swing.JTextArea; // Para crear un área de texto
import javax.swing.JScrollPane; // Para agregar barra de desplazamiento
import javax.swing.JFileChooser; // Para crear un selector de archivos
import javax.swing.JOptionPane; // Para mostrar mensajes emergentes
import java.io.IOException; // Excepciones de E/S
import java.nio.file.DirectoryStream; // Para leer el contenido de directorios
import java.nio.file.Files; // Para operaciones de archivos
import java.nio.file.Path; // Para representar rutas en el sistema de archivos

public class DemoJFileChooser extends JFrame { // Extender JFrame para crear una ventana
    private final JTextArea areaSalida; // Crear un área de texto

    public DemoJFileChooser() throws IOException { // Constructor que lanza excepciones de E/S
        super("Demo de JFileChooser"); // Título de la ventana
        areaSalida = new JTextArea(); // Crear el área de texto
        add(new JScrollPane(areaSalida)); // Añadir área de texto con barra de desplazamiento
        analizarRuta(); // Llamar método para analizar ruta
    }

    public void analizarRuta() throws IOException { // Método para analizar ruta
        Path ruta = obtenerRutaArchivoDirectorio(); // Obtener la ruta seleccionada

        if (ruta != null && Files.exists(ruta)) { // Comprobar si la ruta existe
            StringBuilder builder = new StringBuilder(); // Crear StringBuilder para construir el texto
            builder.append(String.format("%nNombre: %s%n", ruta.getFileName())); // Añadir nombre del archivo
            builder.append(String.format("¿Es un directorio?: %s%n", Files.isDirectory(ruta) ? "Sí" : "No es")); // Comprobar si es un directorio
            builder.append(String.format("¿Es una ruta absoluta?: %s%n", ruta.isAbsolute() ? "Sí" : "No es")); // Comprobar si es una ruta absoluta
            builder.append(String.format("Última modificación: %s%n", Files.getLastModifiedTime(ruta))); // Mostrar última modificación
            builder.append(String.format("Tamaño: %s%n", Files.size(ruta))); // Mostrar tamaño
            builder.append(String.format("Ruta: %s%n", ruta)); // Mostrar ruta
            builder.append(String.format("Ruta absoluta: %s%n", ruta.toAbsolutePath())); // Mostrar ruta absoluta

            if (Files.isDirectory(ruta)) { // Si es un directorio
                builder.append(String.format("%nContenido del directorio:%n"));
                DirectoryStream<Path> flujoDirectorio = Files.newDirectoryStream(ruta); // Leer contenido del directorio
                for (Path p : flujoDirectorio)
                    builder.append(String.format("%s%n", p)); // Añadir cada archivo en el directorio
            }

            areaSalida.setText(builder.toString()); // Mostrar el contenido en el área de texto
        } else {
            JOptionPane.showMessageDialog(this, ruta.getFileName() + " no existe.", "ERROR", JOptionPane.ERROR_MESSAGE); // Mostrar mensaje de error
        }
    }

    private Path obtenerRutaArchivoDirectorio() {
        JFileChooser selectorArchivos = new JFileChooser(); // Crear selector de archivos
        selectorArchivos.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // Configurar para seleccionar archivos y directorios
        int resultado = selectorArchivos.showOpenDialog(this); // Mostrar diálogo de apertura
        if (resultado == JFileChooser.CANCEL_OPTION) // Si el usuario cancela
            System.exit(1); // Salir del programa

        return selectorArchivos.getSelectedFile().toPath(); // Devolver la ruta del archivo seleccionado
    }
}
