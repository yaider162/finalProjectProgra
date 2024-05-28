package Views.panels;

import Models.GLOBALS;
import Presenter.Presenter;
import Views.MainPage;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class RegisterVaccine extends JPanel {
    public Presenter presenter = new Presenter();
    private JTextField vaccineName;
    private JTextField vaccineExpirationDate;
    private JSpinner dateSpinner;
    private MainPage frame;

    public RegisterVaccine(MainPage frame) throws IOException, FontFormatException {
        initComponents(frame);
    }

    private void initComponents(MainPage frame) throws IOException, FontFormatException {
        this.setLayout(new GridBagLayout());
        this.setBackground(GLOBALS.MainColor);
        GridBagConstraints constraints = new GridBagConstraints();

        initVaccineName(constraints);
        initVaccineExpirationDate(constraints);
        initRegisterButton(constraints,frame);
    }

    private void initVaccineName(GridBagConstraints constraints) throws IOException, FontFormatException {
        constraints.gridx = 0;
        constraints.gridy = 0;
        inputText vaccineNameLabel = new inputText("Nombre de la vacuna:");
        this.add(vaccineNameLabel, constraints);
        vaccineName = new JTextField(20);
        constraints.gridx = 1;
        this.add(vaccineName, constraints);
    }

    private void initVaccineExpirationDate(GridBagConstraints constraints) throws IOException, FontFormatException {
        constraints.gridx = 0;
        constraints.gridy = 3;
        inputText vaccineExpirationDateLabel = new inputText("Fecha de vencimiento:");
        this.add(vaccineExpirationDateLabel, constraints);
        Date initialDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -100);
        Date earliestDate = calendar.getTime();
        calendar.add(Calendar.YEAR, 200);
        Date latestDate = calendar.getTime();
        SpinnerModel dateModel = new SpinnerDateModel(initialDate, earliestDate, latestDate, Calendar.YEAR);

        dateSpinner = new JSpinner(dateModel);
        dateSpinner.setEditor(new JSpinner.DateEditor(dateSpinner, "dd/MM/yyyy"));
        constraints.gridx = 1;
        this.add(dateSpinner, constraints);
    }

    private void initRegisterButton(GridBagConstraints constraints, MainPage frame) {
        constraints.gridx = 0;
        constraints.gridy = 4;
        JButton registerButton = new JButton("Registrar");
        registerButton.addActionListener(e -> {
            String name = vaccineName.getText();
            Date expirationDate = (Date) dateSpinner.getValue();
            presenter.addVaccine(name, expirationDate);
            frame.getContentPane().removeAll();
            try {
                frame.addNewPanel(new Header(frame), BorderLayout.NORTH);
                frame.addNewPanel(new Body(frame), BorderLayout.CENTER);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        this.add(registerButton, constraints);
    }
}
