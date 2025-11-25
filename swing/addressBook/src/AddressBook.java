import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class AddressBook {
    private ArrayList<Contact> book;

    public AddressBook() {
        book = new ArrayList<>();
        String file = "./data.csv"; //file path
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

    private void save(String fileName) {
        try {
            FileWriter o = new FileWriter(fileName);
            BufferedWriter out = new BufferedWriter(o);
            String s;
            for (Contact c : book) {
                s = String.join(",", c.getName(), c.getSurname(), c.getEmail(), c.getMobile(), c.getAddress());
                out.write(s);
                out.newLine();
                out.flush();
            }
            o.close();
            out.close();
        } catch (Exception e) {
            System.out.println("Errore in scrittura del file");
        }
    }

    private void importFromFiles(String fileName) {
        try {
            FileReader i = new FileReader(fileName);
            BufferedReader in = new BufferedReader(i);
            String s;
            while ((s = in.readLine()) != null) {
                String[] strings = s.split(",");
                for (String s : strings) {
                    System.out.println(s);
                }
                in.readLine();
            }
            i.close();
            in.close();
        } catch (Exception e) {
            System.out.println("Errore in lettura del file");
        }
    }
}