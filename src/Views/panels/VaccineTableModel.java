package Views.panels;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class VaccineTableModel extends AbstractTableModel {
    private List<String> vaccinesName;
    private List<String> vaccinesDeadline;
    private final String[] columnNames = new String[]{"Nombre", "Fecha de vencimiento"};

    public VaccineTableModel(List<String> vaccinesName, List<String> vaccinesDeadline) {
        this.vaccinesName = vaccinesName;
        this.vaccinesDeadline = vaccinesDeadline;
    }

    @Override
    public int getRowCount() {
        return vaccinesName.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return vaccinesName.get(rowIndex);
            case 1:
                return vaccinesDeadline.get(rowIndex);
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void updateData(List<String> vaccinesName, List<String> vaccinesDeadline) {
        this.vaccinesName = vaccinesName;
        this.vaccinesDeadline = vaccinesDeadline;
        fireTableDataChanged();
    }
}
