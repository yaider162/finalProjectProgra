package Views.panels;

import Models.GLOBALS;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Body extends JPanel {
    public Body() throws IOException, FontFormatException {
        initComponents();
    }
    private void initComponents() throws IOException, FontFormatException {
        this.setLayout(new GridBagLayout());
        this.setBackground(GLOBALS.MainColor);
        GridBagConstraints constraints= new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weighty = 1;
        this.add(image(), constraints); //añado imagen
        constraints.gridy = 1;
        this.add(new Button("Registrar mascota", GLOBALS.normalButtonSize), constraints); // añado el button

        // Está organizado con un GridBagLayout, que es un layout que permite organizar los componentes en una cuadrícula.
    }
    private JLabel image(){
        ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("../../assets/petLogo.jpg")));
        Image image = imageIcon.getImage();
        BufferedImage resizedImage = new BufferedImage(400, 400, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(image, 0, 0, 400, 400, null);
        g2d.dispose();
        ImageIcon scaledIcon = new ImageIcon(resizedImage);
        return new JLabel(scaledIcon);
    }
}
