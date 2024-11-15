import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.sound.sampled.*;
import java.io.File;

public class TinderKidsApp extends JFrame {
    private CardLayout diseñoTarjetas;
    private JPanel panelPrincipal;
    private ArrayList<String> listaSmash = new ArrayList<>();
    private int solteroActual = 0;
    private String[] solteros = {"alvaro", "eddy", "alex", "orla", "rodrigo", "piero"};
    private JLabel imagenSoltero;

    public TinderKidsApp() {
        setTitle("TINDERKIDS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);
        setLocationRelativeTo(null);

        diseñoTarjetas = new CardLayout();
        panelPrincipal = new JPanel(diseñoTarjetas);
        
        // Añadir las pantallas al panel principal
        panelPrincipal.add(crearPanelLogin(), "Login");
        panelPrincipal.add(crearPanelInicio(), "Inicio");
        panelPrincipal.add(crearPanelSolteros(), "Solteros");
        panelPrincipal.add(crearPanelResultados(), "Resultados");

        add(panelPrincipal);
        diseñoTarjetas.show(panelPrincipal, "Login"); // Muestra la pantalla de login al inicio
        setVisible(true);
    }

    // Crear el panel de login
    private JPanel crearPanelLogin() {
        JPanel panelLogin = new JPanel(new GridBagLayout());
        panelLogin.setBackground(new Color(240, 248, 255)); // Fondo azul claro

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panelLogin.add(new JLabel("Usuario:"), gbc);
        JTextField campoUsuario = new JTextField(15);
        gbc.gridx = 1;
        panelLogin.add(campoUsuario, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panelLogin.add(new JLabel("Contraseña:"), gbc);
        JPasswordField campoContraseña = new JPasswordField(15);
        gbc.gridx = 1;
        panelLogin.add(campoContraseña, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        JButton botonLogin = new JButton("Iniciar Sesión");
        botonLogin.setBackground(new Color(100, 149, 237)); // Azul claro
        botonLogin.setForeground(Color.WHITE);
        
        botonLogin.addActionListener(e -> {
            String usuario = campoUsuario.getText();
            String contraseña = new String(campoContraseña.getPassword());
            
            if (usuario.equals("admin") && contraseña.equals("1234")) {
                diseñoTarjetas.show(panelPrincipal, "Inicio");
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        panelLogin.add(botonLogin, gbc);

        return panelLogin;
    }

    // Crear el panel de inicio
    private JPanel crearPanelInicio() {
        JPanel panelInicio = new JPanel(new BorderLayout());
        panelInicio.setBackground(new Color(255, 228, 225)); // Color rosado claro

        JLabel etiquetaLogo = new JLabel();
        etiquetaLogo.setHorizontalAlignment(SwingConstants.CENTER);
        ImageIcon iconoLogo = new ImageIcon("resources/images/logo.png");
        etiquetaLogo.setIcon(redimensionarImagen(iconoLogo, 150, 150)); 
        panelInicio.add(etiquetaLogo, BorderLayout.CENTER);

        JLabel etiquetaTitulo = new JLabel("TINDERKIDS");
        etiquetaTitulo.setFont(new Font("Arial", Font.BOLD, 28));
        etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        etiquetaTitulo.setForeground(new Color(255, 69, 0)); // Rojo oscuro
        panelInicio.add(etiquetaTitulo, BorderLayout.NORTH);

        JButton botonInicio = new JButton("BUSCAR EL AMOR");
        botonInicio.setFont(new Font("Arial", Font.BOLD, 20));
        botonInicio.setBackground(new Color(255, 182, 193)); // Rosa claro
        botonInicio.setForeground(Color.WHITE);
        botonInicio.addActionListener(e -> diseñoTarjetas.show(panelPrincipal, "Solteros"));
        panelInicio.add(botonInicio, BorderLayout.SOUTH);

        return panelInicio;
    }

    // Crear el panel de solteros
    private JPanel crearPanelSolteros() {
        JPanel panelSolteros = new JPanel(new BorderLayout());
        imagenSoltero = new JLabel();
        imagenSoltero.setHorizontalAlignment(SwingConstants.CENTER);
        panelSolteros.add(imagenSoltero, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton botonSmash = new JButton("SMASH");
        botonSmash.setFont(new Font("Arial", Font.BOLD, 20));
        botonSmash.setBackground(new Color(144, 238, 144)); // Verde claro
        botonSmash.setForeground(Color.WHITE);
        botonSmash.addActionListener(e -> manejarSmashOPasar(true));
        
        JButton botonPasar = new JButton("PASS");
        botonPasar.setFont(new Font("Arial", Font.BOLD, 20));
        botonPasar.setBackground(new Color(255, 99, 71)); // Rojo claro
        botonPasar.setForeground(Color.WHITE);
        botonPasar.addActionListener(e -> manejarSmashOPasar(false));

        panelBotones.add(botonSmash);
        panelBotones.add(botonPasar);
        panelSolteros.add(panelBotones, BorderLayout.SOUTH);

        cargarImagenSoltero(); // Cargar la imagen del primer soltero
        return panelSolteros;
    }

    private void manejarSmashOPasar(boolean esSmash) {
        if (esSmash) {
            listaSmash.add(solteros[solteroActual]);
        }
        solteroActual++;
        if (solteroActual < solteros.length) {
            cargarImagenSoltero();
        } else {
            mostrarResultados();
        }
    }

    private void cargarImagenSoltero() {
        String rutaImagenSoltero = "resources/images/" + solteros[solteroActual] + ".png";
        ImageIcon iconoSoltero = new ImageIcon(rutaImagenSoltero);
        imagenSoltero.setIcon(redimensionarImagen(iconoSoltero, 300, 300)); 
    }

    private ImageIcon redimensionarImagen(ImageIcon icono, int anchoMax, int altoMax) {
        Image img = icono.getImage();
        int ancho = icono.getIconWidth();
        int alto = icono.getIconHeight();

        double escala = Math.min((double) anchoMax / ancho, (double) altoMax / alto);
        int nuevoAncho = (int) (ancho * escala);
        int nuevoAlto = (int) (alto * escala);
        Image imagenRedimensionada = img.getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
        
        return new ImageIcon(imagenRedimensionada);
    }

    private JPanel crearPanelResultados() {
        JPanel panelResultados = new JPanel(new BorderLayout());
        panelResultados.setBackground(new Color(224, 255, 255)); // Color celeste claro

        JLabel etiquetaResultado = new JLabel("¡Tus matches!");
        etiquetaResultado.setFont(new Font("Arial", Font.BOLD, 24));
        etiquetaResultado.setHorizontalAlignment(SwingConstants.CENTER);
        panelResultados.add(etiquetaResultado, BorderLayout.NORTH);

        JPanel panelMatches = new JPanel(new GridLayout(0, 1, 10, 10));
        panelResultados.add(new JScrollPane(panelMatches), BorderLayout.CENTER);

        JButton botonFinalizar = new JButton("¡Gracias por usar TinderKids!");
        botonFinalizar.setFont(new Font("Arial", Font.BOLD, 20));
        botonFinalizar.setBackground(new Color(255, 182, 193));
        botonFinalizar.setForeground(Color.WHITE);
        botonFinalizar.addActionListener(e -> reproducirAudio("resources/audio/win.wav"));

        panelResultados.add(botonFinalizar, BorderLayout.SOUTH);
        panelResultados.putClientProperty("panelMatches", panelMatches);

        return panelResultados;
    }

    private void mostrarResultados() {
        JPanel panelResultados = (JPanel) panelPrincipal.getComponent(3); // Obtener el panel de resultados
        JPanel panelMatches = (JPanel) panelResultados.getClientProperty("panelMatches");

        panelMatches.removeAll(); 
        for (String match : listaSmash) {
            String rutaImagenMatch = "resources/images/" + match + ".png";
            ImageIcon iconoMatch = new ImageIcon(rutaImagenMatch);
            JLabel etiquetaMatch = new JLabel(redimensionarImagen(iconoMatch, 100, 100));
            etiquetaMatch.setHorizontalAlignment(SwingConstants.CENTER);
            panelMatches.add(etiquetaMatch);
        }

        panelMatches.revalidate();
        panelMatches.repaint();

        diseñoTarjetas.show(panelPrincipal, "Resultados");
    }

    private void reproducirAudio(String rutaArchivo) {
        try {
            File archivoAudio = new File(rutaArchivo);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoAudio);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TinderKidsApp();
    }
}
