import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.sound.sampled.*;
import java.io.File;

public class EfectosDeSonidoApp extends JFrame {
    public EfectosDeSonidoApp() {
        setTitle("Reproductor de Efectos de Sonido");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 10, 10)); // Filas y columnas

        // Crear las imágenes y botones
        agregarEfecto("resources/images/aplausos.png", "resources/audio/aplausos.wav");
        agregarEfecto("resources/images/campana.png", "resources/audio/campana.wav");
        agregarEfecto("resources/images/explosion.png", "resources/audio/explosion.wav");

        setVisible(true);
    }

    private void agregarEfecto(String rutaImagen, String rutaAudio) {
        // Crear un panel para cada imagen y botón
        JPanel panel = new JPanel(new BorderLayout());
        JLabel etiquetaImagen = new JLabel(new ImageIcon(redimensionarImagen(rutaImagen, 150, 150)));
        etiquetaImagen.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(etiquetaImagen, BorderLayout.CENTER);

        // Botón para reproducir el sonido
        JButton botonReproducir = new JButton("Reproducir");
        botonReproducir.addActionListener(e -> reproducirSonido(rutaAudio));
        panel.add(botonReproducir, BorderLayout.SOUTH);

        // Añadir al frame
        add(panel);
    }

    private Image redimensionarImagen(String ruta, int ancho, int alto) {
        ImageIcon icono = new ImageIcon(ruta); // Carga el icono desde la ruta
        return icono.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH); // Escala la imagen
    }

    private void reproducirSonido(String rutaAudio) {
        try {
            File archivo = new File(rutaAudio); // Carga el archivo de audio
            AudioInputStream flujoAudio = AudioSystem.getAudioInputStream(archivo);
            Clip clip = AudioSystem.getClip(); // Crea un clip para el audio
            clip.open(flujoAudio); // Abre el flujo de audio
            clip.start(); // Reproduce el sonido
        } catch (Exception e) {
            e.printStackTrace(); // Muestra cualquier error en la consola
        }
    }

    public static void main(String[] args) {
        new EfectosDeSonidoApp(); // Lanza la aplicación
    }
}
