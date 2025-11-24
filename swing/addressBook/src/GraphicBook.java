import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class GraphicBook extends JFrame implements ActionListener {
    private AddressBook addressBook;
    private JTable table;
    private DefaultTableModel tableModel;

    private JTextField tfSearch;
    private JButton addButton, editButton, removeButton, searchButton;

    public GraphicBook(AddressBook book) {
        this.addressBook = book;
        initComponents();
        setTitle("Address Book");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initComponents() {
        setLayout(new BorderLayout(5,5));

        // Barra di ricerca
        JPanel searchPanel = new JPanel(new BorderLayout(5,5));
        tfSearch = new JTextField();
        searchButton = new JButton("Search");
        searchPanel.add(new JLabel("Search:"), BorderLayout.WEST);
        searchPanel.add(tfSearch, BorderLayout.CENTER);
        searchPanel.add(searchButton, BorderLayout.EAST);
        add(searchPanel, BorderLayout.NORTH);

        // Tabella contatti
        tableModel = new DefaultTableModel(new String[]{"Name", "Surname", "Email", "Mobile", "Address"}, 0);
        table = new JTable(tableModel);
        refreshTable();
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Pannello bottoni
        JPanel buttonPanel = new JPanel();
        addButton = new JButton("Add");
        editButton = new JButton("Edit");
        removeButton = new JButton("Remove");

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(removeButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Listener
        addButton.addActionListener(this);
        editButton.addActionListener(this);
        removeButton.addActionListener(this);
        searchButton.addActionListener(this);
    }

    public void refreshTable() {
        tableModel.setRowCount(0);
        for (Contact c : addressBook.getAllContacts()) {
            tableModel.addRow(new Object[]{c.getName(), c.getSurname(), c.getEmail(), c.getMobile(), c.getAddress()});
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == addButton) {
            new ContactWindow(this, addressBook, null, this); // nuovo contatto
        } else if (source == editButton) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                Contact selected = addressBook.getAllContacts().get(selectedRow);
                new ContactWindow(this, addressBook, selected, this); // modifica contatto
            } else {
                JOptionPane.showMessageDialog(this, "Seleziona un contatto da modificare.");
            }
        } else if (source == removeButton) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                Contact c = addressBook.getAllContacts().get(selectedRow);
                addressBook.removeContact(c);
                refreshTable();
            }
        } else if (source == searchButton) {
            String query = tfSearch.getText().toLowerCase();
            boolean found = false;
            for (int i = 0; i < table.getRowCount(); i++) {
                String name = table.getValueAt(i, 0).toString().toLowerCase();
                String surname = table.getValueAt(i, 1).toString().toLowerCase();
                if (name.equals(query) || surname.equals(query)) {
                    table.setRowSelectionInterval(i, i);
                    table.scrollRectToVisible(table.getCellRect(i, 0, true));
                    found = true;
                    break;
                }
            }
            if (!found) {
                JOptionPane.showMessageDialog(this, "Contact not found.");
            }
        }
    }
}