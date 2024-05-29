package Views.panels;

import Presenter.Presenter;
import Views.MainPage;
import com.toedter.calendar.JCalendar;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

public class AddVaccine extends JPanel {
    private GridBagConstraints gbc = new GridBagConstraints();
    private JTextField name;
    private JComboBox<String> species;
    private JCalendar expirationDate;
    private Presenter presenter;

    public AddVaccine(MainPage frame, Presenter presenter){
        this.presenter = presenter;
        initComponents(frame);
    }
    private void initComponents(MainPage frame){
        this.setBackground(Models.GLOBALS.MainColor);
        this.setLayout(new GridBagLayout());
        try {
            gbc.weightx = 0.1;
            gbc.weighty = 0.1;

            addName();
            addSpecies();
            addExpirationDate();
            addRegisterButton(frame);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void addName() throws IOException, FontFormatException {
        name = new JTextField(20);
        inputText nameText = new inputText("Nombre de la vacuna:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(nameText, gbc);
        gbc.gridx = 1;
        this.add(name, gbc);
    }
    private void addSpecies() throws IOException, FontFormatException {
        species = new JComboBox<>(new String[]{"Perro", "Gato"});
        inputText speciesText = new inputText("Especie:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(speciesText, gbc);
        gbc.gridx = 1;
        this.add(species, gbc);
    }
    private void addExpirationDate() throws IOException, FontFormatException {
        expirationDate = new JCalendar();
        inputText expirationDateText = new inputText("Fecha de vencimiento:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        this.add(expirationDateText, gbc);
        gbc.gridx = 1;
        this.add(expirationDate, gbc);
    }
    private void addRegisterButton(MainPage frame) throws IOException, FontFormatException {
        Button register = new Button("Registrar", Models.GLOBALS.buttonSize);
        gbc.gridx = 1;
        gbc.gridy = 3;
        this.add(register, gbc);
        register.addActionListener(e -> {
            String vaccineName = name.getText();
            String vaccineSpecies = (String) species.getSelectedItem();
            Date vaccineExpirationDate = expirationDate.getDate();
            presenter.addVaccine(vaccineName, vaccineSpecies, vaccineExpirationDate);
            frame.getContentPane().removeAll();
            try {
                frame.addNewPanel(new Header(frame,presenter), BorderLayout.NORTH);
                frame.addNewPanel(new Body(frame, presenter), BorderLayout.CENTER);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        });
    }
}
