package util;

import java.awt.*;
import javax.swing.*;

public class BackgroundPanel extends JPanel {
    private Image imagen;

    public BackgroundPanel(String ruta) {
        //getResource para acceder al recurso dentro del proyecto
        java.net.URL location = getClass().getResource(ruta);
        if (location != null) {
            imagen = new ImageIcon(location).getImage();
        } else {
            System.err.println("❌ No se encontró la imagen: " + ruta);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
