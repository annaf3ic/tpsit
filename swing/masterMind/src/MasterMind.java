import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MasterMind extends JFrame {
    JFrame f;
    private static String[] colors;
    private static ArrayList<String> colorsIta;
    private static ArrayList<JLabel> labels;
    private ArrayList<String> pattern;
    private ArrayList<String> patternIta;
    private ArrayList<JButton> buttons = new ArrayList<>();
    private ArrayList<Integer> buttonColorIndex = new ArrayList<>();
    private JButton invio;
    private JLabel winLabel;
    private JButton restart;
    private JComboBox numberOfButtonsBox;
    private int numberOfButtons;
    private int numberOfChances;
    private JComboBox numberOfChancesBox;
    private JLabel chancesLeftLabel;
    private int chancesLeft;
    private JLabel revealPattern;

    public MasterMind() {
        colors = new String[]{"#B31B1B", "#ED9121", "#FFD700", "#228B22", "#0070BB", "#9966CC"};
        initComponents();
        resetGame();
    }

    private void resetGame() {
        numberOfButtons = Integer.parseInt((String) numberOfButtonsBox.getSelectedItem());
        buildButtons();

        String val = (String) numberOfChancesBox.getSelectedItem();
        numberOfChances = val.equals("nessun limite") ? -1 : Integer.parseInt(val);
        chancesLeft = numberOfChances;

        generatePattern();

        winLabel.setVisible(false);
        revealPattern.setVisible(false);
        invio.setEnabled(true);

        for (JButton b : buttons) {
            b.setEnabled(true);
            b.setBackground(Color.decode("#E5E4E2"));
        }

        labels.get(0).setText("Esatti: ");
        labels.get(1).setText("Giusti ma fuori posto: ");
        labels.get(2).setText("Errati: ");

        updateChancesLabel();

        eListener();
    }

    private void updateChancesLabel() {
        if (numberOfChances == -1) {
            chancesLeftLabel.setText("Chance rimaste: illimitate");
        } else {
            chancesLeftLabel.setText("Chance rimaste: " + chancesLeft);
        }
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

        colorsIta = new ArrayList<String>();
        for (String s : colors) colorsIta.add(hexToIta(s));
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
            Object src = e.getSource();

            if (src == invio) {
                //DEBUG
                System.out.println("Click sul pulsante INVIO");

                int[] risultato = check();
                labels.get(0).setText("Esatti: " + risultato[0]);
                labels.get(1).setText("Giusti ma fuori posto: " + risultato[1]);
                labels.get(2).setText("Errati: " + risultato[2]);

                if (risultato[0] == numberOfButtons) {
                    winLabel.setVisible(true);
                    invio.setEnabled(false);
                    for (JButton b : buttons) b.setEnabled(false);
                    return;
                }

                if (numberOfChances != -1) {
                    chancesLeft--;
                    updateChancesLabel();

                    if (chancesLeft <= 0) {
                        winLabel.setText("HAI PERSO!");
                        revealPattern.setText("Il pattern era: " + String.join(", ", patternIta));
                        winLabel.setVisible(true);
                        revealPattern.setVisible(true);
                        invio.setEnabled(false);
                        for (JButton b : buttons) b.setEnabled(false);
                    }
                }
                return;
            }

            if (src instanceof JButton && buttons.contains(src)) {
                JButton b = (JButton) src;

                //DEBUG
                int buttonIndex = buttons.indexOf(b);
                System.out.println("Click sul bottone con indice: " + buttonIndex);

                Color currentColor = b.getBackground();
                int nextIndex = 0;

                for (int i = 0; i < colors.length; i++) {
                    if (currentColor.equals(Color.decode(colors[i]))) {
                        nextIndex = (i + 1) % colors.length;
                        break;
                    }
                }

                b.setBackground(Color.decode(colors[nextIndex]));
            }


            if (src == restart || src == numberOfButtonsBox || src == numberOfChancesBox) {
                //DEBUG
                if (src == restart) System.out.println("Click sul bottone Restart");
                else if (src == numberOfButtonsBox) System.out.println("Click su box numero bottoni: valore selezionato: " + numberOfButtonsBox.getSelectedItem());
                else if (src == numberOfChancesBox) System.out.println("Click su box numero chance: valore selezionato: " + numberOfChancesBox.getSelectedItem());

                resetGame();
            }
        };

        for (JButton b : buttons) b.addActionListener(listener);
        restart.addActionListener(listener);
        for (ActionListener al : invio.getActionListeners()) invio.removeActionListener(al);
        invio.addActionListener(listener);
        for (ActionListener al : numberOfButtonsBox.getActionListeners()) numberOfButtonsBox.removeActionListener(al);
        numberOfButtonsBox.addActionListener(listener);
        for (ActionListener al : numberOfChancesBox.getActionListeners()) numberOfChancesBox.removeActionListener(al);
        numberOfChancesBox.addActionListener(listener);
        for (ActionListener al : restart.getActionListeners()) restart.removeActionListener(al);
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

    public void initComponents() {
        f = new JFrame();
        f.setSize(855, 500);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        int x;
        int y;

        x = 300;
        y = 220;
        JLabel labelNButtons = new JLabel("Numero di colori da indovinare: ");
        labelNButtons.setBounds(x, y, 300, 30);
        labelNButtons.setFont(new java.awt.Font("Segoe UI", 0, 20));
        f.add(labelNButtons);

        x += 300;
        String[] n1 = {"3", "4", "5", "6", "7", "8", "9", "10"};
        numberOfButtonsBox = new JComboBox<>(n1);
        numberOfButtonsBox.setBounds(x, y, 50, 30);
        numberOfButtonsBox.setFont(new java.awt.Font("Segoe UI", 0, 20));
        f.add(numberOfButtonsBox);

        x -= 300;
        y += 30;
        JLabel labelNChances = new JLabel("Numero di chance: ");
        labelNChances.setBounds(x, y, 180, 30);
        labelNChances.setFont(new java.awt.Font("Segoe UI", 0, 20));
        f.add(labelNChances);

        x += 180;
        String[] n2 = {"nessun limite", "8", "10", "12", "14", "16", "18", "20"};
        numberOfChancesBox = new JComboBox<>(n2);
        numberOfChancesBox.setBounds(x, y, 150, 30);
        numberOfChancesBox.setFont(new java.awt.Font("Segoe UI", 0, 20));
        f.add(numberOfChancesBox);

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

        y += 55;
        winLabel = new JLabel();
        winLabel.setBounds(x, y, 600, 60);
        winLabel.setFont(new java.awt.Font("Segoe UI", 0, 30));
        f.add(winLabel);

        y += 65;
        chancesLeftLabel = new JLabel();
        chancesLeftLabel.setBounds(x, y, 300, 30);
        chancesLeftLabel.setFont(new java.awt.Font("Segoe UI", 0, 21));
        f.add(chancesLeftLabel);

        y += 35;
        revealPattern = new JLabel();
        revealPattern.setBounds(x, y, 1000, 30);
        revealPattern.setFont(new java.awt.Font("Segoe UI", 0, 20));
        f.add(revealPattern);

        y += 65;
        restart = new JButton("Ricomincia");
        restart.setBounds(x, y, 200, 40);
        restart.setFont(new java.awt.Font("Segoe UI", 0, 20));
        f.add(restart);
    }

    private void buildButtons() {
        // Rimuove i bottoni esistenti dal frame
        for (JButton b : buttons) {
            b.setVisible(false);
            for (ActionListener al : b.getActionListeners()) {
                b.removeActionListener(al);
            }
            f.remove(b);
        }
        buttons.clear();

        // Crea nuovi bottoni in base al numero selezionato
        int x = 5;
        int y = 5;
        for (int i = 0; i < numberOfButtons; i++) {
            JButton button = new JButton();
            button.setBounds(x, y, 200, 200);
            x += 210;
            buttons.add(button);
            f.add(button);
        }
    }

    public static void main(String[] args) {
        new MasterMind();
    }
}