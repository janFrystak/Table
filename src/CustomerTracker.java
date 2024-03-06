import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class CustomerTracker extends AbstractTableModel {
    private List<Customer> list = new ArrayList<>();

    public CustomerTracker(){
        list.addAll(
                List.of(
                        new Customer("Karel"),
                        new Customer("Jindra")
                )
        );
    }
    public void addCustomer(Customer customer) {
        list.add(customer);
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Customer currentCustomer = list.get(rowIndex);
        switch (columnIndex) {
            case 0 -> {
                return currentCustomer.getId();
            }
            case 1 -> {
                return currentCustomer.getName();
            }
        }
        throw new RuntimeException("At column " + columnIndex + ", and at row " + rowIndex);
    }
}
