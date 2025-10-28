import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class MasterMind extends JFrame {
    private static String[] colors;
    private static ArrayList<JLabel> labels;
    private ArrayList<String> pattern;
    private int numberOfButtons = 4;
    private ArrayList<JButton> buttons = new ArrayList<>();
    private JButton invio;

    public MasterMind() {
        colors = new String[]{"#B31B1B", "#ED9121", "#FFD700", "#228B22", "#0070BB", "#9966CC"};
        initComponents();
        generatePattern();
        eListener();
    }

    private void generatePattern() {
        Random random = new Random();
        pattern = new ArrayList<>();
        for (int i=0; i<numberOfButtons; i++) {
            pattern.add(colors[random.nextInt(colors.length)]);
        }
    }

    public void eListener() {
        ActionListener listener = e -> {
            JButton buttonClicked = ((JButton) e.getSource());

            if (buttonClicked == invio) {
                int[] risultato = check();
                labels.get(0).setText("Esatti: " + risultato[0]);
                labels.get(1).setText("Giusti ma fuori posto: " + risultato[1]);
                labels.get(2).setText("Errati: " + risultato[2]);
            } else {
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
            }
        };

        for (JButton button : buttons) {
            button.addActionListener(listener);
        }
        invio.addActionListener(listener);
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
            } else if (pattern.contains(hexColor)) {
                colorOnlyMatches++;
            } else {
                wrong++;
            }
        }

        return new int[]{exactMatches, colorOnlyMatches, wrong};
    }

    public void initComponents() {
        JFrame f = new JFrame();
        f.setSize(500, 300);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        int x = 5;
        int y = 5;
        for (int i = 0; i < 4; i++) {
            JButton button = new JButton();
            button.setBounds(x, y, 200, 200);
            button.setBackground(Color.decode("#E5E4E2"));
            x += 210;
            buttons.add(button);
            f.add(button);
        }

        labels = new ArrayList<>();
        String[] labelsText = {"Esatti: ", "Giusti ma fuori posto: ", "Errati: "};
        x = 5;
        y = 220;
        for (int i=0; i<3; i++) {
            labels.add(new JLabel(labelsText[i]));
            labels.get(i).setBounds(x, y, 250, 25);
            labels.get(i).setFont(new java.awt.Font("Segoe UI", 0, 24));
            f.add(labels.get(i));
            y+=30;
        }

        invio = new JButton("INVIA");
        invio.setBounds(x, y, 90, 40);
        invio.setFont(new java.awt.Font("Segoe UI", 0, 20));
        f.add(invio);
    }
}