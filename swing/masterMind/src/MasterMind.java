import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class MasterMind extends JFrame {
    private static String[] colors;
    private static ArrayList<JLabel> labels;
    private ArrayList<String> pattern;
    private ArrayList<String> patternIta;
    private int numberOfButtons;
    private ArrayList<JButton> buttons = new ArrayList<>();
    private JButton invio;
    private JLabel winLabel;
    private JButton restart;
    private JComboBox numberOfButtonsBox;
    private int numberOfChances;
    private JComboBox numberOfChancesBox;

    public MasterMind() {
        colors = new String[]{"#B31B1B", "#ED9121", "#FFD700", "#228B22", "#0070BB", "#9966CC"};
        initComponents();
        resetGame();
        eListener();
    }

    private void generatePattern() {
        Random random = new Random();
        pattern = new ArrayList<>();
        for (int i=0; i<numberOfButtons; i++) {
            pattern.add(colors[random.nextInt(colors.length)]);
        }

        patternIta = new ArrayList<>();
        for (String s : pattern) patternIta.add(hexToIta(s));
        System.out.println(patternIta); // per debug
    }

    private static String hexToIta(String s) {
        switch (s) {
            case "#B31B1B": return "ROSSO";
            case "#ED9121": return "ARANCIONE";
            case "#FFD700": return "GIALLO";
            case "#228B22": return "VERDE";
            case "#0070BB": return "BLU";
            case "#9966CC": return "VIOLA";
            default: return "";
        }
    }

    public void eListener() {
        ActionListener listener = e -> {
            JButton buttonClicked = ((JButton) e.getSource());
            JComboBox boxClicked = ((JComboBox) e.getSource());

            if (buttonClicked == invio) {
                int[] risultato = check();
                labels.get(0).setText("Esatti: " + risultato[0]);
                labels.get(1).setText("Giusti ma fuori posto: " + risultato[1]);
                labels.get(2).setText("Errati: " + risultato[2]);
                System.out.println(risultato);

                if (risultato[0] == 4) {
                    winLabel.setVisible(true);

                    // disattiva i pulsanti di invio e dei colori
                    invio.setEnabled(false);
                    for (JButton b : buttons) b.setEnabled(false);
                }

            } else if (buttons.contains(buttonClicked)) {
                Color currentColor = buttonClicked.getBackground();
                int nextIndex = 0;

                for (int i = 0; i < colors.length; i++) {
                    Color c = Color.decode(colors[i]);
                    if (currentColor.equals(c)) {
                        nextIndex = (i + 1) % colors.length; // se l'indice è maggiore di colors.length ricomincia dall'indice 0
                        break;
                    }
                }

                Color nextColor = Color.decode(colors[nextIndex]);
                buttonClicked.setBackground(nextColor);

            } else if (buttonClicked == restart) { // reset del gioco
                resetGame();
            }

            if (boxClicked == numberOfButtonsBox) {
                numberOfButtons = buttonClicked.getSelectedItem();
            }
        };

        for (JButton button : buttons) {
            button.addActionListener(listener);
        }
        invio.addActionListener(listener);
        restart.addActionListener(listener);
    }

    private int[] check() {
        int exactMatches = 0;     // colore e posizione corretti
        int colorOnlyMatches = 0; // colore corretto, posizione sbagliata
        int wrong = 0;            // nessuna corrispondenza

        for (int i=0; i<buttons.size(); i++) {
            Color color = buttons.get(i).getBackground();
            String hexColor = String.format("#%02X%02X%02X", color.getRed(), color.getGreen(), color.getBlue()); // tipo Color in stringa con numero esadecimale

            if (hexColor.equals(pattern.get(i))) {
                exactMatches++;
                System.out.println("Colore inserito (corretto): " + hexToIta(hexColor) + ", posizione inserita (corretta): " + i);
            } else if (pattern.contains(hexColor)) {
                colorOnlyMatches++;
                System.out.println("Colore inserito (corretto): " + hexToIta(hexColor) + ", posizione inserita (errata): " + i + ", colore corretto alla posizione " + i + ": " + patternIta.get(i) + ", ultima posizione dove è presente il colore: " + pattern.lastIndexOf(hexColor));
            } else {
                wrong++;
                System.out.println("Colore inserito (errato): " + hexToIta(hexColor) + ", posizione inserita: " + i + ", colore corretto alla posizione " + i + ": " + patternIta.get(i));
            }
        }

        return new int[]{exactMatches, colorOnlyMatches, wrong};
    }

    private void resetGame() {

        generatePattern();
        winLabel.setVisible(false);
        invio.setEnabled(true);
        for (JButton b : buttons) {
            b.setEnabled(true);
            b.setBackground(Color.decode("#E5E4E2"));
        }
        labels.get(0).setText("Esatti: ");
        labels.get(1).setText("Giusti ma fuori posto: ");
        labels.get(2).setText("Errati: ");
    }

    public void initComponents() {
        JFrame f = new JFrame();
        f.setSize(855, 500);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        int x = 5;
        int y = 5;
        for (int i = 0; i < 4; i++) {
            JButton button = new JButton();
            button.setBounds(x, y, 200, 200);
            x += 210;
            buttons.add(button);
            f.add(button);
        }

        labels = new ArrayList<>();
        x = 5;
        y = 220;
        for (int i=0; i<3; i++) {
            labels.add(new JLabel());
            labels.get(i).setBounds(x, y, 250, 25);
            labels.get(i).setFont(new java.awt.Font("Segoe UI", 0, 24));
            f.add(labels.get(i));
            y+=30;
        }

        invio = new JButton("INVIA");
        invio.setBounds(x, y, 90, 40);
        invio.setFont(new java.awt.Font("Segoe UI", 0, 20));
        f.add(invio);

        y += 45;
        winLabel = new JLabel("HAI VINTO!");
        winLabel.setBounds(x, y, 200, 60);
        winLabel.setFont(new java.awt.Font("Segoe UI", 0, 30));
        f.add(winLabel);

        y += 65;
        restart = new JButton("Ricomincia");
        restart.setBounds(x, y, 200, 40);
        restart.setFont(new java.awt.Font("Segoe UI", 0, 20));
        f.add(restart);

        x = 0;
        y = 0;
        solve s = new solve();
        
        String[] n1 = {"3", "4", "5", "6", "7", "8", "9", "10"};
        numberOfButtonsBox = new JComboBox<>(n1);
        numberOfButtonsBox.setBounds(x, y, 50, 30);
        numberOfButtonsBox.setFont(new java.awt.Font("Segoe UI", 0, 20));
        f.add(numberOfButtonsBox);

        String[] n2 = {"8", "10", "12", "14", "16", "18", "20", "nessun limite"};
        numberOfChancesBox = new JComboBox<>(n2);
        numberOfChancesBox.setBounds(x, y, 50, 30);
        numberOfChancesBox.setFont(new java.awt.Font("Segoe UI", 0, 20));
        f.add(numberOfChancesBox);
        c1.addItemListener(s);
    }

    public static void main(String[] args) {
        new MasterMind();
    }
}