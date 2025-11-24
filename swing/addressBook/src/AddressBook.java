import java.util.ArrayList;

public class AddressBook {
    private ArrayList<Contact> book;

    public AddressBook() {
        book = new ArrayList<>();
    }

    public void addContact(Contact c) {
        book.add(c);
    }

    public void removeContact(Contact c) {
        book.remove(c);
    }

    public Contact searchByName(String name) {
        for (Contact c : book) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

    public ArrayList<Contact> getAllContacts() {
        return book;
    }

    public void updateContact(Contact oldC, Contact newC) {
        int index = book.indexOf(oldC);
        if (index != -1) {
            book.set(index, newC);
        }
    }
}