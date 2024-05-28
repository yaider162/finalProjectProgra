package Views.panels;

import Presenter.Presenter;
import Views.MainPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Appointments extends JPanel {
    private JComboBox<String> petSelector;
    private JComboBox<String> vaccineSelector;
    private Presenter presenter = new Presenter();

    public Appointments(MainPage frame) throws IOException, FontFormatException {
        initComponents(frame);
    }

    private void initComponents(MainPage frame) throws IOException, FontFormatException {
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 15));
        this.setBackground(Models.GLOBALS.MainColor);
        petSelector = new JComboBox<>(presenter.getPetNames().toArray(new String[0]));
        this.add(petSelector);
        vaccineSelector = new JComboBox<>(presenter.getVaccinesName().toArray(new String[0]));
        this.add(vaccineSelector);
        Button button = new Button("Registrar cita");
        this.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presenter.addAppointment(petSelector.getSelectedItem().toString(), vaccineSelector.getSelectedItem().toString());
                frame.getContentPane().removeAll();
                try {
                    frame.addNewPanel(new Header(frame), BorderLayout.NORTH);
                    frame.addNewPanel(new Body(frame), BorderLayout.CENTER);
                } catch (IOException | FontFormatException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
    }
}