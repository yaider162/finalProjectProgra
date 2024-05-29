package Views.panels;

import Models.GLOBALS;
import Presenter.Presenter;
import Views.MainPage;

import javax.swing.*;
import java.awt.*;

public class VaccinesList extends JPanel {
    public VaccinesList(MainPage frame, Presenter presenter) {
        initComponents(frame, presenter);
    }

    private void initComponents(MainPage frame, Presenter presenter) {
        this.setBackground(GLOBALS.MainColor);
        addTable(presenter);
        addVaccine(frame, presenter);
    }
    private void addTable(Presenter presenter){
        String[] columnNames = {"Nombre", "Especie", "Fecha de vencimiento"};
        String[][] data = presenter.getVaccines();
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane);
    }
    private void addVaccine(MainPage frame, Presenter presenter){
        try{
            Button addVaccine = new Button("Agregar vacuna", GLOBALS.buttonSize);
            this.add(addVaccine);
            addVaccine.addActionListener(e -> {
                try {
                    frame.getContentPane().removeAll();
                    frame.addNewPanel(new Header(frame, presenter), BorderLayout.NORTH);
                    frame.addNewPanel(new AddVaccine(frame, presenter), BorderLayout.CENTER);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
