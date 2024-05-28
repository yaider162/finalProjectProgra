package Views.panels;

import Views.MainPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Header extends JPanel{

    private MainPage frame;

    public Header(MainPage frame) throws IOException, FontFormatException {
        this.frame = frame;
        initComponents();
    }

    private void initComponents() throws IOException, FontFormatException {
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 15));
        this.setBackground(Models.GLOBALS.BEIGE);
        for (String text : Models.GLOBALS.headerButtonsText) {
            Button button = new Button(text, Models.GLOBALS.buttonSize);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.getContentPane().removeAll();
                    try {
                        frame.addNewPanel(new Header(frame), BorderLayout.NORTH);
                        switch (text) {
                            case "Registrar Mascota":
                                frame.addNewPanel(new Views.panels.RegisterPet(frame), BorderLayout.CENTER);
                                break;
                            case "Registrar Vacuna":
                                frame.addNewPanel(new Views.panels.RegisterVaccine(frame), BorderLayout.CENTER);
                                break;
                            case "Consultar Vacuna":
                                frame.addNewPanel(new Views.panels.ConsultVaccine(), BorderLayout.CENTER);
                                break;
                            case "Citas":
                                frame.addNewPanel(new Views.panels.Appointments(frame), BorderLayout.CENTER);
                                break;
                            case "Consultar Mascota":
                                frame.addNewPanel(new Views.panels.ConsultPet(), BorderLayout.CENTER);
                                break;
                            case "Principal":
                                frame.addNewPanel(new Views.panels.Body(frame), BorderLayout.CENTER);
                                break;
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });
            this.add(button);
        }
    }
}
