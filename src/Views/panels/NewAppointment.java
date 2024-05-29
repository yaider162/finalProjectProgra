package Views.panels;

import Presenter.Presenter;
import Views.MainPage;
import com.toedter.calendar.JCalendar;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class NewAppointment extends JPanel{
    private JTextField petName;
    private JTextField ownerName;
    private JCalendar date;
    private JComboBox<String> specie;
    private JComboBox<String> sex;

    private GridBagConstraints gbc = new GridBagConstraints();
    private JTextField ownerId;
    private Button register;
    public NewAppointment(MainPage frame,Presenter presenter) throws IOException, FontFormatException {
        initComponents(frame,presenter);
    }
    private void initComponents(MainPage frame, Presenter presenter) throws IOException, FontFormatException {
        this.setLayout(new FlowLayout());
        this.setBackground(Models.GLOBALS.MainColor);
        gbc.weightx = 0.1;
        gbc.weighty = 0.1;
        addPetName();
        addOwnerName();
        addOwnerId();
        addSpecie();
        addSex();
        addDate();
        addRegisterButton(frame,presenter);
    }
    private void addDate() {
        this.add(new JLabel("Fecha de la cita:"), gbc);
        date = new JCalendar();
        this.add(date, gbc);
    }
    private void addSex() {
        this.add(new JLabel("Sexo:"), gbc);
        sex = new JComboBox<>(new String[]{"Macho", "Hembra"});
        this.add(sex);
    }
    private void addSpecie() {
        this.add(new JLabel("Especie:"), gbc);
        specie = new JComboBox<>(new String[]{"Perro", "Gato"});
        this.add(specie, gbc);
    }
    private void addOwnerName() {
        this.add(new JLabel("Nombre del dueño:"), gbc);
        ownerName = new JTextField(20);
        this.add(ownerName, gbc);
    }
    private void addOwnerId() {
        this.add(new JLabel("CC del dueño:"), gbc);
        ownerId = new JTextField(20);
        this.add(ownerId, gbc);
    }
    private void addPetName() {
        this.add(new JLabel("Nombre de la mascota:"), gbc);
        petName = new JTextField(20);
        this.add(petName, gbc);
    }
    public void addRegisterButton(MainPage frame,Presenter presenter) throws IOException, FontFormatException {
        register = new Button("Registrar", new Dimension(100, 50));
        this.add(register, gbc);
        register.addActionListener(e -> {
            try {
                presenter.addNewAppointment(petName.getText(), ownerName.getText(), ownerId.getText(), (String) specie.getSelectedItem(),(String) sex.getSelectedItem(), date.getDate());
                frame.getContentPane().removeAll();
                frame.addNewPanel(new Header(frame, presenter), BorderLayout.NORTH);
                frame.addNewPanel(new Body(frame, presenter), BorderLayout.CENTER);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }
}
