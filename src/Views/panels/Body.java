package Views.panels;

import Models.GLOBALS;
import Presenter.Presenter;
import Views.MainPage;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Body extends JPanel {
    public Body(MainPage frame, Presenter presenter) throws IOException, FontFormatException {
        initComponents(frame, presenter);
    }
    private void initComponents(MainPage frame, Presenter presenter) throws IOException, FontFormatException {
        this.setLayout(new GridBagLayout());
        this.setBackground(GLOBALS.MainColor);
        GridBagConstraints constraints= new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weighty = 1;
        this.add(image(), constraints); //añado imagen
        constraints.gridy = 1;
        Button button = new Button("Registrar cita");
        this.add(button, constraints); // añado el button
        button.addActionListener(e -> {
            try {
                frame.getContentPane().removeAll();
                frame.addNewPanel(new Header(frame,presenter), BorderLayout.NORTH);
                frame.addNewPanel(new NewAppointment(frame,presenter), BorderLayout.CENTER);
            } catch (IOException | FontFormatException ioException) {
                ioException.printStackTrace();
            }
        });
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
