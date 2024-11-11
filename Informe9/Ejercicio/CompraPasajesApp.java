// Importamos las librerías necesarias
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Clase principal de la aplicación de compra de pasajes
public class CompraPasajesApp extends JFrame {
    private JTextField campoNombre, campoDocumento, campoFechaViaje; // Campos de texto para datos del pasajero
    private JCheckBox checkAudifonos, checkManta, checkRevista; // Opciones de servicios opcionales
    private JRadioButton radioPiso1, radioPiso2; // Opciones de piso
    private JComboBox<String> comboOrigen, comboDestino; // ComboBox para origen y destino
    private JList<String> listaCalidadServicio; // Lista de calidad de servicio
    private JButton botonMostrarResumen, botonReiniciar; // Botones de acción

    // Constructor donde creamos y organizamos la interfaz
    public CompraPasajesApp() {
        super("Compra de Pasajes"); // Título de la ventana
        setLayout(new GridBagLayout()); // Usamos GridBagLayout para mejor ajuste
        GridBagConstraints gbc = new GridBagConstraints(); // Controla posición de componentes

        // Panel para los datos del pasajero
        JPanel panelDatos = new JPanel(new GridBagLayout());
        panelDatos.setBorder(BorderFactory.createTitledBorder("Datos del Pasajero"));
        panelDatos.setBackground(new Color(240, 248, 255)); // Fondo azul claro
        gbc.insets = new Insets(5, 5, 5, 5); // Espacio entre componentes

        // Etiqueta y campo para el nombre
        gbc.gridx = 0; gbc.gridy = 0;
        panelDatos.add(new JLabel("Nombre:"), gbc);
        campoNombre = new JTextField(15);
        gbc.gridx = 1; gbc.gridy = 0;
        panelDatos.add(campoNombre, gbc);

        // Etiqueta y campo para el documento
        gbc.gridx = 0; gbc.gridy = 1;
        panelDatos.add(new JLabel("Documento de Identidad:"), gbc);
        campoDocumento = new JTextField(15);
        gbc.gridx = 1; gbc.gridy = 1;
        panelDatos.add(campoDocumento, gbc);

        // Etiqueta y campo para la fecha de viaje
        gbc.gridx = 0; gbc.gridy = 2;
        panelDatos.add(new JLabel("Fecha de Viaje:"), gbc);
        campoFechaViaje = new JTextField(10);
        gbc.gridx = 1; gbc.gridy = 2;
        panelDatos.add(campoFechaViaje, gbc);

        // Panel para opciones adicionales
        JPanel panelOpciones = new JPanel(new FlowLayout());
        panelOpciones.setBorder(BorderFactory.createTitledBorder("Opciones de Viaje"));
        panelOpciones.setBackground(new Color(240, 248, 255));

        // Casillas para servicios opcionales
        checkAudifonos = new JCheckBox("Audífonos");
        checkManta = new JCheckBox("Manta");
        checkRevista = new JCheckBox("Revista");
        panelOpciones.add(checkAudifonos);
        panelOpciones.add(checkManta);
        panelOpciones.add(checkRevista);

        // Botones de opción para elegir el piso
        radioPiso1 = new JRadioButton("1er Piso");
        radioPiso2 = new JRadioButton("2do Piso");
        ButtonGroup grupoPiso = new ButtonGroup(); // Agrupamos los botones de opción
        grupoPiso.add(radioPiso1);
        grupoPiso.add(radioPiso2);
        panelOpciones.add(radioPiso1);
        panelOpciones.add(radioPiso2);

        // Panel para la ruta del viaje
        JPanel panelRuta = new JPanel(new GridBagLayout());
        panelRuta.setBorder(BorderFactory.createTitledBorder("Ruta del Viaje"));
        panelRuta.setBackground(new Color(240, 248, 255));

        // Combo box para origen
        gbc.gridx = 0; gbc.gridy = 0;
        panelRuta.add(new JLabel("Origen:"), gbc);
        comboOrigen = new JComboBox<>(new String[]{"Lima", "Arequipa", "Cusco", "Puno"});
        gbc.gridx = 1; gbc.gridy = 0;
        panelRuta.add(comboOrigen, gbc);

        // Combo box para destino
        gbc.gridx = 0; gbc.gridy = 1;
        panelRuta.add(new JLabel("Destino:"), gbc);
        comboDestino = new JComboBox<>(new String[]{"Lima", "Arequipa", "Cusco", "Puno"});
        gbc.gridx = 1; gbc.gridy = 1;
        panelRuta.add(comboDestino, gbc);

        // Lista de calidad de servicio
        gbc.gridx = 0; gbc.gridy = 2;
        panelRuta.add(new JLabel("Calidad de Servicio:"), gbc);
        listaCalidadServicio = new JList<>(new String[]{"Económico", "Standard", "VIP"});
        listaCalidadServicio.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        gbc.gridx = 1; gbc.gridy = 2;
        panelRuta.add(new JScrollPane(listaCalidadServicio), gbc);

        // Panel para los botones
        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.setBackground(new Color(240, 248, 255));

        // Botón para mostrar el resumen
        botonMostrarResumen = new JButton("Mostrar Resumen");
        botonMostrarResumen.setBackground(new Color(173, 216, 230)); // Fondo azul claro
        panelBotones.add(botonMostrarResumen);

        // Botón para reiniciar todos los campos
        botonReiniciar = new JButton("Reiniciar");
        botonReiniciar.setBackground(new Color(255, 182, 193)); // Fondo rosa claro
        panelBotones.add(botonReiniciar);

        // Agregamos los paneles principales a la ventana usando GridBagConstraints
        gbc.gridx = 0; gbc.gridy = 0; gbc.fill = GridBagConstraints.HORIZONTAL;
        add(panelDatos, gbc);
        gbc.gridy = 1;
        add(panelOpciones, gbc);
        gbc.gridy = 2;
        add(panelRuta, gbc);
        gbc.gridy = 3;
        add(panelBotones, gbc);

        // Acción para mostrar el resumen
        botonMostrarResumen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crea el resumen con todos los datos ingresados
                String resumen = "Nombre: " + campoNombre.getText() + "\n"
                        + "Documento: " + campoDocumento.getText() + "\n"
                        + "Fecha de Viaje: " + campoFechaViaje.getText() + "\n"
                        + "Servicios Opcionales: " 
                        + (checkAudifonos.isSelected() ? "Audífonos " : "")
                        + (checkManta.isSelected() ? "Manta " : "")
                        + (checkRevista.isSelected() ? "Revista " : "") + "\n"
                        + "Piso: " + (radioPiso1.isSelected() ? "1er Piso" : "2do Piso") + "\n"
                        + "Origen: " + comboOrigen.getSelectedItem() + "\n"
                        + "Destino: " + comboDestino.getSelectedItem() + "\n"
                        + "Calidad de Servicio: " + listaCalidadServicio.getSelectedValue();

                // Muestra el resumen en un cuadro de diálogo
                JOptionPane.showMessageDialog(null, resumen, "Resumen del Pasaje", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Acción para reiniciar todos los campos
        botonReiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                campoNombre.setText("");
                campoDocumento.setText("");
                campoFechaViaje.setText("");
                checkAudifonos.setSelected(false);
                checkManta.setSelected(false);
                checkRevista.setSelected(false);
                radioPiso1.setSelected(true);
                comboOrigen.setSelectedIndex(0);
                comboDestino.setSelectedIndex(0);
                listaCalidadServicio.clearSelection();
            }
        });
    }

    // Método principal
    public static void main(String[] args) {
        CompraPasajesApp app = new CompraPasajesApp();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(400, 600);
        app.setLocationRelativeTo(null);
        app.setVisible(true);
    }
}
