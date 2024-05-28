package Views.panels;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class PetTableModel extends AbstractTableModel {
    private List<String> petNames;
    private List<String> petTypes;
    private List<String> petRazes;
    private List<String> petResponsibles;
    private final String[] columnNames = new String[]{"Nombre", "Tipo", "Raza", "Responsable Principal"};

    public PetTableModel(List<String> petNames, List<String> petTypes, List<String> petRazes, List<String> petResponsibles) {
        this.petNames = petNames;
        this.petTypes = petTypes;
        this.petRazes = petRazes;
        this.petResponsibles = petResponsibles;
    }

    @Override
    public int getRowCount() {
        return petNames.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return petNames.get(rowIndex);
            case 1:
                return petTypes.get(rowIndex);
            case 2:
                return petRazes.get(rowIndex);
            case 3:
                return petResponsibles.get(rowIndex);
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void updateData(List<String> petNames, List<String> petTypes, List<String> petRazes, List<String> petResponsibles) {
        this.petNames = petNames;
        this.petTypes = petTypes;
        this.petRazes = petRazes;
        this.petResponsibles = petResponsibles;
        fireTableDataChanged();
    }
}