import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraficoTemperaturas extends JPanel {
    private int[] temperaturas = new int[7];
    private boolean datosIngresados = false;

    public GraficoTemperaturas() {
        JFrame frame = new JFrame("Gráfico UwU de temperaturas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);

        JPanel inputPanel = new JPanel(new FlowLayout());
        JTextField[] tempFields = new JTextField[7];
        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};

        for (int i = 0; i < 7; i++) {
            inputPanel.add(new JLabel(dias[i] + ":"));
            tempFields[i] = new JTextField(3);
            inputPanel.add(tempFields[i]);
        }

        JButton mostrarGraficoButton = new JButton("Mostrar Gráfico");
        mostrarGraficoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    for (int i = 0; i < 7; i++) {
                        temperaturas[i] = Integer.parseInt(tempFields[i].getText());
                    }
                    datosIngresados = true;
                    repaint();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Ingrese valores numéricos válidos para las temperaturas.");
                }
            }
        });

        frame.setLayout(new BorderLayout());
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(this, BorderLayout.CENTER);
        frame.add(mostrarGraficoButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!datosIngresados) return;

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();
        int margen = 50;
        int espacio = (width - 2 * margen) / 6;
        int maxTemp = 0;

        for (int temp : temperaturas) {
            maxTemp = Math.max(maxTemp, temp);
        }

        g2d.drawLine(margen, height - margen, width - margen, height - margen); // Eje X
        g2d.drawLine(margen, margen, margen, height - margen); // Eje Y

        for (int i = 0; i < temperaturas.length; i++) {
            int x = margen + i * espacio;
            int y = height - margen - (temperaturas[i] * (height - 2 * margen) / maxTemp);
            g2d.setColor(Color.RED);
            g2d.fillOval(x - 5, y - 5, 10, 10);

            if (i > 0) {
                int xPrev = margen + (i - 1) * espacio;
                int yPrev = height - margen - (temperaturas[i - 1] * (height - 2 * margen) / maxTemp);
                g2d.setColor(Color.BLUE);
                g2d.drawLine(xPrev, yPrev, x, y);
            }

            g2d.setColor(Color.BLACK);
            g2d.drawString(String.valueOf(temperaturas[i]), x - 10, y - 10);
        }
    }

    public static void main(String[] args) {
        new GraficoTemperaturas();
    }
}
