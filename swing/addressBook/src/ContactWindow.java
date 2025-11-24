import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ContactWindow extends JDialog implements ActionListener {

    private JTextField tfName, tfSurname, tfEmail, tfMobile, tfAddress;
    private JButton saveButton, cancelButton;
    private Contact contact; // contatto esistente (modifica) o null (nuovo)
    private AddressBook addressBook;
    private GraphicBook parent;

    public ContactWindow(Frame owner, AddressBook book, Contact contact, GraphicBook parent) {
        super(owner, true); // finestra modale
        this.contact = contact;
        this.addressBook = book;
        this.parent = parent;
        setTitle(contact == null ? "Nuovo Contatto" : "Modifica Contatto");
        initComponents();
        pack();
        setLocationRelativeTo(owner);
        setVisible(true);
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        JPanel fieldsPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        fieldsPanel.add(new JLabel("Name:"));
        tfName = new JTextField(contact != null ? contact.getName() : "");
        fieldsPanel.add(tfName);

        fieldsPanel.add(new JLabel("Surname:"));
        tfSurname = new JTextField(contact != null ? contact.getSurname() : "");
        fieldsPanel.add(tfSurname);

        fieldsPanel.add(new JLabel("Email:"));
        tfEmail = new JTextField(contact != null ? contact.getEmail() : "");
        fieldsPanel.add(tfEmail);

        fieldsPanel.add(new JLabel("Mobile:"));
        tfMobile = new JTextField(contact != null ? contact.getMobile() : "");
        fieldsPanel.add(tfMobile);

        fieldsPanel.add(new JLabel("Address:"));
        tfAddress = new JTextField(contact != null ? contact.getAddress() : "");
        fieldsPanel.add(tfAddress);

        add(fieldsPanel, BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel();
        saveButton = new JButton("Salva");
        cancelButton = new JButton("Annulla");
        buttonsPanel.add(saveButton);
        buttonsPanel.add(cancelButton);
        add(buttonsPanel, BorderLayout.SOUTH);

        saveButton.addActionListener(this);
        cancelButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == saveButton) {
            if (contact == null) { // nuovo contatto
                Contact c = new Contact(tfName.getText(), tfSurname.getText(), tfEmail.getText(), tfMobile.getText(), tfAddress.getText());
                addressBook.addContact(c);
            } else { // modifica contatto esistente
                contact.setName(tfName.getText());
                contact.setSurname(tfSurname.getText());
                contact.setEmail(tfEmail.getText());
                contact.setMobile(tfMobile.getText());
                contact.setAddress(tfAddress.getText());
            }
            parent.refreshTable(); // aggiorna la tabella nella finestra principale
            dispose();
        } else if (source == cancelButton) {
            dispose();
        }
    }
}