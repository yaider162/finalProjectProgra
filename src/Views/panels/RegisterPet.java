package Views.panels;

import Models.GLOBALS;
import Models.Vaccine;
import Models.Vet;
import Presenter.Presenter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class RegisterPet extends JPanel {
    private JTextField petName;
    private JComboBox<String> getPetType;
    private JComboBox<String> petRaze;
    private JTextField PrincipalResponsible;
    public JList<String> vaccines;

    public String[] razesDogs = {"Labrador Retriever", "Pastor Alemán", "Golden Retriever", "Bulldog Francés", "Bulldog", "Beagle", "Poodle", "Rottweiler", "Yorkshire Terrier", "Boxer"};
    public String[] razesCats = {"Siamés","Persa","Main", "Ragdoll", "Bengala", "Siberiano", "Sphynx", "British Shorthair", "Scottish Fold", "Munchkin"};

    public Presenter presenter = new Presenter();
    public RegisterPet() throws IOException, FontFormatException {
        initComponents();
    }

    private void initComponents() throws IOException, FontFormatException {
        this.setLayout(new GridBagLayout());
        this.setBackground(GLOBALS.MainColor);
        GridBagConstraints constraints = new GridBagConstraints();

        initPetName(constraints);
        initPetType(constraints);
        initPetRaze(constraints);
        initPrincipalResponsible(constraints);
        initVaccines(constraints);
        initRegisterButton(constraints);
    }

    private void initPetName(GridBagConstraints constraints) throws IOException, FontFormatException {
        constraints.gridx = 0;
        constraints.gridy = 0;
        inputText petNameLabel = new inputText("Nombre de la mascota");
        this.add(petNameLabel, constraints);
        petName = new JTextField(20);
        constraints.gridx = 1;
        this.add(petName, constraints);
    }

    private void initPetType(GridBagConstraints constraints) throws IOException, FontFormatException {
        constraints.weighty =0.5;
        constraints.fill = GridBagConstraints.HORIZONTAL;

        constraints.gridx = 0;
        constraints.gridy = 1;
        inputText petTypeLabel = new inputText("Tipo de mascota");
        this.add(petTypeLabel,constraints);
        getPetType = new JComboBox<>(new String[]{"Perro", "Gato"});
        constraints.gridx = 1;
        this.add(getPetType, constraints);
    }

    private void initPetRaze(GridBagConstraints constraints) throws IOException, FontFormatException {
        constraints.gridx = 0;
        constraints.gridy = 2;
        inputText petRazeLabel = new inputText("Raza de la mascota");
        this.add(petRazeLabel, constraints);
        if(Objects.equals(getPetType.getSelectedItem(), "Perro")){
            petRaze = new JComboBox<>(razesDogs);
        }else{
            petRaze = new JComboBox<>(razesCats);
        }
        constraints.gridx = 1;
        this.add(petRaze, constraints);
    }

    private void initPrincipalResponsible(GridBagConstraints constraints) throws IOException, FontFormatException {
        constraints.gridx = 0;
        constraints.gridy = 3;
        inputText PrincipalResponsibleLabel = new inputText("Responsable principal");
        this.add(PrincipalResponsibleLabel, constraints);
        PrincipalResponsible = new JTextField(20);
        constraints.gridx = 1;
        this.add(PrincipalResponsible, constraints);
    }

    private void initVaccines(GridBagConstraints constraints) throws IOException, FontFormatException {
        constraints.gridx = 0;
        constraints.gridy = 4;
        inputText vaccinesLabel = new inputText("Vacunas");
        this.add(vaccinesLabel, constraints);
        vaccines = new JList<>(presenter.getVaccines().toArray(new String[0]));
        constraints.gridx = 1;
        this.add(vaccines, constraints);
    }

    private void initRegisterButton(GridBagConstraints constraints) throws IOException, FontFormatException {
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 2;
        this.add(new Button("Registrar", GLOBALS.normalButtonSize), constraints);
    }
}