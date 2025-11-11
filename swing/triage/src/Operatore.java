import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Operatore {
    private static String[] colori;
    private JButton invio;
    private JTextField nomeF;
    private JTextField cognomeF;
    private JTextField cfF;
    private JTextField idF;
    private JTextField motivoF;
    private JComboBox coloreF;

    // display collegato direttamente all'interfaccia dell'operatore
    private Display display;

    public Operatore() {
        colori = new String[]{"ROSSO", "GIALLO", "AZZURRO", "VERDE", "BIANCO"};
        display = new Display();
        initComponents();
        eListener();
    }

    public void eListener() {
        ActionListener listener = e -> {
            Object src = e.getSource();

            if (src == invio) {
                //ERRORE: NON FUNZIONA CLICK SU PULSANTE INVIO!
                //DEBUG
                System.out.println("click invio");


                // Crea un paziente con i campi inseriti
                String nome = nomeF.getText().toUpperCase();
                String cognome = cognomeF.getText().toUpperCase();
                String cf = cfF.getText().toUpperCase();
                String motivo = motivoF.getText().toUpperCase();
                String id = idF.getText().toUpperCase();
                String colore = (String) coloreF.getSelectedItem();

                Paziente paziente = new Paziente(nome, cognome, cf, motivo, id, colore);

                // inserisce il paziente nella lista di pazienti in base all'urgenza (al colore)
                int i = 0;
                for (Paziente p : display.listaPazienti) {
                    if (p.urgenza <= paziente.urgenza) {
                        display.listaPazienti.add(i, paziente);
                        break;
                    }
                    i++;
                }
                display.aggiorna();
            }
        };

        invio.addActionListener(listener);
    }

    public void initComponents() {
        // Inserisce tutti i campi, il bottone di invio e le etichette
        JFrame f = new JFrame();
        f.setSize(1000, 500);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        int x = 5;
        int y = 5;

        JLabel nome = new JLabel("Nome:");
        nome.setBounds(x, y, 300, 30);
        nome.setFont(new java.awt.Font("Segoe UI", 0, 20));
        f.add(nome);

        y += 35;
        nomeF = new JTextField();
        nomeF.setBounds(x, y, 300, 30);
        nomeF.setFont(new java.awt.Font("Segoe UI", 0, 20));
        f.add(nomeF);

        y += 35;
        JLabel cognome = new JLabel("Cognome:");
        cognome.setBounds(x, y, 300, 30);
        cognome.setFont(new java.awt.Font("Segoe UI", 0, 20));
        f.add(cognome);

        y += 35;
        cognomeF = new JTextField();
        cognomeF.setBounds(x, y, 300, 30);
        cognomeF.setFont(new java.awt.Font("Segoe UI", 0, 20));
        f.add(cognomeF);

        y += 35;
        JLabel cf = new JLabel("Codice fiscale:");
        cf.setBounds(x, y, 300, 30);
        cf.setFont(new java.awt.Font("Segoe UI", 0, 20));
        f.add(cf);

        y += 35;
        cfF = new JTextField();
        cfF.setBounds(x, y, 300, 30);
        cfF.setFont(new java.awt.Font("Segoe UI", 0, 20));
        f.add(cfF);

        y += 35;
        JLabel motivo = new JLabel("Motivo:");
        motivo.setBounds(x, y, 300, 30);
        motivo.setFont(new java.awt.Font("Segoe UI", 0, 20));
        f.add(motivo);

        y += 35;
        motivoF = new JTextField();
        motivoF.setBounds(x, y, 300, 30);
        motivoF.setFont(new java.awt.Font("Segoe UI", 0, 20));
        f.add(motivoF);

        x = 600;
        y = 5;
        JLabel id = new JLabel("Codice identificativo:");
        cf.setBounds(x, y, 300, 30);
        cf.setFont(new java.awt.Font("Segoe UI", 0, 20));
        f.add(cf);

        y += 35;
        idF = new JTextField();
        idF.setBounds(x, y, 300, 30);
        idF.setFont(new java.awt.Font("Segoe UI", 0, 20));
        f.add(idF);

        y += 35;
        JLabel colore = new JLabel("Colore");
        colore.setBounds(x, y, 300, 30);
        colore.setFont(new java.awt.Font("Segoe UI", 0, 20));
        f.add(colore);

        y += 35;
        coloreF = new JComboBox(colori);
        coloreF.setBounds(x, y, 300, 30);
        coloreF.setFont(new java.awt.Font("Segoe UI", 0, 20));
        f.add(coloreF);

        y += 50;
        invio = new JButton("INVIA");
        invio.setBounds(x, y, 90, 40);
        invio.setFont(new java.awt.Font("Segoe UI", 0, 20));
        f.add(invio);
    }
}
