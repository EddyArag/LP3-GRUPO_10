import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.*;
import java.io.File;

public class ReproductorMusicaApp extends JFrame {
    private Clip clip;
    private boolean pausado = false;
    private long posicionPausa = 0;

    public ReproductorMusicaApp() {
        setTitle("Reproductor de Música");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Imagen de la canción
        JLabel etiquetaImagen = new JLabel(new ImageIcon(redimensionarImagen("resources/images/tupapa.png", 300, 300)));
        etiquetaImagen.setHorizontalAlignment(SwingConstants.CENTER);
        add(etiquetaImagen, BorderLayout.CENTER);

        // Título de la canción
        JLabel etiquetaTitulo = new JLabel("TU PAPA");
        etiquetaTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        add(etiquetaTitulo, BorderLayout.NORTH);

        // Panel con botones
        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton botonReproducir = new JButton("Reproducir");
        JButton botonPausar = new JButton("Pausar");
        JButton botonReanudar = new JButton("Reanudar");

        // Acciones para los botones
        botonReproducir.addActionListener(e -> reproducirAudio("resources/audio/tupapa.wav"));
        botonPausar.addActionListener(e -> pausarAudio());
        botonReanudar.addActionListener(e -> reanudarAudio());

        // Añadir botones al panel
        panelBotones.add(botonReproducir);
        panelBotones.add(botonPausar);
        panelBotones.add(botonReanudar);
        add(panelBotones, BorderLayout.SOUTH);

        setVisible(true);
    }

    private Image redimensionarImagen(String ruta, int ancho, int alto) {
        ImageIcon icono = new ImageIcon(ruta); // Carga el icono desde la ruta
        return icono.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH); // Escala la imagen
    }

    private void reproducirAudio(String rutaAudio) {
        try {
            File archivo = new File(rutaAudio);
            AudioInputStream flujoAudio = AudioSystem.getAudioInputStream(archivo);
            clip = AudioSystem.getClip();
            clip.open(flujoAudio);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void pausarAudio() {
        if (clip != null && clip.isRunning()) {
            posicionPausa = clip.getMicrosecondPosition();
            clip.stop();
            pausado = true;
        }
    }

    private void reanudarAudio() {
        if (clip != null && pausado) {
            clip.setMicrosecondPosition(posicionPausa);
            clip.start();
            pausado = false;
        }
    }

    public static void main(String[] args) {
        new ReproductorMusicaApp();
    }
}
