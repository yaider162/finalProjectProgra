package Views.panels;

import Presenter.Presenter;
import Views.MainPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Header extends JPanel{

    private MainPage frame;

    public Header(MainPage frame, Presenter presenter) throws IOException, FontFormatException {
        this.frame = frame;
        initComponents(presenter);
    }

    private void initComponents(Presenter presenter) throws IOException, FontFormatException {
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 15));
        this.setBackground(Models.GLOBALS.BEIGE);
        for (String text : Models.GLOBALS.headerButtonsText) {
            Button button = new Button(text, Models.GLOBALS.buttonSize);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.getContentPane().removeAll();
                    try {
                        frame.addNewPanel(new Header(frame, presenter), BorderLayout.NORTH);
                        switch (text) {
                            case "Lista de citas":
                                frame.addNewPanel(new Views.panels.AppointmentsList(frame,presenter), BorderLayout.CENTER);
                                break;
                            case "Lista de vacunas":
                                frame.addNewPanel(new Views.panels.VaccinesList(frame, presenter), BorderLayout.CENTER);
                                break;
                            case "Agregar cita":
                                frame.addNewPanel(new Views.panels.NewAppointment(frame,presenter), BorderLayout.CENTER);
                                break;
                            case "Principal":
                                frame.addNewPanel(new Views.panels.Body(frame, presenter), BorderLayout.CENTER);
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
