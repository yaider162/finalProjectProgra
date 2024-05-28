package Views.panels;

import Models.GLOBALS;
import Presenter.Presenter;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import java.awt.*;
import java.util.ArrayList;

public class ConsultPet extends JPanel {
    Presenter presenter = new Presenter();
    public ConsultPet() {
        initComponents();
    }

    private void initComponents() {
        this.setLayout(new GridBagLayout());
        this.setBackground(GLOBALS.MainColor);
        petTable();
    }

    private void petTable() {
        PetTableModel model = new PetTableModel(presenter.getPetNames(), presenter.getPetTypes(), presenter.getPetRazes(), presenter.getPetResponsibles());
        JTable table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane);
    }

}
