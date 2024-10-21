import javax.swing.JFrame; // Para crear una ventana
import javax.swing.JOptionPane; // Para mostrar mensajes emergentes
import java.io.IOException; // Excepciones de E/S
import java.nio.file.DirectoryStream; // Para leer el contenido de directorios
import java.nio.file.Files; // Para operaciones de archivos
import java.nio.file.Path; // Para representar rutas en el sistema de archivos
import java.nio.file.Paths; // Para crear instancias de Path
import javax.swing.JFileChooser; // Para crear un selector de archivos

public class TestFile {

    public static void main(String[] args) throws IOException { // Lanzar excepciones de E/S
        // Crear un selector de archivos
        JFileChooser selectorArchivos = new JFileChooser();
        selectorArchivos.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // Configurar para seleccionar
                                                                                   // archivos y directorios
        int resultado = selectorArchivos.showOpenDialog(null); // Mostrar diálogo de apertura

        if (resultado == JFileChooser.APPROVE_OPTION) { // Si el usuario selecciona un archivo o directorio
            Path ruta = selectorArchivos.getSelectedFile().toPath(); // Obtener la ruta del archivo seleccionado

            if (Files.exists(ruta)) { // Comprobar si la ruta existe
                // Mostrar información sobre el archivo/directorio
                System.out.printf("%s existe%n", ruta.getFileName());
                System.out.printf("%s un directorio%n", Files.isDirectory(ruta) ? "Es" : "No es");
                System.out.printf("%s una ruta absoluta%n", ruta.isAbsolute() ? "Es" : "No es");
                System.out.printf("Fecha de última modificación: %s%n", Files.getLastModifiedTime(ruta));
                System.out.printf("Tamaño: %s%n", Files.size(ruta));
                System.out.printf("Ruta: %s%n", ruta);
                System.out.printf("Ruta absoluta: %s%n", ruta.toAbsolutePath());

                if (Files.isDirectory(ruta)) { // Si es un directorio
                    System.out.printf("%nContenido del directorio:%n");
                    DirectoryStream<Path> flujoDirectorio = Files.newDirectoryStream(ruta); // Leer contenido del
                                                                                            // directorio
                    for (Path p : flujoDirectorio)
                        System.out.println(p); // Imprimir cada archivo en el directorio
                }
            } else {
                JOptionPane.showMessageDialog(null, ruta + " no existe.", "ERROR", JOptionPane.ERROR_MESSAGE); // Mostrar
                                                                                                               // mensaje
                                                                                                               // de
                                                                                                               // error
            }
        } else {
            System.exit(1); // Salir si el usuario cancela
        }
    }
}
