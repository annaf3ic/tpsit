public class Main {
    public static void main(String[] args) {
        AddressBook book = new AddressBook();
        javax.swing.SwingUtilities.invokeLater(() -> {new GraphicBook(book);});
    }
}