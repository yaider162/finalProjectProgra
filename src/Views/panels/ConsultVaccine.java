package Views.panels;

import Models.GLOBALS;
import Presenter.Presenter;

import javax.swing.*;
import java.awt.*;

public class ConsultVaccine extends JPanel {
    Presenter presenter = new Presenter();

    public ConsultVaccine() {
        initComponents();
    }

    private void initComponents() {
        this.setLayout(new GridBagLayout());
        this.setBackground(GLOBALS.MainColor);
        vaccineTable();
    }

    private void vaccineTable() {
        VaccineTableModel model = new VaccineTableModel(presenter.getVaccinesName(), presenter.getVaccinesDeadline());
        JTable table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane);
    }
}
