import javax.swing.*;
import java.util.ArrayList;

public class Display {
    JLabel lista;
    ArrayList<Paziente> listaPazienti;
    String s = "";

    public Display() {
        initComponents();
        listaPazienti = new ArrayList<>();
    }

    public void aggiorna() {
        lista.setText(toString());
    }

    public void initComponents() {
        // Una sola etichetta con la lista dei pazienti ordinata

        JFrame f = new JFrame();
        f.setSize(1000, 500);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        int x = 5;
        int y = 5;

        lista = new JLabel();
        lista.setBounds(x, y, 950, 400);
        lista.setFont(new java.awt.Font("Segoe UI", 0, 20));
        f.add(lista);
    }

    @Override
    public String toString() {
        for (Paziente p : listaPazienti) {
            s += p.toString() + "\n";
        }
        return s;
    }
}
