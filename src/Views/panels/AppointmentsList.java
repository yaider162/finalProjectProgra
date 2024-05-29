package Views.panels;

import Models.GLOBALS;
import Presenter.Presenter;
import Views.MainPage;

import javax.swing.*;

public class AppointmentsList extends JPanel {
    public AppointmentsList(MainPage frame, Presenter presenter) {
        initComponents(frame, presenter);
    }

    private void initComponents(MainPage frame, Presenter presenter) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(GLOBALS.MainColor);
        addTable(frame, presenter);
        fiteringButtons(frame,presenter);
    }

    private void addTable(MainPage frame, Presenter presenter) {
        String[] columnNames = {"Nombre mascota", "Nombre Dueño", "CC dueño", "Especie", "Sexo", "Fecha de cita"};
        String[][] data = presenter.getAppointments();
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane);
    }

    private void fiteringButtons(MainPage frame, Presenter presenter) {
        JButton filterByOwnerButton = new JButton("Filtrar por dueño");
        JButton filterByDateButton = new JButton("Filtrar por fecha");
        JButton clearButton = new JButton("Limpiar");
        this.add(filterByOwnerButton);
        this.add(filterByDateButton);
        this.add(clearButton);

        filterByOwnerButton.addActionListener(e -> {
            String owner = JOptionPane.showInputDialog("Ingrese el id del dueño");
            String[][] data = presenter.getAppointmentsByOwner(owner);
            updateTable(data);
            fiteringButtons(frame, presenter);
        });

        filterByDateButton.addActionListener(e -> {
            String date = JOptionPane.showInputDialog("Ingrese la fecha de la cita");
            String[][] data = presenter.getAppointmentsByDate(date);
            updateTable(data);
        });

        clearButton.addActionListener(e -> {
            clearTable(frame, presenter);
        });
    }

    private void clearTable(MainPage frame, Presenter presenter) {
        this.removeAll();
        initComponents(frame, presenter);
        this.revalidate();
        this.repaint();
    }

    private void updateTable(String[][] data) {
        this.removeAll();
        String[] columnNames = {"Nombre mascota", "Nombre Dueño", "CC dueño", "Especie", "Sexo", "Fecha de cita"};
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane);
        this.revalidate();
        this.repaint();
    }
}
